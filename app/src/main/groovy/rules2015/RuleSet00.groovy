package rules2015

// ## Parser Rules.
// ## Rules which are tested during the parsing of the header data (included in cef and ceh files)

public class RuleSet00
{
    
    public RuleSet00(i_data)
    {
    }
    
    
    //x moved from 2.00
    // ##  Rule:              0.00
    // ##  Scope:             GENERAL
    // ##  Keyword:           START_META/END_META
    // ##  Data.type:         METADATA
    // ##  Cardinality:       NA
    // ##  Description:       All START_META must have END_META
    // ##  Error.Type:        Fatal Error
    // ##  Error.Message:     Syntax error – START_META/ END_META mismatch
    // ##  Caveats:           NA

    def Rule_0_00()
    {
    }

    
    // ##  Rule:              0.00
    // ##  Scope:             GENERAL
    // ##  Keyword:           START_VARIABLE/END_VARIABLE
    // ##  Data.type:         METADATA
    // ##  Cardinality:       NA
    // ##  Description:       All START_VARIABLE must have END_VARIABLE
    // ##  Error.Type:        Fatal Error
    // ##  Error.Message:     Syntax error – START_VARIABLE/ END_VARIABLE mismatch
    // ##  Caveats:           NA

    def Rule_0_01()
    {
    }

    // ##     Misc Rules
    // ##     Find ceh include
    
    //x moved from 1.04
    // ##  Rule:              1.04
    // ##  Scope:             GLOBAL
    // ##  Keyword:           INCLUDE
    // ##  Data.type:         METADATA
    // ##  Cardinality:       0..n
    // ##  Description:       All include files must exist
    // ##  Error.Type:        Warning
    // ##  Error.Message:     Include file may not exist, but all required metadata may exist in other files?
    // ##  Caveats:           Within Double Quotes

    def Rule_0_02()
    {
    }

    
    
    

    public def run()
    {
        println("XX RuleSet02::run() XX")
    }

}


































