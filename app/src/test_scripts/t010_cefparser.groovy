//x package cefpass


import java.io.File

///////////////////////////////////////////////////////////////////////////////
//

public class Utils
{
    static def fileExists(i_path)          { File f = new File(i_path); (f != null && f.isFile()) }
    static def directoryExists(i_path)     { File f = new File(i_path); (f != null && f.isDirectory()) }

    static def fileExistsS(i_path)         { fileExists(i_path)         ? "OK" : "NOT FOUND" }
    static def directoryExistsS(i_path)    { directoryExists(i_path)    ? "OK" : "NOT FOUND" }
    
}



def str = "Hello, World!"

def l_path = "file:/C:/work.dev/2015.03.22%20github%20cef%20pass%20v2/v0/cef-pass/app/build/resources/test/RuleSet00_00/C3_CP_EDI_EGD__20111009_V01.cef"

println (l_path.substring(6))

