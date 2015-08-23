/*
 * @author sp, @date 19/07/14 22:43
 */

import spock.lang.Specification

import org.springframework.util.ResourceUtils

import cefpass.App
import cefpass.CefParser
import exceptions.CefException
import spock.lang.Unroll

class I_RS0_CefParser_Tests_v2 extends Specification{

    def setup()
    {
        CefParser.init() 
    }

    ///////////////////////////////////////////////////////////////////////////////
    //

    @Unroll
    def "#rule_test_name"() 
    {
        given:
            def l_rule_name = rule_name
            def App app = new App()
        when:
            def result = app.stages((String[])test_cmd_args)
        then:
            (result.isError == true) && (result.stage_results.STAGE_2.exception.toString() == l_rule_name)
        where :
            [rule_name, test_file, test_cmd_args, test_ix, total_ix, rule_test_name] <<  Helper_Resources.getMultiRuleTestsArgsList_v2([
                                                                        "R_0_00___START_META___META_UNCLOSED",
                                                                        "R_0_01___START_META___VARIABLE_UNCLOSED",
                                                                        "R_0_02___START_META___NAME_ERROR",

                                                                        "R_0_10___END_META___VARIABLE_OPENED",
                                                                        "R_0_11___END_META___META_UNOPENED",
                                                                        "R_0_12___END_META___NAME_ERROR",

                                                                        "R_0_20___START_VARIABLE___VARIABLE_UNCLOSED",
                                                                        "R_0_21___START_VARIABLE___META_UNCLOSED",
                                                                        "R_0_22___START_VARIABLE___NAME_ERROR",

                                                                        "R_0_30___END_VARIABLE___META_OPENED",
                                                                        "R_0_31___END_VARIABLE___VARIABLE_UNOPENED",
                                                                        "R_0_32___END_VARIABLE___NAME_ERROR",

                                                                        "R_0_40___INCLUDE_FILE_DUPLICATE",
                                                                        "R_0_41___INCLUDE_FILE_UNFOUND",
                                                                        "R_0_42___INCLUDE_FILE_LEVEL_8",

                                                                        "R_0_50___MALFORMED_READ_LINE",
                                                                        "R_0_51___MALFORMED_STRING_QUOTES"
                                                                  ])
    }
}

















