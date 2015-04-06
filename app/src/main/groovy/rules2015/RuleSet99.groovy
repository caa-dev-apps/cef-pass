package rules2015

import cefpass.CefLog

///////////////////////////////////////////////////////////////////////////////
//

public class RuleSet99
{
    def m_data = null
 
    public RuleSet99(i_data)
    {
        m_data = i_data
    }

    def Rule_99_01()
    {
        return m_data.info != null
    }

    def Rule_99_02()
    {
        return true
    }

    public def run()
    {
        CefLog.stage4_info("\n  RuleSet99")
        
        try
        {
            Rule_99_01()
            Rule_99_02()        
        }
        catch(Exception e)
        {
            CefLog.error("ERROR!! :: RuleSet99::run()")
        }
    }
}


































