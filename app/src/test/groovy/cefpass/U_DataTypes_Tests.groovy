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
            def result = DataTypes.isEntryTypeMismatch("CHAR",             "\"Hello\"")                                    
        then:
            result == false
    }
    
    def "DataTypes.isEntryTypeMismatch__CHAR_ERROR"() {
        when:   
            def result = DataTypes.isEntryTypeMismatch("CHAR",             "Hello")                                    
        then:
            result == true
    }

    def "DataTypes.isEntryTypeMismatch__DOUBLE_OK"() {
        when:   
            def result = DataTypes.isEntryTypeMismatch("DOUBLE",           "1.2")                                          
        then:
            result == false
    }
    
    def "DataTypes.isEntryTypeMismatch__DOUBLE_ERROR"() {
        when:   
            def result = DataTypes.isEntryTypeMismatch("DOUBLE",           "ERROR")
        then:
            result == true
    }

    def "DataTypes.isEntryTypeMismatch__FLOAT_OK"() {
        when:   
            def result = DataTypes.isEntryTypeMismatch("FLOAT",            "1.2")                                          
        then:
            result == false
    }
    
    def "DataTypes.isEntryTypeMismatch__FLOAT_ERROR"() {
        when:   
            def result = DataTypes.isEntryTypeMismatch("FLOAT",            "ERROR")
        then:
            result == true
    }

    def "DataTypes.isEntryTypeMismatch__INT_OK"() {
        when:   
            def result = DataTypes.isEntryTypeMismatch("INT",              "1")                                            
        then:
            result == false
    }
    
    def "DataTypes.isEntryTypeMismatch__INT_ERROR"() {
        when:   
            def result = DataTypes.isEntryTypeMismatch("INT",              "ERROR")                                            
        then:
            result == true
    }

    def "DataTypes.isEntryTypeMismatch__ISO_TIME_OK_1"() {
        when:   
            def result = DataTypes.isEntryTypeMismatch("ISO_TIME",         "2012-04-11T15:57:15Z")                         
        then:
            result == false
    }
    
    def "DataTypes.isEntryTypeMismatch__ISO_TIME_ERROR_1"() {
        when:   
            def result = DataTypes.isEntryTypeMismatch("ISO_TIME",         "2012-04-11T15:ERROR")                         
        then:
            result == true
    }

    def "DataTypes.isEntryTypeMismatch__ISO_TIME_OK_2"() {
        when:   
            def result = DataTypes.isEntryTypeMismatch("ISO_TIME",         "2012-04-11T15:57:15.123456789Z")               
        then:
            result == false
    }
    
    def "DataTypes.isEntryTypeMismatch__ISO_TIME_ERROR_2"() {
        when:   
            def result = DataTypes.isEntryTypeMismatch("ISO_TIME",         "2012-04-11T15:57:15.ERROR")               
        then:
            result == true
    }

    def "DataTypes.isEntryTypeMismatch__ISO_TIME_RANGE_OK_1"() {
        when:   
            def result = DataTypes.isEntryTypeMismatch("ISO_TIME_RANGE",   "2011-10-09T00:00:00Z/2011-10-10T00:00:00Z")    
        then:
            result == false
    }
    
    def "DataTypes.isEntryTypeMismatch__ISO_TIME_RANGE_ERROR_1"() {
        when:   
            def result = DataTypes.isEntryTypeMismatch("ISO_TIME_RANGE",   "2011-10-09T00:00:00Z/ERROR-10T00:00:00Z")    
        then:
            result == true
    }

    def "DataTypes.isEntryTypeMismatch__ISO_TIME_RANGE_OK_2"() {
        when:   
            def result = DataTypes.isEntryTypeMismatch("ISO_TIME_RANGE",   "2011-10-09T00:00:00.12345Z/2011-10-10T00:00:00Z")    
        then:
            result == false
    }
    
    def "DataTypes.isEntryTypeMismatch__ISO_TIME_RANGE_ERROR_2"() {
        when:   
            def result = DataTypes.isEntryTypeMismatch("ISO_TIME_RANGE",   "2011-10-09T00:00:00.12345Z/ERROR-10T00:00:00Z")    
        then:
            result == true
    }

    def "DataTypes.isValidISOTimeRangeStartStop__ISO_TIME_RANGE_START_BEFORE_STOP_OK"() {
        when:   
            def result = DataTypes.isValidISOTimeRangeStartStop("2011-10-09T00:00:00Z/2011-10-10T00:00:00Z")    
        then:
            result == true
    }

    def "DataTypes.isValidISOTimeRangeStartStop__ISO_TIME_RANGE_START_BEFORE_STOP_ERROR"() {
        when:   
            def result = DataTypes.isValidISOTimeRangeStartStop("2012-10-09T00:00:00Z/2011-10-10T00:00:00Z")    
        then:
            result == false
    }
    
}

