/*
  * @author sp, @date 19/07/14 22:43
 */

import spock.lang.Specification

import org.springframework.util.ResourceUtils

import cefpass.App
import cefpass.CefParser
import exceptions.CefException

import spock.lang.Unroll

class I_RS1_GlobalAttributes_Tests_v2 extends Specification{

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
            //x CefException ex = thrown()
            //x ex.matches(l_rule_name) == true
            (result.isError == true) && (result.stage_results.STAGE_4.lastError.tag == l_rule_name)
        where :
            [rule_name, test_file, test_cmd_args, test_ix, total_ix, rule_test_name] <<  Helper_Resources.getMultiRuleTestsArgsList_v2([
                                                                                "R_1_00___FILENAME_MUST_EXIST",
                                                                                "R_1_01___FILENAME_MATCHES_ACTUAL",
                                                                                "R_1_02___FILE_FORMAT_VERSION_MUST_EXIST",
                                                                                "R_1_03___END_OF_RECORD_MARKER_MUST_EXIST"
                                                                  ])
    }



 
}
