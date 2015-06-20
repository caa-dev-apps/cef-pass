import spock.lang.Specification

import org.springframework.util.ResourceUtils

import cefpass.App
import cefpass.CefParser
import exceptions.RS2_MetaObjectsException

import Helper_Resources;

class I_RS2_MetaObjects_Tests extends Specification{

    def setup()
    {
        CefParser.init() 
    }

    ///////////////////////////////////////////////////////////////////////////////
    //

//x     def "R_2_04___FILE_TYPE_MUST_BE_CEF"() 
//x     {
//x         given:
//x             def l_cmd_args = getCommandLineArgs('R_2_04___FILE_TYPE_MUST_BE_CEF/C3_CP_EDI_EGD__20111009_V01.cef')
//x         when:
//x             def App app = new App()
//x             def result = app.stages(l_cmd_args)
//x         then:
//x             RS2_MetaObjectsException ex = thrown()
//x             ex.getError() == RS2_MetaObjectsException.Error.R_2_04___FILE_TYPE_MUST_BE_CEF
//x         
//x     }


///////////////////////////////////////////////////////////////////////////////
//

//x     def "R_2_00___MUST_HAVE_ENTRY"() 
//x     {
//x         given:
//x             def l_cmd_args = Helper_Resources.getCommandLineArgs('R_2_00___MUST_HAVE_ENTRY/C3_CP_EDI_EGD__20111009_V01.cef')
//x         when:
//x             def App app = new App()
//x             def result = app.stages(l_cmd_args)
//x         then:
//x             RS2_MetaObjectsException ex = thrown()
//x             ex.getError() == RS2_MetaObjectsException.Error.R_2_00___MUST_HAVE_ENTRY
//x     }


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
    
//todo      def "R_2_02___ENTRY_MISMATCH_VALUE_TYPE"() 
//todo      {
//todo          given:
//todo              def l_cmd_args = getCommandLineArgs('R_2_02___ENTRY_MISMATCH_VALUE_TYPE/C3_CP_EDI_EGD__20111009_V01.cef')
//todo          when:
//todo              def App app = new App()
//todo              def result = app.stages(l_cmd_args)
//todo          then:
//todo              RS2_MetaObjectsException ex = thrown()
//todo              ex.getError() == RS2_MetaObjectsException.Error.R_2_02___ENTRY_MISMATCH_VALUE_TYPE
//todo          
//todo      }
    
    
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
//x         given:
//x             def l_cmd_args = Helper_Resources.getCommandLineArgs('R_2_04___FILE_TYPE_MUST_BE_CEF/C3_CP_EDI_EGD__20111009_V01.cef')
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
    
    
//todo      def "R_2_05___DATASET_VERSION_MUST_BE_VALID_INTEGER"() 
//todo      {
//todo          given:
//todo              def l_cmd_args = getCommandLineArgs('R_2_05___DATASET_VERSION_MUST_BE_VALID_INTEGER/C3_CP_EDI_EGD__20111009_V01.cef')
//todo          when:
//todo              def App app = new App()
//todo              def result = app.stages(l_cmd_args)
//todo          then:
//todo              RS2_MetaObjectsException ex = thrown()
//todo              ex.getError() == RS2_MetaObjectsException.Error.R_2_05___DATASET_VERSION_MUST_BE_VALID_INTEGER
//todo          
//todo      }
    
    
//todo      def "R_2_06___LOGICAL_FILE_ID_MATCHES_FILENAME"() 
//todo      {
//todo          given:
//todo              def l_cmd_args = getCommandLineArgs('R_2_06___LOGICAL_FILE_ID_MATCHES_FILENAME/C3_CP_EDI_EGD__20111009_V01.cef')
//todo          when:
//todo              def App app = new App()
//todo              def result = app.stages(l_cmd_args)
//todo          then:
//todo              RS2_MetaObjectsException ex = thrown()
//todo              ex.getError() == RS2_MetaObjectsException.Error.R_2_06___LOGICAL_FILE_ID_MATCHES_FILENAME
//todo          
//todo      }
    
    
//todo      def "R_2_07___VERSION_NUMBER_MATCHES_FILENAME"() 
//todo      {
//todo          given:
//todo              def l_cmd_args = getCommandLineArgs('R_2_07___VERSION_NUMBER_MATCHES_FILENAME/C3_CP_EDI_EGD__20111009_V01.cef')
//todo          when:
//todo              def App app = new App()
//todo              def result = app.stages(l_cmd_args)
//todo          then:
//todo              RS2_MetaObjectsException ex = thrown()
//todo              ex.getError() == RS2_MetaObjectsException.Error.R_2_07___VERSION_NUMBER_MATCHES_FILENAME
//todo          
//todo      }
    
    
//todo      def "R_2_08___VERSION_NUMBER_MUST_BE_VALID_INTEGER"() 
//todo      {
//todo          given:
//todo              def l_cmd_args = getCommandLineArgs('R_2_08___VERSION_NUMBER_MUST_BE_VALID_INTEGER/C3_CP_EDI_EGD__20111009_V01.cef')
//todo          when:
//todo              def App app = new App()
//todo              def result = app.stages(l_cmd_args)
//todo          then:
//todo              RS2_MetaObjectsException ex = thrown()
//todo              ex.getError() == RS2_MetaObjectsException.Error.R_2_08___VERSION_NUMBER_MUST_BE_VALID_INTEGER
//todo          
//todo      }
    
    
//todo      def "R_2_09___FILE_TIME_SPAN_MUST_BE_ISO_TIME_RANGE"() 
//todo      {
//todo          given:
//todo              def l_cmd_args = getCommandLineArgs('R_2_09___FILE_TIME_SPAN_MUST_BE_ISO_TIME_RANGE/C3_CP_EDI_EGD__20111009_V01.cef')
//todo          when:
//todo              def App app = new App()
//todo              def result = app.stages(l_cmd_args)
//todo          then:
//todo              RS2_MetaObjectsException ex = thrown()
//todo              ex.getError() == RS2_MetaObjectsException.Error.R_2_09___FILE_TIME_SPAN_MUST_BE_ISO_TIME_RANGE
//todo          
//todo      }
    
    
//todo      def "R_2_10___FILE_TIME_SPAN_START_TIME_MUST_BE_BEFORE_STOP_TIME"() 
//todo      {
//todo          given:
//todo              def l_cmd_args = getCommandLineArgs('R_2_10___FILE_TIME_SPAN_START_TIME_MUST_BE_BEFORE_STOP_TIME/C3_CP_EDI_EGD__20111009_V01.cef')
//todo          when:
//todo              def App app = new App()
//todo              def result = app.stages(l_cmd_args)
//todo          then:
//todo              RS2_MetaObjectsException ex = thrown()
//todo              ex.getError() == RS2_MetaObjectsException.Error.R_2_10___FILE_TIME_SPAN_START_TIME_MUST_BE_BEFORE_STOP_TIME
//todo          
//todo      }
    
                      
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
    
    

}

    
    
    
    
    
    
    












