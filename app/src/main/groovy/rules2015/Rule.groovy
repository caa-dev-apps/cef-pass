package rules2015

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
    
    def skipped(i_dump)
    {
       def str = (("Rule: " + this.Rule).padRight(20) + this.Description).padRight(100) + "Skipped"
       
       return ((i_dump == true) ? (str + "\n" + to_str()) : str) 
    }
    
    def to_str()
    {
        def str = ""
        this.properties.each { prop, val ->
            if(prop in ["metaClass","class"]) return
            str += (("  " + prop).padRight(20) + val) + "\n"
        }
        str
    }
    
    def dump()  { println(to_str()) }
}