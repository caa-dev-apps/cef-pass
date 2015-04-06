package cefpass

///////////////////////////////////////////////////////////////////////////////
//

public class CefLog
{
    enum Type {
        diag,
        info,
        warn,
        error,
        stage_info,
        stage_top
    }

    static def s_type = Type.info
    
    static def println(i_type, i_str)
    {
        if(i_type > s_type)                 { println(i_str) }
        else                                { println("SKIP THIS: " + i_str)}
    }
    
    
    static def info(i_str)                  { CefLog.println(Type.info, i_str.padLeft(4)) }
    
}

CefLog.info("This is a Info Message") 

println("This is a Info Message".padLeft(30))

