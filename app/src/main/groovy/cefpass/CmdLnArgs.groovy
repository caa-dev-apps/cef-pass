package cefpass

import java.io.FileInputStream
import java.io.File
import java.util.zip.GZIPInputStream

import groovy.util.CliBuilder
import org.apache.commons.cli.Option

//-----------------------------------------------------------------------------

public class CmdLnArgs
{
    def static s_searchFolders
    def static s_filename
    def static s_xmlSchemas
    def static s_isOk = false;
    def static s_logsFolder
    def static s_isCommentsOn = false
    
    def static init(String[] i_args) {

        def cli = new CliBuilder(usage:'java -jar cefpass-0.1.0.jar -f <path-to-cef> -i<search include dirs> -x <xml-schema files>')
        cli.c(                     longOpt: 'comments-on',                                                                                 '(default false) include comments in the output data(XML,JSON,Nodes)')
        cli.h(                     longOpt: 'help',                                                                                        'usage information')
        cli.f(argName: 'cef',      longOpt: 'cef',         args: 1,                            required: true,                             '(Required) path to cef file')
        cli.i(argName: 'include',  longOpt: 'include',     args: Option.UNLIMITED_VALUES,      required: false,    valueSeparator: ',',    '(Optional) list of include folders to search for ceh files')
        cli.l(argName: 'logs',     longOpt: 'logs',        args: 1,                            required: false,                            '(Optional) path to logs folder')
        cli.x(argName: 'xsd',      longOpt: 'xsd',         args: Option.UNLIMITED_VALUES,      required: false,    valueSeparator: ',',    '(Optional) list of xml schema files to validate header data against')
        cli.o(                     longOpt: 'xo',                                                                                          'output header meta data in xml format')
        cli.q(                     longOpt: 'qv',                                                                                          'quick validation (only checks 1st data row) ')
 
        def options = cli.parse(i_args)
 
        if(!options) { println "Error";  cli.usage }
        else if (options.h) cli.usage
        else {
            s_filename = options.f
            s_searchFolders = options.is
            s_xmlSchemas = options.xs
            s_logsFolder = options.l  
            s_isCommentsOn = options.c ? true : false
            
            s_isOk = true
        }
        
        show()
    }
    
//x     // FOR TESTING....................
//x     def CmdLnArgs() {
//x         s_filename = TEST_FILES[0]
//x         s_searchFolders = TEST_SEARCH_FOLDERS
//x         
//x         show()
//x     }

    //-----------------------------------------------------------------------------
    //
    
    public def static getSearchFolders()   { return s_searchFolders }
    public def static getFilename()        { return s_filename }
    public def static getLogsFolder()      { return s_logsFolder }
    public def static isOk()               { return s_isOk }
    public def static isCommentsOn()       { return s_isCommentsOn }
    
    
    public def static show() {
        Show.showCefFilename(s_filename)
        Show.showSearchFolders(s_searchFolders)
    }

    //-----------------------------------------------------------------------------
    //

    def static TEST_SEARCH_FOLDERS = [
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/_TEST_SAMPLES/MULTI_LEVEL_INCLUDES",
    
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS",
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS/EDI",
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS/EFW",
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS/PEACE"
    ]

    //-----------------------------------------------------------------------------
    //

    def static TEST_FILES = [
//x         "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/_TEST_SAMPLES/MULTI_LEVEL_INCLUDES/T0001_INCLUDE_TESTS.cef",

        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_EGD__20111009_V01.cef.gz",

        
    //x     "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_EGD__20111009_V01.cef",
//x         "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_EGD__20111020_V01.cef.gz",
//x         "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_EGD__20111021_V01.cef.gz",
//x         "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_EGD__20111022_V01.cef.gz",
//x         "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_QZC__20111009_V01.cef.gz",
//x         "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_QZC__20111020_V01.cef.gz",
//x         "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_QZC__20111021_V01.cef.cef",
//x         "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_QZC__20111021_V01.cef.gz",
//x         "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_QZC__20111022_V01.cef.gz"
    ]

//x     public def static test_batch() {
//x     
//x         for(f in TEST_FILES)
//x         {
//x             try
//x             {
//x                 def r = new CefReader(SEARCH_FOLDERS,
//x                                       f)
//x                                       
//x                 r.printHeaderNodes();
//x             }
//x             catch(Exception e)
//x             {
//x                 e.printStackTrace()
//x             }
//x         }
//x     } 
}
















