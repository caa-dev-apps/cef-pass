package rules2015

import cefpass.CefLog

///////////////////////////////////////////////////////////////////////////////
//

public class Result_RuleTest
{
    def m_ruleName
    def m_status = "Ok"
    def m_isError = false
    
    public Result_RuleTest(i_ruleName)
    {
        m_ruleName = i_ruleName
    }
    
    public setStatus(i_status)      {   m_status = i_status}
    public setIsError(i_isError)    {   m_isError = i_isError }
    
    
    public getStatus()              {   m_status}
    public isError()                {   m_isError}
    
    
    
}