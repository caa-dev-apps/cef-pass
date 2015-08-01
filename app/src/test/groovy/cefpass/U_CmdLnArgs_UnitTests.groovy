/*
  * @author sp, @date 19/07/14 22:43
 */

import spock.lang.Specification

//x_argsimport cefpass.CmdLnArgs
import exceptions.RS1_GlobalAttributesException

class U_CmdLnArgs_UnitTests extends Specification{

    def setup()
    {
    }

    ///////////////////////////////////////////////////////////////////////////////
    //
    
//x_args    def "Test 001 Plain cef file"() 
//x_args    {
//x_args        setup:
//x_args            def l_filename = "C3_CP_EDI_EGD__20111009_V01.cef"
//x_args            def l_filename_gz = 'R_1_00___FILENAME_MUST_EXIST/' + l_filename;
//x_args            
//x_args            String[] l_cmd_args = [
//x_args                "-f",
//x_args                l_filename_gz,
//x_args            ]            
//x_args            
//x_args        when:
//x_args            CmdLnArgs.init(l_cmd_args)
//x_args        then:
//x_args            println "+ = + + = + + = + + = + + = + + = + + = + "
//x_args            println l_filename
//x_args            println CmdLnArgs.getFilename()
//x_args            println "+ = + + = + + = + + = + + = + + = + + = + "
//x_args            
//x_args            l_filename == CmdLnArgs.getFilename()
//x_args    }
//x_args
//x_args    
//x_args    def "Test 002 cef.gz file"() 
//x_args    {
//x_args        setup:
//x_args            def l_filename = "C3_CP_EDI_EGD__20111009_V01.cef"
//x_args            def l_filename_gz = 'R_1_00___FILENAME_MUST_EXIST/' + l_filename + ".gz"
//x_args            
//x_args            String[] l_cmd_args = [
//x_args                "-f",
//x_args                l_filename_gz,
//x_args            ]            
//x_args            
//x_args        when:
//x_args            CmdLnArgs.init(l_cmd_args)
//x_args        then:
//x_args            println "+ = + + = + + = + + = + + = + + = + + = + "
//x_args            println l_filename
//x_args            println CmdLnArgs.getFilename()
//x_args            println "+ = + + = + + = + + = + + = + + = + + = + "
//x_args            
//x_args            l_filename == CmdLnArgs.getFilename()
//x_args    }
//x_args    
//x_args    
//x_args    def "Test 003 -r rules"() 
//x_args    {
//x_args        setup:
//x_args            String[] l_cmd_args = [
//x_args                "-f", "a-filename.cef",
//x_args                "-r", "1.02, 2.01, 3.04"
//x_args            ]            
//x_args        when:
//x_args            CmdLnArgs.init(l_cmd_args)
//x_args        then:
//x_args            def l_ruleId = CmdLnArgs.getTestRuleId()
//x_args            println "Rules:" + l_ruleId
//x_args            
//x_args            l_ruleId != null
//x_args    }
//x_args    
//x_args    def "Test 003a -s stop on fail default"() 
//x_args    {
//x_args        setup:
//x_args            String[] l_cmd_args = [
//x_args                "-f", "a-filename.cef"
//x_args            ]            
//x_args        when:
//x_args            CmdLnArgs.init(l_cmd_args)
//x_args        then:
//x_args            def l_stopOnFail = CmdLnArgs.getStopOnFail()
//x_args            println l_stopOnFail.getClass().getName()
//x_args            
//x_args            println "Stop on Fail:" + l_stopOnFail
//x_args            
//x_args            l_stopOnFail == false
//x_args    }
//x_args    
//x_args    def "Test 003b -s stop on fail False"() 
//x_args    {
//x_args        setup:
//x_args            String[] l_cmd_args = [
//x_args                "-f", "a-filename.cef",
//x_args                "-s", "false"
//x_args            ]            
//x_args        when:
//x_args            CmdLnArgs.init(l_cmd_args)
//x_args        then:
//x_args            def l_stopOnFail = CmdLnArgs.getStopOnFail()
//x_args            println l_stopOnFail.getClass().getName()
//x_args            
//x_args            println "Stop on Fail:" + l_stopOnFail
//x_args            
//x_args            l_stopOnFail == false
//x_args    }
//x_args    
//x_args    def "Test 003c -s stop on fail True"() 
//x_args    {
//x_args        setup:
//x_args            String[] l_cmd_args = [
//x_args                "-f", "a-filename.cef",
//x_args                "-s", "true"
//x_args            ]            
//x_args        when:
//x_args            CmdLnArgs.init(l_cmd_args)
//x_args        then:
//x_args            def l_stopOnFail = CmdLnArgs.getStopOnFail()
//x_args            println l_stopOnFail.getClass().getName()
//x_args            
//x_args            println "Stop on Fail:" + l_stopOnFail
//x_args            
//x_args            l_stopOnFail == true
//x_args    }
//x_args    
//x_args
//x_args    def "Test 004a -o Output Results Level default (1)"() 
//x_args    {
//x_args        setup:
//x_args            String[] l_cmd_args = [
//x_args                "-f", "a-filename.cef"
//x_args            ]            
//x_args        when:
//x_args            CmdLnArgs.init(l_cmd_args)
//x_args        then:
//x_args            def s_outputResultsLevel = CmdLnArgs.getOutputResultsLevel()
//x_args            println "Output Results Level:" + s_outputResultsLevel
//x_args            
//x_args            s_outputResultsLevel == 1
//x_args    }
//x_args    
//x_args    def "Test 004b -o Output Results Level 0"() 
//x_args    {
//x_args        setup:
//x_args            String[] l_cmd_args = [
//x_args                "-f", "a-filename.cef",
//x_args                "-o", "0"
//x_args            ]            
//x_args        when:
//x_args            CmdLnArgs.init(l_cmd_args)
//x_args        then:
//x_args            def s_outputResultsLevel = CmdLnArgs.getOutputResultsLevel()
//x_args            println "Output Results Level:" + s_outputResultsLevel
//x_args            
//x_args            s_outputResultsLevel == 0
//x_args    }
//x_args    
//x_args    def "Test 004c -o Output Results Level 1"() 
//x_args    {
//x_args        setup:
//x_args            String[] l_cmd_args = [
//x_args                "-f", "a-filename.cef",
//x_args                "-o", "1"
//x_args            ]            
//x_args        when:
//x_args            CmdLnArgs.init(l_cmd_args)
//x_args        then:
//x_args            def s_outputResultsLevel = CmdLnArgs.getOutputResultsLevel()
//x_args            println "Output Results Level:" + s_outputResultsLevel
//x_args            
//x_args            s_outputResultsLevel == 1
//x_args    }
//x_args    
//x_args    def "Test 004d -o Output Results Level 2"() 
//x_args    {
//x_args        setup:
//x_args            String[] l_cmd_args = [
//x_args                "-f", "a-filename.cef",
//x_args                "-o", "2"
//x_args            ]            
//x_args        when:
//x_args            CmdLnArgs.init(l_cmd_args)
//x_args        then:
//x_args            def s_outputResultsLevel = CmdLnArgs.getOutputResultsLevel()
//x_args            println "Output Results Level:" + s_outputResultsLevel
//x_args            
//x_args            s_outputResultsLevel == 2
//x_args    }
}


