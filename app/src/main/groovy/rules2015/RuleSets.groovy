package rules2015

public class RuleSets
{
    def RuleSet01 m_set01 = null;
    def RuleSet02 m_set02 = null;
    def RuleSet99 m_set99 = null;

    def m_headerData = null;
    
    public RuleSets(i_headerData)
    {
        m_headerData = i_headerData;
        
        m_set01 = new RuleSet01()
        m_set01 = new RuleSet01()
        m_set99 = new RuleSet99()
    }

    public def run()
    {
        println("RuleSets::run()")
        
        try
        {
            l_set01.run()
            l_set02.run()
            l_set99.run()
        }
        catch(Exception e)
        {
            println("ERROR!! :: RuleSets::run()")
        }
    }
}























