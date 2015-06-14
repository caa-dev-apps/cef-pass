package cefpass

import javax.xml.xpath.*
import javax.xml.parsers.DocumentBuilderFactory

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import groovy.xml.DOMBuilder

///////////////////////////////////////////////////////////////////////////////
//
 
//x public class CefHeaderXPath
//x {
//x     def m_xpath = null
//x     def m_documentElement = null
//x     
//x     public CefHeaderXPath(String i_xml)
//x     {
//x         def builder         = DocumentBuilderFactory.newInstance().newDocumentBuilder()
//x         def inputStream     = new ByteArrayInputStream( i_xml.bytes )
//x         m_documentElement   = builder.parse(inputStream).documentElement
//x         
//x         m_xpath             = XPathFactory.newInstance().newXPath()
//x     }
//x 
//x     // USE ABOVE CONSTRUCTOR - THIS ONE IS NOT WORKING....it should though! TODO = REVIST!!!
//x     public CefHeaderXPath(Element i_documentElement)
//x     {
//x         m_documentElement   = i_documentElement
//x         m_xpath             = XPathFactory.newInstance().newXPath()
//x     }
//x 
//x     def query_nodeset(String i_xpathQuery)
//x     {
//x         def ls = []
//x         
//x         m_xpath.evaluate(i_xpathQuery, m_documentElement, XPathConstants.NODESET).each{
//x             ls << it
//x         }
//x         
//x         return ls
//x     }
//x 
//x     def getSingleNode(String i_xpathQuery)
//x     {
//x         def v = null
//x         def ls = query_nodeset(i_xpathQuery)
//x         
//x         if(ls != null && ls.size() == 1)
//x         {
//x             v = ls[0]
//x         }
//x         
//x         return v
//x     }
//x 
//x     def getSingleNodeValue(String i_xpathQuery)
//x     {
//x         def v = null
//x         def n = getSingleNode(i_xpathQuery)
//x         
//x         if(n != null) {
//x             v = n.getNodeValue()
//x         }
//x         
//x         return v
//x     }
//x 
//x     def getElementText(String i_xpathQuery)
//x     {
//x         def txt = getSingleNodeValue(i_xpathQuery + "/text()")
//x         txt
//x     }
//x 
//x     ///////////////////////////////////////////////////////////////////////////////
//x     //
//x 
//x     def getMeta(i_name)
//x     {
//x         getSingleNode('/root/meta[@name="' + i_name +  '"]')
//x     }
//x 
//x     def getMetaList()
//x     {
//x         query_nodeset('/root/meta')
//x     }
//x     
//x     def getMetaEntry(i_name)
//x     {
//x         getElementText('/root/meta[@name="' + i_name +  '"]/ENTRY[1]')
//x     }
//x 
//x     def getMetaEntryPair(i_name)                                                                        
//x     {                                                                                                   //  e.g.
//x         [                                                                                               //  <meta name="FILE_TIME_SPAN">
//x             "ENTRY":      getElementText('/root/meta[@name="' + i_name +  '"]/ENTRY[1]'),               //    <VALUE_TYPE>ISO_TIME_RANGE</VALUE_TYPE>
//x             "VALUE_TYPE": getElementText('/root/meta[@name="' + i_name +  '"]/VALUE_TYPE[1]')           //    <ENTRY>2011-10-09T00:00:00Z/2011-10-10T00:00:00Z</ENTRY>
//x         ]                                                                                               //  </meta>
//x     }
//x 
//x     def getMetaPairNames()
//x     {
//x         //  get all meta elements with a VALUE_TYPE
//x         def rs = []
//x         String l_xpathQuery = "/root/meta/VALUE_TYPE/../@name"
//x         
//x         m_xpath.evaluate(l_xpathQuery, m_documentElement, XPathConstants.NODESET ).each{
//x             def ix = 0
//x             def l_name = it.getTextContent()
//x             
//x             m_xpath.evaluate('/root/meta[@name="' + l_name + '"]/ENTRY', m_documentElement, XPathConstants.NODESET).each {
//x                 ix++ 
//x             }
//x             
//x             if(ix == 1) { rs << l_name}
//x         }
//x         
//x         return rs
//x     }
//x     
//x     ///////////////////////////////////////////////////////////////////////////////
//x     //
//x 
//x     def getFilename()
//x     {
//x         getElementText("/root/FILE_NAME")
//x     }
//x 
//x     def getFileFormatVersion()
//x     {
//x         getElementText("/root/FILE_FORMAT_VERSION")
//x     }
//x 
//x     def getEndOfRecordMarker()
//x     {
//x         getElementText("/root/END_OF_RECORD_MARKER")
//x     }
//x 
//x     def getDataUntil()
//x     {
//x         getElementText("/root/DATA_UNTIL")
//x     }
//x     
//x     def getLogicalFileId()                                                      //              <meta name="LOGICAL_FILE_ID">
//x     {                                                                           //                <ENTRY>"C3_CP_EDI_EGD__20111009_V01"</ENTRY>
//x         getMetaEntry("LOGICAL_FILE_ID")                                         //              </meta>
//x     }
//x 
//x     def getVersionNumber()                                                      //              <meta name="VERSION_NUMBER">
//x     {                                                                           //                <ENTRY>"01"</ENTRY>
//x         getMetaEntry("VERSION_NUMBER")                                          //              </meta>
//x     }
//x 
//x     def getFileType()                                                           //              <meta name="FILE_TYPE">
//x     {                                                                           //                <ENTRY>"cef"</ENTRY>
//x         getMetaEntry("FILE_TYPE")                                               //              </meta>
//x     }
//x 
//x     def getDataSetId()                                                          //              <meta name="DATASET_VERSION">
//x     {                                                                           //                <ENTRY>"2.0"</ENTRY>
//x         getMetaEntry("DATASET_VERSION")                                         //              </meta>
//x     }
//x }


