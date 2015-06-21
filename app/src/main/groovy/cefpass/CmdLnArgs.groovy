package cefpass

import groovy.util.CliBuilder
import org.apache.commons.cli.Option

///////////////////////////////////////////////////////////////////////////////
//

//x public class CmdLnArgs
//x {
//x     def static s_searchFolders
//x     def static s_filename
//x     def static s_xmlSchemas
//x     def static s_isOk = false;
//x     def static s_logsFolder
//x     def static s_isCommentsOn = false
//x     
//x     def static init(String[] i_args) {
//x 
//x         def cli = new CliBuilder(usage:'java -jar cefpass-0.1.0.jar -f <path-to-cef> -i<search include dirs> -x <xml-schema files>')
//x         cli.c(                     longOpt: 'comments-on',                                                                                 '(default false) include comments in the output data(XML,JSON,Nodes)')
//x         cli.h(                     longOpt: 'help',                                                                                        'usage information')
//x         cli.f(argName: 'cef',      longOpt: 'cef',         args: 1,                            required: true,                             '(Required) path to cef file')
//x         cli.i(argName: 'include',  longOpt: 'include',     args: Option.UNLIMITED_VALUES,      required: false,    valueSeparator: ',',    '(Optional) list of include folders to search for ceh files')
//x         cli.l(argName: 'logs',     longOpt: 'logs',        args: 1,                            required: false,                            '(Optional) path to logs folder')
//x         cli.x(argName: 'xsd',      longOpt: 'xsd',         args: Option.UNLIMITED_VALUES,      required: false,    valueSeparator: ',',    '(Optional) list of xml schema files to validate header data against')
//x         cli.o(                     longOpt: 'xo',                                                                                          'output header meta data in xml format')
//x         cli.q(                     longOpt: 'qv',                                                                                          'quick validation (only checks 1st data row) ')
//x  
//x         def options = cli.parse(i_args)
//x  
//x         if(!options) { CefLog.error "Error";  cli.usage }
//x         else if (options.h) cli.usage
//x         else {
//x             // values are false if missing i.e. user does not set them
//x             s_filename = options.f
//x             s_searchFolders = options.is
//x             s_xmlSchemas = options.xs
//x             s_logsFolder = options.l  
//x             s_isCommentsOn = options.c ? true : false
//x             
//x             println "@@@@@@@@@@@@@@@@ " + s_filename
//x             
//x             
//x             s_isOk = true
//x         }
//x         
//x         show()
//x     }
//x     
//x     ///////////////////////////////////////////////////////////////////////////////
//x     //
//x     
//x     public def static getSearchFolders()   { return s_searchFolders }
//x     public def static getFilename()        { return s_filename }
//x     public def static getLogsFolder()      { return s_logsFolder }
//x     public def static isOk()               { return s_isOk }
//x     public def static isCommentsOn()       { return s_isCommentsOn }
//x     
//x     // only the filename - not full path
//x     public def static getCefFilename()     { 
//x         def f = Utils.getFilename(s_filename); 
//x         if(f != null) {
//x             def ix = f.lastIndexOf(".gz")
//x             f = (ix >= 0) ? f.substring(0, ix) : f
//x         }
//x         f
//x     }
//x     
//x 
//x     
//x     public def static show() {
//x         if(s_filename != false)         Show.showCefFilename(s_filename)
//x         if(s_searchFolders != false)    Show.showSearchFolders(s_searchFolders)
//x     }
//x 
//x }

public class CmdLnArgs
{
    def static s_searchFolders
    def static s_filepath   // full
    def static s_filename
    def static s_xmlSchemas
    def static s_isOk = false;
    def static s_logsFolder
    def static s_isCommentsOn = false
    
    def static s_logicalFileId
    def static s_cefFileVersion
    
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
            s_filepath = options.f
            s_searchFolders = options.is
            s_xmlSchemas = options.xs
            s_logsFolder = options.l  
            s_isCommentsOn = options.c ? true : false
            
            s_filename = Utils.getCefFilename(s_filepath)
            s_logicalFileId = Utils.getCefLogicalFileId(s_filename)
            s_cefFileVersion = Utils.getCefFileVersion(s_filename)
            
            s_isOk = true
        }
        
        show()
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    //
    
    public def static getSearchFolders()   { return s_searchFolders }
    public def static getFilePath()        { return s_filepath }
    public def static getLogsFolder()      { return s_logsFolder }
    public def static isOk()               { return s_isOk }
    public def static isCommentsOn()       { return s_isCommentsOn }
    
    public def static getFilename()        { return s_filename }
    public def static getLogicalFileId()   { return s_logicalFileId }
    public def static getCefFileVersion()  { return s_cefFileVersion }
    
    public def static show() {
        if(s_filepath != false)         Show.showCefFilePath(s_filepath)
        if(s_searchFolders != false)    Show.showSearchFolders(s_searchFolders)
    }

}













