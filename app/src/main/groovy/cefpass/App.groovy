package cefpass

import java.util.logging.Logger

import rules2015.RuleSets

///////////////////////////////////////////////////////////////////////////////
//

//x public class App {
//x 
//x 
//x     boolean args(String[] i_args) {
//x         true
//x     }
//x     
//x     public def boolean  stages(String[] i_args) {
//x         //  1. command line inputs
//x         //
//x         //      PASS/FAIL
//x         //
//x         //  2. cef header read + includes
//x         //
//x         //      attributes
//x         //      meta
//x         //      vars
//x         //      
//x         //      output (header data)
//x         //          - //x groovy nodes
//x         //          - xml 
//x         //
//x         //      PASS/FAIL
//x         //
//x         //  3. xml validation
//x         //
//x         //      PASS/FAIL
//x         //
//x         //  4. Groovy/JS Rules
//x         //
//x         //      PASS/FAIL
//x         //
//x         //
//x         //  5. Data Validations
//x         //      - Date Time checks
//x         //      - Data format/type
//x         //      - # Data cells
//x 
//x         def result = false
//x         
//x         try{
//x             CefLog.top "Stage 1: "
//x             ///////////////////////////////////////////////////////////////////////////////
//x             //
//x             
//x             CmdLnArgs.init(i_args)
//x             if(CmdLnArgs.isOk() == false) return
//x             FileLogs.init()
//x 
//x             
//x             
//x             CefLog.top "Stage 2: "
//x             ///////////////////////////////////////////////////////////////////////////////
//x             //
//x             
//x             CefReader l_reader = new CefReader()
//x             CefHeaderXml l_headerXml = l_reader.getHeaderXml()
//x             FileLogs.writeTextFile("nodes.xml", l_headerXml.getXmlNodesAsString())
//x 
//x             
//x             
//x             CefLog.top "Stage 3: "
//x             ///////////////////////////////////////////////////////////////////////////////
//x             //
//x //x             String l_xmlPath = FileLogs.getFilePath("nodes.xml")
//x //x             String l_xsdPath = "C:/work.dev/2014.09.27.github.cef.pass.v2/cef-pass/xsd/a1.xsd"
//x //x             if(CefHeaderXsd.validateXMLSchema(l_xsdPath, l_xmlPath) == false) return
//x      
//x             
//x             
//x             CefLog.top"Stage 4: "
//x             ///////////////////////////////////////////////////////////////////////////////
//x             //
//x             
//x             RuleSets.run(l_headerXml.getHeaderXPath())
//x             
//x             result = true
//x 
//x             
//x             
//x             
//x             CefLog.top "Stage 5: "
//x             ///////////////////////////////////////////////////////////////////////////////
//x             //
//x             
//x         }
//x         catch(Exception e) {
//x             e.printStackTrace()        
//x         }
//x         
//x         result
//x     }
//x     
//x     public static void main(String[] i_args) {
//x         CefLog.diag "Hello, World!"
//x         CefLog.diag "workingDir: "  + System.getProperty("user.dir")
//x         
//x         App a = new App();
//x         
//x         a.stages(i_args)
//x         
//x         FileLogs.close()
//x     }
//x }
//x 

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
        
//x         try{
        CefLog.top "Stage 1: "  //  /////////////////////////////////////////////////////////////////////////////
            
            CmdLnArgs.init(i_args)
            if(CmdLnArgs.isOk() == false) return
            FileLogs.init()

            
        CefLog.top "Stage 2: "  //  /////////////////////////////////////////////////////////////////////////////
            
            CefReader l_reader = new CefReader()
            CefHeaderXml l_headerXml = l_reader.getHeaderXml()
            FileLogs.writeTextFile("nodes.xml", l_headerXml.getXmlNodesAsString())

            
        CefLog.top "Stage 3: "  //  /////////////////////////////////////////////////////////////////////////////
                                    
            //  String l_xmlPath = FileLogs.getFilePath("nodes.xml")
            //  String l_xsdPath = "C:/work.dev/2014.09.27.github.cef.pass.v2/cef-pass/xsd/a1.xsd"
            //  if(CefHeaderXsd.validateXMLSchema(l_xsdPath, l_xmlPath) == false) return
            
            
        CefLog.top "Stage 4: "  //  /////////////////////////////////////////////////////////////////////////////
            
            RuleSets.run(l_headerXml.getHeaderXPath())
            
        CefLog.top "Stage 5: "  //  /////////////////////////////////////////////////////////////////////////////
            
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








            