public class CefHeaderXPath
{
    def m_xpath = null
    def m_documentElement = null
    
    public CefHeaderXPath(String i_xml)
    {
        def builder         = DocumentBuilderFactory.newInstance().newDocumentBuilder()
        def inputStream     = new ByteArrayInputStream( i_xml.bytes )
        m_documentElement   = builder.parse(inputStream).documentElement
        
        m_xpath             = XPathFactory.newInstance().newXPath()
    }

    // USE ABOVE CONSTRUCTOR - THIS ONE IS NOT WORKING....it should though! TODO = REVIST!!!
    public CefHeaderXPath(Element i_documentElement)
    {
        m_documentElement   = i_documentElement
        m_xpath             = XPathFactory.newInstance().newXPath()
    }

    ///////////////////////////////////////////////////////////////////////////////
    //
    
    def eval_boolean(String i_xpathQuery)           {   m_xpath.evaluate(i_xpathQuery, m_documentElement, XPathConstants.BOOLEAN)   }
    def eval_dom_object_model(String i_xpathQuery)  {   m_xpath.evaluate(i_xpathQuery, m_documentElement, XPathConstants.DOM_OBJECT_MODEL)   }
    def eval_node(String i_xpathQuery)              {   m_xpath.evaluate(i_xpathQuery, m_documentElement, XPathConstants.NODE)   }
    def eval_nodeset(String i_xpathQuery)           {   m_xpath.evaluate(i_xpathQuery, m_documentElement, XPathConstants.NODESET)   }
    def eval_number(String i_xpathQuery)            {   m_xpath.evaluate(i_xpathQuery, m_documentElement, XPathConstants.NUMBER)   }
    def eval_string(String i_xpathQuery)            {   m_xpath.evaluate(i_xpathQuery, m_documentElement, XPathConstants.STRING)   }
    
//x     def query_nodeset(String i_xpathQuery)
//x     {
//x         def ls = []
//x         
//x         m_xpath.evaluate(i_xpathQuery, m_documentElement, XPathConstants.NODESET).each{
//x             ls << it
//x         }
//x         
//x         return ls
//x     }

