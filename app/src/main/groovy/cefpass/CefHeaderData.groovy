package cefpass

import java.io.FileInputStream
import java.io.File
import java.util.zip.GZIPInputStream

import groovy.xml.MarkupBuilder
//x import groovy.xml.MarkupBuilder
 
//-----------------------------------------------------------------------------
//

//x class IllegalArgException  extends Exception{} 

//-----------------------------------------------------------------------------
//

class CefHeaderData {

    def builder = new NodeBuilder()
    def builderMU = new MarkupBuilder()
    def root = builder.root()
    def cur = root

//x def error(i_message) { throw new IllegalArgException(); /*System.exit(-1)*/ }
    def error(i_message) { println i_message; System.exit(-1) }

    def append(nodes) { cur = root; root.append(nodes) }
    
    def addAttr(k,v,q) { cur.append(builder.a((k): v, q: q)) }  // quotes
    def addComment(c) { Show.showHeaderComment(c); cur.append(builder.c(c)) }
    
    def stxMeta(n) {  cur = builder.meta(name: n); root.append(cur) }
    def etxMeta(n) {  cur = root }
    
    def stxVar(n) { cur = builder.var(name: n); root.append(cur) }
    def etxVar(n) { cur = root}

    def dump() {
        def writer2 = new StringWriter()
        root.print(new PrintWriter(writer2))
        println writer2.toString()
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


