package rules2015

import cefpass.CefLog

///////////////////////////////////////////////////////////////////////////////
//
// ## Parser Rules.
// ## Rules which are tested during the parsing of the header data 
// (included in cef and ceh files)

// used for message purposes only. 

public class RuleSet00 extends RuleSet
{
    static s_rules =
    [
        R_0_00___START_META___META_UNCLOSED:                         // RULESET 0 rule 00
        new Rule(
            Rule:              "0.00",
            Scope:             "GENERAL",
            Keyword:           "START_META/END_META",
            Data_type:         "METADATA",
            Cardinality:       "NA",
            Description:       "R_0_00___START_META___META_UNCLOSED",
            Error_Type:        "Fatal Error",
            Error_Message:     "R_0_00___START_META___META_UNCLOSED",
            Caveats:           "NA",
            Notes:             "**"
        ),

        R_0_01___START_META___VARIABLE_UNCLOSED:                     // RULESET 0 rule 01
        new Rule(
            Rule:              "0.01",
            Scope:             "GENERAL",
            Keyword:           "START_META/END_META",
            Data_type:         "METADATA",
            Cardinality:       "NA",
            Description:       "R_0_01___START_META___VARIABLE_UNCLOSED",
            Error_Type:        "Fatal Error",
            Error_Message:     "R_0_01___START_META___VARIABLE_UNCLOSED",
            Caveats:           "NA",
            Notes:             "**"
        ),
        
        R_0_02___START_META___NAME_ERROR:                            // RULESET 0 rule 02
        new Rule(
            Rule:              "0.02",
            Scope:             "GENERAL",
            Keyword:           "START_META/END_META",
            Data_type:         "METADATA",
            Cardinality:       "NA",
            Description:       "R_0_02___START_META___NAME_ERROR",
            Error_Type:        "Fatal Error",
            Error_Message:     "R_0_02___START_META___NAME_ERROR",
            Caveats:           "NA",
            Notes:             "**"
        ),
        

        R_0_10___END_META___VARIABLE_OPENED:                         // RULESET 0 rule 10
        new Rule(
            Rule:              "0.10",
            Scope:             "GENERAL",
            Keyword:           "START_META/END_META",
            Data_type:         "METADATA",
            Cardinality:       "NA",
            Description:       "R_0_10___END_META___VARIABLE_OPENED",
            Error_Type:        "Fatal Error",
            Error_Message:     "R_0_10___END_META___VARIABLE_OPENED",
            Caveats:           "NA",
            Notes:             "**"
        ),
        
        R_0_11___END_META___META_UNOPENED:                           // RULESET 0 rule 11
        new Rule(
            Rule:              "0.11",
            Scope:             "GENERAL",
            Keyword:           "START_META/END_META",
            Data_type:         "METADATA",
            Cardinality:       "NA",
            Description:       "R_0_11___END_META___META_UNOPENED",
            Error_Type:        "Fatal Error",
            Error_Message:     "R_0_11___END_META___META_UNOPENED",
            Caveats:           "NA",
            Notes:             "**"
        ),
        
        R_0_12___END_META___NAME_ERROR:                              // RULESET 0 rule 12
        new Rule(
            Rule:              "0.12",
            Scope:             "GENERAL",
            Keyword:           "START_META/END_META",
            Data_type:         "METADATA",
            Cardinality:       "NA",
            Description:       "R_0_12___END_META___NAME_ERROR",
            Error_Type:        "Fatal Error",
            Error_Message:     "R_0_12___END_META___NAME_ERROR",
            Caveats:           "NA",
            Notes:             "**"
        ),
        

        R_0_20___START_VARIABLE___VARIABLE_UNCLOSED:                 // RULESET 0 rule 20
        new Rule(
            Rule:              "0.20",
            Scope:             "GENERAL",
            Keyword:           "START_META/END_META",
            Data_type:         "METADATA",
            Cardinality:       "NA",
            Description:       "R_0_20___START_VARIABLE___VARIABLE_UNCLOSED",
            Error_Type:        "Fatal Error",
            Error_Message:     "R_0_20___START_VARIABLE___VARIABLE_UNCLOSED",
            Caveats:           "NA",
            Notes:             "**"
        ),
        
        R_0_21___START_VARIABLE___META_UNCLOSED:                     // RULESET 0 rule 21
        new Rule(
            Rule:              "0.21",
            Scope:             "GENERAL",
            Keyword:           "START_META/END_META",
            Data_type:         "METADATA",
            Cardinality:       "NA",
            Description:       "R_0_21___START_VARIABLE___META_UNCLOSED",
            Error_Type:        "Fatal Error",
            Error_Message:     "R_0_21___START_VARIABLE___META_UNCLOSED",
            Caveats:           "NA",
            Notes:             "**"
        ),
        
        R_0_22___START_VARIABLE___NAME_ERROR:                        // RULESET 0 rule 22
        new Rule(
            Rule:              "0.22",
            Scope:             "GENERAL",
            Keyword:           "START_META/END_META",
            Data_type:         "METADATA",
            Cardinality:       "NA",
            Description:       "R_0_22___START_VARIABLE___NAME_ERROR",
            Error_Type:        "Fatal Error",
            Error_Message:     "R_0_22___START_VARIABLE___NAME_ERROR",
            Caveats:           "NA",
            Notes:             "**"
        ),
        

        R_0_30___END_VARIABLE___META_OPENED:                         // RULESET 0 rule 30
        new Rule(
            Rule:              "0.30",
            Scope:             "GENERAL",
            Keyword:           "START_META/END_META",
            Data_type:         "METADATA",
            Cardinality:       "NA",
            Description:       "R_0_30___END_VARIABLE___META_OPENED",
            Error_Type:        "Fatal Error",
            Error_Message:     "R_0_30___END_VARIABLE___META_OPENED",
            Caveats:           "NA",
            Notes:             "**"
        ),
        
        R_0_31___END_VARIABLE___VARIABLE_UNOPENED:                   // RULESET 0 rule 31
        new Rule(
            Rule:              "0.31",
            Scope:             "GENERAL",
            Keyword:           "START_META/END_META",
            Data_type:         "METADATA",
            Cardinality:       "NA",
            Description:       "R_0_31___END_VARIABLE___VARIABLE_UNOPENED",
            Error_Type:        "Fatal Error",
            Error_Message:     "R_0_31___END_VARIABLE___VARIABLE_UNOPENED",
            Caveats:           "NA",
            Notes:             "**"
        ),
        
        R_0_32___END_VARIABLE___NAME_ERROR:                          // RULESET 0 rule 32
        new Rule(
            Rule:              "0.32",
            Scope:             "GENERAL",
            Keyword:           "START_META/END_META",
            Data_type:         "METADATA",
            Cardinality:       "NA",
            Description:       "R_0_32___END_VARIABLE___NAME_ERROR",
            Error_Type:        "Fatal Error",
            Error_Message:     "R_0_32___END_VARIABLE___NAME_ERROR",
            Caveats:           "NA",
            Notes:             "**"
        ),
        
        
        R_0_40___INCLUDE_FILE_DUPLICATE:                             // RULESET 0 rule 40
        new Rule(
            Rule:              "0.40",
            Scope:             "GENERAL",
            Keyword:           "INCLUDE_FILE",
            Data_type:         "METADATA",
            Cardinality:       "NA",
            Description:       "R_0_40___INCLUDE_FILE_DUPLICATE",
            Error_Type:        "Fatal Error",
            Error_Message:     "R_0_40___INCLUDE_FILE_DUPLICATE",
            Caveats:           "NA",
            Notes:             "**"
        ),
        
        R_0_41___INCLUDE_FILE_UNFOUND:                               // RULESET 0 rule 41
        new Rule(
            Rule:              "0.41",
            Scope:             "GENERAL",
            Keyword:           "INCLUDE_FILE",
            Data_type:         "METADATA",
            Cardinality:       "NA",
            Description:       "R_0_41___INCLUDE_FILE_UNFOUND",
            Error_Type:        "Fatal Error",
            Error_Message:     "R_0_41___INCLUDE_FILE_UNFOUND",
            Caveats:           "NA",
            Notes:             "**"
        ),
        
        R_0_42___INCLUDE_FILE_LEVEL_8:                                // RULESET 0 rule 42
        new Rule(
            Rule:              "0.42",
            Scope:             "GENERAL",
            Keyword:           "INCLUDE_FILE",
            Data_type:         "METADATA",
            Cardinality:       "NA",
            Description:       "R_0_42___INCLUDE_FILE_LEVEL_8",
            Error_Type:        "Fatal Error",
            Error_Message:     "R_0_42___INCLUDE_FILE_LEVEL_8",
            Caveats:           "NA",
            Notes:             "**"
        )
    ]
    
    static def getRules() { s_rules }
    static def getRule(k) { s_rules[k] }
    
    static showAll() 
    {
        s_rules.each {
            CefLog.stage2_info(it.value.about(), "PASSED")
        }
    }
}

