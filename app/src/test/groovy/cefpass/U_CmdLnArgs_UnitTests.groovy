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
            println CmdLnArgs.getCefFilename()
            println "+ = + + = + + = + + = + + = + + = + + = + "
            
            l_filename == CmdLnArgs.getCefFilename()
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
            println CmdLnArgs.getCefFilename()
            println "+ = + + = + + = + + = + + = + + = + + = + "
            
            l_filename == CmdLnArgs.getCefFilename()
    }
}


