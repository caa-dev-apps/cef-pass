//x package helpers; ???????????????????

import spock.lang.Specification

import org.springframework.util.ResourceUtils

public class Helper_Resources
{
    public static def getParent(i_path)
    {
        def l_file = new File(i_path)
        return l_file.getParent()
    }
    
    public static def getTestResourcePath(i_relative_path)
    {
        def dummy = new Helper_Resources();
        
        File l_file = ResourceUtils.getFile(dummy.getClass().getResource(i_relative_path))
        
        return l_file.getAbsolutePath()
    }
    
    public static String[] getCommandLineArgs(i_relative_path)
    {
        def l_path = getTestResourcePath(i_relative_path)
        def l_parent = getParent(l_path)
        
        String[] l_args = [
            "-f",
            l_path,
            "-i",
            l_parent,
            "-l",
            "C:/work.dev/2015.03.22 github cef pass v2/v0/_logs"    // TODO FIXME FOR LINUX!!
        ]
    }
    
    public static String[][] getCommandLineArgsList(i_relative_path)
    {
        def l_argsList = [];
        def l_path = getTestResourcePath(i_relative_path)
        
        println "Test Input:"
        println "\tFolder: "
        println "\t\t" + l_path
        println "\tFile(s): "
        
        new File(l_path).eachFileMatch(~/.*.(?i)CEF/) { file ->  
            println "\t\t" + file.getName()  
            
            String[] l_args = [
                "-f",
                file.getCanonicalPath(),
                "-i",
                l_path,
                "-l",
                "C:/Dump/_logs"    // TODO FIXME FOR LINUX!!
            ]
            
            l_argsList << l_args
        }      
        println ""
        
        l_argsList
    }
}

    
    
    
    
    
    
    












