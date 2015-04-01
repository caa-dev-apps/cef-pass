//x #!/usr/bin/groovy
//x 
import javax.xml.xpath.*
import javax.xml.parsers.DocumentBuilderFactory

import groovy.xml.MarkupBuilder
import groovy.xml.DOMBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.*
import groovy.json.JsonBuilder

def TEST_XML_DOCUMENT = '''<?xml version="1.0" encoding="UTF-8"?>
            <root>
              <FILE_NAME>"C3_CP_EDI_EGD__20111009_V01.cef"</FILE_NAME>
              <FILE_FORMAT_VERSION>"CEF-2.0"</FILE_FORMAT_VERSION>
              <meta name="LOGICAL_FILE_ID">
                <ENTRY>"C3_CP_EDI_EGD__20111009_V01"</ENTRY>
              </meta>
              <meta name="VERSION_NUMBER">
                <ENTRY>"01"</ENTRY>
              </meta>
              <meta name="FILE_TIME_SPAN">
                <VALUE_TYPE>ISO_TIME_RANGE</VALUE_TYPE>
                <ENTRY>2011-10-09T00:00:00Z/2011-10-10T00:00:00Z</ENTRY>
              </meta>
              <meta name="GENERATION_DATE">
                <VALUE_TYPE>ISO_TIME</VALUE_TYPE>
                <ENTRY>2012-04-11T15:57:15Z</ENTRY>
              </meta>
              <meta name="FILE_CAVEATS">
                <ENTRY>"CAA_EDITOF_V1_04  2011-04-04T10:30:00Z"</ENTRY>
              </meta>
              <include>"C3_CH_EDI_EGD_DATASET.ceh"</include>
              <include>"C3_CH_EDI3_INST.ceh"</include>
              <include>"CL_CH_EDI_EXP.ceh"</include>
              <include>"CL_CH_MISSION.ceh"</include>
              <meta name="MISSION">
                <ENTRY>"Cluster"</ENTRY>
              </meta>
              <meta name="MISSION_TIME_SPAN">
                <VALUE_TYPE>ISO_TIME_RANGE</VALUE_TYPE>
                <ENTRY>2000-08-16T12:39:00Z/2009-12-31T23:59:59Z</ENTRY>
              </meta>
              <meta name="MISSION_AGENCY">
                <ENTRY>"ESA"</ENTRY>
              </meta>
              <meta name="MISSION_DESCRIPTION">
                <ENTRY>"The aim of the Cluster mission is to study small-scale structures of the magnetosphere "</ENTRY>
                <ENTRY>"and its environment in three dimensions. To achieve this, Cluster is constituted of four "</ENTRY>
                <ENTRY>"identical spacecraft that will flight in a tetrahedral configuration. The separation distances "</ENTRY>
                <ENTRY>"between the spacecraft will be varied between ~40 km and 10 000 km, according to the "</ENTRY>
                <ENTRY>"key scientific regions."</ENTRY>
              </meta>
              <meta name="MISSION_KEY_PERSONNEL">
                <ENTRY>"Philippe Escoubet&gt;Philippe.Escoubet@esa.int &gt;Cluster Project Scientist"</ENTRY>
              </meta>
              <meta name="MISSION_REFERENCES">
                <ENTRY>"The Cluster and Phoenix Missions&gt;Cluster project and instrument teams&gt;Space Sci. Rev. 79, Nos. 1-2, 1997"</ENTRY>
              </meta>
              <meta name="MISSION_REGION">
                <ENTRY>"Solar_Wind"</ENTRY>
                <ENTRY>"Bow_Shock"</ENTRY>
                <ENTRY>"Magnetosheath"</ENTRY>
                <ENTRY>"Magnetopause"</ENTRY>
                <ENTRY>"Magnetosphere"</ENTRY>
                <ENTRY>"Magnetotail"</ENTRY>
                <ENTRY>"Polar_Cap"</ENTRY>
                <ENTRY>"Auroral_Region"</ENTRY>
                <ENTRY>"Cusp"</ENTRY>
                <ENTRY>"Radiation_Belt"</ENTRY>
                <ENTRY>"Plasmasphere"</ENTRY>
              </meta>
              <meta name="MISSION_CAVEATS">
                <ENTRY>"*CL"</ENTRY>
              </meta>
              <meta name="EXPERIMENT">
                <ENTRY>"EDI"</ENTRY>
              </meta>
              <meta name="EXPERIMENT_DESCRIPTION">
                <ENTRY>"Electron Drift Instrument"</ENTRY>
                <ENTRY>"Electric field measured by the drift velocity "</ENTRY>
                <ENTRY>"of monoenergetic artificial electron beams "</ENTRY>
                <ENTRY>"injected perpendicularly to the ambient magnetic field"</ENTRY>
              </meta>
              <meta name="INVESTIGATOR_COORDINATES">
                <ENTRY>"Goetz Paschmann&gt;PI&gt;goetz.paschmann@mpe.mpg.de"</ENTRY>
                <ENTRY>"Roy Torbert&gt;PI&gt;roy.torbert@unh.edu"</ENTRY>
                <ENTRY>"Jack Quinn&gt;CoPI&gt;jmquinn@bu.edu"</ENTRY>
              </meta>
              <meta name="EXPERIMENT_REFERENCES">
                <ENTRY>"*CL_CD_EDI_CAAICD"</ENTRY>
                <ENTRY>"*CL_CD_EDI_USERMAN"</ENTRY>
                <ENTRY>"AnnGeo_FirstResults.pdf"</ENTRY>
                <ENTRY>"AnnGeo_JQuinn1669.pdf"</ENTRY>
                <ENTRY>"http://www.mpe.mpg.de/CLUSTER/EDI-Pages/edi_page.html"</ENTRY>
              </meta>
              <meta name="EXPERIMENT_KEY_PERSONNEL">
                <ENTRY>"Edita Georgescu&gt;Archive Scientist&gt;eg@mps.mpg.de"</ENTRY>
                <ENTRY>"Hans Vaith&gt;Experiment Engineer&gt;hans.vaith@unh.edu"</ENTRY>
                <ENTRY>"Mark Chutter&gt;Software Engineer&gt;mark.chutter@unh.edu"</ENTRY>
                <ENTRY>"Pamela Puhl-Quinn&gt;Software Engineer&gt;pamela.puhlquinn@aer.com"</ENTRY>
              </meta>
              <meta name="EXPERIMENT_CAVEATS">
                <ENTRY>"EDI experiment is operated in 2 modes 'Electric Field'"</ENTRY>
                <ENTRY>"and 'Ambient Electron' mode, see CaveatList files for"</ENTRY>
                <ENTRY>"specific time intervals"</ENTRY>
                <ENTRY>""</ENTRY>
                <ENTRY>"Large data gaps may occur due to: "</ENTRY>
                <ENTRY>"- highly variable magnetic and/or electric fields"</ENTRY>
                <ENTRY>"- high ambient electron fluxes"</ENTRY>
                <ENTRY>"- radiation induced hardware failures"</ENTRY>
                <ENTRY>""</ENTRY>
                <ENTRY>"Smaller data gaps occur in MCP calibration mode or "</ENTRY>
                <ENTRY>"at regularly scheduled BM3 dumps"</ENTRY>
                <ENTRY>""</ENTRY>
                <ENTRY>"Data availability in 'Electric field' mode is documented"</ENTRY>
                <ENTRY>"in the QSTAT files with 10 min resolution"</ENTRY>
                <ENTRY>""</ENTRY>
              </meta>
              <include>"C3_CH_OBS.ceh"</include>
              <meta name="OBSERVATORY">
                <ENTRY>"Cluster-3"</ENTRY>
              </meta>
              <meta name="OBSERVATORY_CAVEATS">
                <ENTRY>"*C3_CQ"</ENTRY>
              </meta>
              <meta name="OBSERVATORY_DESCRIPTION">
                <ENTRY>"Cluster-3 (Samba)"</ENTRY>
                <ENTRY>"Launched: 16 Jul 2000"</ENTRY>
                <ENTRY>"ESA Number: 3"</ENTRY>
                <ENTRY>"COSPAR ID: 2000-041A"</ENTRY>
                <ENTRY>"USSPACECOM catalogue number: 26410"</ENTRY>
                <ENTRY>"CSDS Code: C3"</ENTRY>
                <ENTRY>"ESOC FD code: S3"</ENTRY>
                <ENTRY>"ESA Flight Model Number: FM7"</ENTRY>
              </meta>
              <meta name="OBSERVATORY_TIME_SPAN">
                <VALUE_TYPE>ISO_TIME_RANGE</VALUE_TYPE>
                <ENTRY>2000-07-16T12:39:00Z/2009-12-31T23:59:59Z</ENTRY>
              </meta>
              <meta name="OBSERVATORY_REGION">
                <ENTRY>"Solar_Wind"</ENTRY>
                <ENTRY>"Bow_Shock"</ENTRY>
                <ENTRY>"Magnetosheath"</ENTRY>
                <ENTRY>"Magnetopause"</ENTRY>
                <ENTRY>"Magnetosphere"</ENTRY>
                <ENTRY>"Magnetotail"</ENTRY>
                <ENTRY>"Polar_Cap"</ENTRY>
                <ENTRY>"Auroral_Region"</ENTRY>
                <ENTRY>"Cusp"</ENTRY>
                <ENTRY>"Radiation_Belt"</ENTRY>
                <ENTRY>"Plasmasphere"</ENTRY>
              </meta>
              <meta name="INSTRUMENT_NAME">
                <ENTRY>"EDI3"</ENTRY>
              </meta>
              <meta name="INSTRUMENT_DESCRIPTION">
                <ENTRY>"EDI Experiment on Cluster C3"</ENTRY>
              </meta>
              <meta name="INSTRUMENT_TYPE">
                <ENTRY>"Electron_Drift"</ENTRY>
              </meta>
              <meta name="MEASUREMENT_TYPE">
                <ENTRY>"Electric_Field"</ENTRY>
              </meta>
              <meta name="INSTRUMENT_CAVEATS">
                <ENTRY>" "</ENTRY>
              </meta>
              <meta name="DATASET_ID">
                <ENTRY>"C3_CP_EDI_EGD"</ENTRY>
              </meta>
              <meta name="DATA_TYPE">
                <ENTRY>"CP&gt;CAA Parameter"</ENTRY>
              </meta>
              <meta name="DATASET_TITLE">
                <ENTRY>"Electron Gyrotime Data"</ENTRY>
              </meta>
              <meta name="DATASET_DESCRIPTION">
                <ENTRY>"This dataset contains measurements of the gyro-time of emitted "</ENTRY>
                <ENTRY>"electrons from the EDI experiment on the Cluster C3 spacecraft"</ENTRY>
                <ENTRY>"The kinetic energy of the emitted electrons is: 1. or 0.5 keV (kine_flag=0,1) "</ENTRY>
              </meta>
              <meta name="CONTACT_COORDINATES">
                <ENTRY>"EditaGeorgescu&gt;Archive Scientist&gt;eg@mps.mpg.de"</ENTRY>
              </meta>
              <meta name="PROCESSING_LEVEL">
                <ENTRY>"Auxiliary"</ENTRY>
              </meta>
              <meta name="TIME_RESOLUTION">
                <ENTRY>0.015625</ENTRY>
              </meta>
              <meta name="MAX_TIME_RESOLUTION">
                <ENTRY>0.015625</ENTRY>
              </meta>
              <meta name="MIN_TIME_RESOLUTION">
                <ENTRY>1.e31</ENTRY>
              </meta>
              <meta name="DATASET_CAVEATS">
                <ENTRY>"No regularly spaced time series!"</ENTRY>
                <ENTRY>"MAX_TIME_RESOLUTION is given for burst mode"</ENTRY>
                <ENTRY>"MIN_TIME_RESOLUTION is set to fill_value"</ENTRY>
                <ENTRY>"Time_tags are the registered UT at electron detection"</ENTRY>
                <ENTRY>"To convert gyrotime microseconds to B in nT use for"</ENTRY>
                <ENTRY>"kine_flag=0: 35793.785"</ENTRY>
                <ENTRY>"kine_flag=1: 35758.831"</ENTRY>
                <ENTRY>""</ENTRY>
              </meta>
              <meta name="ACKNOWLEDGEMENT">
                <ENTRY>"Please acknowledge the EDI team and ESA Cluster Active Archive"</ENTRY>
                <ENTRY>" when using this data"</ENTRY>
              </meta>
              <meta name="METADATA_TYPE">
                <ENTRY>"CAA"</ENTRY>
              </meta>
              <meta name="METADATA_VERSION">
                <ENTRY>"2.0"</ENTRY>
              </meta>
              <meta name="FILE_TYPE">
                <ENTRY>"cef"</ENTRY>
              </meta>
              <meta name="DATASET_VERSION">
                <ENTRY>"2.0"</ENTRY>
              </meta>
              <var name="time_tags__C3_CP_EDI_EGD">
                <PARAMETER_TYPE>"Support_Data"</PARAMETER_TYPE>
                <CATDESC>"Time Tag"</CATDESC>
                <UNITS>"s"</UNITS>
                <SI_CONVERSION>"1.0&gt;s"</SI_CONVERSION>
                <FIELDNAM>"Universal Time"</FIELDNAM>
                <FILLVAL>9999-12-31T23:59:59.999999Z</FILLVAL>
                <SIGNIFICANT_DIGITS>27</SIGNIFICANT_DIGITS>
                <LABLAXIS>"UT"</LABLAXIS>
                <VALUE_TYPE>ISO_TIME</VALUE_TYPE>
                <DELTA_PLUS>0.244e-6</DELTA_PLUS>
                <DELTA_MINUS>0.244e-6</DELTA_MINUS>
              </var>
              <var name="tof__C3_CP_EDI_EGD">
                <PARAMETER_TYPE>"Data"</PARAMETER_TYPE>
                <ENTITY>"Electron"</ENTITY>
                <PROPERTY>"Time-of-Flight"</PROPERTY>
                <CATDESC>"electron gyration time"</CATDESC>
                <VALUE_TYPE>FLOAT</VALUE_TYPE>
                <FIELDNAM>"Time-of-Flight"</FIELDNAM>
                <FILLVAL>0.000</FILLVAL>
                <SIGNIFICANT_DIGITS>10</SIGNIFICANT_DIGITS>
                <QUALITY>"2"</QUALITY>
                <LABLAXIS>"tof"</LABLAXIS>
                <SI_CONVERSION>"1.0e-6&gt;s"</SI_CONVERSION>
                <UNITS>"microseconds"</UNITS>
                <DEPEND_0>time_tags__C3_CP_EDI_EGD</DEPEND_0>
              </var>
              <var name="sigma_tof__C3_CP_EDI_EGD">
                <PARAMETER_TYPE>"Data"</PARAMETER_TYPE>
                <ENTITY>"Electron"</ENTITY>
                <PROPERTY>"Time-of-Flight"</PROPERTY>
                <CATDESC>"electron gyration time standard deviation"</CATDESC>
                <VALUE_TYPE>FLOAT</VALUE_TYPE>
                <FIELDNAM>"Time-of-Flight standard deviation"</FIELDNAM>
                <FILLVAL>0.000</FILLVAL>
                <SIGNIFICANT_DIGITS>10</SIGNIFICANT_DIGITS>
                <QUALITY>"2"</QUALITY>
                <LABLAXIS>"sigma_tof"</LABLAXIS>
                <SI_CONVERSION>"1.0e-6&gt;s"</SI_CONVERSION>
                <UNITS>"microseconds"</UNITS>
                <DEPEND_0>time_tags__C3_CP_EDI_EGD</DEPEND_0>
              </var>
              <var name="gdu_flag__C3_CP_EDI_EGD">
                <PARAMETER_TYPE>"Support_Data"</PARAMETER_TYPE>
                <ENTITY>"Electron"</ENTITY>
                <PROPERTY>"Time-of-Flight"</PROPERTY>
                <CATDESC>"Detector Unit"</CATDESC>
                <VALUE_TYPE>INT</VALUE_TYPE>
                <FIELDNAM>"Detector Unit"</FIELDNAM>
                <FILLVAL>0</FILLVAL>
                <SIGNIFICANT_DIGITS>1</SIGNIFICANT_DIGITS>
                <LABLAXIS>"DU"</LABLAXIS>
                <UNITS>"Unitless"</UNITS>
                <DEPEND_0>time_tags__C3_CP_EDI_EGD</DEPEND_0>
              </var>
              <var name="kine_flag__C3_CP_EDI_EGD">
                <PARAMETER_TYPE>"Support_Data"</PARAMETER_TYPE>
                <ENTITY>"Electron"</ENTITY>
                <PROPERTY>"Time-of-Flight"</PROPERTY>
                <CATDESC>"electron gyration time"</CATDESC>
                <VALUE_TYPE>INT</VALUE_TYPE>
                <FIELDNAM>"Kinetic Energy Flag"</FIELDNAM>
                <FILLVAL>9</FILLVAL>
                <SIGNIFICANT_DIGITS>1</SIGNIFICANT_DIGITS>
                <LABLAXIS>"KinEnFlag"</LABLAXIS>
                <UNITS>"Unitless"</UNITS>
                <DEPEND_0>time_tags__C3_CP_EDI_EGD</DEPEND_0>
              </var>
              <DATA_UNTIL>EOF</DATA_UNTIL>
            </root>
'''

