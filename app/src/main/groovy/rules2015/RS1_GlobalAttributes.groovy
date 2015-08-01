package rules2015

import cefpass.Utils
//x_args    import cefpass.CmdLnArgs
import cefpass.CmdLnArgs_v2
import cefpass.CefResult

///////////////////////////////////////////////////////////////////////////////
//

public class RS1_GlobalAttributes extends RuleSet
{
    def m_data
    
    public RS1_GlobalAttributes(i_data)
    {
        m_data = i_data
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
                def l_result = new CefResult("R_1_00___FILENAME_MUST_EXIST")
                
                if(Utils.isQuotedString(m_data.headerXPath.getFilename()) == true) 
                    l_result.setPass()
                
                l_result
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
                def l_result = new CefResult("R_1_01___FILENAME_MATCHES_ACTUAL")
                
                def l_filename = Utils.getUnQuotedString(m_data.headerXPath.getFilename())
                
//x_args                if(CmdLnArgs.getFilename() == l_filename) 
                if(CmdLnArgs_v2.getObject().getFilename() == l_filename) 
                    l_result.setPass()
                
                l_result
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
                def l_result = new CefResult("R_1_02___FILE_FORMAT_VERSION_MUST_EXIST")
                
                if(Utils.isQuotedString(m_data.headerXPath.getFileFormatVersion()) == true) 
                    l_result.setPass()
                
                l_result
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
                def l_result = new CefResult("R_1_03___END_OF_RECORD_MARKER_MUST_EXIST")
                
                if(Utils.isQuotedString(m_data.headerXPath.getEndOfRecordMarker()) == true) 
                    l_result.setPass()
                
                l_result
            }
            
        )
    ]
}





















