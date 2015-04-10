/*
 * This Spock specification was auto generated by running 'gradle init --type groovy-library'
 * by 'sp' at '19/07/14 22:43' with Gradle 1.12
 *
 * @author sp, @date 19/07/14 22:43
 */

import spock.lang.Specification

import cefpass.App
import org.springframework.util.ResourceUtils

class RuleSet00_Tests extends Specification{

    def getTestResourcePath(i_path)
    {
        //x File l_file = ResourceUtils.getFile(this.getClass().getResource('RuleSet00_00_b/C3_CP_EDI_EGD__20111009_V01.cef'))
        File l_file = ResourceUtils.getFile(this.getClass().getResource(i_path))
        
        return l_file.getAbsolutePath()
    }

    ///////////////////////////////////////////////////////////////////////////////
    //

    def "RuleSet00_00_a - warm-up read file only"() {
    
        setup:
            def l_path = getTestResourcePath('RuleSet00_00_a/C3_CP_EDI_EGD__20111009_V01.cef')
        when:
            def result = (l_path != null)
        then:
            result == true
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    //
    //      Rule:              "0.00",
    //      Scope:             "GENERAL",
    //      Keyword:           "START_META/END_META",
    //      Data_type:         "METADATA",
    //      Cardinality:       "NA",
    //      Description:       "All START_META must have END_META",
    //      Error_Type:        "Fatal Error",
    //      Error_Message:     "Syntax error – START_META/ END_META mismatch",
    //      Caveats:           "NA",
    //      Notes:             "** Moved from 2.00 - Parser stage **"
    //        

    def "RuleSet00_00_b - test "() {
    
        setup:
            def l_path = getTestResourcePath('RuleSet00_00_b/C3_CP_EDI_EGD__20111009_V01.cef')
        
            def App app = new App()
            String[] l_args = [
                "-f",
                l_path,
                "-l",
                "C:/work.dev/2015.03.22 github cef pass v2/v0/_logs"
            ]
        
        when:
            def result = app.stages(l_args)
        then:
            result == true
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    //
    //      Rule:              "0.01",
    //      Scope:             "GENERAL",
    //      Keyword:           "START_VARIABLE/END_VARIABLE",
    //      Data_type:         "METADATA",
    //      Cardinality:       "NA",
    //      Description:       "All START_VARIABLE must have END_VARIABLE",
    //      Error_Type:        "Fatal Error",
    //      Error_Message:     "Syntax error – START_VARIABLE/ END_VARIABLE mismatch",
    //      Caveats:           "NA",
    //      Notes:             "-"
    //

    def "RuleSet00_01_a - test "() {
    
        setup:
            def l_path = getTestResourcePath('RuleSet00_01_a/C3_CP_EDI_EGD__20111009_V01.cef')

            def App app = new App()
            String[] l_args = [
                "-f",
                l_path,
                "-l",
                "C:/work.dev/2015.03.22 github cef pass v2/v0/_logs"
            ]
        
        when:
            def result = app.stages(l_args)
        then:
            result == true
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    //
    //      Rule:              "0.02",
    //      Scope:             "GLOBAL",
    //      Keyword:           "INCLUDE",
    //      Data_type:         "METADATA",
    //      Cardinality:       "0..n",
    //      Description:       "All include files must exist",
    //      Error_Type:        "Warning",
    //      Error_Message:     "Include file may not exist, but all required metadata may exist in other files?",
    //      Caveats:           "Within Double Quotes",
    //      Notes:             "** Moved from 1.04 - Parser stage **"
    
    def "RuleSet00_02_a - test "() {
    
        setup:
            def l_path = getTestResourcePath('RuleSet00_02_a/C3_CP_EDI_EGD__20111009_V01.cef')
        
            def App app = new App()
            String[] l_args = [
                "-f",
                l_path,
                "-l",
                "C:/work.dev/2015.03.22 github cef pass v2/v0/_logs"
            ]
        
        when:
            def result = app.stages(l_args)
        then:
            result == true
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}





