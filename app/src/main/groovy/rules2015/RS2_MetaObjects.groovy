package rules2015

import cefpass.CefResult

///////////////////////////////////////////////////////////////////////////////
//

public class RS2_MetaObjects extends RuleSet
{
    def m_data
    
    public RS2_MetaObjects(i_data)
    {
        m_data = i_data
    }
    
    def m_rules =
    [
        R_2_00___MUST_HAVE_ENTRY:                                                       // RULESET 1 rule 00
        new Rule(
            Rule:              "2.00",
            Scope:             "GENERAL",
            Keyword:           "START_META/END_META",
            Data_type:         "METADATA",
            Cardinality:       "NA",
            Description:       "Check METADATA must have ENTRY = field",
            Error_Type:        "Fatal Error",
            Error_Message:     "Empty Meta Object(s)",
            Caveats:           "NA",
            Notes:             "-",
            Test_Func:         {
    
                def l_result = new CefResult("R_2_00___MUST_HAVE_ENTRY")

                // number of empty meta objects -> def countEmptyMetaObjects()
                if(m_data.headerXPath.hasEmptyMetaObjects() == false)
                    l_result.setPass()
                
                l_result
            }
        ),        

        //x R_2_01___XXXXXXXXXXXXXXXXXXXXXXXXX:                                             
        //x //x 
        //x //x 
        //x //x 
        //x //x 
        //x 
        
        R_2_02___ENTRY_MISMATCH_VALUE_TYPE:                                             // RULESET 2 rule 02
        new Rule(
            Rule:              "2.02",
            Scope:             "GENERAL",
            Keyword:           "START_META/END_META",
            Data_type:         "METADATA",
            Cardinality:       "NA",
            Description:       "Check if METADATA VALUE_TYPE provided, ENTRY value must be of type",
            Error_Type:        "Fatal Error",
            Error_Message:     "VARIABLE <x> VALUE DOES NOT MATCH TYPE Valid Types(CHAR,DOUBLE,FLOAT,INT,ISO_TIME,ISO_TIME_RANGE)",
            Caveats:           "NA",
            Notes:             "-",
            Test_Func:         {
                
                def l_result = new CefResult("R_2_02___ENTRY_MISMATCH_VALUE_TYPE")
                
                if(m_data.headerXPath.anyMetaEntryTypeMismatches() == false)
                    l_result.setPass()
                
                l_result
            }
        ),        

        R_2_03___REQUIRED_VARIABLES_XXXX:                                               // RULESET 2 rule 03
        new Rule(
            Rule:              "2.03",
            Scope:             "GENERAL",
            Keyword:           "START_META/END_META",
            Data_type:         "METADATA",
            Cardinality:       "1",
            Description:       "Check REQUIRED VARIABLES (below) NEED TO TRANSLATE ????????????????????????",
            Error_Type:        "Fatal Error",
            Error_Message:     "MISSING <x> VARIABLE",
            Caveats:           "NA",
            Notes:             "-",
            Test_Func:         {
                // "TODO"
                
                def l_result = new CefResult("R_2_03___REQUIRED_VARIABLES_XXXX")
                l_result.setSkipped()
                l_result
            }
        ),        

        R_2_04___FILE_TYPE_MUST_BE_CEF:                                                 // RULESET 2 rule 04
        new Rule(
            Rule:              "2.04",
            Scope:             "GENERAL",
            Keyword:           "FILE_TYPE",
            Data_type:         "METADATA",
            Cardinality:       "1",
            Description:       "Check FILE_TYPE must be cef",
            Error_Type:        "Fatal Error",
            Error_Message:     "FILE_TYPE is not CEF, unable to validate non CEF files",
            Caveats:           "NA",
            Notes:             "-",
            Test_Func:         {
            
                def l_result = new CefResult("R_2_04___FILE_TYPE_MUST_BE_CEF")
                
                if("\"cef\"".equals(m_data.headerXPath.getFileType()) == true)
                    l_result.setPass()
                
                l_result
            }
        ),        

        R_2_05___DATASET_VERSION_MUST_BE_VALID_INTEGER:                                 // RULESET 2 rule 05
        new Rule(
            Rule:              "2.05",
            Scope:             "GENERAL",
            Keyword:           "DATASET_VERSION",
            Data_type:         "METADATA",
            Cardinality:       "1",
            Description:       "Check DATASET_VERSION must be valid integer",
            Error_Type:        "Fatal Error",
            Error_Message:     "DATASET_VERSION IS NOT VALID INTEGER",
            Caveats:           "NA",
            Notes:             "-",
            Test_Func:         {
                
//x                 def l_result = new CefResult("R_2_05___DATASET_VERSION_MUST_BE_VALID_INTEGER")
//x                  
//x                 if(m_data.headerXPath.datasetVersionIsValidInt() == true)
//x                     l_result.setPass()
//x                 
//x                 l_result

                // now it is a String!!! 
                def l_result = new CefResult("R_2_05___DATASET_VERSION_MUST_BE_VALID_INTEGER")
                 
                l_result.setSkipped()
                
                l_result
            }
        ),        

        R_2_06___LOGICAL_FILE_ID_MATCHES_FILENAME:                                      // RULESET 2 rule 06
        new Rule(
            Rule:              "2.06",
            Scope:             "GENERAL",
            Keyword:           "LOGICAL_FILE_ID",
            Data_type:         "METADATA",
            Cardinality:       "1",
            Description:       "Check LOGICAL_FILE_ID is same as Filename without extension",
            Error_Type:        "Fatal Error?",
            Error_Message:     "Logical File ID does not match filename",
            Caveats:           "NA",
            Notes:             "-",
            Test_Func:         {
                
                def l_result = new CefResult("R_2_06___LOGICAL_FILE_ID_MATCHES_FILENAME")
                
                if(m_data.headerXPath.logicalFileIdMatchesFilename() == true)
                    l_result.setPass()
                
                l_result
                
            }
        ),        

        R_2_07___VERSION_NUMBER_MUST_BE_VALID_INTEGER:                                  // RULESET 2 rule 08
        new Rule(
            Rule:              "2.07",
            Scope:             "GENERAL",
            Keyword:           "VERSION_NUMBER",
            Data_type:         "METADATA",
            Cardinality:       "1",
            Description:       "Check VERSION_NUMBER must be valid integer",
            Error_Type:        "Fatal Error",
            Error_Message:     "Invalid value",
            Caveats:           "NA",
            Notes:             "-",
            Test_Func:         {
                
                def l_result = new CefResult("R_2_07___VERSION_NUMBER_MUST_BE_VALID_INTEGER")
                
                if(m_data.headerXPath.versionNumberIsValidInteger() == true)
                    l_result.setPass()
                
                l_result
                
            }
        ),        

        R_2_08___VERSION_NUMBER_MATCHES_FILENAME:                                       // RULESET 2 rule 07
        new Rule(
            Rule:              "2.08",
            Scope:             "GENERAL",
            Keyword:           "VERSION_NUMBER",
            Data_type:         "METADATA",
            Cardinality:       "1",
            Description:       "Check VERSION_NUMBER must match version number in filename",
            Error_Type:        "Fatal Error",
            Error_Message:     "VERSION_NUMBER does not match version in filename",
            Caveats:           "NA",
            Notes:             "-",
            Test_Func:         {
                
                def l_result = new CefResult("R_2_08___VERSION_NUMBER_MATCHES_FILENAME")
                
                if(m_data.headerXPath.versionNumberMatchesFilename() == true)
                    l_result.setPass()
                
                l_result
            }
            
        ),        
        
        R_2_09___FILE_TIME_SPAN_MUST_BE_ISO_TIME_RANGE:                                 // RULESET 2 rule 09
        new Rule(
            Rule:              "2.09",
            Scope:             "GENERAL",
            Keyword:           "FILE_TIME_SPAN",
            Data_type:         "METADATA",
            Cardinality:       "1",
            Description:       "Check FILE_TIME_SPAN must be ISO_TIME_RANGE",
            Error_Type:        "Fatal Error",
            Error_Message:     "VARIABLE <x> Invalid Format",
            Caveats:           "NA",
            Notes:             "-",
            Test_Func:         {

                def l_result = new CefResult("R_2_09___FILE_TIME_SPAN_MUST_BE_ISO_TIME_RANGE")
                
                if(m_data.headerXPath.fileTimeSpanIsValidISOTimeRange() == true)
                    l_result.setPass()
                
                l_result
                
            }
        ),        

        R_2_10___FILE_TIME_SPAN_START_TIME_MUST_BE_BEFORE_STOP_TIME:                    // RULESET 2 rule 10
        new Rule(
            Rule:              "2.10",
            Scope:             "GENERAL",
            Keyword:           "FILE_TIME_SPAN",
            Data_type:         "METADATA",
            Cardinality:       "1",
            Description:       "Check FILE_TIME_SPAN, START_TIME must be before STOP TIME",
            Error_Type:        "Fatal Error",
            Error_Message:     "VARIABLE <x> Start Time must be before Stop time",
            Caveats:           "NA",
            Notes:             "-",
            Test_Func:         {

                def l_result = new CefResult("R_2_10___FILE_TIME_SPAN_START_TIME_MUST_BE_BEFORE_STOP_TIME")
                
                if(m_data.headerXPath.fileTimeSpanStartIsBeforeFileTimeSpanStop() == true)
                    l_result.setPass()
                
                l_result
                
            }
        ),        
        
        // MOVE TO DATA RULES
        R_2_11___DATA_RECORD_TIME_STAMP_MUST_BE_BETWEEN_FILE_TIME_SPAN:                 // RULESET 2 rule 11
        new 
        Rule(
            Rule:              "2.11",
            Scope:             "GENERAL",
            Keyword:           "FILE_TIME_SPAN",
            Data_type:         "METADATA / DATA",
            Cardinality:       "1",
            Description:       "Check Data Records Timestamp must be with FILE_TIME_SPAN",
            Error_Type:        "Fatal Error",
            Error_Message:     "Data outside FILE_TIME_SPAN",
            Caveats:           "NA",
            Notes:             "-",
            Test_Func:         {
                //x "TODO"
                
                def l_result = new CefResult("R_2_11___DATA_RECORD_TIME_STAMP_MUST_BE_BETWEEN_FILE_TIME_SPAN")
                l_result.setSkipped()
                l_result                
            }
        )        
    ]

}