import spock.lang.Specification

import cefpass.CefParser
import exceptions.CefParserException

///////////////////////////////////////////////////////////////////////////////
//

class CefParser_Tests extends Specification{

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
//x 
//x }


    def test_1 = { i_data -> 
        def l_result = false
        
        try {
            CefParser.init() 
            CefParser.test_kv(i_data.k1, i_data.v1)
            CefParser.test_kv(i_data.k2, i_data.v2)
            
            l_result = true
        }
        catch (CefParserException e) {
            l_result = (i_data.ex == e.getError())
        }
        finally {
        }
        
        return l_result
    }

    def test_2 = { i_data -> 
        def l_result = false
        
        try {
            CefParser.init() 
            
            if(i_data.func=="CefParser.includeFileDuplicate")     CefParser.includeFileDuplicate("Test-File.tst")
            else if(i_data.func=="CefParser.includeFileNotFound") CefParser.includeFileNotFound("Test-File.tst")
            else if(i_data.func=="CefParser.includeFileLevel8")   CefParser.includeFileLevel8("Test-File.tst")
                
            l_result = true
        }
        catch (CefParserException e) {
            l_result = (i_data.ex == e.getError())
        }
        finally {
        }
        
        return l_result
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    //
    
    def "ix:0   ex:CefParserException.Error.NO_ERROR"() {
        setup:
        when:   
            def result = test_1([k1:"START_META",
                                 v1:"m1",
                                 k2:"END_META",
                                 v2:"m1",
                                 ex:CefParserException.Error.NO_ERROR])
        then:   
            result == true
    }    
                   
    def "ix:10  ex:CefParserException.Error.R_0_00___START_META___META_UNCLOSED"() {
        setup:
        when:   
            def result = test_1([k1:"START_META",
                                 v1:"m1",
                                 k2:"START_META",
                                 v2:"m1",
                                 ex:CefParserException.Error.R_0_00___START_META___META_UNCLOSED])
        then:   
            result == true
    }    
    
    def "ix:11  ex:CefParserException.Error.R_0_01___START_META___VARIABLE_UNCLOSED"() {
        setup:
        when:   
            def result = test_1([k1:"START_VARIABLE",
                                 v1:"m1",
                                 k2:"START_META",
                                 v2:"m1",
                                 ex:CefParserException.Error.R_0_01___START_META___VARIABLE_UNCLOSED])
        then:   
            result == true
    }   
    
    def "ix:12  ex:CefParserException.Error.R_0_02___START_META___NAME_ERROR"() {
        setup:
        when:   
            def result = test_1([k1:"START_META",
                                 v1:"",
                                 k2:"START_META",
                                 v2:"m1",
                                 ex:CefParserException.Error.R_0_02___START_META___NAME_ERROR])
        then:   
            result == true
    }    
                                                                                                                                         
    def "ix:20  ex:CefParserException.Error.R_0_10___END_META___VARIABLE_OPENED"() {
        setup:
        when:   
            def result = test_1([k1:"START_VARIABLE",
                                 v1:"m1",
                                 k2:"END_META",
                                 v2:"m1",
                                 ex:CefParserException.Error.R_0_10___END_META___VARIABLE_OPENED])
        then:   
            result == true
    }    
    
    def "ix:21  ex:CefParserException.Error.R_0_11___END_META___META_UNOPENED"() {
        setup:
        when:   
            def result = test_1([k1:"END_META",
                                 v1:"m1",
                                 k2:"END_META",
                                 v2:"m1",
                                 ex:CefParserException.Error.R_0_11___END_META___META_UNOPENED])
        then:   
            result == true
    }    
    
    def "ix:22  ex:CefParserException.Error.R_0_12___END_META___NAME_ERROR"() {
        setup:
        when:   
            def result = test_1([k1:"START_META",
                                 v1:"m1",
                                 k2:"END_META",
                                 v2:"m2",
                                 ex:CefParserException.Error.R_0_12___END_META___NAME_ERROR])
        then:   
            result == true
    }    
                                                                                                                                         
    def "ix:30  ex:CefParserException.Error.R_0_20___START_VARIABLE___VARIABLE_UNCLOSED"() {
        setup:
        when:   
            def result = test_1([k1:"START_VARIABLE",
                                 v1:"m1",
                                 k2:"START_VARIABLE",
                                 v2:"m1",
                                 ex:CefParserException.Error.R_0_20___START_VARIABLE___VARIABLE_UNCLOSED])
        then:   
            result == true
    }    
    
    def "ix:31  ex:CefParserException.Error.R_0_21___START_VARIABLE___META_UNCLOSED"() {
        setup:
        when:   
            def result = test_1([k1:"START_META",
                                 v1:"m1",
                                 k2:"START_VARIABLE",
                                 v2:"m1",
                                 ex:CefParserException.Error.R_0_21___START_VARIABLE___META_UNCLOSED])
        then:   
            result == true
    }  
    
    def "ix:30  ex:CefParserException.Error.R_0_22___START_VARIABLE___NAME_ERROR"() {
        setup:
        when:   
            def result = test_1([k1:"START_VARIABLE",
                                 v1:"",
                                 k2:"START_VARIABLE",
                                 v2:"m1",
                                 ex:CefParserException.Error.R_0_22___START_VARIABLE___NAME_ERROR])
        then:   
            result == true
    }    
                                                                                                                                         
    def "ix:40  ex:CefParserException.Error.R_0_30___END_VARIABLE___META_OPENED"() {
        setup:
        when:   
            def result = test_1([k1:"START_META",
                                 v1:"m1",
                                 k2:"END_VARIABLE",
                                 v2:"m1",
                                 ex:CefParserException.Error.R_0_30___END_VARIABLE___META_OPENED])
        then:   
            result == true
    }
    
    def "ix:41  ex:CefParserException.Error.R_0_31___END_VARIABLE___VARIABLE_UNOPENED"() {
        setup:
        when:   
            def result = test_1([k1:"END_VARIABLE",
                                 v1:"m1",
                                 k2:"END_VARIABLE",
                                 v2:"m1",
                                 ex:CefParserException.Error.R_0_31___END_VARIABLE___VARIABLE_UNOPENED])
        then:   
            result == true
    }    
    
    def "ix:42  ex:CefParserException.Error.R_0_32___END_VARIABLE___NAME_ERROR"() {
        setup:
        when:   
            def result = test_1([k1:"START_VARIABLE",
                                 v1:"m1",
                                 k2:"END_VARIABLE",
                                 v2:"m2",
                                 ex:CefParserException.Error.R_0_32___END_VARIABLE___NAME_ERROR])
        then:   
            result == true
    }    
                                                                                                                                                    
    def "ix:50    ex:CefParserException.Error.R_0_40___INCLUDE_FILE_DUPLICATE"() {
        setup:
        when:   
            def result = test_2([func:"CefParser.includeFileDuplicate",
                                 ex:CefParserException.Error.R_0_40___INCLUDE_FILE_DUPLICATE])
        then:   
            result == true
    }    
    
    def "ix:51    ex:CefParserException.Error.R_0_41___INCLUDE_FILE_UNFOUND"() {
        setup:
        when:   
            def result = test_2([func:"CefParser.includeFileNotFound",
                                 ex:CefParserException.Error.R_0_41___INCLUDE_FILE_UNFOUND])
        then:   
            result == true
    }    
    
    def "ix:52    ex:CefParserException.Error.R_0_42___INCLUDE_FILE_LEVEL_8"() {
        setup:
        when:   
            def result = test_2([func:"CefParser.includeFileLevel8",
                                 ex:CefParserException.Error.R_0_42___INCLUDE_FILE_LEVEL_8])
        then:   
            result == true
    }    
}


            






























