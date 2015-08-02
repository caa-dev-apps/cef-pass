import spock.lang.Specification

import cefpass.CmdLnArgs_v2
import exceptions.RS1_GlobalAttributesException

class U_CmdLnArgs_v2_UnitTests extends Specification{

    def CEF_FILE = "C:/work.dev/2015.03.22 github cef pass v2/v0/cef-pass/app/src/test/resources/R_0_00___START_META___META_UNCLOSED/C3_CP_EDI_EGD__20111009_V01.cef.gz"
    def INCLUDE_FOLDERS = ["FOLDER_01", "FOLDER_02"]
    def TEST_DATA_00_CONFIG_FILE = "t000_config_data.groovy"
    def TEST_DATA_01_CONFIG_FILE = "t001_config_data.groovy"

    def setup()
    {
    }

    ///////////////////////////////////////////////////////////////////////////////
    //

    def "Test 00 Cmd Params Only - Empty Config File"() 
    {
        setup:
            def l_cmdLnArgs = CmdLnArgs_v2.getObject()
        when:
            String[] l_args = [
                "-f",       CEF_FILE,
                "-i",       INCLUDE_FOLDERS.join(","),
                "-g",       Helper_Resources.getTestResourcePath("_CmdLnArgs") + "/" + TEST_DATA_00_CONFIG_FILE,
                "-e",       "development",
                "-o",       "2"
            ]
        
            l_cmdLnArgs.init(l_args)    
            l_cmdLnArgs.show()
        then:
            assert(l_cmdLnArgs.getIsCommentsOn()            == false)
            
            assert(l_cmdLnArgs.getFilePath()                == CEF_FILE)
            assert(l_cmdLnArgs.getSearchFolders()           == ["FOLDER_01", "FOLDER_02"])
            assert(l_cmdLnArgs.getXmlSchemas()              == [])
            assert(l_cmdLnArgs.getLogsFolder()              == false)
            
            assert(l_cmdLnArgs.getIsOutputHeaderXML()       == false)
            assert(l_cmdLnArgs.getIsQuickValidation()       == false)
            
            assert(l_cmdLnArgs.getTestRuleId()              == false)
            assert(l_cmdLnArgs.getIsNoStopOnFail()          == false)
            assert(l_cmdLnArgs.getOutputResultsLevel()      == 2)
            
            assert(l_cmdLnArgs.getFilename()                == "C3_CP_EDI_EGD__20111009_V01.cef")
            assert(l_cmdLnArgs.getLogicalFileId()           == "C3_CP_EDI_EGD__20111009_V01")
            assert(l_cmdLnArgs.getCefFileVersion()          == "01")
            
            assert(l_cmdLnArgs.getIsOk()                    == true)
    }    


    def "Test 01 Cmd Params + Config File"() 
    {
        setup:
            def l_cmdLnArgs = CmdLnArgs_v2.getObject()
        when:
            String[] l_args = [
                "-f",       CEF_FILE,
                "-i",       INCLUDE_FOLDERS.join(","),
                "-g",       Helper_Resources.getTestResourcePath("_CmdLnArgs") + "/" + TEST_DATA_01_CONFIG_FILE,
                "-e",       "development",
//x                 "-o",       "2"
            ]
        
            l_cmdLnArgs.init(l_args)    
            l_cmdLnArgs.show()
        then:
            assert(l_cmdLnArgs.getIsCommentsOn()            == true)
            
            assert(l_cmdLnArgs.getFilePath()                == CEF_FILE)
            assert(l_cmdLnArgs.getSearchFolders()           == ["FOLDER_01", "FOLDER_02"])
            assert(l_cmdLnArgs.getXmlSchemas()              == [])
            assert(l_cmdLnArgs.getLogsFolder()              == "C:/Dump/_logs")
            
            assert(l_cmdLnArgs.getIsOutputHeaderXML()       == true)
            assert(l_cmdLnArgs.getIsQuickValidation()       == true)
            
            assert(l_cmdLnArgs.getTestRuleId()              == "1.02")
            assert(l_cmdLnArgs.getIsNoStopOnFail()          == true)
            assert(l_cmdLnArgs.getOutputResultsLevel()      == 2)
            
            assert(l_cmdLnArgs.getFilename()                == "C3_CP_EDI_EGD__20111009_V01.cef")
            assert(l_cmdLnArgs.getLogicalFileId()           == "C3_CP_EDI_EGD__20111009_V01")
            assert(l_cmdLnArgs.getCefFileVersion()          == "01")
            
            assert(l_cmdLnArgs.getIsOk()                    == true)            
    }    
    
    
    def "Test 02 Cmd Params + No Config File"() 
    {
        setup:
            def l_cmdLnArgs = CmdLnArgs_v2.getObject()
        when:
            String[] l_args = [
                "-f",       CEF_FILE,
                "-i",       INCLUDE_FOLDERS.join(","),
                "-r",       "1.03",
                 "-o",       "2"
            ]
        
            l_cmdLnArgs.init(l_args)    
            l_cmdLnArgs.show()
        then:
            assert(l_cmdLnArgs.getIsCommentsOn()            == false)
            
            assert(l_cmdLnArgs.getFilePath()                == CEF_FILE)
            assert(l_cmdLnArgs.getSearchFolders()           == ["FOLDER_01", "FOLDER_02"])
            assert(l_cmdLnArgs.getXmlSchemas()              == [])
            assert(l_cmdLnArgs.getLogsFolder()              == false)
            
            assert(l_cmdLnArgs.getIsOutputHeaderXML()       == false)
            assert(l_cmdLnArgs.getIsQuickValidation()       == false)
            
            assert(l_cmdLnArgs.getTestRuleId()              == "1.03")
            assert(l_cmdLnArgs.getIsNoStopOnFail()          == false)
            assert(l_cmdLnArgs.getOutputResultsLevel()      == 2)
            
            assert(l_cmdLnArgs.getFilename()                == "C3_CP_EDI_EGD__20111009_V01.cef")
            assert(l_cmdLnArgs.getLogicalFileId()           == "C3_CP_EDI_EGD__20111009_V01")
            assert(l_cmdLnArgs.getCefFileVersion()          == "01")
            
            assert(l_cmdLnArgs.getIsOk()                    == true)            
    }    
    
}


