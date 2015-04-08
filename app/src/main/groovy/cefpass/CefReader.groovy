package cefpass

import java.io.FileInputStream
import java.io.File
import java.util.zip.GZIPInputStream

///////////////////////////////////////////////////////////////////////////////
//

public class CefReader
{
    def included = []

    def m_headerXml
    def m_cefContexts = []
    def m_isCommentsOn = false
    
    class MalFormedCef extends Exception{} 
    
    public CefReader()
    {
        m_isCommentsOn = CmdLnArgs.isCommentsOn()
        m_headerXml = do_process(CmdLnArgs.getFilename(), 0, [0])
    }
    
    public def getHeaderXml() { return m_headerXml }
    public def getCefContects() { return m_cefContexts }
    
    def process_data_line(l) {
         Show.showDataLine(l)
    }

    public def showContexts() {
        Show.showContexts(m_cefContexts)
    }
    
    def do_process(i_path, i_level, i_prefix) {
        def l_levelIncludeCount = 0
    
        def l_cx = new CefContext(i_path, i_level, i_prefix)
        
        m_cefContexts << l_cx
        
        def l_headerXml = new CefHeaderXml()
        
        def l_data_until = false
        def l_fileInputStream = new FileInputStream(i_path)
        def l_fileStream = (i_path.endsWith(".gz")) ? new GZIPInputStream(l_fileInputStream) : l_fileInputStream;

        def regexStr = /^\s*(\S+)\s*=\s*(.+)\s*$/
        def regexCommentStr = /^\s*!.*$/
    
        def include_ceh = { i_filename ->
        
            def l_filepath = null
            def l_dummy =  null
            
            (i_filename, l_dummy) = l_headerXml.removeQuotes(i_filename)
            
//x         for(d in CmdLnArgs.getSearchFolders()) {
//x             def p = d + '/' + i_filename
//x         
//x             if(included.find{ it == p } != null)  { l_headerXml.error('include file: already added'); break }
//x             else if (new File(p).exists())  { l_filepath = p; included << p; break }
//x         }
//x         
//x         if(l_filepath == null) l_headerXml.error('include file: Not found')
//x         else if(i_level > 8) l_headerXml.error('include file: level > 8')
//x         else do_process(l_filepath, i_level+1, (i_prefix + l_levelIncludeCount++)).each{ l_headerXml.appendDocument(it) }
        
            for(d in CmdLnArgs.getSearchFolders()) {
                def p = d + '/' + i_filename
          
                if(included.find{ it == p } != null)  { CefParser.includeFileDuplicate(i_filename); break }
                else if (new File(p).exists())  { l_filepath = p; included << p; break }
            }
         
            if(l_filepath == null) CefParser.includeFileNotFound(i_filename)
            else if(i_level > 8) CefParser.includeFileLevel8(i_filename)
            else do_process(l_filepath, i_level+1, (i_prefix + l_levelIncludeCount++)).each{ l_headerXml.appendDocument(it) }
        }
        
        l_fileStream.eachLine { it 
            l_cx.incLineCount()
            l_cx.diag(it)
        
            FileLogs.diag(it)
        
            if(l_data_until == true) {
                process_data_line(it)
            }
            else {
                def matcher = it =~ regexStr
                
                if (matcher.matches()) {
                    def key = matcher[0][1].trim()
                    def val = matcher[0][2].trim()
            
                    if("include".compareToIgnoreCase(key) == 0) 
                    { 
                        l_headerXml.add_kv("include-start", val)
                        include_ceh(val) 
                        l_headerXml.add_kv("include-end", val)
                    }
                    else
                    {
                        if("DATA_UNTIL".compareToIgnoreCase(key) == 0) { l_data_until = true }
                        l_headerXml.add_kv(key, val)
                    }
                }
                else if ((it =~ regexCommentStr).matches()) {
                    if(m_isCommentsOn) l_headerXml.addComment(it)
                }
                else if(it.size() == 0) {
                    // ignore
                }
                else {
                    throw new MalFormedCef()
                }    
            }
        }
        
        l_headerXml
    }
    
}

















