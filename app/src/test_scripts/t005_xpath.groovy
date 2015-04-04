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
        def l_next = i_from_document.root.getFirstChild()
        
        while(l_next != null)
        {
            cur.appendChild(doc.importNode(l_next, true))
            l_next = l_next.getNextSibling()
        }
    }

    def stxMix(t, n) {  
         cur = doc.createElement(t); 
         def attr = doc.createAttribute("name")
         attr.setValue(n)
         cur.setAttributeNode(attr)
         cur = root.appendChild(doc.createElement(t))
    }

    def stxMeta(n)              { cur = stxMix("meta", n) }
    def etxMeta(n)              { cur = root }
    def stxVar(n)               { cur = stxMix("var", n) } 
    def etxVar(n)               { cur = root }
    def addAttr(k,v)            { cur.appendChild(doc.createElement(k)).appendChild(doc.createTextNode(v)) }
    
    def addComment(c)           { cur.appendChild(doc.createComment(c)) }
    def getXmlNodesAsString()   { XmlUtil.serialize(root) }
    def dumpX()                 { println getXmlNodesAsString() }
    def getDocument() { doc }
    
    def removeQuotes(v) {
        def l = v.length()
        def q = (l > 2 && v[0] == '"' && v[l-1] == '"') 
        if (q==true) { v = v.substring(1,l-1) }
        
        [v, q]
    }

    def add_kv(k, i_v){
        def (v, q) = removeQuotes(i_v)

        if(q == true) {
            v = '\"' + v +'\"'
        }
        
        Show.showHeaderKV(k,v)
        
    	if("START_META".compareToIgnoreCase(k) == 0)			stxMeta(v) 
    	else if ("END_META".compareToIgnoreCase(k) == 0)		etxMeta(v) 
    	else if ("START_VARIABLE".compareToIgnoreCase(k) == 0) 	stxVar(v) 
    	else if ("END_VARIABLE".compareToIgnoreCase(k) == 0)	etxVar(v) 
    	else 													addAttr(k,v,q) 
    }
    
}    

























def test_001()
{

    def H1 = new CefHeaderNodesNEW()

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
    
    
    def H2 = new CefHeaderNodesNEW()

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







































