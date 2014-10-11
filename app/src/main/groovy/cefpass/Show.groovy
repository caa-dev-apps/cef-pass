package cefpass

import groovy.xml.XmlUtil
import groovy.json.JsonBuilder 

public class Show {

    public static boolean s_show_cef_filename = true;               // main cef file
    public static boolean s_show_search_folders = true;             // list of folders to search for ceh includes

//x public static boolean s_show_file_read_line_details = true      // file line as read + line number etc
    public static boolean s_show_file_read_line_details = false     // file line as read + line number etc
//x public static boolean s_show_header_kv = true                   // header key and value
    public static boolean s_show_header_kv = false                  // header key and value
//x public static boolean s_show_header_comment = true              // header comment
    public static boolean s_show_header_comment = false             // header comment
    
    public static boolean s_show_cx_files = true;                   // list the main cef and ceh filenames
    public static boolean s_show_nodes = true;                      // show nodebuilder -> nodes dump
    public static boolean s_show_xml_nodes = true;                  // show nodebuilder -> xml dump
    public static boolean s_show_json_nodes = true;                 // (from map/list input) show jsonbuilder -> xml dump
    public static boolean s_show_data_line = true;                  // show data as read
    

    
    ///////////////////////////////////////////////////////////////////////////////
    //

    public static void showCefFilename(i_path) {
        if(s_show_cef_filename == true) {
            println "\nCEF Filename:"    
            println "\t" + i_path
        }
    }
    
    public static void showSearchFolders(i_searchFolders) {
        if(s_show_search_folders == true) {
            println "\nSearch Folders:"    
            i_searchFolders.each { 
                println "\t" + it
            }
        }
    }

    public static void showContextFile(String i_text) 
    {
        if(s_show_cx_files == true) println i_text
    }
    
    public static void showNodes(i_root) 
    {
        if(s_show_nodes == true) {
            println "\nNodes:"
            
            def writer = new StringWriter()
            i_root.print(new PrintWriter(writer))
            println writer.toString()    
        }
    }
    
    public static void showXmlNodes(i_root) 
    {
        if(s_show_xml_nodes == true) {
            println "\nXML Nodes:"
        
            println new XmlUtil().serialize(i_root)    
        }
    }
    
    
    public static void showJSONodes(i_root) 
    {
        if(s_show_json_nodes == true) {
            println "\nJSON Nodes:"

            def builder = new JsonBuilder(i_root)
            println builder.toPrettyString() 
        }
    }
    

    public static void showDataLine(i_line) 
    {
        if(s_show_data_line == true) println "Data: " + i_line
    }
    
    public static void showContexts(i_cefContexts) {
        if(s_show_search_folders == true) {
            println "\nCef Contexts:"    
            i_cefContexts.each { 
                println "\t" + it.getString()
            }
        }
    }
 
    public static void showFileReadLineDetails(i_line_details) {
        if(s_show_file_read_line_details == true) println "H:\t" + i_line_details
    }
    
    public static void showHeaderKV(i_key, i_value) {
        if(s_show_header_kv == true) println "H:\t" + "k:" + i_key + "v:" + i_value
    }
    
    public static void showHeaderComment(i_comment) {
        if(s_show_header_comment == true) println "H:\t" + i_comment
    }
 }
