package cefpass

///////////////////////////////////////////////////////////////////////////////
//

public class CefLog
{
    enum Type {
        diag,
        info,
        exception,
        stage_info,
        stage_result,
        full_result,
    }

    static def s_type = Type.info
//x     static def s_type = Type.stage_result

    // no checks
    static def p(i_str) {
        println i_str
    }
    
    static def print_ln(i_type, i_str)
    {
        if(i_type >= s_type)                        { CefLog.p i_str  }
    }                                    
    
    static def strFmt(i_str1, i_str2)               { ((i_str2 != null) ? ("    " + i_str1).padRight(100) + i_str2 : ("  " + i_str1))} 
                                         
    static def diag(i_str)                          { CefLog.print_ln(Type.diag, i_str) }
    static def info(i_str)                          { CefLog.print_ln(Type.info, i_str) }
    static def exception(i_str)                     { CefLog.print_ln(Type.exception, i_str) }
    static def warn(i_str)                          { CefLog.print_ln(Type.exception, i_str) }
    static def error(i_str)                         { CefLog.print_ln(Type.exception, i_str) }
                                            

    static def stage1_info(i_str1, i_str2=null)     { stage_info(1, i_str1, i_str2) }   
    static def stage2_info(i_str1, i_str2=null)     { stage_info(2, i_str1, i_str2) }   
    static def stage3_info(i_str1, i_str2=null)     { stage_info(3, i_str1, i_str2) }   
    static def stage4_info(i_str1, i_str2=null)     { stage_info(4, i_str1, i_str2) }   
    static def stage5_info(i_str1, i_str2=null)     { stage_info(5, i_str1, i_str2) }   

    static def stage_info(i_stage, i_str1, i_str2=null)  { CefLog.print_ln(Type.stage_info,  strFmt(i_str1, i_str2)) }
    
    static def stage_result(i_str)                  { CefLog.print_ln(Type.stage_result, i_str) }
    static def full_result(i_str)                   { CefLog.print_ln(Type.full_result, i_str) }
    
    
}

