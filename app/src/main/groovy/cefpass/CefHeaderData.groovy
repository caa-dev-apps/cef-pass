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
 
class CefHeaderNodes {

    def builder = new NodeBuilder()
    def root = builder.root()
    def cur = root

    def error(i_message) { println i_message; System.exit(-1) }

    def append(nodes) { cur = root; root.append(nodes) }

    def appendDocument(i_document) { 
        i_document.root.children().each { append(it); }
    }    
    
//x     def addAttr(k,v,q) { cur.append(builder.a((k): v, q: q)) }  // quotes
//x     def addAttr(k,v,q) { cur.append(builder.a((k): v, q: q)) }  // quotes
//x     def addAttr(k,v,q) { cur.append(builder.createNode(k, '\"' + v +'\"')) }  // quotes
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

//x     def builder = MarkupBuilder.newInstance()
//x     def builder = DOMBuilder.newInstance()
//x     def builder = JsonBuilder.newInstance()
//x     def builder = NodeBuilder.newInstance()
//x     def root = builder.root() { 

    
//x-x class CefHeaderNodes {
//x-x 
//x-x //x     def builder = new NodeBuilder()
//x-x //x     def root = builder.root()
//x-x //x     def cur = root
//x-x 
//x-x     def builder = null;
//x-x     def root = null;
//x-x     def cur = null;
//x-x     
//x-x     public CefHeaderNodes(i_builder)
//x-x     {
//x-x         builder = i_builder
//x-x         root = builder.root()
//x-x         cur = root
//x-x     }
//x-x     
//x-x     
//x-x     def error(i_message) { println i_message; System.exit(-1) }
//x-x 
//x-x     def append(nodes) { cur = root; root.append(nodes) }
//x-x 
//x-x     def appendDocument(i_document) { 
//x-x         i_document.root.children().each { append(it); }
//x-x     }    
//x-x     
//x-x //x     def addAttr(k,v,q) { cur.append(builder.a((k): v, q: q)) }  // quotes
//x-x //x     def addAttr(k,v,q) { cur.append(builder.a((k): v, q: q)) }  // quotes
//x-x //x     def addAttr(k,v,q) { cur.append(builder.createNode(k, '\"' + v +'\"')) }  // quotes
//x-x     def addAttr(k,v,q) { cur.append(builder.createNode(k, v )) }  // quotes
//x-x     
//x-x     
//x-x     def addComment(c) { Show.showHeaderComment(c); cur.append(builder.c(c)) }
//x-x     
//x-x     def stxMeta(n) {  cur = builder.meta(name: n); root.append(cur) }
//x-x     def etxMeta(n) {  cur = root }
//x-x     
//x-x     def stxVar(n) { cur = builder.var(name: n); root.append(cur) }
//x-x     def etxVar(n) { cur = root}
//x-x 
//x-x     def getNodesAsString()    { 
//x-x         //x println "\nNodes:"
//x-x         def writer = new StringWriter()
//x-x         root.print(new PrintWriter(writer))
//x-x         writer.toString()    
//x-x     }
//x-x     
//x-x     def getXmlNodesAsString() { 
//x-x         //x println "\nXML Nodes:"
//x-x         new XmlUtil().serialize(root)    
//x-x     }
//x-x     
//x-x     def dump() {
//x-x         //x def writer2 = new StringWriter()
//x-x         //x root.print(new PrintWriter(writer2))
//x-x         println getNodesAsString()
//x-x     }
//x-x }    
    
    
    
    
    
    
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

    
//x     def builder = MarkupBuilder.newInstance()
//x     def builder = DOMBuilder.newInstance()
//x     def builder = JsonBuilder.newInstance()
//x     def builder = NodeBuilder.newInstance()
//x     def root = builder.root() { 

    
