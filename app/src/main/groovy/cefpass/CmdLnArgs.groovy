package cefpass

import java.io.FileInputStream
import java.io.File
import java.util.zip.GZIPInputStream

//-----------------------------------------------------------------------------
//

public class CmdLnArgs
{
    def m_searchFolders
    def m_filename

    def CmdLnArgs(String[] i_args) {
        m_filename = TEST_FILES[0]
        m_searchFolders = TEST_SEARCH_FOLDERS
        
        show()
    }
    
    def TEST_SEARCH_FOLDERS = [
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/_TEST_SAMPLES/MULTI_LEVEL_INCLUDES",
    
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS",
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS/EDI",
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS/EFW",
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS/PEACE"
    ]

//-----------------------------------------------------------------------------
//

    def TEST_FILES = [
//x         "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/_TEST_SAMPLES/MULTI_LEVEL_INCLUDES/T0001_INCLUDE_TESTS.cef",

        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_EGD__20111009_V01.cef.gz",

        
    //x     "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_EGD__20111009_V01.cef",
//x         "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_EGD__20111020_V01.cef.gz",
//x         "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_EGD__20111021_V01.cef.gz",
//x         "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_EGD__20111022_V01.cef.gz",
//x         "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_QZC__20111009_V01.cef.gz",
//x         "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_QZC__20111020_V01.cef.gz",
//x         "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_QZC__20111021_V01.cef.cef",
//x         "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_QZC__20111021_V01.cef.gz",
//x         "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_QZC__20111022_V01.cef.gz"
    ]

//-----------------------------------------------------------------------------
//
    public def show() {
        Show.showCefFilename(m_filename)
        Show.showSearchFolders(m_searchFolders)
    }

    public def getSearchFolders()  { return  m_searchFolders }
    public def getFilename()  { return m_filename }
    
    public def test_batch() {
    
        for(f in TEST_FILES)
        {
            try
            {
                def r = new CefReader(SEARCH_FOLDERS,
                                      f)
                                      
                r.printHeaderNodes();
            }
            catch(Exception e)
            {
                e.printStackTrace()
            }
        }
    } 
}





