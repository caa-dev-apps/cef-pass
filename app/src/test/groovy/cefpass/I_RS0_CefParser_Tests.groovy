/*
 * @author sp, @date 19/07/14 22:43
 */

import spock.lang.Specification

import org.springframework.util.ResourceUtils

import cefpass.App
import cefpass.CefParser
import exceptions.RS0_CefParserException

class I_RS0_CefParser_Tests extends Specification{

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
    
    ///////////////////////////////////////////////////////////////////////////////
    //

    def "R_0_00___START_META___META_UNCLOSED"() 
    {
        setup:
            def l_cmd_args = getCommandLineArgs('R_0_00___START_META___META_UNCLOSED/C3_CP_EDI_EGD__20111009_V01.cef')
        when:
            def App app = new App()
            def result = app.stages(l_cmd_args)
        then:
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_00___START_META___META_UNCLOSED
        
    }
    def "R_0_01___START_META___VARIABLE_UNCLOSED"() 
    {
        setup:
            def l_cmd_args = getCommandLineArgs('R_0_01___START_META___VARIABLE_UNCLOSED/C3_CP_EDI_EGD__20111009_V01.cef')
        when:
            def App app = new App()
            def result = app.stages(l_cmd_args)
        then:
            RS0_CefParserException ex = thrown()
            println ex.getError()
            ex.getError() == RS0_CefParserException.Error.R_0_01___START_META___VARIABLE_UNCLOSED
        
    }
    def "R_0_02___START_META___NAME_ERROR"() 
    {
        setup:
            def l_cmd_args = getCommandLineArgs('R_0_02___START_META___NAME_ERROR/C3_CP_EDI_EGD__20111009_V01.cef')
        when:
            def App app = new App()
            def result = app.stages(l_cmd_args)
        then:
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_02___START_META___NAME_ERROR
        
    }

    def "R_0_10___END_META___VARIABLE_OPENED"() 
    {
        setup:
            def l_cmd_args = getCommandLineArgs('R_0_10___END_META___VARIABLE_OPENED/C3_CP_EDI_EGD__20111009_V01.cef')
        when:
            def App app = new App()
            def result = app.stages(l_cmd_args)
        then:
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_10___END_META___VARIABLE_OPENED
        
    }
    def "R_0_11___END_META___META_UNOPENED"() 
    {
        setup:
            def l_cmd_args = getCommandLineArgs('R_0_11___END_META___META_UNOPENED/C3_CP_EDI_EGD__20111009_V01.cef')
        when:
            def App app = new App()
            def result = app.stages(l_cmd_args)
        then:
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_11___END_META___META_UNOPENED
        
    }
    def "R_0_12___END_META___NAME_ERROR"() 
    {
        setup:
            def l_cmd_args = getCommandLineArgs('R_0_12___END_META___NAME_ERROR/C3_CP_EDI_EGD__20111009_V01.cef')
        when:
            def App app = new App()
            def result = app.stages(l_cmd_args)
        then:
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_12___END_META___NAME_ERROR
        
    }

    def "R_0_20___START_VARIABLE___VARIABLE_UNCLOSED"() 
    {
        setup:
            def l_cmd_args = getCommandLineArgs('R_0_20___START_VARIABLE___VARIABLE_UNCLOSED/C3_CP_EDI_EGD__20111009_V01.cef')
        when:
            def App app = new App()
            def result = app.stages(l_cmd_args)
        then:
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_20___START_VARIABLE___VARIABLE_UNCLOSED
        
    }
    def "R_0_21___START_VARIABLE___META_UNCLOSED"() 
    {
        setup:
            def l_cmd_args = getCommandLineArgs('R_0_21___START_VARIABLE___META_UNCLOSED/C3_CP_EDI_EGD__20111009_V01.cef')
        when:
            def App app = new App()
            def result = app.stages(l_cmd_args)
        then:
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_21___START_VARIABLE___META_UNCLOSED
        
    }
    def "R_0_22___START_VARIABLE___NAME_ERROR"() 
    {
        setup:
            def l_cmd_args = getCommandLineArgs('R_0_22___START_VARIABLE___NAME_ERROR/C3_CP_EDI_EGD__20111009_V01.cef')
        when:
            def App app = new App()
            def result = app.stages(l_cmd_args)
        then:
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_22___START_VARIABLE___NAME_ERROR
        
    }

