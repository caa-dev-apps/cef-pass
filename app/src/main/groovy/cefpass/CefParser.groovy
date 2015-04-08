package cefpass

///////////////////////////////////////////////////////////////////////////////
//

public class CefParser
{
    enum Error {
        eNULL,
        
        START_META_REQ__META_NOT_CLOSED,
        START_META_REQ__VARIABLE_NOT_CLOSED,

        END_META_REQ__META_NOT_OPEN,
        END_META_REQ__META_NAME_ERROR,

        START_VARIABLE_REQ__VARIABLE_NOT_CLOSED,
        START_VARIABLE_REQ__META_NOT_CLOSED,

        END_VARIABLE_REQ__VARIABLE_NOT_OPEN,
        END_VARIABLE_REQ__VAR_NAME_ERROR,
        
        INCLUDE_FILE_DUPLICATE,
        INCLUDE_FILE_NOT_FOUND,
        INCLUDE_FILE_LEVEL_8
    }
    
    static def s_error = Error.eNULL;
    static def s_var = null
    static def s_meta = null
    static def s_k = null
    static def s_v = null
    static def s_includeFile = null
    
    static def init() { 
        s_error = Error.eNULL; 
        s_var = null
        s_meta = null
        s_k = null
        s_v = null
        s_includeFile = null
    }

    static def save_kv(k, v)        
    { 
        s_k = k; 
        s_v = v; 
    }
    
    static def stxMeta(v)
    {
        if(s_meta != null)          s_error = Error.START_META_REQ__META_NOT_CLOSED
        else if(s_var != null)      s_error = Error.START_META_REQ__VARIABLE_NOT_CLOSED
        else                        s_meta = v
    }
    
    static def etxMeta(v) 
    {
        if(s_meta == null)          s_error = Error.END_META_REQ__META_NOT_OPEN
        else if(s_meta != v)        s_error = Error.END_META_REQ__META_NAME_ERROR
        else                        s_meta = null
    }


    static def stxVar(v) 
    {
        if(s_var != null)           s_error = Error.START_VARIABLE_REQ__VARIABLE_NOT_CLOSED
        else if(s_meta != null)     s_error = Error.START_VARIABLE_REQ__META_NOT_CLOSED
        else                        s_var = v
    }
    
    static def etxVar(v) 
    {
        if(s_var == null)           s_error = Error.END_VARIABLE_REQ__VARIABLE_NOT_OPEN
        else if(s_var != v)         s_error = Error.END_VARIABLE_REQ__VAR_NAME_ERROR
        else                        s_var = null
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    //

    static def includeFileDuplicate(f)
    {
        s_includeFile = f
        s_error = Error.INCLUDE_FILE_DUPLICATE;
    }
    
    static def includeFileNotFound(f)
    {
        s_includeFile = f
        s_error = Error.INCLUDE_FILE_NOT_FOUND;
    }

    static def includeFileLevel8(f)
    {
        s_includeFile = f
        s_error = Error.INCLUDE_FILE_LEVEL_8;
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    //

    static def test_kv(k, v){
        
        if(s_error == Error.eNULL)                                     
        {
            save_kv(k,v)
            
            if("START_META".compareToIgnoreCase(k) == 0)            stxMeta(v) 
            else if ("END_META".compareToIgnoreCase(k) == 0)		etxMeta(v) 
            else if ("START_VARIABLE".compareToIgnoreCase(k) == 0) 	stxVar(v) 
            else if ("END_VARIABLE".compareToIgnoreCase(k) == 0)	etxVar(v) 
        }
    
        return s_error
    }
}


