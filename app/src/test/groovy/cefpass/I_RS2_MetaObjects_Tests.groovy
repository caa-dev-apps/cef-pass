import spock.lang.Specification

import org.springframework.util.ResourceUtils

import cefpass.App
import cefpass.CefParser
import exceptions.RS2_MetaObjectsException
import spock.lang.Unroll

import Helper_Resources;

//x @Unroll
class I_RS2_MetaObjects_Tests extends Specification{

    def setup()
    {
        CefParser.init() 
    }

    ///////////////////////////////////////////////////////////////////////////////
    //

    def "R_2_00___MUST_HAVE_ENTRY"() 
    {
        given:
            def App app = new App()
        when:
            def result = app.stages(l_cmd_args)
        then:
            RS2_MetaObjectsException ex = thrown()
            ex.getError() == RS2_MetaObjectsException.Error.R_2_00___MUST_HAVE_ENTRY
        where :
            l_cmd_args << Helper_Resources.getCommandLineArgsList('R_2_00___MUST_HAVE_ENTRY')
    }
    
    def "R_2_02___ENTRY_MISMATCH_VALUE_TYPE"() 
    {
        given:
            def App app = new App()
        when:
            def result = app.stages(l_cmd_args)
        then:
            RS2_MetaObjectsException ex = thrown()
            ex.getError() == RS2_MetaObjectsException.Error.R_2_02___ENTRY_MISMATCH_VALUE_TYPE
        where :
            l_cmd_args << Helper_Resources.getCommandLineArgsList('R_2_02___ENTRY_MISMATCH_VALUE_TYPE')
        
    }
    
//todo      def "R_2_03___REQUIRED_VARIABLES_XXXX"() 
//todo      {
//todo          given:
//todo              def l_cmd_args = getCommandLineArgs('R_2_03___REQUIRED_VARIABLES_XXXX/C3_CP_EDI_EGD__20111009_V01.cef')
//todo          when:
//todo              def App app = new App()
//todo              def result = app.stages(l_cmd_args)
//todo          then:
//todo              RS2_MetaObjectsException ex = thrown()
//todo              ex.getError() == RS2_MetaObjectsException.Error.R_2_03___REQUIRED_VARIABLES_XXXX
//todo          
//todo      }
    
    // done
    def "R_2_04___FILE_TYPE_MUST_BE_CEF"() 
    {
        given:      
            def App app = new App()
        when:
            def result = app.stages(l_cmd_args)
        then:
            RS2_MetaObjectsException ex = thrown()
            ex.getError() == RS2_MetaObjectsException.Error.R_2_04___FILE_TYPE_MUST_BE_CEF
        where :
            l_cmd_args << Helper_Resources.getCommandLineArgsList('R_2_04___FILE_TYPE_MUST_BE_CEF')
    }
    
    def "R_2_05___DATASET_VERSION_MUST_BE_VALID_INTEGER"() 
    {
        given:
            def App app = new App()
        when:
            def result = app.stages(l_cmd_args)
        then:
            RS2_MetaObjectsException ex = thrown()
            ex.getError() == RS2_MetaObjectsException.Error.R_2_05___DATASET_VERSION_MUST_BE_VALID_INTEGER
        where :
            l_cmd_args << Helper_Resources.getCommandLineArgsList('R_2_05___DATASET_VERSION_MUST_BE_VALID_INTEGER')
    }
    
    def "R_2_06___LOGICAL_FILE_ID_MATCHES_FILENAME"() 
    {
        given:
            def App app = new App()
        when:
            def result = app.stages(l_cmd_args)
        then:
            RS2_MetaObjectsException ex = thrown()
            ex.getError() == RS2_MetaObjectsException.Error.R_2_06___LOGICAL_FILE_ID_MATCHES_FILENAME
        where :
            l_cmd_args << Helper_Resources.getCommandLineArgsList('R_2_06___LOGICAL_FILE_ID_MATCHES_FILENAME')
    }
    
    def "R_2_07___VERSION_NUMBER_MUST_BE_VALID_INTEGER"() 
    {
        given:
            def App app = new App()
        when:
            def result = app.stages(l_cmd_args)
        then:
            RS2_MetaObjectsException ex = thrown()
            ex.getError() == RS2_MetaObjectsException.Error.R_2_07___VERSION_NUMBER_MUST_BE_VALID_INTEGER
        where :
            l_cmd_args << Helper_Resources.getCommandLineArgsList('R_2_07___VERSION_NUMBER_MUST_BE_VALID_INTEGER')
    }

