package cefpass

///////////////////////////////////////////////////////////////////////////////
//

public class CefParser
{
    static def s_error = false;
    static def s_var = null
    static def s_meta = null
    
    static def init() { 
        s_error = false; 
        s_var = null
        s_meta = null
    }
    
    static def stxMeta(v)
    {
        if(s_meta != null)      s_error = "META_OPEN_REQ__META_NOT_CLOSED"
        else if(s_var != null)  s_error = "META_OPEN_REQ__VAR_NOT_CLOSED"
        else                    s_meta = v
    }
    
    static def etxMeta(v) 
    {
        if(s_meta == null)      s_error = "META_CLOSE_REQ__META_NOT_OPEN"
        else if(s_meta != v)    s_error = "META_CLOSE_REQ__META_NAME_ERROR"
        else                    s_meta = null
    }


    static def stxVar(v) 
    {
        if(s_var != null)       s_error = "VAR_OPEN_REQ__VAR_NOT_CLOSED"
        else if(s_meta != null) s_error = "VAR_OPEN_REQ__META_NOT_CLOSED"
        else                    s_var = v
    }
    
    static def etxVar(v) 
    {
        if(s_var == null)       s_error = "VAR_CLOSE_REQ__VAR_NOT_OPEN"
        else if(s_var != v)     s_error = "VAR_CLOSE_REQ__VAR_NAME_ERROR"
        else                    s_var = null
    }
    
    static def test_kv(k, v){
        
        if(s_error == true)                                     { /* do nothing */ }
        else if("START_META".compareToIgnoreCase(k) == 0)       stxMeta(v) 
    	else if ("END_META".compareToIgnoreCase(k) == 0)		etxMeta(v) 
    	else if ("START_VARIABLE".compareToIgnoreCase(k) == 0) 	stxVar(v) 
    	else if ("END_VARIABLE".compareToIgnoreCase(k) == 0)	etxVar(v) 
    
        return s_error
    }
    
}


println CefParser.test_kv("START_META","ABC")
println CefParser.test_kv("END_META","ABC")

CefParser.init()

println CefParser.test_kv("START_META","ABC1")
println CefParser.test_kv("END_META","ABC2")

CefParser.init()

println CefParser.test_kv("START_META","ABC1")
println CefParser.test_kv("END_VARIABLE","ABC")





























