package rules2015

// ## A stub class for testing the tests.

public class RuleSet99
{
    def m_data = null
    
    public RuleSet99(i_data)
    {
        m_data = i_data
    }

    // ##  Rule:              0.00
    // ##  Scope:             GENERAL
    // ##  Keyword:           START_META/END_META
    // ##  Data.type:         METADATA
    // ##  Cardinality:       NA
    // ##  Description:       All START_META must have END_META
    // ##  Error.Type:        Fatal Error
    // ##  Error.Message:     Syntax error – START_META/ END_META mismatch
    // ##  Caveats:           NA

    def Rule_99_01()
    {
//x         return m_data.info == 'TODO'
        return m_data.info != null
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

    def Rule_99_02()
    {
        return true
    }

    public def run()
    {
        println("RuleSet99::run()")
        
        try
        {
            Rule_99_01()
            Rule_99_02()        
        }
        catch(Exception e)
        {
            println("ERROR!! :: RuleSet99::run()")
        }
    }
}


































