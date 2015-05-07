package cefpass

import groovy.util.CliBuilder
import org.apache.commons.cli.Option

///////////////////////////////////////////////////////////////////////////////
//

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
 
        if(!options) { CefLog.error "Error";  cli.usage }
        else if (options.h) cli.usage
        else {
            // values are false if missing i.e. user does not set them
            s_filename = options.f
            s_searchFolders = options.is
            s_xmlSchemas = options.xs
            s_logsFolder = options.l  
            s_isCommentsOn = options.c ? true : false
            
            s_isOk = true
        }
        
        show()
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    //
    
    public def static getSearchFolders()   { return s_searchFolders }
    public def static getFilename()        { return s_filename }
    public def static getLogsFolder()      { return s_logsFolder }
    public def static isOk()               { return s_isOk }
    public def static isCommentsOn()       { return s_isCommentsOn }
    
    // only the filename - not full path
    public def static getCefFilename()     { 
        def f = Utils.getFilename(s_filename); 
        if(f != null) {
            def ix = f.lastIndexOf(".gz")
            f = (ix >= 0) ? f.substring(0, ix) : f
        }
        f
    }
    

    
    public def static show() {
        if(s_filename != false)         Show.showCefFilename(s_filename)
        if(s_searchFolders != false)    Show.showSearchFolders(s_searchFolders)
    }

}
















