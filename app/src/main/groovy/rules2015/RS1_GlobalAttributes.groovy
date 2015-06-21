package rules2015

import cefpass.CefLog
import cefpass.Utils
import cefpass.CmdLnArgs

import exceptions.RS1_GlobalAttributesException

///////////////////////////////////////////////////////////////////////////////
//

public class RS1_GlobalAttributes extends RuleSet
{
    def m_data
    
    public RS1_GlobalAttributes(i_data)
    {
        m_data = i_data
    }
    
    static def fatal_error(i_error)
    {
        throw new RS1_GlobalAttributesException(i_error)
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
            Description:       "Check FILE_NAME attribute must exist",
            Error_Type:        "Fatal Error",
            Error_Message:     "Missing FILE_NAME Attribute",
            Caveats:           "Within Double Quotes",
            Notes:             "-",
            Test_Func:         {
                
                if(Utils.isQuotedString(m_data.headerXPath.getFilename()) == false) 
                    fatal_error(RS1_GlobalAttributesException.Error.R_1_00___FILENAME_MUST_EXIST)
                
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
            Description:       "Check FILE_NAME attribute value matches actual Filename",
            Error_Type:        "Fatal Error",
            Error_Message:     "Filename and metadata filename do not match",
            Caveats:           "Within Double Quotes",
            Notes:             "-",
            
            Test_Func:         {
                def l_filename = Utils.getUnQuotedString(m_data.headerXPath.getFilename())
                
                if(CmdLnArgs.getFilename() != l_filename) 
                    fatal_error(RS1_GlobalAttributesException.Error.R_1_01___FILENAME_MATCHES_ACTUAL)
                
                "OK"
            }
        ),
        
        R_1_02___FILE_FORMAT_VERSION_MUST_EXIST:                // RULESET 1 rule 02
        new Rule(
            Rule:              "1.02",
            Scope:             "GLOBAL",
            Keyword:           "FILE_FORMAT_VERSION",
            Data_type:         "METADATA",
            Cardinality:       "1",
            Description:       "Check FILE_FORMAT_VERSION attribute must exist",
            Error_Type:        "Fatal Error",
            Error_Message:     "Missing FILE_FORMAT_VERSION",
            Caveats:           "Within Double Quotes",
            Notes:             "-",
            Test_Func:         {
                
                if(Utils.isQuotedString(m_data.headerXPath.getFileFormatVersion()) == false) 
                    fatal_error(RS1_GlobalAttributesException.Error.R_1_02___FILE_FORMAT_VERSION_MUST_EXIST)
                
                "OK"
            }
        ),
        
        R_1_03___END_OF_RECORD_MARKER_MUST_EXIST:               // RULESET 1 rule 03
        new Rule(
            Rule:              "1.03",
            Scope:             "GLOBAL",
            Keyword:           "END_OF_RECORD_MARKER",
            Data_type:         "METADATA",
            Cardinality:       "1",
            Description:       "Check END_OF_RECORD_MARKER attribute must exist (may be blank??)",
            Error_Type:        "Fatal Error",
            Error_Message:     "Missing END_OF_RECORD_MARKER",
            Caveats:           "Within Double Quotes",
            Notes:             "-",
            Test_Func:         {
                
                if(Utils.isQuotedString(m_data.headerXPath.getEndOfRecordMarker()) == false) 
                    fatal_error(RS1_GlobalAttributesException.Error.R_1_03___END_OF_RECORD_MARKER_MUST_EXIST)
                
                "OK"
            }
        )
    ]

    public def run()
    {
        CefLog.stage4_info("\n  RS1_GlobalAttributes")

        m_rules.each {
            //x println it.value
            //x println it.value.to_str()
            //x it.value.Test_Func()
            
            CefLog.stage4_info(it.value.about(), it.value.Test_Func())     
        }
    }
}





















