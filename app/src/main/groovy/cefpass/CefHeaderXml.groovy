package cefpass

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

public class CefHeaderXml{
    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
    Document doc = docBuilder.newDocument();
    
    Element root = doc.createElement("root");
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
        cur.setAttribute("name", n)
        root.appendChild(cur)
    }

    def stxMeta(n)              { stxMix("meta", n) }
    def etxMeta(n)              { cur = root }
    def stxVar(n)               { stxMix("var", n) } 
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

    def add_kv(k, v){
        Show.showHeaderKV(k,v)
        
    	if("START_META".compareToIgnoreCase(k) == 0)			stxMeta(v) 
    	else if ("END_META".compareToIgnoreCase(k) == 0)		etxMeta(v) 
    	else if ("START_VARIABLE".compareToIgnoreCase(k) == 0) 	stxVar(v) 
    	else if ("END_VARIABLE".compareToIgnoreCase(k) == 0)	etxVar(v) 
    	else 													addAttr(k,v) 
    }
    
}    





































