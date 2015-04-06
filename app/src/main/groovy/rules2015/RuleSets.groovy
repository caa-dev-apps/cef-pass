package rules2015

import cefpass.CefLog

///////////////////////////////////////////////////////////////////////////////
//

public class RuleSets
{
    def m_set00 = null;
    def m_set01 = null;
    def m_set02 = null;
    def m_set99 = null;

    public RuleSets(i_headerXPath)
    {
        def l_data = [
            headerXPath: i_headerXPath,
            info: [ a:1, b:2, c:3]
        ]
        
        m_set00 = new RuleSet00(l_data)
        m_set01 = new RuleSet01(l_data)
        m_set02 = new RuleSet02(l_data)
        m_set99 = new RuleSet99(l_data)
    }

    def run()
    {
        try
        {
            m_set00.run()
            m_set01.run()
            m_set02.run()
            m_set99.run()
        }
        catch(Exception e)
        {
            CefLog.error("ERROR!! :: RuleSets::run()")
        }
    }
    
    static void run(i_headerXPath)
    {
        new RuleSets(i_headerXPath).run()
    }
}























