package rules2015

import cefpass.CefLog
import cefpass.Utils

import exceptions.RuleSet01Exception

///////////////////////////////////////////////////////////////////////////////
//

public class RuleSet01 extends RuleSet
{
    def m_data
    
    public RuleSet01(i_data)
    {
        m_data = i_data
    }
    
    static def fatal_error(i_error)
    {
        throw new RuleSet01Exception(i_error)
    }
    
    def m_rules =
    [
        R_1_00___FILENAME_MUST_EXIST:                           // RULESET 1 rule 00
        new Rule(
            Rule:              "1.00",
            Scope:             "GLOBAL",
            Keyword:           "FILE_NAME",
            Data_type:         "METADATA",
            Cardinality:       "1",
            Description:       "Must exist",
            Error_Type:        "Fatal Error",
            Error_Message:     "Missing FILE_NAME",
            Caveats:           "Within Double Quotes",
            Notes:             "-",
            Test_Func:         {
                
                if(Utils.isQuotedString(m_data.headerXPath.getFilename()) == false) 
                    fatal_error(RuleSet01Exception.Error.R_1_00___FILENAME_MUST_EXIST)
                
                "OK"
            }
        ),
        
        R_1_01___FILENAME_MATCHES_ACTUAL:                       // RULESET 1 rule 01
        new Rule(
            Rule:              "1.01",
            Scope:             "GLOBAL",
            Keyword:           "FILE_NAME",
            Data_type:         "METADATA",
            Cardinality:       "1",
            Description:       "Name of file on disk equals FILE_NAME",
            Error_Type:        "Fatal Error",
            Error_Message:     "Filename and metadata filename do not match",
            Caveats:           "Within Double Quotes",
            Notes:             "-",
            Test_Func:         { "Under Devlopment" }
        ),
        
        R_1_02___FILE_FORMAT_VERSION_MUST_EXIST:                // RULESET 1 rule 02
        new Rule(
            Rule:              "1.02",
            Scope:             "GLOBAL",
            Keyword:           "FILE_FORMAT_VERSION",
            Data_type:         "METADATA",
            Cardinality:       "1",
            Description:       "Must exist",
            Error_Type:        "Fatal Error",
            Error_Message:     "Missing FILE_FORMAT_VERSION",
            Caveats:           "Within Double Quotes",
            Notes:             "-",
            Test_Func:         { "Under Devlopment" }
        ),
        
        R_1_03___END_OF_RECORD_MARKER_MUST_EXIST:               // RULESET 1 rule 03
        new Rule(
            Rule:              "1.03",
            Scope:             "GLOBAL",
            Keyword:           "END_OF_RECORD_MARKER",
            Data_type:         "METADATA",
            Cardinality:       "1",
            Description:       "Must exist BUT may be blank",
            Error_Type:        "Fatal Error",
            Error_Message:     "Missing END_OF_RECORD_MARKER",
            Caveats:           "Within Double Quotes",
            Notes:             "-",
            Test_Func:         { "Under Devlopment" }
        )
    ]

    public def run()
    {
        CefLog.stage4_info("\n  RuleSet01")

        m_rules.each {
            //x println it.value
            //x println it.value.to_str()
            //x it.value.Test_Func()
            
            CefLog.stage4_info(it.value.about(), it.value.Test_Func())     
        }
    }
}





















