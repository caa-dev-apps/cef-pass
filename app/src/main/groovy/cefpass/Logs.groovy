package cefpass

import java.io.FileInputStream
import java.io.File
import java.util.zip.GZIPInputStream

import groovy.util.CliBuilder
import org.apache.commons.cli.Option

//-----------------------------------------------------------------------------

public class Logs
{
    static String s_logsFolder = null;
    static File s_appLogsFile = null;
    Logs s_logs = new Logs()

    def static init() {
        s_logsFolder = CmdLnArgs.getLogsFolder()
        
        if(s_logsFolder == null) {
            s_logsFolder = System.getProperty("user.dir") + "../logs"
        }
        
        s_logsFolder += "/" 
        s_logsFolder += new Date().format('yyyy-MM-dd') 
        s_logsFolder += "." 
        s_logsFolder += sprintf("%06d", System.currentTimeMillis() % 1000000)
        
        new File(s_logsFolder).mkdirs();
        
        s_appLogsFile = new File(s_logsFolder + "\\" + "app-logs.txt")
        //x s_appLogsFile << "Hello, World!"
        
    }
    
    def static close() {
        //x s_appLogsFile.close()
    }
    
    def static writeTextFile(i_filename, 
                             i_contents) 
    {
        println "writeTextFile: " + i_filename
    
        if(s_logsFolder != null)
        {
//x         new File(s_logsFolder).mkdirs();
            File file = new File(s_logsFolder + "\\" + i_filename)
            file << i_contents
        }
    }
    
    def static getFilePath(i_filename) 
    {
        return s_logsFolder + "\\" + i_filename
    }
    
    
    
    
    def static diag(i_text) {
        s_appLogsFile << i_text
        s_appLogsFile << "\n"
    }
    
    def static dump() {
        println s_logsFolder
    }
    
}


