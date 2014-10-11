package cefpass

public class App {
    boolean m1() {
        println "Hello, World!"
        true
//x         false
    }

    public void test_batch() {
        new CmdLineSamples().test_batch();
    }
    
    
    public void stages(String[] i_args) {
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

        try{
            // stage #1
            CmdLnArgs l_args = new CmdLnArgs(i_args)

            // stage #2
            CefReader l_reader = new CefReader(l_args)
            l_reader.showContexts()
            
            CefHeaderData l_headerData = l_reader.getHeaderData()
//x         l_headerData.show()
            
            l_headerData.showNodes() 
            l_headerData.showXmlNodes() 
            l_headerData.showJSONNodes() 
            
            // todo show_nodes
            // todo show_xml
            // todo show_json

            // stage #3 validate XML
            // todo get xml

        }
        catch(Exception e) {
            e.printStackTrace()        
        }
    }
    
    
    
    public static void main(String[] i_args) {
        println "Hello, World!"
    
        App a = new App();
        a.stages(i_args);
    }
}
