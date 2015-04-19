import spock.lang.Specification

import cefpass.CefParser

///////////////////////////////////////////////////////////////////////////////
//

class CefParser_Tests_00 extends Specification{

//x     def "01 CefParser_Tests: test meta matches - no error - eNULL"() {
//x 
//x         setup:
//x             CefParser.init()
//x         when:
//x             def result1 = CefParser.test_kv("START_META","ABC")
//x             def result2 = CefParser.test_kv("END_META","ABC")
//x         then:
//x             result2 == CefParser.Error.eNULL
//x     }
//x     
//x     def "02 CefParser_Tests: test variable mismatch"() {
//x 
//x         setup:
//x             CefParser.init()
//x         when:
//x             def result1 = CefParser.test_kv("START_META","ABC1")
//x             def result2 = CefParser.test_kv("END_META","ABC2")
//x         then:
//x             result2 == CefParser.Error.END_META_REQ__META_NAME_ERROR
//x     }    
//x 
//x     def "03 CefParser_Tests: test start_meta - end variable mismatch"() {
//x 
//x         setup:
//x             CefParser.init()
//x         when:
//x             def result1 = CefParser.test_kv("START_META","ABC1")
//x             def result2 = CefParser.test_kv("END_VARIABLE","ABC2")
//x         then:
//x             result2 == CefParser.Error.END_VARIABLE_REQ__VARIABLE_NOT_OPEN
//x     }    
//x  
//x     def "04 CefParser_Tests: test include errors INCLUDE_FILE_DUPLICATE"() {
//x 
//x         setup:
//x             CefParser.init()
//x         when:
//x             def result2 = CefParser.includeFileDuplicate("TEST/Include/Filename_001")
//x         then:
//x             result2 == CefParser.Error.INCLUDE_FILE_DUPLICATE
//x     }    
//x 
//x     def "05 CefParser_Tests: test include errors INCLUDE_FILE_NOT_FOUND"() {
//x 
//x         setup:
//x             CefParser.init()
//x         when:
//x             def result2 = CefParser.includeFileNotFound("TEST/Include/Filename_002")
//x         then:
//x             result2 == CefParser.Error.INCLUDE_FILE_NOT_FOUND
//x     }    
//x 
//x     def "06 CefParser_Tests: test include errors INCLUDE_FILE_LEVEL_8"() {
//x 
//x         setup:
//x             CefParser.init()
//x         when:
//x             def result2 = CefParser.includeFileLevel8("TEST/Include/Filename_003")
//x         then:
//x             result2 == CefParser.Error.INCLUDE_FILE_LEVEL_8
//x     }    

}
