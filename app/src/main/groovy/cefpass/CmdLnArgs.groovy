package cefpass

import groovy.util.CliBuilder
import org.apache.commons.cli.Option
import java.io.File

///////////////////////////////////////////////////////////////////////////////
//

public class CmdLnArgs
{
    def static s_isCommentsOn = false
    
    def static s_filepath 
    def static s_searchFolders
    def static s_logsFolder
    def static s_xmlSchemas

    def static s_outputHeaderXML
    def static s_quickValidation
    
    
    def static s_testRuleId
    def static s_stopOnFail
    def static s_outputResultsLevel
    
    def static s_configFilePath
    def static s_configEnv
    
    def static s_filename
    def static s_logicalFileId
    def static s_cefFileVersion
    
    def static s_isOk = false;
    
    def static init(String[] i_args) {

        def cli = new CliBuilder(usage:'java -jar cefpass-0.1.0.jar -f <path-to-cef> -i<search include dirs> -x <xml-schema files>')
        
        cli.c(                       longOpt: 'comments-on',                                                                                 '(default false) include comments in the output data(XML)')
        cli.h(                       longOpt: 'help',                                                                                        'usage information')
        cli.f(argName: 'cef',        longOpt: 'cef',         args: 1,                            required: true,                             '(Required) path to cef file')
        cli.i(argName: 'include',    longOpt: 'include',     args: Option.UNLIMITED_VALUES,      required: false,    valueSeparator: ',',    '(Optional) list of include folders to search for ceh files')
        cli.l(argName: 'logs',       longOpt: 'logs',        args: 1,                            required: false,                            '(Optional) path to logs folder')
        cli.x(argName: 'xsd',        longOpt: 'xsd',         args: Option.UNLIMITED_VALUES,      required: false,    valueSeparator: ',',    '(Optional) list of xml schema files to validate header data against')
        
        cli.o(                       longOpt: 'xo',                                                                                          'output header meta data in xml format')
        cli.q(                       longOpt: 'qv',                                                                                          'quick validation (only checks 1st data row) ')
                                 
        cli.r(argName: 'rule',       longOpt: 'rule-id',     args: 1,                            required: false,                            '(Optional) Test specific Rule Id. Default=All e.g. "1.02"')
        cli.s(argName: 'stop',       longOpt: 'stop',        args: 1,                            required: false,                            '(Optional) Stop on Fail. TRUE/FALSE Default=FALSE')
        cli.o(argName: 'output',     longOpt: 'output',      args: 1,                            required: false,                            '(Optional) Output Results Level(0,1,2): 0:Pass/Fail, 1:Details 2:Verbose=Todo Default=1')
                                 
        cli.g(argName: 'config',     longOpt: 'config',      args: 1,                            required: false,                            '(Optional) A groovy dsl config file')
        cli.e(argName: 'config-env', longOpt: 'config-env',  args: 1,                            required: false,                            '(Optional) A config environment tag (e.g. dev, test, default=none)')
        
        def options = cli.parse(i_args)
 
        if(!options) { CefLog.error "Error";  cli.usage }
        else if (options.h) cli.usage
        else {
            // values are false if missing i.e. user does not set them
            s_isCommentsOn          = options.c ? true : false
            
            s_filepath              = options.f
            s_searchFolders         = options.is
            s_logsFolder            = options.l  
            s_xmlSchemas            = options.xs

            s_outputHeaderXML       = options.o
            s_quickValidation       = options.q
            
            s_testRuleId            = options.r
            s_stopOnFail            = Boolean.valueOf(options.s)
            s_outputResultsLevel    = Utils.getIntegerInRange(options.o, 0, 2, 1)
            
            s_configFilePath        = options.g
            s_configEnv             = options.e

            if(s_configFilePath)
            {
                def l_env = s_configEnv ?: ""
                def l_config = new ConfigSlurper(l_env).parse(new File(s_configFilePath).toURL())                
                
                s_isCommentsOn          = Boolean.valueOf(l_config.settings.isCommentsOn ) ?: s_isCommentsOn
                
                s_filepath              = l_config.settings.filepath                ?: s_filepath
                s_searchFolders         = l_config.settings.searchFolders           ?: s_searchFolders
                s_logsFolder            = l_config.settings.logsFolder              ?: s_logsFolder
                s_xmlSchemas            = l_config.settings.xmlSchemas              ?: s_xmlSchemas
                
                s_outputHeaderXML       = l_config.settings.outputHeaderXML         ?: s_outputHeaderXML
                s_quickValidation       = l_config.settings.quickValidation         ?: s_quickValidation
                
                s_testRuleId            = l_config.settings.testRuleId              ?: s_testRuleId
                s_stopOnFail            = (true == l_config.settings.stopOnFail )   ?: s_stopOnFail
                
                s_outputResultsLevel    = Utils.getIntegerInRange((l_config.settings.outputResultsLevel ?: options.o), 0, 2, 1)
            }
            
            s_filename              = Utils.getCefFilename(s_filepath)
            s_logicalFileId         = Utils.getCefLogicalFileId(s_filename)
            s_cefFileVersion        = Utils.getCefFileVersion(s_filename)
            
            s_isOk = true
        }
        
        show()
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    //
    
    static def isCommentsOn()            { s_isCommentsOn }

    static def getFilePath()             { s_filepath }
    static def getSearchFolders()        { s_searchFolders }
    static def getLogsFolder()           { s_logsFolder }
    static def getXmlSchemas()           { s_xmlSchemas }

    static def getOutputHeaderXML()      { s_outputHeaderXML } 
    static def getQuickValidation()      { s_quickValidation }

    static def getTestRuleId()           { s_testRuleId }
    static def getStopOnFail()           { s_stopOnFail }
    static def getOutputResultsLevel()   { s_outputResultsLevel }

    static def getFilename()             { s_filename }
    static def getLogicalFileId()        { s_logicalFileId }
    static def getCefFileVersion()       { s_cefFileVersion }

    static def isOk()                    { s_isOk }
    
    static def show() {
        //x if(s_filepath != false)         Show.showCefFilePath(s_filepath)
        //x if(s_searchFolders != false)    Show.showSearchFolders(s_searchFolders)
            
        println "CmdLnArgs.isCommentsOn".padRight(50)             + CmdLnArgs.isCommentsOn()            

        println "CmdLnArgs.getFilePath".padRight(50)              + CmdLnArgs.getFilePath()             
        println "CmdLnArgs.getSearchFolders".padRight(50)         + CmdLnArgs.getSearchFolders()        
        println "CmdLnArgs.getLogsFolder".padRight(50)            + CmdLnArgs.getLogsFolder()           
        println "CmdLnArgs.getXmlSchemas".padRight(50)            + CmdLnArgs.getXmlSchemas()           
                     

        println "CmdLnArgs.getOutputHeaderXML".padRight(50)       + CmdLnArgs.getOutputHeaderXML()
        println "CmdLnArgs.getQuickValidation".padRight(50)       + CmdLnArgs.getQuickValidation()        

        println "CmdLnArgs.getTestRuleId".padRight(50)            + CmdLnArgs.getTestRuleId()           
        println "CmdLnArgs.getStopOnFail".padRight(50)            + CmdLnArgs.getStopOnFail()           
        println "CmdLnArgs.getOutputResultsLevel".padRight(50)    + CmdLnArgs.getOutputResultsLevel()   

        println "CmdLnArgs.getFilename".padRight(50)              + CmdLnArgs.getFilename()             
        println "CmdLnArgs.getLogicalFileId".padRight(50)         + CmdLnArgs.getLogicalFileId()        
        println "CmdLnArgs.getCefFileVersion".padRight(50)        + CmdLnArgs.getCefFileVersion()       

        println "CmdLnArgs.isOk".padRight(50)                     + CmdLnArgs.isOk()                    
    }
}

