package rules2015

import cefpass.CefLogResults
import cefpass.CefResult
import cefpass.CmdLnArgs_v2

///////////////////////////////////////////////////////////////////////////////
//

public class RuleSets
{
    def m_set01 = null;
    def m_set02 = null;
    def m_rules = null;
    def m_noStopOnFail = false;
    
    public RuleSets(i_headerXPath)
    {
        def l_data = [
            headerXPath: i_headerXPath
        ]
        
        m_set01 = new RS1_GlobalAttributes(l_data)
        m_set02 = new RS2_MetaObjects(l_data)
        
        m_noStopOnFail = CmdLnArgs_v2.getObject().getIsNoStopOnFail()
        m_rules = getRules()
    }
        
    // Either full list, or 1 x list based on Id passed on cmdline
    def getRules()
    {
        def l_allRules = m_set01.m_rules + 
                         m_set02.m_rules;
        
        def l_testRuleId = CmdLnArgs_v2.getObject().getTestRuleId()  // 1.02, 
        
        if(l_testRuleId != false) {
            def l_rules = []
            //x l_testRuleIds.each{ rule_id ->
            def l_rule = l_allRules.find { it ->
                it.value.rule == l_testRuleId
            }
        
            if (l_rule != null) l_rules += l_rule
            //x }
            
            l_allRules = l_rules
            m_noStopOnFail = false
        } 
        
        l_allRules
    }

    ///////////////////////////////////////////////////////////////////////////////
    //

    // run all tests
    def run_all() {
        def l_result = new CefResult("RuleSet-All")
        def l_errors = false
       
        m_rules.each {
            def l_rule_testResult = it.value.Test_Func()
            
            l_errors = l_errors || l_rule_testResult.isError
            
            CefLogResults.stage_info(4, it.value.about(), l_rule_testResult.status)     
        }  

        if(l_errors == false)
            l_result.setPass()
        
        l_result
    }
    
    // stop on fail 
    def run_stopOnFail() {
        
        def l_result = new CefResult("RuleSet-Stop-On-Fail")
        def l_errors = false
        def l_rule_testResult
        
        m_rules.any {
            l_rule_testResult = it.value.Test_Func()
            l_errors = l_errors || l_rule_testResult.isError
            CefLogResults.stage_info(4, it.value.about(), l_rule_testResult.status)     
            l_errors
        }
        
        if(l_errors == false)  l_result.setPass()
        else                   l_result.setLastError(l_rule_testResult)
        
        l_result
    }
    
    def run() {
        def l_result = null
        
        if(m_noStopOnFail)  l_result = run_all()
        else                l_result = run_stopOnFail()
        
        //x l_result.info()
        //x l_result.lastError.info()
        
        l_result
    }
    
    static CefResult run(i_headerXPath)
    {
        new RuleSets(i_headerXPath).run()
    }
}

