public class CefException extends Exception
{
}

public class CefParserException extends CefException
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
    
    Error m_error;
    public CefParserException(Error i_error) { m_error = i_error}
    
    public String toString() { m_error != null ? m_error.toString() : "Exception:Error:undefined"}
}

public class CefParser
{
    static def s_var = null
    static def s_meta = null
    static def s_k = null
    static def s_v = null
    static def s_includeFile = null
    
    static def init() { 
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
    
    static def fatal_error(i_error)
    {
        throw new CefParserException(i_error)
    }
    
    static def stxMeta(v)
    {
        if(s_meta != null)          fatal_error(CefParserException.Error.START_META_REQ__META_NOT_CLOSED)
        else if(s_var != null)      fatal_error(CefParserException.Error.START_META_REQ__VARIABLE_NOT_CLOSED)
        else                        s_meta = v
    }
    
    static def etxMeta(v) 
    {
        if(s_meta == null)          fatal_error(CefParserException.Error.END_META_REQ__META_NOT_OPEN)
        else if(s_meta != v)        fatal_error(CefParserException.Error.END_META_REQ__META_NAME_ERROR)
        else                        s_meta = null
    }


    static def stxVar(v) 
    {
        if(s_var != null)           fatal_error(CefParserException.Error.START_VARIABLE_REQ__VARIABLE_NOT_CLOSED)
        else if(s_meta != null)     fatal_error(CefParserException.Error.START_VARIABLE_REQ__META_NOT_CLOSED)
        else                        s_var = v
    }
    
    static def etxVar(v) 
    {
        if(s_var == null)           fatal_error(CefParserException.Error.END_VARIABLE_REQ__VARIABLE_NOT_OPEN)
        else if(s_var != v)         fatal_error(CefParserException.Error.END_VARIABLE_REQ__VAR_NAME_ERROR)
        else                        s_var = null
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    //

    static def includeFileDuplicate(f)
    {
        s_includeFile = f
        fatal_error(CefParserException.Error.INCLUDE_FILE_DUPLICATE)
    }
    
    static def includeFileNotFound(f)
    {
        s_includeFile = f
        fatal_error(CefParserException.Error.INCLUDE_FILE_NOT_FOUND)
    }

    static def includeFileLevel8(f)
    {
        s_includeFile = f
        fatal_error(CefParserException.Error.INCLUDE_FILE_LEVEL_8)
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    //

    static def test_kv(k, v)
    {
        save_kv(k,v)
            
        if("START_META".compareToIgnoreCase(k) == 0)            stxMeta(v) 
        else if ("END_META".compareToIgnoreCase(k) == 0)		etxMeta(v) 
        else if ("START_VARIABLE".compareToIgnoreCase(k) == 0) 	stxVar(v) 
        else if ("END_VARIABLE".compareToIgnoreCase(k) == 0)	etxVar(v) 
    }
}


public class App {

    def p = { println it }
    def test_1 = { p "test_1"; CefParser.init() } 
    

    def test_x = { i_data -> 
        try {
            p "\ntest: " + i_data.ix; 
            
            CefParser.init() 
            
            CefParser.test_kv(i_data.k1, i_data.v1)
            CefParser.test_kv(i_data.k2, i_data.v2)
        }
        catch (Exception e) {
            p e.toString()
            p "Error: "  + i_data.toString()
        }
        finally {
            p "+"
        }
    }
    
    def do_tests_1()
    {
        def l_data = [
            [ ix:1,   k1:"START_META",    v1:"m1",    k2:"END_META",  v2:"m1" ],
            [ ix:2,   k1:"START_META",    v1:"m1",    k2:"END_VARIABLE",  v2:"m1" ],
            [ ix:3,   k1:"START_META",    v1:"m1",    k2:"END_META",  v2:"m1" ],
            [ ix:4,   k1:"START_META",    v1:"m1",    k2:"END_META",  v2:"m1" ],
        ]
        
        l_data.each { test_x it }
    }
    
    public def boolean stages(String[] i_args) {
        def result = false
        
        p "Stage 1: "  //  /////////////////////////////////////////////////////////////////////////////
            do_tests_1()
        p "Stage 2: "  //  /////////////////////////////////////////////////////////////////////////////
        p "Stage 3: "  //  /////////////////////////////////////////////////////////////////////////////
        p "Stage 4: "  //  /////////////////////////////////////////////////////////////////////////////
        p "Stage 5: "  //  /////////////////////////////////////////////////////////////////////////////
        
        result
    }
    
    public static void run(String[] i_args) {
        println "Hello, World!"
        
        App a = new App();

        try
        {
            a.stages(i_args)
        }
        catch(Exception e) {
            e.printStackTrace()        
        }
    }
}

App.run()



















