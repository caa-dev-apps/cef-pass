package cefpass

import java.io.FileInputStream
import java.io.File
import java.util.zip.GZIPInputStream

import groovy.json.JsonBuilder

///////////////////////////////////////////////////////////////////////////////
//


class CefHeaderJSON {
 
    def root = [ type:'root', name:'root', elems:[] ];
    def cur = root;
   
    def error(i_message) { println i_message; System.exit(-1) }
 
    def append(nodes) { cur = root; root.elems << nodes }
    def appendDocument(i_document) { append(i_document.root); }   
 
    def addAttr(k,v,q) { cur.elems << [type:'a', k:k, v:v, q:q] }  // quotes
    def addComment(c) { cur.elems << [type:'c', k:'c', v:c]  }
   
    def stxMeta(n) {  cur = [type:'meta', name:n, elems:[]]; root.elems << cur }
    def etxMeta(n) {  cur = root }
 
    def stxVar(n) {  cur = [type:'var', name:n, elems:[]]; root.elems << cur }
    def etxVar(n) {  cur = root }
 
    def dump() {
        def builder = new JsonBuilder(root)
        println builder.toPrettyString()       
    }
    
    def showJSONodes() { Show.showJSONodes(root) }
    def show() { showJSONodes() }
}
 
class CefHeaderNodes {

    def builder = new NodeBuilder()
    def root = builder.root()
    def cur = root

    def error(i_message) { println i_message; System.exit(-1) }

    def append(nodes) { cur = root; root.append(nodes) }

    def appendDocument(i_document) { 
        i_document.root.children().each { append(it); }
    }    
    
    def addAttr(k,v,q) { cur.append(builder.a((k): v, q: q)) }  // quotes
    def addComment(c) { Show.showHeaderComment(c); cur.append(builder.c(c)) }
    
    def stxMeta(n) {  cur = builder.meta(name: n); root.append(cur) }
    def etxMeta(n) {  cur = root }
    
    def stxVar(n) { cur = builder.var(name: n); root.append(cur) }
    def etxVar(n) { cur = root}

    def showNodes() {   Show.showNodes(root) }
    def showXmlNodes() { Show.showXmlNodes(root)  }
    def show() { showNodes(); showXmlNodes() }
    
    def dump() {
        def writer2 = new StringWriter()
        root.print(new PrintWriter(writer2))
        println writer2.toString()
    }
}


class CefHeaderData {

    def headerNodes = new CefHeaderNodes()
    def headerJSON = new CefHeaderJSON()

    def error(i_message) { println i_message; System.exit(-1) }
    
    def append(nodes) { headerNodes.append(nodes);                                              headerJSON.append(nodes); }
    def appendDocument(i_headerData) { headerNodes.appendDocument(i_headerData.headerNodes);    headerJSON.appendDocument(i_headerData.headerJSON);}
    
    def addAttr(k,v,q) { headerNodes.addAttr(k,v,q);                                            headerJSON.addAttr(k,v,q);}  // quotes
    def addComment(c) { headerNodes.addComment(c);                                              headerJSON.addComment(c);}
    
    def stxMeta(n) {  headerNodes.stxMeta(n);                                                   headerJSON.stxMeta(n);}
    def etxMeta(n) {  headerNodes.etxMeta(n);                                                   headerJSON.etxMeta(n);}
    
    def stxVar(n) { headerNodes.stxVar(n);                                                      headerJSON.stxVar(n); }
    def etxVar(n) { headerNodes.etxVar(n);                                                      headerJSON.etxVar(n); }

    def dump() { headerNodes.dump();                                                            
                 headerJSON.dump();}
    
    def show() { headerNodes.show();                                                            headerJSON.show() }
    
    def showNodes() { headerNodes.showNodes() }
    def showXmlNodes() { headerNodes.showXmlNodes() }
    def showJSONNodes() { headerJSON.show() 
    }
    
    
    def removeQuotes(v) {
        def l = v.length()
        def q = (l > 2 && v[0] == '"' && v[l-1] == '"') 
        if (q==true) { v = v.substring(1,l-1) }
        
        [v, q]
    }
    
    def add_kv(k, i_v){
        def (v, q) = removeQuotes(i_v)
    
        Show.showHeaderKV(k,v)
        
    	if("START_META".compareToIgnoreCase(k) == 0)			stxMeta(v) 
    	else if ("END_META".compareToIgnoreCase(k) == 0)		etxMeta(v) 
    	else if ("START_VARIABLE".compareToIgnoreCase(k) == 0) 	stxVar(v) 
    	else if ("END_VARIABLE".compareToIgnoreCase(k) == 0)	etxVar(v) 
    	else 													addAttr(k,v,q) 
    }
}
