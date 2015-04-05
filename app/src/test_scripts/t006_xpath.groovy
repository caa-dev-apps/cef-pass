package cefpass

///////////////////////////////////////////////////////////////////////////////
//

public class Rule
{
    def Rule
    def Scope
    def Keyword
    def Data_type
    def Cardinality
    def Description
    def Error_Type
    def Error_Message
    def Caveats
    def Notes
    
    def param_string(i_key, i_pad=30)
    {
        i_key.padRight(i_pad) + this[i_key]
    }
    
    def skipped()
    {
       (("Rule: " + this.Rule).padRight(20) + this.Description).padRight(70) + "Skipped"
    }
    
    def dump()
    {
        this.properties.each { prop, val ->
            if(prop in ["metaClass","class"]) return
            println(("  " + prop).padRight(20) + val)
        }
        println("")
    }
}


public class RuleSet
{
}


public class RuleSet00 extends RuleSet
{
    
//x         def i_data = [
//x             headerXPath: i_headerXPath,
//x             info: [ a:1, b:2, c:3]
//x         ]
    
    public RuleSet00(i_data)
    {
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
        
        l_rule.dump()
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
        
        println l_rule.skipped()
        
        l_rule.dump()        
    }

    def Rule_0_02()
    {
        def l_rule = new Rule(
            Rule:              "1.02",
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
        
        l_rule.dump()        
    }

    def run_all()
    {
        println("\nRuleSet00::run_all()")
        
        Rule_0_00();
        Rule_0_01();
        Rule_0_02();
    }

    public static def run()
    {
        def l_ruleset00 = new RuleSet00()
        l_ruleset00.run_all()
    }
}


RuleSet00.run()