    def query_nodeset(String i_xpathQuery)
    {
        def ls = []
        
        eval_nodeset(i_xpathQuery).each{
            ls << it
        }
        
        return ls
    }
    
    
    def getSingleNode(String i_xpathQuery)
    {
        def v = null
        def ls = query_nodeset(i_xpathQuery)
        
        if(ls != null && ls.size() == 1)
        {
            v = ls[0]
        }
        
        return v
    }

    def getSingleNodeValue(String i_xpathQuery)
    {
        def v = null
        def n = getSingleNode(i_xpathQuery)
        
        if(n != null) {
            v = n.getNodeValue()
        }
        
        return v
    }

    def getElementText(String i_xpathQuery)
    {
        def txt = getSingleNodeValue(i_xpathQuery + "/text()")
        txt
    }

    ///////////////////////////////////////////////////////////////////////////////
    //

    def getMeta(i_name)
    {
        getSingleNode('/root/meta[@name="' + i_name +  '"]')
    }

    def getMetaList()
    {
        query_nodeset('/root/meta')
    }
    
    def getMetaEntry(i_name)
    {
        eval_string('/root/meta[@name="' + i_name +  '"]/ENTRY[1]')
    }

    def getMetaEntryPair(i_name)                                                                        
    {                                                                                                   //  e.g.
        [                                                                                               //  <meta name="FILE_TIME_SPAN">
            "ENTRY":      getElementText('/root/meta[@name="' + i_name +  '"]/ENTRY[1]'),               //    <VALUE_TYPE>ISO_TIME_RANGE</VALUE_TYPE>
            "VALUE_TYPE": getElementText('/root/meta[@name="' + i_name +  '"]/VALUE_TYPE[1]')           //    <ENTRY>2011-10-09T00:00:00Z/2011-10-10T00:00:00Z</ENTRY>
        ]                                                                                               //  </meta>
    }

    def getMetaPairNames()
    {
        //  get all meta elements with a VALUE_TYPE
        def rs = []
        String l_xpathQuery = "/root/meta/VALUE_TYPE/../@name"
        
        m_xpath.evaluate(l_xpathQuery, m_documentElement, XPathConstants.NODESET).each{
            def ix = 0
            def l_name = it.getTextContent()
            
            m_xpath.evaluate('/root/meta[@name="' + l_name + '"]/ENTRY', m_documentElement, XPathConstants.NODESET).each {
                ix++ 
            }
            
            if(ix == 1) { rs << l_name}
        }
        
        return rs
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    //

    def getFilename()
    {
        getElementText("/root/FILE_NAME")
    }

    def getFileFormatVersion()
    {
        getElementText("/root/FILE_FORMAT_VERSION")
    }

    def getEndOfRecordMarker()
    {
        getElementText("/root/END_OF_RECORD_MARKER")
    }

    def getDataUntil()
    {
        getElementText("/root/DATA_UNTIL")
    }
    
    def getLogicalFileId()                                                      //              <meta name="LOGICAL_FILE_ID">
    {                                                                           //                <ENTRY>"C3_CP_EDI_EGD__20111009_V01"</ENTRY>
        getMetaEntry("LOGICAL_FILE_ID")                                         //              </meta>
    }

    def getVersionNumber()                                                      //              <meta name="VERSION_NUMBER">
    {                                                                           //                <ENTRY>"01"</ENTRY>
        getMetaEntry("VERSION_NUMBER")                                          //              </meta>
    }

    def getFileType()                                                           //              <meta name="FILE_TYPE">
    {                                                                           //                <ENTRY>"cef"</ENTRY>
        getMetaEntry("FILE_TYPE")                                               //              </meta>
    }

    def getDataSetId()                                                          //              <meta name="DATASET_VERSION">
    {                                                                           //                <ENTRY>"2.0"</ENTRY>
        getMetaEntry("DATASET_VERSION")                                         //              </meta>
    }

    ///////////////////////////////////////////////////////////////////////////////
    //

    def hasEmptyMetaObjects()
    {
        eval_boolean('/root/meta[count(*)=0]')                                 // t/f
    }
    
    def countEmptyMetaObjects()
    {
        eval_number('count(/root/meta[count(*)=0])')                           // n >= 0
    }
    
    
    
    
}



