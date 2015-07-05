package cefpass

import rules2015.RuleSets
import rules2015.RS0_CefParser

///////////////////////////////////////////////////////////////////////////////
//

public class App {

    CefHeaderXml m_headerXml = null
    
    boolean args(String[] i_args) {
        true
    }
    
    public def stage_1__cmdln_args(i_args) {
        CefLog.top "Stage 1: " 
        
        println "Command Line Args:"
        i_args.each {
            println "\t" + it
        }
        
        CmdLnArgs.init(i_args)
        if(CmdLnArgs.isOk() == false) { System.exit(-1); } 
        FileLogs.init()
    }
    
    public def stage_2__parser() {
        CefLog.top "Stage 2: " 
        
        CefReader l_reader = new CefReader()
        //x CefHeaderXml 
        m_headerXml = l_reader.getHeaderXml()
        FileLogs.writeTextFile("nodes.xml", m_headerXml.getXmlNodesAsString())

        RS0_CefParser.showAll()
    }
    
    public def stage_3__xsd_schema() {
        CefLog.top "Stage 3: " 
        
        //  String l_xmlPath = FileLogs.getFilePath("nodes.xml")
        //  String l_xsdPath = "C:/work.dev/2014.09.27.github.cef.pass.v2/cef-pass/xsd/a1.xsd"
        //  if(CefHeaderXsd.validateXMLSchema(l_xsdPath, l_xmlPath) == false) return
        CefLog.stage3_info("validateXMLSchema", "Skipped")
    }
    
    public def stage_4__rules__global_attributes() {
    }

    public def stage_4__rules__meta_objects() {
    }

    public def stage_4__rules__variable_objects() {
    }

    public def stage_4__rules() {
        CefLog.top "Stage 4: " 
        
        RuleSets.run(m_headerXml.getHeaderXPath())
    }

    public def stage_5__data() {
        CefLog.top "Stage 5: " 
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    //
    
    public def boolean  stages(String[] i_args) {
        
        def result = false

        //x try
        //x {
            stage_1__cmdln_args(i_args)
            stage_2__parser()
            stage_3__xsd_schema()
            //x stage_4__rules__global_attributes()
            //x stage_4__rules__meta_objects()
            //x stage_4__rules__variable_objects()
            stage_4__rules()
            stage_5__data()
            
            result = true
        //x }
        //x catch(Exception e) {
        //x     println "Error"
        //x }
        
        return result
    }
    
    public static void main(String[] i_args) {
        CefLog.diag "Hello, World!"
        CefLog.diag "workingDir: "  + System.getProperty("user.dir")
        
        App a = new App();

        try
        {
            a.stages(i_args)
        }
        catch(Exception e) {
            e.printStackTrace()        
        }
        
        FileLogs.close()
    }
}








            




