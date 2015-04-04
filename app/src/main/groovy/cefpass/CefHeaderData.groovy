package cefpass

import java.io.FileInputStream
import java.io.File
import java.util.zip.GZIPInputStream

import groovy.xml.XmlUtil

import groovy.xml.MarkupBuilder
import groovy.xml.DOMBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.*

///////////////////////////////////////////////////////////////////////////////
//
 
//x     def builder = MarkupBuilder.newInstance()
//x     def builder = DOMBuilder.newInstance()
//x     def builder = JsonBuilder.newInstance()
//x     def builder = NodeBuilder.newInstance()
 
class CefHeaderNodes {

    def builder = new NodeBuilder()
    def root = builder.root()
    def cur = root

    def error(i_message) { println i_message; System.exit(-1) }

    def append(nodes) { cur = root; root.append(nodes) }

    def appendDocument(i_document) { 
        i_document.root.children().each { append(it); }
    }    
    
    def addAttr(k,v,q) { cur.append(builder.createNode(k, v )) }  // quotes
    
    def addComment(c) { Show.showHeaderComment(c); cur.append(builder.c(c)) }
    
    def stxMeta(n) {  cur = builder.meta(name: n); root.append(cur) }
    def etxMeta(n) {  cur = root }
    
    def stxVar(n) { cur = builder.var(name: n); root.append(cur) }
    def etxVar(n) { cur = root}

    def getNodesAsString()    { 
        //x println "\nNodes:"
        def writer = new StringWriter()
        root.print(new PrintWriter(writer))
        writer.toString()    
    }
    
    def getXmlNodesAsString() { 
        //x println "\nXML Nodes:"
        new XmlUtil().serialize(root)    
    }
    
    def dump() {
        //x def writer2 = new StringWriter()
        //x root.print(new PrintWriter(writer2))
        println getNodesAsString()
    }
}

class CefHeaderData {

    def headerNodes = new CefHeaderNodes()

    def error(i_message) { println i_message; System.exit(-1) }
    
    def append(nodes) { headerNodes.append(nodes);                                              }
    def appendDocument(i_headerData) { headerNodes.appendDocument(i_headerData.headerNodes);    }
    
    def addAttr(k,v,q) { headerNodes.addAttr(k,v,q);                                            }
    def addComment(c) { headerNodes.addComment(c);                                              }
    
    def stxMeta(n) {  headerNodes.stxMeta(n);                                                   }
    def etxMeta(n) {  headerNodes.etxMeta(n);                                                   }
    
    def stxVar(n) { headerNodes.stxVar(n);                                                      }
    def etxVar(n) { headerNodes.etxVar(n);                                                      }

    def dump() { headerNodes.dump();                                                            }      
    
    def getNodesAsString()    { headerNodes.getNodesAsString()                                  }
    def getXmlNodesAsString() { headerNodes.getXmlNodesAsString()                               }

    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // Legacy Hack!!! TODO DomBuilder should replace ?NodeBuilder above... but this is fine for now!             
    // 
    //                  !!!!   This is a Hack   :-(      FIXME    !!!!
    //                  !!!!   This is a Hack   :-(      FIXME    !!!!
    //                  !!!!   This is a Hack   :-(      FIXME    !!!!
    //                  !!!!   This is a Hack   :-(      FIXME    !!!!
    // 
    //                  used for rules
    // 
    // 
    def getDocument() { DOMBuilder.parse(new StringReader(getXmlNodesAsString()))             }
    
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



///////////////////////////////////////////////////////////////////////////////  ///////////////////////////////////////////////////////////////////////////////  ///////////////////////////////////////////////////////////////////////////////
//                                                                               //                                                                               //


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





































