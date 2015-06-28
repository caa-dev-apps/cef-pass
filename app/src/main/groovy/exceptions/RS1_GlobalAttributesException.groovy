package exceptions

public class RS1_GlobalAttributesException extends CefException
{
    enum Error {
        NO_ERROR,
        
        R_1_00___FILENAME_MUST_EXIST,                                // RULESET 1 rule 00
        R_1_01___FILENAME_MATCHES_ACTUAL,                            // RULESET 1 rule 01
        R_1_02___FILE_FORMAT_VERSION_MUST_EXIST,                     // RULESET 1 rule 02
        R_1_03___END_OF_RECORD_MARKER_MUST_EXIST                     // RULESET 1 rule 03
    }

    Error m_error;
    
    public RS1_GlobalAttributesException()                  { m_error = Error.NO_ERROR }
    public RS1_GlobalAttributesException(Error i_error)     { m_error = i_error}
    
    public String toString()                                { m_error != null ? m_error.toString() : "Exception,Error,undefined"}
    public Error getError()                                 { return m_error }
    public Boolean matches(i_rule_name)                     { return m_error != null && i_rule_name != null && m_error.toString().equals(i_rule_name) }
}

