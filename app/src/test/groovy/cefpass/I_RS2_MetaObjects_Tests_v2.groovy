import spock.lang.Specification

import org.springframework.util.ResourceUtils

import cefpass.App
import cefpass.CefParser
import exceptions.RS2_MetaObjectsException
import spock.lang.Unroll

import Helper_Resources;

//x @Unroll
class I_RS2_MetaObjects_Tests_v2 extends Specification{

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
            RS2_MetaObjectsException ex = thrown()
            ex.matches(l_rule_name) == true
        where :
            [rule_name, test_file, test_cmd_args, test_ix, total_ix, rule_test_name] <<  Helper_Resources.getMultiRuleTestsArgsList_v2([
                                                                        "R_2_00___MUST_HAVE_ENTRY",
                                                                        "R_2_02___ENTRY_MISMATCH_VALUE_TYPE",
//..                                                                          "R_2_03___REQUIRED_VARIABLES_XXXX",
                                                                        "R_2_04___FILE_TYPE_MUST_BE_CEF",
                                                                        "R_2_05___DATASET_VERSION_MUST_BE_VALID_INTEGER",
                                                                        "R_2_06___LOGICAL_FILE_ID_MATCHES_FILENAME",
                                                                        "R_2_07___VERSION_NUMBER_MUST_BE_VALID_INTEGER",
                                                                        "R_2_08___VERSION_NUMBER_MATCHES_FILENAME",
                                                                        "R_2_09___FILE_TIME_SPAN_MUST_BE_ISO_TIME_RANGE",
                                                                        "R_2_10___FILE_TIME_SPAN_START_TIME_MUST_BE_BEFORE_STOP_TIME",
                                                                        //x "R_2_11___DATA_RECORD_TIME_STAMP_MUST_BE_BETWEEN_FILE_TIME_SPAN"
                                                                  ])
    }
}

