package cefpass

import javax.xml.xpath.*
import javax.xml.parsers.DocumentBuilderFactory

//x import groovy.xml.MarkupBuilder
import groovy.xml.DOMBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.*
//x import groovy.json.JsonBuilder

///////////////////////////////////////////////////////////////////////////////
//
 
public class CefHeaderXmlProcessor
{
    def m_xpath = null
    def m_document = null
    
    public CefHeaderXmlProcessor(i_xml)
    {
        def builder         = DocumentBuilderFactory.newInstance().newDocumentBuilder()
        def inputStream     = new ByteArrayInputStream( i_xml.bytes )
        
        m_document          = builder.parse(inputStream).documentElement
        m_xpath             = XPathFactory.newInstance().newXPath()
    }

    def query_nodeset(String i_xpathQuery)
    {
        def ls = []
        
        m_xpath.evaluate(i_xpathQuery, m_document, XPathConstants.NODESET).each{
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
            //x println txt
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
        getElementText('/root/meta[@name="' + i_name +  '"]/ENTRY[1]')
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
        
        m_xpath.evaluate(l_xpathQuery, m_document, XPathConstants.NODESET ).each{
            def ix = 0
            def l_name = it.getTextContent()
            
            m_xpath.evaluate('/root/meta[@name="' + l_name + '"]/ENTRY', m_document, XPathConstants.NODESET).each {
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
}


