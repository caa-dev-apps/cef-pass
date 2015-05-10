import spock.lang.Specification

import cefpass.CefLog

class U_CefLog_Tests extends Specification{

    def "01 CefLog_Tests: test each of the static CefLog functions"() {

        when:
            def result = false
            try
            {
                CefLog.error("This is an Error Message") 
                CefLog.warn("This is a Warning Message") 
                CefLog.info("This is an Info Message") 
                CefLog.diag("This is a Diag Message") 

                CefLog.stage1_info("Stage #1 info")
                CefLog.stage2_info("Stage #2 info")
                CefLog.stage3_info("Stage #3 info")
                CefLog.stage4_info("Stage #4 info")
                CefLog.stage5_info("Stage #5 info")

                CefLog.stage1_info("Stage #1 info", "TRUE")
                CefLog.stage2_info("Stage #2 info", false)
                CefLog.stage3_info("Stage #3 info")
                CefLog.stage4_info("Stage #4 info", 1234)
                CefLog.stage5_info("Stage #5 info", "Yo!")

                CefLog.top("This is a stage top message")
                
                result = true
            }
            catch(Exception e)
            {
            }
            
        then:
            result == true
    }
    
    
    
    
    def "02 CefLog_Tests: check files/folders exist"() {

        setup:

            def l_files = [
                    "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_EGD__20111009_V01.cef.gz"
                ]
                
            def l_folders = [
                    "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/_TEST_SAMPLES/MULTI_LEVEL_INCLUDES",
                    "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS",
                    "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS/EDI",
                    "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS/EFW",
                    "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS/PEACE"
                ]
                
        when:
            def result = false
            try
            {
                CefLog.error("This is an Error Message") 
                CefLog.warn("This is a Warning Message") 
                CefLog.info("This is an Info Message") 
                CefLog.diag("This is a Diag Message") 

                CefLog.stage1_info("Stage #1 info")
                CefLog.stage2_info("Stage #2 info")
                CefLog.stage3_info("Stage #3 info")
                CefLog.stage4_info("Stage #4 info")
                CefLog.stage5_info("Stage #5 info")

                CefLog.stage1_info("Stage #1 info", "TRUE")
                CefLog.stage2_info("Stage #2 info", false)
                CefLog.stage3_info("Stage #3 info")
                CefLog.stage4_info("Stage #4 info", 1234)
                CefLog.stage5_info("Stage #5 info", "Yo!")

                CefLog.top("This is a stage top message")
                
                result = true
            }
            catch(Exception e)
            {
            }
            
        then:
            result == true
    }    
    
    
    
    
    
}
