/*
  * @author sp, @date 19/07/14 22:43
 */

import spock.lang.Specification

import org.springframework.util.ResourceUtils

import cefpass.App
import cefpass.CefParser
import exceptions.RS2_MetaObjectsException

class I_RS2_MetaObjects_Tests extends Specification{

    def setup()
    {
        CefParser.init() 
    }

    def getParent(i_path)
    {
        def l_file = new File(i_path)
        return l_file.getParent()
    }
    
    def getTestResourcePath(i_relative_path)
    {
        File l_file = ResourceUtils.getFile(this.getClass().getResource(i_relative_path))
        
        return l_file.getAbsolutePath()
    }
    
    String[] getCommandLineArgs(i_relative_path)
    {
        def l_path = getTestResourcePath(i_relative_path)
        def l_parent = getParent(l_path)
        
        String[] l_args = [
            "-f",
            l_path,
            "-i",
            l_parent,
            "-l",
            "C:/work.dev/2015.03.22 github cef pass v2/v0/_logs"    // TODO FIXME FOR LINUX!!
        ]
    }
    
    String[][] getCommandLineArgsList(i_relative_path)
    {
        def l_argsList = [];
        def l_path = getTestResourcePath(i_relative_path)
        
        new File(l_path).eachFileMatch(~/.*.(?i)CEF/) { file ->  
            println "##### >>>> " + file.getName()  
            
            String[] l_args = [
                "-f",
                file.getCanonicalPath(),
                "-i",
                l_path,
                "-l",
                "C:/Dump/_logs"    // TODO FIXME FOR LINUX!!
            ]
            
            l_argsList << l_args
        }      
        
        l_argsList
    }

    
    
    
    ///////////////////////////////////////////////////////////////////////////////
    //

//x     def "R_2_04___FILE_TYPE_MUST_BE_CEF"() 
//x     {
//x         setup:
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

    def "R_2_00___MUST_HAVE_ENTRY"() 
    {
        setup:
            def l_cmd_args = getCommandLineArgs('R_2_00___MUST_HAVE_ENTRY/C3_CP_EDI_EGD__20111009_V01.cef')
        when:
            def App app = new App()
            def result = app.stages(l_cmd_args)
        then:
            RS2_MetaObjectsException ex = thrown()
            ex.getError() == RS2_MetaObjectsException.Error.R_2_00___MUST_HAVE_ENTRY
        
    }
    
    def "R_2_00___MUST_HAVE_ENTRY NEW METHOD MULTIPLE INPUTS WHERE CLAUSE"() 
    {
        given:
            println l_cmd_args
            def App app = new App()
        when:
            def result = app.stages(l_cmd_args)
        then:
            RS2_MetaObjectsException ex = thrown()
            ex.getError() == RS2_MetaObjectsException.Error.R_2_00___MUST_HAVE_ENTRY
            
        where :
            l_cmd_args << getCommandLineArgsList('R_2_00___MUST_HAVE_ENTRY')
    }    
    
    
    
    
    
//todo      def "R_2_02___ENTRY_MISMATCH_VALUE_TYPE"() 
//todo      {
//todo          setup:
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
//todo          setup:
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
        setup:
            def l_cmd_args = getCommandLineArgs('R_2_04___FILE_TYPE_MUST_BE_CEF/C3_CP_EDI_EGD__20111009_V01.cef')
        when:
            def App app = new App()
            def result = app.stages(l_cmd_args)
        then:
            RS2_MetaObjectsException ex = thrown()
            ex.getError() == RS2_MetaObjectsException.Error.R_2_04___FILE_TYPE_MUST_BE_CEF
        
    }
    
    
//todo      def "R_2_05___DATASET_VERSION_MUST_BE_VALID_INTEGER"() 
//todo      {
//todo          setup:
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
//todo          setup:
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
//todo          setup:
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
//todo          setup:
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
//todo          setup:
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
//todo          setup:
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
//todo          setup:
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

    
    
    
    
    
    
    












