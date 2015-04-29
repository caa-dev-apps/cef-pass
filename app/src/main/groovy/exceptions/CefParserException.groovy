package exceptions

public class CefParserException extends CefException
{
    enum Error {
        NO_ERROR,
        
        R_0_00___START_META___META_UNCLOSED,                         // RULESET 0 rule 00
        R_0_01___START_META___VARIABLE_UNCLOSED,                     // RULESET 0 rule 01
        R_0_02___START_META___NAME_ERROR,                            // RULESET 0 rule 02

        R_0_10___END_META___VARIABLE_OPENED,                         // RULESET 0 rule 10
        R_0_11___END_META___META_UNOPENED,                           // RULESET 0 rule 11
        R_0_12___END_META___NAME_ERROR,                              // RULESET 0 rule 12

        R_0_20___START_VARIABLE___VARIABLE_UNCLOSED,                 // RULESET 0 rule 20
        R_0_21___START_VARIABLE___META_UNCLOSED,                     // RULESET 0 rule 21
        R_0_22___START_VARIABLE___NAME_ERROR,                        // RULESET 0 rule 22

        R_0_30___END_VARIABLE___META_OPENED,                         // RULESET 0 rule 30
        R_0_31___END_VARIABLE___VARIABLE_UNOPENED,                   // RULESET 0 rule 31
        R_0_32___END_VARIABLE___NAME_ERROR,                          // RULESET 0 rule 32
        
        R_0_40___INCLUDE_FILE_DUPLICATE,                             // RULESET 0 rule 40
        R_0_41___INCLUDE_FILE_UNFOUND,                               // RULESET 0 rule 41
        R_0_42___INCLUDE_FILE_LEVEL_8,                               // RULESET 0 rule 42
        
        R_0_50___MALFORMED_READ_LINE,                                // RULESET 0 rule 50
        R_0_51___MALFORMED_STRING_QUOTES                             // RULESET 0 rule 51
    }

    
    Error m_error;
    
    public CefParserException()                 { m_error = Error.NO_ERROR }
    public CefParserException(Error i_error)    { m_error = i_error}
    
    public String toString()                    { m_error != null ? m_error.toString() : "Exception:Error:undefined"}
    public Error getError()                     { return m_error }
}
