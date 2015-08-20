//x package cefpass
//x 
//x ///////////////////////////////////////////////////////////////////////////////
//x // '(Optional) Output Results Level(0,1,2,3): 0:Debug 1:Info 2:Stages 3:Result Only')
//x 
//x public class CefLogOutput
//x {
//x     enum Type {
//x         diag,
//x         stage_info,
//x         stage_result,
//x         full_result,
//x     }
//x 
//x     static def s_type = Type.info
//x //x     static def s_type = Type.stage_result
//x 
//x     // no checks
//x     static def p(i_str) {
//x         println i_str
//x     }
//x     
//x     static def print_ln(i_type, i_str)
//x     {
//x         if(i_type >= s_type)                        { CefLog.p i_str  }
//x     }                                    
//x     
//x                                          
//x     static def diag(i_str)                          { CefLog.print_ln(Type.diag, i_str) }
//x //x     static def info(i_str)                          { CefLog.print_ln(Type.info, i_str) }
//x //x     static def exception(i_str)                     { CefLog.print_ln(Type.exception, i_str) }
//x //x     static def warn(i_str)                          { CefLog.print_ln(Type.exception, i_str) }
//x //x     static def error(i_str)                         { CefLog.print_ln(Type.exception, i_str) }
//x 
//x     
//x     static def strFmt(i_str1, i_str2)               { ((i_str2 != null) ? ("    " + i_str1).padRight(100) + i_str2 : ("  " + i_str1))} 
//x     static def stage_info(i_stage, i_str1, i_str2=null)  { CefLog.print_ln(Type.stage_info,  strFmt(i_str1, i_str2)) }
//x 
//x     static def stage1_info(i_str1, i_str2=null)     { stage_info(1, i_str1, i_str2) }   
//x     static def stage2_info(i_str1, i_str2=null)     { stage_info(2, i_str1, i_str2) }   
//x     static def stage3_info(i_str1, i_str2=null)     { stage_info(3, i_str1, i_str2) }   
//x     static def stage4_info(i_str1, i_str2=null)     { stage_info(4, i_str1, i_str2) }   
//x     static def stage5_info(i_str1, i_str2=null)     { stage_info(5, i_str1, i_str2) }   
//x 
//x     
//x     static def stage_result(i_str)                  { CefLog.print_ln(Type.stage_result, i_str) }
//x     static def full_result(i_str)                   { CefLog.print_ln(Type.full_result, i_str) }
//x     
//x     
//x }

