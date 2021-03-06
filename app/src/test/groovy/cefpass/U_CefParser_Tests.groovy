import spock.lang.Specification

import cefpass.CefParser
import exceptions.RS0_CefParserException

///////////////////////////////////////////////////////////////////////////////
//

class U_CefParser_Tests extends Specification{

    def setup()
    {
        CefParser.init() 
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    //
    
    def "RS0_CefParserException.Error.NO_ERROR"() {
        when:   
            CefParser.test_kv("START_META", "m1")
            CefParser.test_kv("END_META", "m1")
            
            def result = true
        then:
            result == true
    }    
                   
    def "RS0_CefParserException.Error.R_0_00___START_META___META_UNCLOSED"() {
        when:   
            CefParser.test_kv("START_META", "m1")
            CefParser.test_kv("START_META", "m1")
        then:
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_00___START_META___META_UNCLOSED
    }    
    
    def "RS0_CefParserException.Error.R_0_01___START_META___VARIABLE_UNCLOSED"() {
        when:   
            CefParser.test_kv("START_VARIABLE", "m1")
            CefParser.test_kv("START_META", "m1")
        then:
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_01___START_META___VARIABLE_UNCLOSED
    }   
    
    def "RS0_CefParserException.Error.R_0_02___START_META___NAME_ERROR"() {
        when:   
            CefParser.test_kv("START_META", "")
            CefParser.test_kv("START_META", "m1")
        then:
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_02___START_META___NAME_ERROR
    }    
                                                                                                                                         
    def "RS0_CefParserException.Error.R_0_10___END_META___VARIABLE_OPENED"() {
        when:   
            CefParser.test_kv("START_VARIABLE", "m1")
            CefParser.test_kv("END_META", "m1")
        then:
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_10___END_META___VARIABLE_OPENED
    }    
    
    def "RS0_CefParserException.Error.R_0_11___END_META___META_UNOPENED"() {
        when:   
            CefParser.test_kv("END_META", "m1")
            CefParser.test_kv("END_META", "m2")
        then:
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_11___END_META___META_UNOPENED
    }    
    
    def "RS0_CefParserException.Error.R_0_12___END_META___NAME_ERROR"() {
        when:   
            CefParser.test_kv("START_META", "m1")
            CefParser.test_kv("END_META", "m2")
        then:
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_12___END_META___NAME_ERROR
    }    
                                                                                                                                         
    def "RS0_CefParserException.Error.R_0_20___START_VARIABLE___VARIABLE_UNCLOSED"() {
        when:   
            CefParser.test_kv("START_VARIABLE", "m1")
            CefParser.test_kv("START_VARIABLE", "m2")
        then:
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_20___START_VARIABLE___VARIABLE_UNCLOSED
    }    
    
    def "RS0_CefParserException.Error.R_0_21___START_VARIABLE___META_UNCLOSED"() {
        when:   
            CefParser.test_kv("START_META", "m1")
            CefParser.test_kv("START_VARIABLE", "m1")
        then:
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_21___START_VARIABLE___META_UNCLOSED
    }  
    
    def "RS0_CefParserException.Error.R_0_22___START_VARIABLE___NAME_ERROR"() {
        when:   
            CefParser.test_kv("START_VARIABLE", "")
            CefParser.test_kv("START_VARIABLE", "m1")
        then:
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_22___START_VARIABLE___NAME_ERROR
    }    
                                                                                                                                         
    def "RS0_CefParserException.Error.R_0_30___END_VARIABLE___META_OPENED"() {
        when:   
            CefParser.test_kv("START_META", "m1")
            CefParser.test_kv("END_VARIABLE", "m1")
        then:
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_30___END_VARIABLE___META_OPENED
    }
    
    def "RS0_CefParserException.Error.R_0_31___END_VARIABLE___VARIABLE_UNOPENED"() {
        when:   
            CefParser.test_kv("END_VARIABLE", "m1")
            CefParser.test_kv("END_VARIABLE", "m1")
        then:
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_31___END_VARIABLE___VARIABLE_UNOPENED
    }    
    
    def "RS0_CefParserException.Error.R_0_32___END_VARIABLE___NAME_ERROR"() {
        when:   
            CefParser.test_kv("START_VARIABLE", "m1")
            CefParser.test_kv("END_VARIABLE", "m2")
        then:
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_32___END_VARIABLE___NAME_ERROR
    }    
    
    ///////////////////////////////////////////////////////////////////////////////
    //

    def "RS0_CefParserException.Error.R_0_40___INCLUDE_FILE_DUPLICATE"() {
        when:   
            CefParser.includeFileDuplicate("Test-File.tst")
        then:   
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_40___INCLUDE_FILE_DUPLICATE
    }    
    
    def "RS0_CefParserException.Error.R_0_41___INCLUDE_FILE_UNFOUND"() {
        when:   
            CefParser.includeFileNotFound("Test-File.tst")
        then:   
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_41___INCLUDE_FILE_UNFOUND
    }    
    
    def "RS0_CefParserException.Error.R_0_42___INCLUDE_FILE_LEVEL_8"() {
        when:   
            CefParser.includeFileLevel8("Test-File.tst")
        then:   
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_42___INCLUDE_FILE_LEVEL_8
    }    
    
    ///////////////////////////////////////////////////////////////////////////////
    //

    def "RS0_CefParserException.Error.R_0_50___MALFORMED_READ_LINE"() {
        when:   
            CefParser.MalFormedReadLine("START_META no_equals_sign")
        then:   
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_50___MALFORMED_READ_LINE
    }    
    
    def "RS0_CefParserException.Error.R_0_51___MALFORMED_STRING_QUOTES"() {
        when:   
            CefParser.test_kv("TEST_ENTRY", "\"m1")
        then:   
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_51___MALFORMED_STRING_QUOTES
    }    
    
    
}

