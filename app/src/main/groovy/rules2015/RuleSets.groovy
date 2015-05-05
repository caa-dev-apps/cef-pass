package rules2015

import cefpass.CefLog

///////////////////////////////////////////////////////////////////////////////
//

public class RuleSets
{
    //x def m_set00 = null;
    def m_set01 = null;
    def m_set02 = null;

    public RuleSets(i_headerXPath)
    {
        def l_data = [
            headerXPath: i_headerXPath,
            info: [ a:1, b:2, c:3]
        ]
        
        //x m_set00 = new RuleSet00(l_data)
        m_set01 = new RuleSet01(l_data)
        m_set02 = new RuleSet02(l_data)
    }

    def run()
    {
//x         try
//x         {
            //x m_set00.run()
            m_set01.run()
            m_set02.run()
//x         }
//x         catch(Exception e)
//x         {
//x             CefLog.error("ERROR!! :: RuleSets::run()")
//x         }
    }
    
    static void run(i_headerXPath)
    {
        new RuleSets(i_headerXPath).run()
    }
}