    def "R_2_08___VERSION_NUMBER_MATCHES_FILENAME"() 
    {
        given:
            def App app = new App()
        when:
            def result = app.stages(l_cmd_args)
        then:
            RS2_MetaObjectsException ex = thrown()
            ex.getError() == RS2_MetaObjectsException.Error.R_2_08___VERSION_NUMBER_MATCHES_FILENAME
        where :
            l_cmd_args << Helper_Resources.getCommandLineArgsList('R_2_08___VERSION_NUMBER_MATCHES_FILENAME')
    }
    
    def "R_2_09___FILE_TIME_SPAN_MUST_BE_ISO_TIME_RANGE"() 
    {
        given:
            def App app = new App()
        when:
            def result = app.stages(l_cmd_args)
        then:
            RS2_MetaObjectsException ex = thrown()
            ex.getError() == RS2_MetaObjectsException.Error.R_2_09___FILE_TIME_SPAN_MUST_BE_ISO_TIME_RANGE
        where :
            l_cmd_args << Helper_Resources.getCommandLineArgsList('R_2_09___FILE_TIME_SPAN_MUST_BE_ISO_TIME_RANGE')
            
    }
    
    def "R_2_10___FILE_TIME_SPAN_START_TIME_MUST_BE_BEFORE_STOP_TIME"() 
    {
        given:
            def App app = new App()
        when:
            def result = app.stages(l_cmd_args)
        then:
            RS2_MetaObjectsException ex = thrown()
            ex.getError() == RS2_MetaObjectsException.Error.R_2_10___FILE_TIME_SPAN_START_TIME_MUST_BE_BEFORE_STOP_TIME
        where :
            l_cmd_args << Helper_Resources.getCommandLineArgsList('R_2_10___FILE_TIME_SPAN_START_TIME_MUST_BE_BEFORE_STOP_TIME')
    }

    
//todo      def "R_2_11___DATA_RECORD_TIME_STAMP_MUST_BE_BETWEEN_FILE_TIME_SPAN"() 
//todo      {
//todo          given:
//todo              def l_cmd_args = getCommandLineArgs('R_2_11___DATA_RECORD_TIME_STAMP_MUST_BE_BETWEEN_FILE_TIME_SPAN/C3_CP_EDI_EGD__20111009_V01.cef')
//todo          when:
//todo              def App app = new App()
//todo              def result = app.stages(l_cmd_args)
//todo          then:
//todo              RS2_MetaObjectsException ex = thrown()
//todo              ex.getError() == RS2_MetaObjectsException.Error.R_2_11___DATA_RECORD_TIME_STAMP_MUST_BE_BETWEEN_FILE_TIME_SPAN
//todo          
//todo      }


//x     def getEntryTestValues(String[])
//x     {
//x             [
//x             [   test_name: "First test"    ,test_num: 1        ,a: 0 ,b: 1 ], 
//x             [   test_name: "Second test"   ,test_num: 2        ,a: 1 ,b: 2 ], 
//x             [   test_name: "Third test"    ,test_num: 3        ,a: 2 ,b: 3 ], 
//x             [   test_name: "Fourth test"   ,test_num: 4        ,a: 3 ,b: 4 ], 
//x             [   test_name: "Fifth test"    ,test_num: 5        ,a: 4 ,b: 5 ], 
//x             ]
//x     }

    @Unroll
    def "R_2_10___XXXX #test_name #test_num"() 
    {
        given:
            def App app = new App()
        when:
            a = a + 1
        then:
            a == b
        where :
            test_name       | test_num | a | b
            "First test"    | 1        | 0 | 1
            "Second test"   | 2        | 1 | 2
            "Third test"    | 3        | 2 | 3
            "Fourth test"   | 4        | 3 | 4
            "Fifth test"    | 5        | 4 | 5
    }
    

//x     def getEntryTestValues(String[] i_imputs)
    def getEntryTestValues(i_vals)
    {
           [
            [    "First test"    , 1        , 0 , 1 ], 
            [    "Second test"   , 2        , 1 , 2 ], 
            [    "Third test"    , 3        , 2 , 3 ], 
            [    "Fourth test"   , 4        , 3 , 4 ], 
            [    "Fifth test"    , 5        , 4 , 5 ], 
            ]            
    }

    @Unroll
    def "R_2_10___YYYY #test_name #test_num"() 
    {
        given:
            def App app = new App()
        when:
            a = a + 1
        then:
            a == b
        where:
            [test_name, test_num, a, b] <<  getEntryTestValues([1,2,3,4])
            
    }
}

    
    
    
    
    
    
    












