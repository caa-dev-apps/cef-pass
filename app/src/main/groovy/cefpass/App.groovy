package cefpass

import java.util.logging.Logger

import rules2015.RulesSet01;
import rules2015.RulesSet02;


public class App {
    boolean m1() {
        println "Hello, World!"
        true
    }

///////////////////////////////////////////////////////////////////////////////
//

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
        //          - groovy nodes
        //          - xml 
        //          - json
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
            // stage #1
            CmdLnArgs.init(i_args)
            if(CmdLnArgs.isOk() == false) return
            Logs.init()
            
            // stage #2
            CefReader l_reader = new CefReader()
            //i l_reader.showContexts()
            
            CefHeaderData l_headerData = l_reader.getHeaderData()
            //i l_headerData.showNodes() 
            //i l_headerData.showXmlNodes() 
            //i l_headerData.showJSONNodes() 
            
            Logs.writeTextFile("nodes.txt", l_headerData.getNodesAsString())
            Logs.writeTextFile("nodes.xml", l_headerData.getXmlNodesAsString())
            Logs.writeTextFile("nodes.json", l_headerData.getJSONodesAsString())

            // stage #3 validate XML
            // ----------------------------------------------------------------------------------
            // Under development
            // ----------------------------------------------------------------------------------
//x             String l_xmlPath = Logs.getFilePath("nodes.xml")
//x             String l_xsdPath = "C:/work.dev/2014.09.27.github.cef.pass.v2/cef-pass/xsd/a1.xsd"
//x             
//x             if(XSDValidataion.validateXMLSchema(l_xsdPath, l_xmlPath) == false) return
     
            // ----------------------------------------------------------------------------------
            // 
            // ----------------------------------------------------------------------------------

            // stage #4
            RulesSet01 l_set01 = new RulesSet01()
            l_set01.run()

            RulesSet01.test()
            
            RulesSet02 l_set02 = new RulesSet02()
            l_set02.run()
            
            
            
            
            result = true
        }
        catch(Exception e) {
            e.printStackTrace()        
        }
        
        result
    }
    
    public static void main(String[] i_args) {
        println "Hello, World!"
        println "workingDir: "  + System.getProperty("user.dir")
//x         Logger logger = Logger.getLogger("")
//x         logger.info ("Hello, World!")
//x     
//x         i_args.each { 
//x             println " ++ " +  it
//x         }
        App a = new App();
        
        a.stages(i_args)
        
        Logs.close()
    }
}









            




