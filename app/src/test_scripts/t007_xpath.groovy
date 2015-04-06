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
        top
    }

    static def s_type = Type.info
    
    static def println(i_type, i_str)
    {
        if(i_type > s_type)                         { println(i_str) }
        else                                        { println("SKIP THIS: " + i_str)}
    }                                    
    
    static def strFmt(i_str1, i_str2)               { ((i_str2 != null) ? ("    " + i_str1).padRight(100) + i_str2 : ("    " + i_str1))} 
                                         
    static def error(i_str)                         { CefLog.println(Type.error, i_str) }
    static def warn(i_str)                          { CefLog.println(Type.warn, i_str) }
    static def info(i_str)                          { CefLog.println(Type.info, i_str) }
    static def diag(i_str)                          { CefLog.println(Type.diag, i_str) }
                                            
    static def stage_info(i_stage, i_str1, i_str2)  { CefLog.println(Type.stage_info,  strFmt(i_str1, i_str2)) }
    static def top(i_str)                           { CefLog.println(Type.top, i_str) }

    static def stage1_info(i_str1, i_str2=null)     { stage_info(1, i_str1, i_str2) }   
    static def stage2_info(i_str1, i_str2=null)     { stage_info(2, i_str1, i_str2) }   
    static def stage3_info(i_str1, i_str2=null)     { stage_info(3, i_str1, i_str2) }   
    static def stage4_info(i_str1, i_str2=null)     { stage_info(4, i_str1, i_str2) }   
    static def stage5_info(i_str1, i_str2=null)     { stage_info(5, i_str1, i_str2) }   
    
    
}


//x CefLog.error("This is a Error Message") 
//x CefLog.warn("This is a Warning Message") 
//x CefLog.info("This is a Info Message") 
//x CefLog.diag("This is a Diag Message") 

CefLog.stage1_info("Stage #1 info", "TRUE")
CefLog.stage2_info("Stage #2 info", false)
CefLog.stage3_info("Stage #3 info")
CefLog.stage4_info("Stage #4 info", 1234)
CefLog.stage5_info("Stage #5 info", "Yo!")

//x CefLog.stage_top("This is a stage top message")
//x 
//x println "Hello, World!".padLeft(10)


