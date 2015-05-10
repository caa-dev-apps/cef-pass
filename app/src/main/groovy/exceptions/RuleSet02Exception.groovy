package exceptions

public class RuleSet02Exception extends CefException
{
    enum Error {
        NO_ERROR,
        
        R_2_00___MUST_HAVE_ENTRY,                                                       // RULESET 1 rule 00
        R_2_02___ENTRY_MISMATCH_VALUE_TYPE,                                             // RULESET 2 rule 02
        R_2_03___REQUIRED_VARIABLES_XXXX,                                               // RULESET 2 rule 03
        R_2_04___FILE_TYPE_MUST_BE_CEF,                                                 // RULESET 2 rule 04
        R_2_05___DATASET_VERSION_MUST_BE_VALID_INTEGER,                                 // RULESET 2 rule 05
        R_2_06___LOGICAL_FILE_ID_MATCHES_FILENAME,                                      // RULESET 2 rule 06
        R_2_07___VERSION_NUMBER_MATCHES_FILENAME,                                       // RULESET 2 rule 07
        R_2_08___VERSION_NUMBER_MUST_BE_VALID_INTEGER,                                  // RULESET 2 rule 08
        R_2_09___FILE_TIME_SPAN_MUST_BE_ISO_TIME_RANGE,                                 // RULESET 2 rule 09
        R_2_10___FILE_TIME_SPAN_START_TIME_MUST_BE_BEFORE_STOP_TIME,                    // RULESET 2 rule 10
        R_2_11___DATA_RECORD_TIME_STAMP_MUST_BE_BETWEEN_FILE_TIME_SPAN                  // RULESET 2 rule 11
    }

    Error m_error;
    
    public RuleSet02Exception()                 { m_error = Error.NO_ERROR }
    public RuleSet02Exception(Error i_error)    { m_error = i_error}
    
    public String toString()                    { m_error != null ? m_error.toString() : "Exception,Error,undefined"}
    public Error getError()                     { return m_error }
}

