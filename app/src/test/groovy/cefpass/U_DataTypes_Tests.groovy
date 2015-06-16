import spock.lang.Specification

import cefpass.DataTypes
import exceptions.RS0_CefParserException

///////////////////////////////////////////////////////////////////////////////
//

class U_DataTypes_Tests extends Specification{

    def setup()
    {
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    //
    
    def "DataTypes.isEntryTypeMatch__CHAR_OK"() {
        when:   
            def result = DataTypes.isEntryTypeMatch("CHAR",             "\"Hello\"")                                    
        then:
            result == true
    }
    
    def "DataTypes.isEntryTypeMatch__CHAR_ERROR"() {
        when:   
            def result = DataTypes.isEntryTypeMatch("CHAR",             "Hello")                                    
        then:
            result == false
    }

    def "DataTypes.isEntryTypeMatch__DOUBLE_OK"() {
        when:   
            def result = DataTypes.isEntryTypeMatch("DOUBLE",           "1.2")                                          
        then:
            result == true
    }
    
    def "DataTypes.isEntryTypeMatch__DOUBLE_ERROR"() {
        when:   
            def result = DataTypes.isEntryTypeMatch("DOUBLE",           "ERROR")
        then:
            result == false
    }

    def "DataTypes.isEntryTypeMatch__FLOAT_OK"() {
        when:   
            def result = DataTypes.isEntryTypeMatch("FLOAT",            "1.2")                                          
        then:
            result == true
    }
    
    def "DataTypes.isEntryTypeMatch__FLOAT_ERROR"() {
        when:   
            def result = DataTypes.isEntryTypeMatch("FLOAT",            "ERROR")
        then:
            result == false
    }

    def "DataTypes.isEntryTypeMatch__INT_OK"() {
        when:   
            def result = DataTypes.isEntryTypeMatch("INT",              "1")                                            
        then:
            result == true
    }
    
    def "DataTypes.isEntryTypeMatch__INT_ERROR"() {
        when:   
            def result = DataTypes.isEntryTypeMatch("INT",              "ERROR")                                            
        then:
            result == false
    }

    def "DataTypes.isEntryTypeMatch__ISO_TIME_OK_1"() {
        when:   
            def result = DataTypes.isEntryTypeMatch("ISO_TIME",         "2012-04-11T15:57:15Z")                         
        then:
            result == true
    }
    
    def "DataTypes.isEntryTypeMatch__ISO_TIME_ERROR_1"() {
        when:   
            def result = DataTypes.isEntryTypeMatch("ISO_TIME",         "2012-04-11T15:ERROR")                         
        then:
            result == false
    }

    def "DataTypes.isEntryTypeMatch__ISO_TIME_OK_2"() {
        when:   
            def result = DataTypes.isEntryTypeMatch("ISO_TIME",         "2012-04-11T15:57:15.123456789Z")               
        then:
            result == true
    }
    
    def "DataTypes.isEntryTypeMatch__ISO_TIME_ERROR_2"() {
        when:   
            def result = DataTypes.isEntryTypeMatch("ISO_TIME",         "2012-04-11T15:57:15.ERROR")               
        then:
            result == false
    }

    def "DataTypes.isEntryTypeMatch__ISO_TIME_RANGE_OK_1"() {
        when:   
            def result = DataTypes.isEntryTypeMatch("ISO_TIME_RANGE",   "2011-10-09T00:00:00Z/2011-10-10T00:00:00Z")    
        then:
            result == true
    }
    
    def "DataTypes.isEntryTypeMatch__ISO_TIME_RANGE_ERROR_1"() {
        when:   
            def result = DataTypes.isEntryTypeMatch("ISO_TIME_RANGE",   "2011-10-09T00:00:00Z/ERROR-10T00:00:00Z")    
        then:
            result == false
    }

    def "DataTypes.isEntryTypeMatch__ISO_TIME_RANGE_OK_2"() {
        when:   
            def result = DataTypes.isEntryTypeMatch("ISO_TIME_RANGE",   "2011-10-09T00:00:00.12345Z/2011-10-10T00:00:00Z")    
        then:
            result == true
    }
    
    def "DataTypes.isEntryTypeMatch__ISO_TIME_RANGE_ERROR_2"() {
        when:   
            def result = DataTypes.isEntryTypeMatch("ISO_TIME_RANGE",   "2011-10-09T00:00:00.12345Z/ERROR-10T00:00:00Z")    
        then:
            result == false
    }

}

