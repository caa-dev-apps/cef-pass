package cefpass

import javax.xml.xpath.*
import javax.xml.parsers.DocumentBuilderFactory

import groovy.xml.MarkupBuilder
import groovy.xml.DOMBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.*
//x import groovy.json.JsonBuilder
import groovy.xml.XmlUtil

//x class CefHeaderNodesX {
//x 
//x     def builder = new NodeBuilder()
//x     def root = builder.root()
//x     def cur = root


//x D <- createDocument
//x Cur <- D.getDocumentElement()
//x E1 <- createElement(Tag)
//x T1 <- createTextNode(Text)
//x E1.appendChild(T1)
//x Cur.appendChild(E1)
//x 
//x D
//x     <E1>T1</E1>
//x 

    
//x class CefHeaderNodesX extends NodeBuilder{
class CefHeaderNodesX extends NodeBuilder{

//x     def builder = new NodeBuilder()
    def root = this.root()
    def cur = root
    
    
    def error(i_message) { println i_message; System.exit(-1) }

    def append(nodes) { cur = root; root.append(nodes) }

    def appendDocument(i_document) { 
        i_document.root.children().each { append(it); }
    }    
    
    def addAttr(k,v,q) { cur.append(this.createNode(k, v )) }  // quotes
    def addAttr(k,v) { cur.append(this.createNode(k, v )) }  // quotes
    
    def addComment(c) { Show.showHeaderComment(c); cur.append(this.c(c)) }
    
    def stxMeta(n) {  cur = this.meta(name: n); root.append(cur) }
    def etxMeta(n) {  cur = root }
    
    def stxVar(n) { cur = this.var(name: n); root.append(cur) }
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
    
    
    def test_info() {
        println "root type -> " + root.getClass().getName()
    }
}


//x                 TARGET:     DOCUMENT ELEMENT
//x 
//x 
//x                 m_document          = builder.parse(inputStream).documentElement
//x                 m_xpath             = XPathFactory.newInstance().newXPath()
//x                 }
//x 
//x                 def query_nodeset(String i_xpathQuery)
//x                 {
//x                 def ls = []
//x 
//x                 m_xpath.evaluate(i_xpathQuery, m_document, XPathConstants.NODESET).each{




def H = new CefHeaderNodesX()

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

H.test_info()









































