package rules2015

import cefpass.CefLog

///////////////////////////////////////////////////////////////////////////////
//

public class RuleSets
{
    def m_set01 = null;
    def m_set02 = null;

    public RuleSets(i_headerXPath)
    {
        def l_data = [
            headerXPath: i_headerXPath,
            info: [ a:1, b:2, c:3]
        ]
        
        m_set01 = new RS1_GlobalAttributes(l_data)
        m_set02 = new RS2_MetaObjects(l_data)
    }

    def run()
    {
        m_set01.run()
        m_set02.run()
    }
    
    static void run(i_headerXPath)
    {
        new RuleSets(i_headerXPath).run()
    }
}























