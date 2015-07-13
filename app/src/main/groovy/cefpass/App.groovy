package cefpass

import rules2015.RuleSets
import rules2015.RS0_CefParser

///////////////////////////////////////////////////////////////////////////////
//

public class App {

    CefHeaderXml m_headerXml = null
    String[] m_args
    
    public App()
    {
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    //
    
    class AppResult extends CefResult
    {
        def stage_results = [:]
        
        AppResult() { 
            tag="AppResult" 
        }
        
        def pushResult(i_key, i_result) {
            stage_results[i_key] = i_result
            i_result.diag()
            i_result.isError
        }
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    //
    
    boolean args(String[] i_args) {
        true
    }
    
    def stage_1__cmdln_args = {
        CefLog.top "Stage 1: " 
        println "Stage 1: ========================================== "
        
        def l_result = new CefResult("stage_1__cmdln_args")
        
        try{
            println "Command Line Args:"
            m_args.each {
                println "\t" + it
            }
            
            CmdLnArgs.init(m_args)
            if(CmdLnArgs.isOk() == false) { throw new Exception("Error: CmdLnArgs") } 
            FileLogs.init()
            
            l_result.setPass()
        }
        catch (Exception e) {
            l_result.setException(e)
        }
            
        l_result
    }
    
    def stage_2__parser = {
        CefLog.top "Stage 2: " 
        println "Stage 2: ========================================== "
        
        def l_result = new CefResult("stage_2__parser")
        
        try{
            CefReader l_reader = new CefReader()
            //x CefHeaderXml 
            m_headerXml = l_reader.getHeaderXml()
            FileLogs.writeTextFile("nodes.xml", m_headerXml.getXmlNodesAsString())

            RS0_CefParser.showAll()
            
            l_result.setPass()
        }
        catch (Exception e) {
           l_result.setException(e)
        }
            
        l_result
    }
    
    def stage_3__xsd_schema = {
        CefLog.top "Stage 3: " 
        println "Stage 3: ========================================== "
        
        def l_result = new CefResult("stage_3__xsd_schema")
        
        try{
            //  String l_xmlPath = FileLogs.getFilePath("nodes.xml")
            //  String l_xsdPath = "C:/work.dev/2014.09.27.github.cef.pass.v2/cef-pass/xsd/a1.xsd"
            //  if(CefHeaderXsd.validateXMLSchema(l_xsdPath, l_xmlPath) == false) return
            CefLog.stage3_info("validateXMLSchema", "Skipped")
            
            l_result.setPass()
        }
        catch (Exception e) {
           l_result.setException(e)
        }
            
        l_result
    }
    
    def stage_4__rules = {
        CefLog.top "Stage 4: " 
        println "Stage 4: ========================================== "
        
        def l_result = new CefResult("stage_4__rules")
        
        try{
//x             def r = RuleSets.run(m_headerXml.getHeaderXPath())
//x             
//x             if(r.isError == false) l_result.setPass()
//x             else                   l_result.setFail()
        
            l_result = RuleSets.run(m_headerXml.getHeaderXPath())
        }
        catch (Exception e) {
            
           l_result.setException(e)
        }
            
        l_result
    }

    def stage_5__data = {
        CefLog.top "Stage 5: " 
        println "Stage 5: ========================================== "
        
        def l_result = new CefResult("stage_5__data")
        
        try{
            l_result.setPass()
        }
        catch (Exception e) {
           l_result.setException(e)
        }
            
        l_result
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    //
    
    public def stages(String[] i_args) {
        m_args = i_args
        
        def l_result = new AppResult()
        
        def l_stages = [
            STAGE_1: stage_1__cmdln_args,
            STAGE_2: stage_2__parser,
            STAGE_3: stage_3__xsd_schema ,
            STAGE_4: stage_4__rules,
            STAGE_5: stage_5__data
        ] as TreeMap // retain order

        def r = l_stages.any { it ->
            println it.key
            def res = it.value()
            l_result.pushResult(it.key, res)
        }

        if(r == false) l_result.setPass()   // did not stop
        else           l_result.setFail()
    
        l_result        
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

