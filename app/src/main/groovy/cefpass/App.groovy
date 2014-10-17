package cefpass

import java.util.logging.Logger

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
            CmdLnArgs l_args = new CmdLnArgs(i_args)

            if(l_args.isOk() == false) return
            
            
            // stage #2
            CefReader l_reader = new CefReader(l_args)
            l_reader.showContexts()
            
            CefHeaderData l_headerData = l_reader.getHeaderData()
//x         l_headerData.show()
            
            l_headerData.showNodes() 
            l_headerData.showXmlNodes() 
            l_headerData.showJSONNodes() 
            
            Logs.writeTextFile("nodes.txt", l_headerData.getNodesAsString())
            Logs.writeTextFile("nodes.xml", l_headerData.getXmlNodesAsString())
            Logs.writeTextFile("nodes.json", l_headerData.getJSONodesAsString())

//x             Logs.writeTextFile("nodes.txt",  "Hello, World!")
//x             Logs.writeTextFile("nodes.xml",  "Hello, World!")
//x             Logs.writeTextFile("nodes.json", "Hello, World!")
            
            // stage #3 validate XML
            // todo get xml
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
        Logger logger = Logger.getLogger("")
        logger.info ("Hello, World!")
    
        i_args.each { 
            println " ++ " +  it
        }



        App a = new App();
        
        a.stages(i_args);
    }
}









            




