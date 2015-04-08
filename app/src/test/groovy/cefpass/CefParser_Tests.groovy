import spock.lang.Specification

import cefpass.CefParser

///////////////////////////////////////////////////////////////////////////////
//

class CefParser_Tests extends Specification{

    def "01 CefParser_Tests: test meta matches - no error - eNULL"() {

        setup:
            CefParser.init()
        when:
            def result1 = CefParser.test_kv("START_META","ABC")
            def result2 = CefParser.test_kv("END_META","ABC")
        then:
            result2 == CefParser.Error.eNULL
    }
    
    def "02 CefParser_Tests: test variable mismatch"() {

        setup:
            CefParser.init()
        when:
            def result1 = CefParser.test_kv("START_META","ABC1")
            def result2 = CefParser.test_kv("END_META","ABC2")
        then:
            result2 == CefParser.Error.END_META_REQ__META_NAME_ERROR
    }    

    def "03 CefParser_Tests: test start_meta - end variable mismatch"() {

        setup:
            CefParser.init()
        when:
            def result1 = CefParser.test_kv("START_META","ABC1")
            def result2 = CefParser.test_kv("END_VARIABLE","ABC2")
        then:
            result2 == CefParser.Error.END_VARIABLE_REQ__VARIABLE_NOT_OPEN
    }    
 
    def "04 CefParser_Tests: test include errors INCLUDE_FILE_DUPLICATE"() {

        setup:
            CefParser.init()
        when:
            def result2 = CefParser.includeFileDuplicate("TEST/Include/Filename_001")
        then:
            result2 == CefParser.Error.INCLUDE_FILE_DUPLICATE
    }    

    def "05 CefParser_Tests: test include errors INCLUDE_FILE_NOT_FOUND"() {

        setup:
            CefParser.init()
        when:
            def result2 = CefParser.includeFileNotFound("TEST/Include/Filename_002")
        then:
            result2 == CefParser.Error.INCLUDE_FILE_NOT_FOUND
    }    

    def "06 CefParser_Tests: test include errors INCLUDE_FILE_LEVEL_8"() {

        setup:
            CefParser.init()
        when:
            def result2 = CefParser.includeFileLevel8("TEST/Include/Filename_003")
        then:
            result2 == CefParser.Error.INCLUDE_FILE_LEVEL_8
    }    

}
