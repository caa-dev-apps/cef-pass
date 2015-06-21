package cefpass

import java.io.File

///////////////////////////////////////////////////////////////////////////////
//

public class Utils
{
    static def fileExists(i_path)          { File f = new File(i_path); (f != null && f.isFile()) }
    static def directoryExists(i_path)     { File f = new File(i_path); (f != null && f.isDirectory()) }

    static def fileExistsS(i_path)         { fileExists(i_path)         ? "OK" : "NOT FOUND" }
    static def directoryExistsS(i_path)    { directoryExists(i_path)    ? "OK" : "NOT FOUND" }
    
    static def isQuotedString(i_s)         { (i_s != null) && (i_s.size() >= 2) && (i_s[0] =='\"') && (i_s[i_s.size()-1]=='\"') }
    static def getUnQuotedString(i_s)      { 
        def r = null
//x         if(i_s != null)
        if((i_s != null) && isQuotedString(i_s))
        {   
            def l = i_s.size()
            if(l >= 2) r = i_s.substring(1, l-1)
        }
        else {
            r = i_s
        }
            
        r
    }

    // only the filename - not full path
    static def getFilename(i_path)         { File f = new File(i_path); ((f != null) ? f.getName() : null) }

    // just filename + no gz
    static def getCefFilename(i_filepath) { 
        def f = Utils.getFilename(i_filepath); 
        if(f != null) {
            def ix = f.lastIndexOf(".gz")
            f = (ix >= 0) ? f.substring(0, ix) : f
        }
        f
    }

    // filename less the ext    C3_CP_EDI_EGD__20111009_V01
    static def getCefLogicalFileId(i_filename) { 
        def ix = i_filename.indexOf('.')
        (ix >= 0) ? i_filename.substring(0,ix) : null
    }

    // just the number
    static def getCefFileVersion(i_filename) {
        def v = null
        def logical_str = Utils.getCefLogicalFileId(i_filename)
        if(logical_str != null) {
            def ix = logical_str.toUpperCase().lastIndexOf('_V')
            if(ix >= 0) v = logical_str.substring(ix+2)
        }
        
        v
    }
    
}
