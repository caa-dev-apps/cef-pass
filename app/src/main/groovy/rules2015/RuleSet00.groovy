package rules2015

///////////////////////////////////////////////////////////////////////////////
//
// ## Parser Rules.
// ## Rules which are tested during the parsing of the header data (included in cef and ceh files)

public class RuleSet00 extends RuleSet
{
    
//x         def i_data = [
//x             headerXPath: i_headerXPath,
//x             info: [ a:1, b:2, c:3]
//x         ]
    def m_data
    
    public RuleSet00(i_data)
    {
        m_data = i_data
    }
    
    def Rule_0_00()
    {
        def l_rule = new Rule(
            Rule:              "0.00",
            Scope:             "GENERAL",
            Keyword:           "START_META/END_META",
            Data_type:         "METADATA",
            Cardinality:       "NA",
            Description:       "All START_META must have END_META",
            Error_Type:        "Fatal Error",
            Error_Message:     "Syntax error – START_META/ END_META mismatch",
            Caveats:           "NA",
            Notes:             "** Moved from 2.00 - Parser stage **"
        )
        
        println l_rule.skipped()
    }

    def Rule_0_01()
    {
        def l_rule = new Rule(
            Rule:              "0.01",
            Scope:             "GENERAL",
            Keyword:           "START_VARIABLE/END_VARIABLE",
            Data_type:         "METADATA",
            Cardinality:       "NA",
            Description:       "All START_VARIABLE must have END_VARIABLE",
            Error_Type:        "Fatal Error",
            Error_Message:     "Syntax error – START_VARIABLE/ END_VARIABLE mismatch",
            Caveats:           "NA",
            Notes:             "-"
        )
        
        println l_rule.skipped(true)
    }

    def Rule_0_02()
    {
        def l_rule = new Rule(
            Rule:              "0.02",
            Scope:             "GLOBAL",
            Keyword:           "INCLUDE",
            Data_type:         "METADATA",
            Cardinality:       "0..n",
            Description:       "All include files must exist",
            Error_Type:        "Warning",
            Error_Message:     "Include file may not exist, but all required metadata may exist in other files?",
            Caveats:           "Within Double Quotes",
            Notes:             "** Moved from 1.04 - Parser stage **"
        )
        
        println l_rule.skipped()
    }

    def run()
    {
        println("\nRuleSet00::run()")
        
        Rule_0_00();
        Rule_0_01();
        Rule_0_02();
    }

    public static def test(i_data)
    {
        def l_ruleset00 = new RuleSet00(i_data)
        l_ruleset00.run()
    }
}


//x RuleSet00.test(null)


