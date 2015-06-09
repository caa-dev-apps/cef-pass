/*
  * @author sp, @date 19/07/14 22:43
 */

import spock.lang.Specification

import org.springframework.util.ResourceUtils

import cefpass.App
import cefpass.CefParser
import exceptions.RS2_MetaObjectsException

class I_RS2_MetaObjects_Tests extends Specification{

    def setup()
    {
        CefParser.init() 
    }

    def getParent(i_path)
    {
        def l_file = new File(i_path)
        return l_file.getParent()
    }
    
    def getTestResourcePath(i_relative_path)
    {
        File l_file = ResourceUtils.getFile(this.getClass().getResource(i_relative_path))
        
        return l_file.getAbsolutePath()
    }
    
    String[] getCommandLineArgs(i_relative_path)
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
    
    ///////////////////////////////////////////////////////////////////////////////
    //

    def "R_2_04___FILE_TYPE_MUST_BE_CEF"() 
    {
        setup:
            def l_cmd_args = getCommandLineArgs('R_2_04___FILE_TYPE_MUST_BE_CEF/C3_CP_EDI_EGD__20111009_V01.cef')
        when:
            def App app = new App()
            def result = app.stages(l_cmd_args)
        then:
            RS2_MetaObjectsException ex = thrown()
            ex.getError() == RS2_MetaObjectsException.Error.R_2_04___FILE_TYPE_MUST_BE_CEF
        
    }
}

















