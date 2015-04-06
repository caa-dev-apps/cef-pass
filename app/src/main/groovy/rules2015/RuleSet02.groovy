package rules2015

import cefpass.CefLog

///////////////////////////////////////////////////////////////////////////////
//

public class RuleSet02 extends RuleSet
{
    
//x         def i_data = [
//x             headerXPath: i_headerXPath,
//x             info: [ a:1, b:2, c:3]
//x         ]
    
    def m_data
    
    public RuleSet02(i_data)
    {
        m_data = i_data
    }
    
    def Rule_2_01()
    {
        def l_rule = new Rule(
            Rule:              "2.01",
            Scope:             "GENERAL",
            Keyword:           "START_META/END_META",
            Data_type:         "METADATA",
            Cardinality:       "NA",
            Description:       "Must have ENTRY= field",
            Error_Type:        "Fatal Error",
            Error_Message:     "VARIABLE <x> EMPTY",
            Caveats:           "NA",
            Notes:             "-"
        )
        
        CefLog.stage4_info(l_rule.about(), "SKIPPED")      
    }

    def Rule_2_02()
    {
        def l_rule = new Rule(
            Rule:              "2.02",
            Scope:             "GENERAL",
            Keyword:           "START_META/END_META",
            Data_type:         "METADATA",
            Cardinality:       "NA",
            Description:       "If VALUE_TYPE provided, value must be of type indicated",
            Error_Type:        "Fatal Error",
            Error_Message:     "VARIABLE <x> VALUE DOES NOT MATCH TYPE",
            Caveats:           "NA",
            Notes:             "-"
        )
        
        CefLog.stage4_info(l_rule.about(), "SKIPPED")      
    }

    def Rule_2_03()
    {
        def l_rule = new Rule(
            Rule:              "2.03",
            Scope:             "GENERAL",
            Keyword:           "START_META/END_META",
            Data_type:         "METADATA",
            Cardinality:       "1",
            Description:       "REQUIRED VARIABLES (below)",
            Error_Type:        "Fatal Error",
            Error_Message:     "MISSING <x> VARIABLE",
            Caveats:           "NA",
            Notes:             "-"
        )
        
        CefLog.stage4_info(l_rule.about(), "SKIPPED")      
    }

    def Rule_2_04()
    {
        def l_rule = new Rule(
            Rule:              "2.04",
            Scope:             "GENERAL",
            Keyword:           "FILE_TYPE",
            Data_type:         "METADATA",
            Cardinality:       "1",
            Description:       "must be cef",
            Error_Type:        "Fatal Error",
            Error_Message:     "FILE_TYPE is not CEF, unable to validate non CEF files",
            Caveats:           "NA",
            Notes:             "-"
        )
        
        CefLog.stage4_info(l_rule.about(), "SKIPPED")      
    }

    def Rule_2_05()
    {
        def l_rule = new Rule(
            Rule:              "2.05",
            Scope:             "GENERAL",
            Keyword:           "DATASET_VERSION",
            Data_type:         "METADATA",
            Cardinality:       "1",
            Description:       "must be valid integer",
            Error_Type:        "Fatal Error",
            Error_Message:     "Invalid value",
            Caveats:           "NA",
            Notes:             "-"
        )
        
        CefLog.stage4_info(l_rule.about(), "SKIPPED")      
    }

    def Rule_2_06()
    {
        def l_rule = new Rule(
            Rule:              "2.06",
            Scope:             "GENERAL",
            Keyword:           "LOGICAL_FILE_ID",
            Data_type:         "METADATA",
            Cardinality:       "1",
            Description:       "Same as Filename without extension",
            Error_Type:        "Fatal Error?",
            Error_Message:     "Logical File ID does not match filename",
            Caveats:           "NA",
            Notes:             "-"
        )
        
        CefLog.stage4_info(l_rule.about(), "SKIPPED")      
    }

    def Rule_2_07()
    {
        def l_rule = new Rule(
            Rule:              "2.07",
            Scope:             "GENERAL",
            Keyword:           "VERSION_NUMBER",
            Data_type:         "METADATA",
            Cardinality:       "1",
            Description:       "VERSION_NUMBER must match version number in filename",
            Error_Type:        "Fatal Error",
            Error_Message:     "VERSION_NUMBER does not match version in filename",
            Caveats:           "NA",
            Notes:             "-"
        )
        
        CefLog.stage4_info(l_rule.about(), "SKIPPED")      
    }

    def Rule_2_08()
    {
        def l_rule = new Rule(
            Rule:              "2.08",
            Scope:             "GENERAL",
            Keyword:           "VERSION_NUMBER",
            Data_type:         "METADATA",
            Cardinality:       "1",
            Description:       "must be valid integer",
            Error_Type:        "Fatal Error",
            Error_Message:     "Invalid value",
            Caveats:           "NA",
            Notes:             "-"
        )
        
        CefLog.stage4_info(l_rule.about(), "SKIPPED")      
    }

    def Rule_2_09()
    {
        def l_rule = new Rule(
            Rule:              "2.09",
            Scope:             "GENERAL",
            Keyword:           "FILE_TIME_SPAN",
            Data_type:         "METADATA",
            Cardinality:       "1",
            Description:       "must be ISO_TIME_RANGE",
            Error_Type:        "Fatal Error",
            Error_Message:     "VARIABLE <x> Invalid Format",
            Caveats:           "NA",
            Notes:             "-"
        )
        
        CefLog.stage4_info(l_rule.about(), "SKIPPED")      
    }

    def Rule_2_10()
    {
        def l_rule = new Rule(
            Rule:              "2.10",
            Scope:             "GENERAL",
            Keyword:           "FILE_TIME_SPAN",
            Data_type:         "METADATA",
            Cardinality:       "1",
            Description:       "START_TIME must be before STOP TIME",
            Error_Type:        "Fatal Error",
            Error_Message:     "VARIABLE <x> Start Time must be before Stop time",
            Caveats:           "NA",
            Notes:             "-"
        )
        
        CefLog.stage4_info(l_rule.about(), "SKIPPED")      
    }

    def Rule_2_11()
    {
        def l_rule = new Rule(
            Rule:              "2.11",
            Scope:             "GENERAL",
            Keyword:           "FILE_TIME_SPAN",
            Data_type:         "METADATA / DATA",
            Cardinality:       "1",
            Description:       "Timespan of data RECORDS must be between FILE_TIME_SPAN",
            Error_Type:        "Fatal Error",
            Error_Message:     "Data outside FILE_TIME_SPAN",
            Caveats:           "NA",
            Notes:             "-"
        )
        
        CefLog.stage4_info(l_rule.about(), "SKIPPED")      
    }

    public def run()
    {
        CefLog.stage4_info("\n  RuleSet02")
        
        Rule_2_01();
        Rule_2_02();
        Rule_2_03();
        Rule_2_04();        
        Rule_2_05();
        Rule_2_06();
        Rule_2_07();
        Rule_2_08();
        Rule_2_09();        
        Rule_2_10();
        Rule_2_11();
    }
}
















