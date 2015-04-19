@Grapes(
	@Grab(group='org.spockframework', module='spock-core', version='0.7-groovy-2.0')
)


import spock.lang.Specification

public class CefException extends Exception
{
}


public class CefParserException extends CefException
{
    enum Error {
        NO_ERROR,
        
        START_META___META_UNCLOSED,
        START_META___VARIABLE_UNCLOSED,
        START_META___NAME_ERROR,

        END_META___VARIABLE_OPENED,
        END_META___META_UNOPENED,
        END_META___NAME_ERROR,

        START_VARIABLE___VARIABLE_UNCLOSED,
        START_VARIABLE___META_UNCLOSED,
        START_VARIABLE___NAME_ERROR,

        END_VARIABLE___META_OPENED,
        END_VARIABLE___VARIABLE_UNOPENED,
        END_VARIABLE___NAME_ERROR,
        
        INCLUDE_FILE_DUPLICATE,
        INCLUDE_FILE_UNFOUND,
        INCLUDE_FILE_LEVEL_8
    }
    
    Error m_error;
    
    public CefParserException()                 { m_error = Error.NO_ERROR }
    public CefParserException(Error i_error)    { m_error = i_error}
    
    public String toString()                    { m_error != null ? m_error.toString() : "Exception:Error:undefined"}
    public Error getError()                     { return m_error }
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
        if(s_meta != null)                  fatal_error(CefParserException.Error.START_META___META_UNCLOSED)
        else if(s_var != null)              fatal_error(CefParserException.Error.START_META___VARIABLE_UNCLOSED)
        else if(v==null || v.length()==0)   fatal_error(CefParserException.Error.START_META___NAME_ERROR)
        else                                s_meta = v
    }
    
    static def etxMeta(v) 
    {
        if(s_var != null)                   fatal_error(CefParserException.Error.END_META___VARIABLE_OPENED)         // NEW
        else if(s_meta == null)             fatal_error(CefParserException.Error.END_META___META_UNOPENED)
        else if(s_meta != v)                fatal_error(CefParserException.Error.END_META___NAME_ERROR)
        else                                s_meta = null
    }


    static def stxVar(v) 
    {
        if(s_var != null)                   fatal_error(CefParserException.Error.START_VARIABLE___VARIABLE_UNCLOSED)
        else if(s_meta != null)             fatal_error(CefParserException.Error.START_VARIABLE___META_UNCLOSED)
        else if(v==null || v.length()==0)   fatal_error(CefParserException.Error.START_VARIABLE___NAME_ERROR)
        else                                s_var = v
    }
    
    static def etxVar(v) 
    {
        if(s_meta != null)                  fatal_error(CefParserException.Error.END_VARIABLE___META_OPENED)            // NEW
        else if(s_var == null)              fatal_error(CefParserException.Error.END_VARIABLE___VARIABLE_UNOPENED)
        else if(s_var != v)                 fatal_error(CefParserException.Error.END_VARIABLE___NAME_ERROR)
        else                                s_var = null
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
        fatal_error(CefParserException.Error.INCLUDE_FILE_UNFOUND)
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
//x     def test_1 = { p "test_1"; CefParser.init() } 
    

    def test_1 = { i_data -> 
        try {
            p "\ntest: " + i_data.ix; 
            
            CefParser.init() 
            
            CefParser.test_kv(i_data.k1, i_data.v1)
            CefParser.test_kv(i_data.k2, i_data.v2)
        }
        catch (CefParserException e) {
            p (((i_data.ex == e.getError()) ? "ERROR-TEST-PASS" : "ERROR-TEST-FAIL") + "\t\t" + i_data.toString())
        }
        finally {
            p "+"
        }
    }


    def test_2 = { i_data -> 
        try {
            p "\ntest: " + i_data.ix; 
            
            CefParser.init() 
            
            if(i_data.func=="CefParser.includeFileDuplicate")     CefParser.includeFileDuplicate("Test-File.tst")
            else if(i_data.func=="CefParser.includeFileNotFound") CefParser.includeFileNotFound("Test-File.tst")
            else if(i_data.func=="CefParser.includeFileLevel8")   CefParser.includeFileLevel8("Test-File.tst")
            else                                                { p "x x x x x x x x" }
            
            //x i_data.func("Test-File.tst")
        }
        catch (CefParserException e) {
            p (((i_data.ex == e.getError()) ? "ERROR-TEST-PASS" : "ERROR-TEST-FAIL") + "\t\t" + i_data.toString())
        }
        finally {
            p "+"
        }
    }
    
    def do_tests_1()
    {
        def l_data = [
            [ ix:0,    k1:"START_META",         v1:"m1",    k2:"END_META",          v2:"m1",     ex:CefParserException.Error.NO_ERROR ],
                   
            [ ix:10,   k1:"START_META",         v1:"m1",    k2:"START_META",        v2:"m1",     ex:CefParserException.Error.START_META___META_UNCLOSED ],
            [ ix:11,   k1:"START_VARIABLE",     v1:"m1",    k2:"START_META",        v2:"m1",     ex:CefParserException.Error.START_META___VARIABLE_UNCLOSED ],
            [ ix:12,   k1:"START_META",         v1:"",      k2:"START_META",        v2:"m1",     ex:CefParserException.Error.START_META___NAME_ERROR ],
            
            
            [ ix:20,   k1:"START_VARIABLE",     v1:"m1",    k2:"END_META",          v2:"m1",     ex:CefParserException.Error.END_META___VARIABLE_OPENED ],
            [ ix:21,   k1:"END_META",           v1:"m1",    k2:"END_META",          v2:"m1",     ex:CefParserException.Error.END_META___META_UNOPENED ],
            [ ix:22,   k1:"START_META",         v1:"m1",    k2:"END_META",          v2:"m2",     ex:CefParserException.Error.END_META___NAME_ERROR ],

            
            [ ix:30,   k1:"START_VARIABLE",     v1:"m1",    k2:"START_VARIABLE",    v2:"m1",     ex:CefParserException.Error.START_VARIABLE___VARIABLE_UNCLOSED ],
            [ ix:31,   k1:"START_META",         v1:"m1",    k2:"START_VARIABLE",    v2:"m1",     ex:CefParserException.Error.START_VARIABLE___META_UNCLOSED ],
            [ ix:30,   k1:"START_VARIABLE",     v1:"",      k2:"START_VARIABLE",    v2:"m1",     ex:CefParserException.Error.START_VARIABLE___NAME_ERROR ],
                                                                                          
            [ ix:40,   k1:"START_META",         v1:"m1",    k2:"END_VARIABLE",      v2:"m1",     ex:CefParserException.Error.END_VARIABLE___META_OPENED ],
            [ ix:41,   k1:"END_VARIABLE",       v1:"m1",    k2:"END_VARIABLE",      v2:"m1",     ex:CefParserException.Error.END_VARIABLE___VARIABLE_UNOPENED ],
            [ ix:42,   k1:"START_VARIABLE",     v1:"m1",    k2:"END_VARIABLE",      v2:"m2",     ex:CefParserException.Error.END_VARIABLE___NAME_ERROR ]
                             
        ]
        
        l_data.each { test_1 it }
    }
    
    def do_tests_2()
    {
        def l_data = [
            [ ix:50,   func:"CefParser.includeFileDuplicate",          ex:CefParserException.Error.INCLUDE_FILE_DUPLICATE ],
            [ ix:51,   func:"CefParser.includeFileNotFound",           ex:CefParserException.Error.INCLUDE_FILE_UNFOUND ],
            [ ix:52,   func:"CefParser.includeFileLevel8",             ex:CefParserException.Error.INCLUDE_FILE_LEVEL_8 ],
        ]
        
        l_data.each { test_2 it }
    }
        
    public def boolean stages(String[] i_args) {
        def result = false
        
            do_tests_1()
            do_tests_2()

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

//x App.run()





//x import cefpass.CefParser

///////////////////////////////////////////////////////////////////////////////
//

//x org.spockframework:spock-core:0.7-groovy-2.0'


//x @Grapes(
//x 	@Grab(group='org.spockframework', module='spock-core', version='0.7-groovy-2.0')
//x )



class CefParser_Tests extends Specification{

    def "TEST 01"() {

        setup:
            println "Setup"
//x             CefParser.init()
        when:
            println "When"
            def l_when = true
//x             def result1 = CefParser.test_kv("START_META","ABC")
//x             def result2 = CefParser.test_kv("END_META","ABC")
        then:
//x             result2 == CefParser.Error.eNULL
            println "Then"
            l_when == true
    }
}













