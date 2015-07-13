/*
  * @author sp, @date 19/07/14 22:43
 */

import spock.lang.Specification

import cefpass.CmdLnArgs
import exceptions.RS1_GlobalAttributesException

class U_CmdLnArgs_UnitTests extends Specification{

    def setup()
    {
    }

    ///////////////////////////////////////////////////////////////////////////////
    //
    
    def "Test 001 Plain cef file"() 
    {
        setup:
            def l_filename = "C3_CP_EDI_EGD__20111009_V01.cef"
            def l_filename_gz = 'R_1_00___FILENAME_MUST_EXIST/' + l_filename;
            
            String[] l_cmd_args = [
                "-f",
                l_filename_gz,
            ]            
            
        when:
            CmdLnArgs.init(l_cmd_args)
        then:
            println "+ = + + = + + = + + = + + = + + = + + = + "
            println l_filename
            println CmdLnArgs.getFilename()
            println "+ = + + = + + = + + = + + = + + = + + = + "
            
            l_filename == CmdLnArgs.getFilename()
    }

    
    def "Test 002 cef.gz file"() 
    {
        setup:
            def l_filename = "C3_CP_EDI_EGD__20111009_V01.cef"
            def l_filename_gz = 'R_1_00___FILENAME_MUST_EXIST/' + l_filename + ".gz"
            
            String[] l_cmd_args = [
                "-f",
                l_filename_gz,
            ]            
            
        when:
            CmdLnArgs.init(l_cmd_args)
        then:
            println "+ = + + = + + = + + = + + = + + = + + = + "
            println l_filename
            println CmdLnArgs.getFilename()
            println "+ = + + = + + = + + = + + = + + = + + = + "
            
            l_filename == CmdLnArgs.getFilename()
    }
    
    
    def "Test 003 -r rules"() 
    {
        setup:
            String[] l_cmd_args = [
                "-f", "a-filename.cef",
                "-r", "1.02, 2.01, 3.04"
            ]            
        when:
            CmdLnArgs.init(l_cmd_args)
        then:
            def l_ruleId = CmdLnArgs.getTestRuleId()
            println "Rules:" + l_ruleId
            
            l_ruleId != null
    }
    
    def "Test 003a -s stop on fail default"() 
    {
        setup:
            String[] l_cmd_args = [
                "-f", "a-filename.cef"
            ]            
        when:
            CmdLnArgs.init(l_cmd_args)
        then:
            def l_stopOnFail = CmdLnArgs.getStopOnFail()
            println l_stopOnFail.getClass().getName()
            
            println "Stop on Fail:" + l_stopOnFail
            
            l_stopOnFail == false
    }
    
    def "Test 003b -s stop on fail False"() 
    {
        setup:
            String[] l_cmd_args = [
                "-f", "a-filename.cef",
                "-s", "false"
            ]            
        when:
            CmdLnArgs.init(l_cmd_args)
        then:
            def l_stopOnFail = CmdLnArgs.getStopOnFail()
            println l_stopOnFail.getClass().getName()
            
            println "Stop on Fail:" + l_stopOnFail
            
            l_stopOnFail == false
    }
    
    def "Test 003c -s stop on fail True"() 
    {
        setup:
            String[] l_cmd_args = [
                "-f", "a-filename.cef",
                "-s", "true"
            ]            
        when:
            CmdLnArgs.init(l_cmd_args)
        then:
            def l_stopOnFail = CmdLnArgs.getStopOnFail()
            println l_stopOnFail.getClass().getName()
            
            println "Stop on Fail:" + l_stopOnFail
            
            l_stopOnFail == true
    }
    

    def "Test 004a -o Output Results Level default (1)"() 
    {
        setup:
            String[] l_cmd_args = [
                "-f", "a-filename.cef"
            ]            
        when:
            CmdLnArgs.init(l_cmd_args)
        then:
            def s_outputResultsLevel = CmdLnArgs.getOutputResultsLevel()
            println "Output Results Level:" + s_outputResultsLevel
            
            s_outputResultsLevel == 1
    }
    
    def "Test 004b -o Output Results Level 0"() 
    {
        setup:
            String[] l_cmd_args = [
                "-f", "a-filename.cef",
                "-o", "0"
            ]            
        when:
            CmdLnArgs.init(l_cmd_args)
        then:
            def s_outputResultsLevel = CmdLnArgs.getOutputResultsLevel()
            println "Output Results Level:" + s_outputResultsLevel
            
            s_outputResultsLevel == 0
    }
    
    def "Test 004c -o Output Results Level 1"() 
    {
        setup:
            String[] l_cmd_args = [
                "-f", "a-filename.cef",
                "-o", "1"
            ]            
        when:
            CmdLnArgs.init(l_cmd_args)
        then:
            def s_outputResultsLevel = CmdLnArgs.getOutputResultsLevel()
            println "Output Results Level:" + s_outputResultsLevel
            
            s_outputResultsLevel == 1
    }
    
    def "Test 004d -o Output Results Level 2"() 
    {
        setup:
            String[] l_cmd_args = [
                "-f", "a-filename.cef",
                "-o", "2"
            ]            
        when:
            CmdLnArgs.init(l_cmd_args)
        then:
            def s_outputResultsLevel = CmdLnArgs.getOutputResultsLevel()
            println "Output Results Level:" + s_outputResultsLevel
            
            s_outputResultsLevel == 2
    }
}


