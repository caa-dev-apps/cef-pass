package cefpass

import java.io.FileInputStream
import java.io.File
import java.util.zip.GZIPInputStream

import groovy.util.CliBuilder
import org.apache.commons.cli.Option

//-----------------------------------------------------------------------------

public class CmdLnArgs
{
    def m_searchFolders
    def m_filename
    def m_xmlSchemas
    def m_isOk = false;
    def m_logsFolder
    
    def CmdLnArgs(String[] i_args) {

        def cli = new CliBuilder(usage:'java -jar cefpass-0.1.0.jar -f <path-to-cef> -i<search include dirs> -x <xml-schema files>')
        cli.h(                     longOpt: 'help',                                                                                        'usage information')
        cli.f(argName: 'cef',      longOpt: 'cef',         args: 1,                            required: true,                             '(Required) path to cef file')
        cli.i(argName: 'include',  longOpt: 'include',     args: Option.UNLIMITED_VALUES,      required: false,    valueSeparator: ',',    '(Optional) list of include folders to search for ceh files')
        cli.l(argName: 'logs',     longOpt: 'logs',        args: 1,                            required: false,                            '(Optional) path to logs folder')
        cli.x(argName: 'xsd',      longOpt: 'xsd',         args: Option.UNLIMITED_VALUES,      required: false,    valueSeparator: ',',    '(Optional) list of xml schema files to validate header data against')
        cli.q(                     longOpt: 'qv',                                                                                          'quick validation (only checks 1st data row) ')
        cli.o(                     longOpt: 'xo',                                                                                          'output header meta data in xml format')
 
        def options = cli.parse(i_args)
 
        if(!options) { println "Error";  cli.usage }
        else if (options.h) cli.usage
        else {
            m_filename = options.f
            m_searchFolders = options.is
            m_xmlSchemas = options.xs
            m_logsFolder = options.l  

            Logs.init(m_logsFolder)
            
            m_isOk = true
        }
        
        show()
    }
    
    // FOR TESTING....................
    def CmdLnArgs() {
        m_filename = TEST_FILES[0]
        m_searchFolders = TEST_SEARCH_FOLDERS
        
        show()
    }

    //-----------------------------------------------------------------------------
    //
    
    public def getSearchFolders()   { return  m_searchFolders }
    public def getFilename()        { return m_filename }
    public def getLogsFolder()      { return m_logsFolder }
    public def isOk()               { return m_isOk; }
    
    public def show() {
        Show.showCefFilename(m_filename)
        Show.showSearchFolders(m_searchFolders)
    }

    //-----------------------------------------------------------------------------
    //

    def TEST_SEARCH_FOLDERS = [
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/_TEST_SAMPLES/MULTI_LEVEL_INCLUDES",
    
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS",
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS/EDI",
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS/EFW",
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS/PEACE"
    ]

    //-----------------------------------------------------------------------------
    //

    def TEST_FILES = [
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

    public def test_batch() {
    
        for(f in TEST_FILES)
        {
            try
            {
                def r = new CefReader(SEARCH_FOLDERS,
                                      f)
                                      
                r.printHeaderNodes();
            }
            catch(Exception e)
            {
                e.printStackTrace()
            }
        }
    } 
}

