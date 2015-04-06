package rules2015

import cefpass.CefLog

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
    
    def about()  { ("Rule: " + this.Rule).padRight(20) + this.Description }
    
    
//x     def skipped(i_dump)
//x     {
//x        def str = (("\tRule: " + this.Rule).padRight(20) + this.Description).padRight(100) + "Skipped"
//x        
//x        return ((i_dump == true) ? (str + "\n" + to_str()) : str) 
//x     }
    
    def to_str()
    {
        def str = ""
        this.properties.each { prop, val ->
            if(prop in ["metaClass","class"]) return
            str += (("  " + prop).padRight(20) + val) + "\n"
        }
        str
    }
    
    def dump()  { CefLog.diag(to_str()) }
}