package rules2015

import cefpass.CefLog
import cefpass.Utils
import cefpass.CmdLnArgs
import cefpass.CefResult

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
//x             Test_Func:         {
//x                 if(Utils.isQuotedString(m_data.headerXPath.getFilename()) == false) 
//x                     fatal_error(RS1_GlobalAttributesException.Error.R_1_00___FILENAME_MUST_EXIST)
//x                 
//x                 "OK"
//x             }
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
            
//x             Test_Func:         {
//x                 def l_filename = Utils.getUnQuotedString(m_data.headerXPath.getFilename())
//x                 
//x                 if(CmdLnArgs.getFilename() != l_filename) 
//x                     fatal_error(RS1_GlobalAttributesException.Error.R_1_01___FILENAME_MATCHES_ACTUAL)
//x                 
//x                 "OK"
//x             }
            
            Test_Func:         {
                def l_result = new CefResult("R_1_01___FILENAME_MATCHES_ACTUAL")
                
                def l_filename = Utils.getUnQuotedString(m_data.headerXPath.getFilename())
                
                if(CmdLnArgs.getFilename() == l_filename) 
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
//x             Test_Func:         {
//x                 
//x                 if(Utils.isQuotedString(m_data.headerXPath.getFileFormatVersion()) == false) 
//x                     fatal_error(RS1_GlobalAttributesException.Error.R_1_02___FILE_FORMAT_VERSION_MUST_EXIST)
//x                 
//x                 "OK"
//x             }
            
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
//x             Test_Func:         {
//x                 
//x                 if(Utils.isQuotedString(m_data.headerXPath.getEndOfRecordMarker()) == false) 
//x                     fatal_error(RS1_GlobalAttributesException.Error.R_1_03___END_OF_RECORD_MARKER_MUST_EXIST)
//x                 
//x                 "OK"
//x             }
            
            Test_Func:         {
                def l_result = new CefResult("R_1_03___END_OF_RECORD_MARKER_MUST_EXIST")
                
                if(Utils.isQuotedString(m_data.headerXPath.getEndOfRecordMarker()) == true) 
                    l_result.setPass()
                
                l_result
            }
            
        )
    ]

//x     public def run()
//x     {
//x         CefLog.stage4_info("\n  RS1_GlobalAttributes")
//x 
//x         m_rules.each {
//x             //x println it.value
//x             //x println it.value.to_str()
//x             //x it.value.Test_Func()
//x             
//x             CefLog.stage4_info(it.value.about(), it.value.Test_Func())     
//x         }
//x     }
//x     
//todo    public def run()
//todo    {
//todo        CefLog.stage4_info("\n  RS1_GlobalAttributes")
//todo
//todo        m_rules.each {
//todo            //x println it.value
//todo            //x println it.value.to_str()
//todo            //x it.value.Test_Func()
//todo            def l_result = "x"
//todo            
//todo            try {
//todo                l_result = it.value.Test_Func()
//todo            }
//todo            catch (Execption e) {
//todo            }
//todo            
//todo            //x CefLog.stage4_info(it.value.about(), it.value.Test_Func())     
//todo            CefLog.stage4_info(it.value.about(), l_result)     
//todo        }
//todo    }
    
}





















