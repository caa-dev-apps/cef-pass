//x package cefpass
//x 
//x ///////////////////////////////////////////////////////////////////////////////
//x //  
//x 
//x public class CefLogDiag
//x {
//x     enum Type {
//x         diag,
//x         info,
//x         exception,
//x         warn,
//x         error
//x     }
//x 
//x     static Type s_type = Type.
//x     static boolean s_enabled = true
//x     
//x     static sboolean s_enabled = true
//x     
//x     
//x     static def print_ln(i_type, i_str)
//x     {
//x         if(s_enabled && i_type >= s_type)           { CefLogDiag.p i_str  }
//x     }                                    
//x                                          
//x     static def diag(i_str)                          { CefLogDiag.print_ln(CefLog.Type.diag,         i_str) }
//x     static def info(i_str)                          { CefLogDiag.print_ln(CefLog.Type.info,         i_str) }
//x     static def exception(i_str)                     { CefLogDiag.print_ln(CefLog.Type.exception,    i_str) }
//x     static def warn(i_str)                          { CefLogDiag.print_ln(CefLog.Type.warn,         i_str) }
//x     static def error(i_str)                         { CefLogDiag.print_ln(CefLog.Type.error,        i_str) }
//x }
//x 
