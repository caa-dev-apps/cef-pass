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
    
    private def Logs()
    {
    }

    def static writeTextFile(i_filename, 
                             i_contents) 
    {
        if(s_logFolder != null {
            ant.project.buildListeners[0].messageOutputLevel = 0
//x             ant.mkdir(dir: s_logsFolder + '/' + i_filename)        
            ant.mkdir(dir: s_logsFolder)        
            
            File file = new File(s_logsFolder + "/" + i_filename)

            file << i_contents
            
        }
    }
}

