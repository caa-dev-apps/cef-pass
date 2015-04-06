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
    
    static def strFmt(i_str1, i_str2)               { ((i_str2 != null) ? ("    " + i_str1).padRight(100) + i_str2 : ("  " + i_str1))} 
                                         
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


import java.io.File

public class Utils
{
    static def fileExists(i_path)          { File f = new File(i_path); (f != null && f.isFile()) }
    static def directoryExists(i_path)     { File f = new File(i_path); (f != null && f.isDirectory()) }

    static def fileExistsS(i_path)         { fileExists(i_path)         ? "OK" : "NOT FOUND" }
    static def directoryExistsS(i_path)    { directoryExists(i_path)    ? "OK" : "NOT FOUND" }
    
}


def l_files = [
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_EGD__20111009_V01.cef.gz"
    ]
    
def l_folders = [
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/_TEST_SAMPLES/MULTI_LEVEL_INCLUDES",
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS",
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS/EDI",
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS/EFW",
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS/PEACE"
    ]
    


def fileExists(i_path)          { File f = new File(i_path); (f != null && f.isFile()) }
def directoryExists(i_path)     { File f = new File(i_path); (f != null && f.isDirectory()) }

CefLog.stage1_info("Files")
l_files.each { CefLog.stage1_info(it, Utils.fileExistsS(it)) }

CefLog.stage1_info("Folders")
l_folders.each { CefLog.stage1_info(it, Utils.directoryExistsS(it)) }



CefLog.stage1_info("Files")
l_files.each { CefLog.stage1_info(it, Utils.directoryExistsS(it)) }

CefLog.stage1_info("Folders")
l_folders.each { CefLog.stage1_info(it, Utils.fileExistsS(it)) }


















