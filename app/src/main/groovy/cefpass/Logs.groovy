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
    Logs s_logs = new Logs()

    def static init(i_logsFolder) {
        s_logsFolder = i_logsFolder
        
        if(s_logsFolder == null) {
            s_logsFolder = System.getProperty("user.dir") + "../logs"
        }
        
        s_logsFolder += "/" 
        s_logsFolder += System.currentTimeMillis()
    }
    
    def static writeTextFile(i_filename, 
                             i_contents) 
    {
        println "writeTextFile: " + i_filename
    
        if(s_logsFolder != null)
        {
            new File(s_logsFolder).mkdirs();
            File file = new File(s_logsFolder + "\\" + i_filename)
            file << i_contents
        }
    }
    
    def static dump() {
        println s_logsFolder
    }
    
}


