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
    
    public static def getTestResourcePath(i_rule_name_path)
    {
        def dummy = new Helper_Resources();
        
        File l_file = ResourceUtils.getFile(dummy.getClass().getResource(i_rule_name_path))
        
        return l_file.getAbsolutePath()
    }
    
    
    static def ruleName2RuleId(i_ruleName) {
        def s = ""
        try {
            def v1 =  i_ruleName.substring(2,3)
            def v2 =  i_ruleName.substring(4,6)
            s = v1 + "." + v2;
        }
        catch(Exception e){
        }
    
        s
    }  
    
    public static String[] getCommandLineArgs(i_rule_name_path)
    {
        def l_path = getTestResourcePath(i_rule_name_path)
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
    
    public static String[][] getCommandLineArgsList(i_rule_name_path)
    {
        def l_argsList = [];
        def l_path = getTestResourcePath(i_rule_name_path)
        
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
    
    
    
    // WE ARE ONLY TESTING 1 RULE HERE - WITH THE ADDITION OF THE -r ruleId CMDLN ARG OPTION
    // [ [ rule_name, file_name, cmd_args, ix] ]
    public static getRuleTestsArgsList_v2(i_rule_name, i_ix)
    {
        def l_ix = 1 // local = this rule only
        def l_ruleTestsArgsList = [];
        def l_path = getTestResourcePath(i_rule_name)
        
        def l_ruleId = ruleName2RuleId(i_rule_name)
        
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
                "-r",
                l_ruleId,
                "-l",
                "C:/Dump/_logs"    // TODO FIXME FOR LINUX!!
            ]
            
            //x def l_rule_test_name = i_rule_name.padRight(72,'_') + " " + l_ix + " " + file.getName()
            //x def l_rule_test_name = i_rule_name.padRight(72,'_') + " " + l_ix + " " + file.getName()
            def l_rule_test_name = (i_rule_name.substring(0,6) + "____"+ l_ix + "____"+ file.getName()).padRight(64,'_') +  i_rule_name

            l_ruleTestsArgsList << [i_rule_name, file.getName(), l_args, l_ix++, i_ix++, l_rule_test_name]
        }      
        println ""
        
        l_ruleTestsArgsList
    }

    // [ [ rule_name, file_name, cmd_args, ix] ]
    public static getMultiRuleTestsArgsList_v2(i_rule_names)
    {
        def l_ix = 1    // all rules
        def l_multiRuleTestsArgsList = []
        
        i_rule_names.each { l_rule_name -> 
            def l_ruleTestsArgsList = getRuleTestsArgsList_v2(l_rule_name, l_ix)
            l_ix += l_ruleTestsArgsList.size()
            l_multiRuleTestsArgsList += l_ruleTestsArgsList
        }
    
        l_multiRuleTestsArgsList
    }
    
}

    
    
    
    
    
    
    












