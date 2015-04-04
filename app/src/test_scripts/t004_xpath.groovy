package cefpass

///////////////////////////////////////////////////////////////////////////////
//

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
 
import groovy.xml.XmlUtil

///////////////////////////////////////////////////////////////////////////////
//

class CefHeaderNodesNEW {

    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
    Document doc = docBuilder.newDocument();
    
    Element root = doc.createElement("cef_root");
    def cur = root
    
    def error(i_message) { println i_message; System.exit(-1) }
    def appendDocument(i_from_document) { 
        def l_root = i_from_document.root
        def l_next = l_root.getFirstChild()
        
        while(l_next != null)
        {
            def l_import = doc.importNode(l_next, true)
            cur.appendChild(l_import)
            l_next = l_next.getNextSibling()
        }
    }
    
    def addAttr(k,v) { 
        def elem = doc.createElement(k)
        elem.appendChild(doc.createTextNode(v))
        cur.appendChild(elem) 
    }
    def addComment(c) { cur.appendChild(doc.createComment(c)) }
     
    def stxMeta(n) {  
         cur = doc.createElement('meta'); 
         def attr = doc.createAttribute("name")
         attr.setValue(n)
         cur.setAttributeNode(attr)
         root.appendChild(cur)
    }
    
    def etxMeta(n) {  cur = root }
    
    def stxVar(n) {  
         cur = doc.createElement('var'); 
         def attr = doc.createAttribute("name")
         attr.setValue(n)
         cur.setAttributeNode(attr)
         root.appendChild(cur)
    }
    
    def etxVar(n) {  cur = root }
    
    def getXmlNodesAsString() { 
        XmlUtil.serialize(root)    
    }

    def dumpX() {
        println getXmlNodesAsString()
    }    
}    

def test_001()
{

    def H1 = new CefHeaderNodesXml()

    H1.addComment("Start of H1 Global Attributes")
    H1.addAttr("K1", "V1")
    H1.addAttr("K2", "V2")
    H1.addAttr("K3", "V3")

    H1.addComment("Start of H1 Meta Elements + Values")
    H1.stxMeta("M1")
    H1.addAttr("MK1", "V1")
    H1.addAttr("MK2", "V2")
    H1.addAttr("MK3", "V3")
    H1.etxMeta("M1")

    H1.addComment("Start of H1 Variable Elements + Values")
    H1.stxVar("V1")
    H1.addAttr("VK1", "V1")
    H1.addAttr("VK2", "V2")
    H1.addAttr("VK3", "V3")
    H1.etxVar("V1")

    H1.dumpX()
    
    
    def H2 = new CefHeaderNodesXml()

    H2.addComment("Start of H2 Global Attributes")
    H2.addAttr("K21", "V21")
    H2.addAttr("K22", "V22")
    H2.addAttr("K23", "V23")

    H2.addComment("Start of H Meta Elements + Values")
    H2.stxMeta("M21")
    H2.addAttr("M2K1", "V21")
    H2.addAttr("MK22", "V22")
    H2.addAttr("MK23", "V23")
    H2.etxMeta("M21")

    H2.addComment("Start of H Variable Elments + Values")
    H2.stxVar("V21")
    H2.addAttr("VK21", "V21")
    H2.addAttr("VK22", "V22")
    H2.addAttr("VK23", "V23")
    H2.etxVar("V21")


    H2.dumpX()

    
    H1.appendDocument(H2)
    
    
    
    H1.dumpX()
     
    //x H.test_info()

}


test_001()







































