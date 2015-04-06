package cefpass

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