    def "R_0_30___END_VARIABLE___META_OPENED"() 
    {
        setup:
            def l_cmd_args = getCommandLineArgs('R_0_30___END_VARIABLE___META_OPENED/C3_CP_EDI_EGD__20111009_V01.cef')
        when:
            def App app = new App()
            def result = app.stages(l_cmd_args)
        then:
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_30___END_VARIABLE___META_OPENED
        
    }
    def "R_0_31___END_VARIABLE___VARIABLE_UNOPENED"() 
    {
        setup:
            def l_cmd_args = getCommandLineArgs('R_0_31___END_VARIABLE___VARIABLE_UNOPENED/C3_CP_EDI_EGD__20111009_V01.cef')
        when:
            def App app = new App()
            def result = app.stages(l_cmd_args)
        then:
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_31___END_VARIABLE___VARIABLE_UNOPENED
        
    }
    def "R_0_32___END_VARIABLE___NAME_ERROR"() 
    {
        setup:
            def l_cmd_args = getCommandLineArgs('R_0_32___END_VARIABLE___NAME_ERROR/C3_CP_EDI_EGD__20111009_V01.cef')
        when:
            def App app = new App()
            def result = app.stages(l_cmd_args)
        then:
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_32___END_VARIABLE___NAME_ERROR
        
    }
        
    def "R_0_40___INCLUDE_FILE_DUPLICATE"() 
    {
        setup:
            def l_cmd_args = getCommandLineArgs('R_0_40___INCLUDE_FILE_DUPLICATE/C3_CP_EDI_EGD__20111009_V01.cef')
        when:
            def App app = new App()
            def result = app.stages(l_cmd_args)
        then:
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_40___INCLUDE_FILE_DUPLICATE
        
    }
    def "R_0_41___INCLUDE_FILE_UNFOUND"() 
    {
        setup:
            def l_cmd_args = getCommandLineArgs('R_0_41___INCLUDE_FILE_UNFOUND/C3_CP_EDI_EGD__20111009_V01.cef')
        when:
            def App app = new App()
            def result = app.stages(l_cmd_args)
        then:
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_41___INCLUDE_FILE_UNFOUND
        
    }
    def "R_0_42___INCLUDE_FILE_LEVEL_8"() 
    {
        setup:
            def l_cmd_args = getCommandLineArgs('R_0_42___INCLUDE_FILE_LEVEL_8/C3_CP_EDI_EGD__20111009_V01.cef')
        when:
            def App app = new App()
            def result = app.stages(l_cmd_args)
        then:
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_42___INCLUDE_FILE_LEVEL_8
    }
    
    def "R_0_50___MALFORMED_READ_LINE"() 
    {
        setup:
            def l_cmd_args = getCommandLineArgs('R_0_50___MALFORMED_READ_LINE/C3_CP_EDI_EGD__20111009_V01.cef')
        when:
            def App app = new App()
            def result = app.stages(l_cmd_args)
        then:
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_50___MALFORMED_READ_LINE
    }

    def "R_0_51___MALFORMED_STRING_QUOTES"() 
    {
        setup:
            def l_cmd_args = getCommandLineArgs('R_0_51___MALFORMED_STRING_QUOTES/C3_CP_EDI_EGD__20111009_V01.cef')
        when:
            def App app = new App()
            def result = app.stages(l_cmd_args)
        then:
            RS0_CefParserException ex = thrown()
            ex.getError() == RS0_CefParserException.Error.R_0_51___MALFORMED_STRING_QUOTES
    }
    
}
















