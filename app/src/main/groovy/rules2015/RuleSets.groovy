package rules2015

import cefpass.CefLog

///////////////////////////////////////////////////////////////////////////////
//

public class RuleSets
{
    def m_set01 = null;
    def m_set02 = null;

    def m_rules = null;
    
    public RuleSets(i_headerXPath)
    {
        def l_data = [
            headerXPath: i_headerXPath,
            info: [ a:1, b:2, c:3]
        ]
        
        m_set01 = new RS1_GlobalAttributes(l_data)
        m_set02 = new RS2_MetaObjects(l_data)
        
        m_rules = getRules()
    }
        
        
    // Either full list, or list based on Ids passed on cmdline
    def getRules()
    {
        def l_allRules = m_set01.m_rules + 
                         m_set02.m_rules;
        
        def l_testRuleIds = CmdLnArgs.getTestRuleIds()  // 1.02, 2.03...
        
        if(l_testRuleIds != null) {
            
            l_testRuleIds.each{ rule_id ->
                def l_rule = l_allRules.find { it ->
                    it.value.rule == rule_id
                }
            
                if (l_rule != null) l_rules += l_rule
            }
            
            l_allRules = l_rules
        } 
        
        
        l_allRules
    }

    ///////////////////////////////////////////////////////////////////////////////
    //

//          CmdLnArgs.getTestRuleIds()            { s_testRules }
//          CmdLnArgs.getStopOnFail()           { s_stopOnFail }
//          CmdLnArgs.getOutputResultsLevel()   { s_outputResultsLevel }
//      
//          CefLog.stage4_info("\n  RS1_GlobalAttributes")
//  
//          m_rules.each {
//              //x println it.value
//              //x println it.value.to_str()
//              //x it.value.Test_Func()
//              
//              CefLog.stage4_info(it.value.about(), it.value.Test_Func())     
//          }    
    
            //x println it.value
            //x println it.value.to_str()
            //x it.value.Test_Func()
    
    public getStatus()              {   m_status}
    public isError()                {   m_isError}
    
    
    // run all tests
    def run_all() {
        l_errors = false
       
        m_rules.each {
            def l_rule_testResult = it.value.Test_Func()
            
            l_errors = l_errors || l_rule_testResult.isError()
            
            //x CefLog.stage4_info(it.value.about(), it.value.Test_Func())     
            
            CefLog.stage4_info(it.value.about(), l_rule_testResult.getStatus())     
        }  

        !l_errors
    }
    
    // stop on fail 
    def run_stopOnFail() {
        l_errors = false
        
        m_rules.any {
            def l_rule_testResult = it.value.Test_Func()
            
            l_errors = l_errors || l_rule_testResult.isError()
            
            //x CefLog.stage4_info(it.value.about(), it.value.Test_Func())     
            
            CefLog.stage4_info(it.value.about(), l_rule_testResult.getStatus())     
            l_errors
        }
        
        !l_errors
    }
    
    def run() 
    {
        def l_result = null
        
        if(CmdLnArgs.getStopOnFail()) l_result = run_stopOnFail()
        else                          l_result = run_all()
        
        l_result
    }
    
    static void run(i_headerXPath)
    {
        new RuleSets(i_headerXPath).run()
    }
}























