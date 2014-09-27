package cefpass

import java.io.FileInputStream
import java.io.File
import java.util.zip.GZIPInputStream

//-----------------------------------------------------------------------------
//


public class CefReader
{
    def included = []

    def m_searchFolders
    def m_filename
    def m_cehRoot

    def m_cefContexts = []
    
    class MalFormedCef extends Exception{} 
    
    public CefReader(i_searchFolders,
                     i_filename)
    {
        m_searchFolders = i_searchFolders
        m_filename = i_filename

        Show.showCefFilename(m_filename)
        Show.showSearchFolders(m_searchFolders)

        m_cehRoot = do_process(m_filename, 0, [0])
    }

    def process_data_line(l) {
         Show.showDataLine(l)
    }

    
    public def printHeaderNodes() {
        Show.showContexts(m_cefContexts)
    
        Show.showNodes(m_cehRoot)
        
        Show.showXmlNodes(m_cehRoot) 
    }
    

    def do_process(i_path, i_level, i_prefix) {
        def l_levelIncludeCount = 0
    
        def l_cx = new CefContext(i_path, i_level, i_prefix)
        
        m_cefContexts << l_cx
        
        def l_headerData = new CefHeaderData()

        def l_data_until = false
        def l_fileInputStream = new FileInputStream(i_path)
        def l_fileStream = (i_path.endsWith(".gz")) ? new GZIPInputStream(l_fileInputStream) : l_fileInputStream;

        def regexStr = /^\s*(\S+)\s*=\s*(.+)\s*$/
        def regexCommentStr = /^\s*!.*$/
    
        def include_ceh = { i_filename ->
        
            def l_filepath = null
            def l_dummy =  null
            
            (i_filename, l_dummy) = l_headerData.removeQuotes(i_filename)
            
            for(d in m_searchFolders) {
                def p = d + '/' + i_filename
          
                if(included.find{ it == p } != null)  { l_headerData.error('include file: already added'); break }
                else if (new File(p).exists())  { l_filepath = p; included << p; break }
            }
         
            if(l_filepath == null) l_headerData.error('include file: Not found')
            else if(i_level > 8) l_headerData.error('include file: level > 8')
            else do_process(l_filepath, i_level+1, (i_prefix + l_levelIncludeCount++)).each{ l_headerData.append(it) }
        }

        
        l_fileStream.eachLine { it 
            l_cx.incLineCount()
            l_cx.diag(it)
        
            if(l_data_until == true) {
                process_data_line(it)
            }
            else {
                def matcher = it =~ regexStr
                
                if (matcher.matches()) {
                    def key = matcher[0][1].trim()
                    def val = matcher[0][2].trim()
            
                    l_headerData.add_kv(key,
                                        val)
                
                    if("DATA_UNTIL".compareToIgnoreCase(key) == 0) l_data_until = true
                    else if("include".compareToIgnoreCase(key) == 0) include_ceh(val)
                }
                else if ((it =~ regexCommentStr).matches()) {
                    l_headerData.addComment(it)
                }
                else if(it.size() == 0) {
                    // ignore
                }
                else {
                    throw new MalFormedCef()
                }    
            }
        }
        
        l_headerData.root
    }
    
}

















