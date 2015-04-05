package rules2015

///////////////////////////////////////////////////////////////////////////////
//

public class RuleSet01
{

//x         def i_data = [
//x             headerXPath: i_headerXPath,
//x             info: [ a:1, b:2, c:3]
//x         ]
    def m_data
    
    public RuleSet01(i_data)
    {
        m_data = i_data
    }
    
    def Rule_1_01()
    {
        def l_rule = new Rule(
            Rule:              "1.00",
            Scope:             "GLOBAL",
            Keyword:           "FILE_NAME",
            Data_type:         "METADATA",
            Cardinality:       "1",
            Description:       "Must exist",
            Error_Type:        "Fatal Error",
            Error_Message:     "Missing FILE_NAME",
            Caveats:           "Within Double Quotes",
            Notes:             "-"
        )
        
        println l_rule.skipped()
    }

    def Rule_1_00()
    {
        def l_rule = new Rule(
            Rule:              "1.01",
            Scope:             "GLOBAL",
            Keyword:           "FILE_NAME",
            Data_type:         "METADATA",
            Cardinality:       "1",
            Description:       "Name of file on disk equals FILE_NAME",
            Error_Type:        "Fatal Error",
            Error_Message:     "Filename and metadata filename do not match",
            Caveats:           "Within Double Quotes",
            Notes:             "-"
        )
        
        println l_rule.skipped()
    }

    def Rule_1_02()
    {
        def l_rule = new Rule(
            Rule:              "1.02",
            Scope:             "GLOBAL",
            Keyword:           "FILE_FORMAT_VERSION",
            Data_type:         "METADATA",
            Cardinality:       "1",
            Description:       "Must exist",
            Error_Type:        "Fatal Error",
            Error_Message:     "Missing FILE_FORMAT_VERSION",
            Caveats:           "Within Double Quotes",
            Notes:             "-"
        )
        
        println l_rule.skipped()
    }

    def Rule_1_03()
    {
        def l_rule = new Rule(
            Rule:              "1.03",
            Scope:             "GLOBAL",
            Keyword:           "END_OF_RECORD_MARKER",
            Data_type:         "METADATA",
            Cardinality:       "1",
            Description:       "Must exist BUT may be blank",
            Error_Type:        "Fatal Error",
            Error_Message:     "Missing END_OF_RECORD_MARKER",
            Caveats:           "Within Double Quotes",
            Notes:             "-"
        )
        
        println l_rule.skipped()
    }

    def Rule_1_04()
    {
        def l_rule = new Rule(
            Rule:              "1.04",
            Scope:             "GLOBAL",
            Keyword:           "INCLUDE",
            Data_type:         "METADATA",
            Cardinality:       "0..n",
            Description:       "All include files must exist",
            Error_Type:        "Warning",
            Error_Message:     "Include file may not exist, but all required metadata may exist in other files?",
            Caveats:           "Within Double Quotes",
            Notes:             "-"
        )
        
        println l_rule.skipped()
    }

    public def run()
    {
        println("\nRuleSet01::run()")
        
        Rule_1_00();
        Rule_1_01();
        Rule_1_02();
        Rule_1_03();
        Rule_1_04();
    }
    
//x     static public def test()
//x     {
//x         println("Zz RuleSet01::test() zZ")
//x     }
    
}





















