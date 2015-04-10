package cefpass

import java.util.logging.Logger

import rules2015.RuleSets

///////////////////////////////////////////////////////////////////////////////
//

public class App {


    boolean args(String[] i_args) {
        true
    }
    
    public def boolean  stages(String[] i_args) {
        //  1. command line inputs
        //
        //      PASS/FAIL
        //
        //  2. cef header read + includes
        //
        //      attributes
        //      meta
        //      vars
        //      
        //      output (header data)
        //          - //x groovy nodes
        //          - xml 
        //
        //      PASS/FAIL
        //
        //  3. xml validation
        //
        //      PASS/FAIL
        //
        //  4. Groovy/JS Rules
        //
        //      PASS/FAIL
        //
        //
        //  5. Data Validations
        //      - Date Time checks
        //      - Data format/type
        //      - # Data cells

        def result = false
        
        try{
            ///////////////////////////////////////////////////////////////////////////////
            // stage #1
            CefLog.top "Stage 1: "
            CmdLnArgs.init(i_args)
            if(CmdLnArgs.isOk() == false) return
            FileLogs.init()
            
            ///////////////////////////////////////////////////////////////////////////////
            // stage #2
            CefLog.top "Stage 2: "
            CefReader l_reader = new CefReader()
            //i l_reader.showContexts()
            
            CefHeaderXml l_headerXml = l_reader.getHeaderXml()
            FileLogs.writeTextFile("nodes.xml", l_headerXml.getXmlNodesAsString())

            ///////////////////////////////////////////////////////////////////////////////
            // stage #3 validate XML
            CefLog.top "Stage 3: "
            // ----------------------------------------------------------------------------------
            // Under development
            // ----------------------------------------------------------------------------------
//x             String l_xmlPath = FileLogs.getFilePath("nodes.xml")
//x             String l_xsdPath = "C:/work.dev/2014.09.27.github.cef.pass.v2/cef-pass/xsd/a1.xsd"
//x             
//x             if(CefHeaderXsd.validateXMLSchema(l_xsdPath, l_xmlPath) == false) return
     
            // ----------------------------------------------------------------------------------
            // 

            
            ///////////////////////////////////////////////////////////////////////////////
            // stage #4
            CefLog.top"Stage 4: "
            // ----------------------------------------------------------------------------------
            // Under development
            // ----------------------------------------------------------------------------------
            
            RuleSets.run(l_headerXml.getHeaderXPath())
            
            result = true
            
            ///////////////////////////////////////////////////////////////////////////////
            // stage #5
            CefLog.top "Stage 5: "
            // ----------------------------------------------------------------------------------
            // Under development
            // ----------------------------------------------------------------------------------
            
        }
        catch(Exception e) {
            e.printStackTrace()        
        }
        
        result
    }
    
    public static void main(String[] i_args) {
        CefLog.diag "Hello, World!"
        CefLog.diag "workingDir: "  + System.getProperty("user.dir")
        
        App a = new App();
        
        a.stages(i_args)
        
        FileLogs.close()
    }
}









            




