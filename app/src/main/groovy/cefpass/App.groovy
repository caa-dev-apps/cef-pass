package cefpass

import java.util.logging.Logger

import rules2015.RuleSets
import rules2015.RS0_CefParser
//x import rules2015.RS1_GlobalAttributes
//x import rules2015.RS2_MetaObjects

///////////////////////////////////////////////////////////////////////////////
//

public class App {


    boolean args(String[] i_args) {
        true
    }
    
    public def boolean  stages(String[] i_args) {
        println "Command Line Args:"
        i_args.each {
            println "\t" + it
        }
        
        def result = false
        
//x         try{
        CefLog.top "Stage 1: "  //  /////////////////////////////////////////////////////////////////////////////   command line inputs 
            
            CmdLnArgs.init(i_args)
            if(CmdLnArgs.isOk() == false) return
            FileLogs.init()

            
        CefLog.top "Stage 2: "  //  /////////////////////////////////////////////////////////////////////////////   cef header read + includes
            
            CefReader l_reader = new CefReader()
            CefHeaderXml l_headerXml = l_reader.getHeaderXml()
            FileLogs.writeTextFile("nodes.xml", l_headerXml.getXmlNodesAsString())

            RS0_CefParser.showAll()
            
        CefLog.top "Stage 3: "  //  /////////////////////////////////////////////////////////////////////////////   xml validation
                                    
            //  String l_xmlPath = FileLogs.getFilePath("nodes.xml")
            //  String l_xsdPath = "C:/work.dev/2014.09.27.github.cef.pass.v2/cef-pass/xsd/a1.xsd"
            //  if(CefHeaderXsd.validateXMLSchema(l_xsdPath, l_xmlPath) == false) return
            CefLog.stage3_info("validateXMLSchema", "Skipped")
            
        CefLog.top "Stage 4: "  //  /////////////////////////////////////////////////////////////////////////////   Globals Attrs, Meta Object, Variable Objects
            
            RuleSets.run(l_headerXml.getHeaderXPath())
            
        CefLog.top "Stage 5: "  //  /////////////////////////////////////////////////////////////////////////////   Data
            
//x         }
//x         catch(Exception e) {
//x             e.printStackTrace()        
//x         }
        
        return true
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








            




