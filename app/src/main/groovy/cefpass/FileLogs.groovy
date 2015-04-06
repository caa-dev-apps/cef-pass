package cefpass

import java.io.FileInputStream
import java.io.File
import java.util.zip.GZIPInputStream

import groovy.util.CliBuilder
import org.apache.commons.cli.Option

///////////////////////////////////////////////////////////////////////////////
//

public class FileLogs
{
    static String s_logsFolder = null;
    static File s_appFileLogsFile = null;
    FileLogs s_logs = new FileLogs()

    def static init() {
        s_logsFolder = CmdLnArgs.getLogsFolder()
        
        CefLog.diag("############ cefpass.FileLogs" + s_logsFolder);
        
        if(s_logsFolder == null) {
            s_logsFolder = System.getProperty("user.dir") + "../logs"
        }
        
        s_logsFolder += "/" 
        s_logsFolder += new Date().format('yyyy-MM-dd') 
        s_logsFolder += "." 
        s_logsFolder += sprintf("%06d", System.currentTimeMillis() % 1000000)
        
        new File(s_logsFolder).mkdirs();
        
        s_appFileLogsFile = new File(s_logsFolder + "\\" + "app-logs.txt")
        //x s_appFileLogsFile << "Hello, World!"
        
    }
    
    def static close() {
        //x s_appFileLogsFile.close()
    }
    
    def static writeTextFile(i_filename, 
                             i_contents) 
    {
        CefLog.diag "** ** ** ** writeTextFile: " + i_filename
    
        if(s_logsFolder != null)
        {
            def l_path = s_logsFolder + "\\" + i_filename
            
            CefLog.diag "** ++ == ** writeTextFilePath: " +  l_path
            
            File file = new File(l_path)
            file << i_contents
        }
    }
    
    def static getFilePath(i_filename) 
    {
        return s_logsFolder + "\\" + i_filename
    }
    
    def static diag(i_text) {
        s_appFileLogsFile << i_text
        s_appFileLogsFile << "\n"
    }
    
    def static dump() {
        CefLog.diag s_logsFolder
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    //

    def static write_logs(i_level, i_str)
    {
        
        
    }
    
    
    
}