///////////////////////////////////////////////////////////////////////////////
//

//                          '//*[starts-with(name(), "var")]' )
//                          '//var' )

//                          '/root/FILE_NAME' )
//                          '/root/FILE_NAME/text()' )
//                          '//var/FIELDNAM/text()' )
//                          '//var@name' )
//                          '//var/FIELDNAM/node()' )

//                          '//var/DEPEND_0/node()' )
//                          '//var[@name="kine_flag__C3_CP_EDI_EGD"]')

//                          '//var[@name="kine_flag__C3_CP_EDI_EGD"]/LABLAXIS/text()')
//                          '//var[@name="kine_flag__C3_CP_EDI_EGD"]/UNITS/text()')

//                          '/root/FILE_NAME/text()' )
//                          '/root/FILE_NAME' )

//                          '/root/FILE_NAME/text()' )
//                          '/root/FILE_NAME' )

//                          '/root/meta/ENTRY/text()' )
//                          '/root/meta/ENTRY/text()' )

//                          '//meta[@name="ACKNOWLEDGEMENT"]/ENTRY/text()')

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
    {
        [
            "ENTRY":      getElementText('/root/meta[@name="' + i_name +  '"]/ENTRY[1]'),
            "VALUE_TYPE": getElementText('/root/meta[@name="' + i_name +  '"]/VALUE_TYPE[1]')
        ]
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


def CefHeaderXmlProcessor_TESTS(i_T_XML)
{

    def getElementText_DUMP =         {   i_xpathQuery -> 
//x         println "getElementText_DUMP "
//x         println "xpathQuery:         " + i_xpathQuery
//x         println "result:             " + i_T_XML.getElementText(i_xpathQuery)
//x         println ""
    }

    def getFilename_DUMP =            {             println "";       println "getFilename_DUMP";            println(i_T_XML.getFilename())                }
    def getFileFormatVersion_DUMP =   {             println "";       println "getFileFormatVersion_DUMP";   println(i_T_XML.getFileFormatVersion())       }
    def getEndOfRecordMarker_DUMP =   {             println "";       println "getEndOfRecordMarker_DUMP";   println(i_T_XML.getEndOfRecordMarker())       }
    def getDataUntil_DUMP =           {             println "";       println "getDataUntil_DUMP";           println(i_T_XML.getDataUntil())               }

    def getLogicalFileId_DUMP =       {             println "";       println "getLogicalFileId_DUMP";       println(i_T_XML.getLogicalFileId())           }
    def getVersionNumber_DUMP =       {             println "";       println "getVersionNumber_DUMP";       println(i_T_XML.getVersionNumber())           }
    def getFileType_DUMP =            {             println "";       println "getFileType_DUMP";            println(i_T_XML.getFileType())                }
    def getDataSetId_DUMP =           {             println "";       println "getDataSetId_DUMP";           println(i_T_XML.getDataSetId())               }

    def getMeta_DUMP =                {   i_name -> println "";       println("getMeta_DUMP");               println(i_T_XML.getMeta(i_name))              }
    def getMetaList_DUMP =            {             println "";       println("getMetaList_DUMP");           println(i_T_XML.getMetaList())                }
    def getMetaEntry_DUMP =           {   i_name -> println "";       println("getMetaEntry_DUMP");          println(i_T_XML.getMetaEntry(i_name))         }
    def getMetaEntryPair_DUMP =       {   i_name -> println "";       println("getMetaEntryPair_DUMP");      println(i_T_XML.getMetaEntryPair(i_name))     }
    def getMetaPairNames_DUMP =       {             println "";       println("getMetaPairNames_DUMP");      println(i_T_XML.getMetaPairNames())           }
    
    
    getElementText_DUMP("/root/FILE_NAME")
    getElementText_DUMP("/root/FILE_FORMAT_VERSION")
    getElementText_DUMP("/root/END_OF_RECORD_MARKER")
    getElementText_DUMP("/root/DATA_UNTIL")

    getFilename_DUMP()
    getFileFormatVersion_DUMP()
    getEndOfRecordMarker_DUMP()
    getDataUntil_DUMP()

        
    getLogicalFileId_DUMP()            

    getVersionNumber_DUMP()            
    getFileType_DUMP()                 
    getDataSetId_DUMP()                


    getMeta_DUMP("DATASET_CAVEATS")
    getMetaList_DUMP()
    getMetaEntry_DUMP("LOGICAL_FILE_ID")
    getMetaEntry_DUMP("VERSION_NUMBER")

    //x T_XML.getMetaEntryPair_DUMP(i_name)
    getMetaEntryPair_DUMP("FILE_TIME_SPAN")
    getMetaEntryPair_DUMP("GENERATION_DATE")
    getMetaEntryPair_DUMP("MISSION_TIME_SPAN")
    getMetaEntryPair_DUMP("OBSERVATORY_TIME_SPAN")

    println "==============================="
    i_T_XML.getMetaPairNames().each { println it}

}


def T_XML = new CefHeaderXmlProcessor(TEST_XML_DOCUMENT)

CefHeaderXmlProcessor_TESTS(T_XML)










              
              
