package cefpass

import javax.xml.xpath.*
import javax.xml.parsers.DocumentBuilderFactory

//x import groovy.xml.MarkupBuilder
import groovy.xml.DOMBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.*
//x import groovy.json.JsonBuilder
import groovy.xml.XmlUtil

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
    def addAttr(k,v) { cur.append(builder.createNode(k, v )) }  // quotes
    
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


    def dumpX() {
        println getXmlNodesAsString()
    }
    
    def dump() {
        //x def writer2 = new StringWriter()
        //x root.print(new PrintWriter(writer2))
        println getNodesAsString()
    }
}

//x    def add_kv(k, i_v){
//x        def (v, q) = removeQuotes(i_v)
//x 
//x         if(q == true) {
//x             v = '\"' + v +'\"'
//x         }
//x         
//x         Show.showHeaderKV(k,v)
//x         
//x     	if("START_META".compareToIgnoreCase(k) == 0)			stxMeta(v) 
//x     	else if ("END_META".compareToIgnoreCase(k) == 0)		etxMeta(v) 
//x     	else if ("START_VARIABLE".compareToIgnoreCase(k) == 0) 	stxVar(v) 
//x     	else if ("END_VARIABLE".compareToIgnoreCase(k) == 0)	etxVar(v) 
//x     	else 													addAttr(k,v,q) 
//x     }


def H = new CefHeaderNodes()

H.addAttr("K1", "V1")
H.addAttr("K2", "V2")
H.addAttr("K3", "V3")

H.stxMeta("M1")
H.addAttr("MK1", "V1")
H.addAttr("MK2", "V2")
H.addAttr("MK3", "V3")
H.etxMeta("M1")


H.stxMeta("V1")
H.addAttr("VK1", "V1")
H.addAttr("VK2", "V2")
H.addAttr("VK3", "V3")
H.etxMeta("V1")

H.dump()

H.dumpX()











































