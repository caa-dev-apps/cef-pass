/*
 * This Spock specification was auto generated by running 'gradle init --type groovy-library'
 * by 'sp' at '19/07/14 22:43' with Gradle 1.12
 *
 * @author sp, @date 19/07/14 22:43
 */

import spock.lang.Specification
import cefpass.CefHeaderXPath

class U_CefHeaderXPath_Tests extends Specification{

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
    
    def "01 CefHeaderXPath_Tests: getFilename"() {

        setup:
            def T_XmlProc = new CefHeaderXPath(TEST_XML_DOCUMENT)
        when:
            def l_result = T_XmlProc.getFilename()
        then:
            l_result != null
    }
    
    def "02 CefHeaderXPath_Tests: getFileFormatVersion"() {

        setup:
            def T_XmlProc = new CefHeaderXPath(TEST_XML_DOCUMENT)
        when:
            def l_result = T_XmlProc.getFileFormatVersion()
        then:
            l_result != null
    }
    
    def "03 CefHeaderXPath_Tests: getEndOfRecordMarker"() {

        setup:
            def T_XmlProc = new CefHeaderXPath(TEST_XML_DOCUMENT)
        when:
            def l_result = T_XmlProc.getEndOfRecordMarker()
        then:
            l_result == null
    }
    
    def "04 CefHeaderXPath_Tests: getDataUntil"() {

        setup:
            def T_XmlProc = new CefHeaderXPath(TEST_XML_DOCUMENT)
        when:
            def l_result = T_XmlProc.getDataUntil()
        then:
            l_result != null
    }
    
    def "05 CefHeaderXPath_Tests: getLogicalFileId"() {

        setup:
            def T_XmlProc = new CefHeaderXPath(TEST_XML_DOCUMENT)
        when:
            def l_result = T_XmlProc.getLogicalFileId()
        then:
            l_result != null
    }
    
    def "06 CefHeaderXPath_Tests: getVersionNumber"() {

        setup:
            def T_XmlProc = new CefHeaderXPath(TEST_XML_DOCUMENT)
        when:
            def l_result = T_XmlProc.getVersionNumber()
        then:
            l_result != null
    }
    
    def "07 CefHeaderXPath_Tests: getFileType"() {

        setup:
            def T_XmlProc = new CefHeaderXPath(TEST_XML_DOCUMENT)
        when:
            def l_result = T_XmlProc.getFileType()
        then:
            l_result != null
    }
    
    def "08 CefHeaderXPath_Tests: getDatasetVersionNumber"() {

        setup:
            def T_XmlProc = new CefHeaderXPath(TEST_XML_DOCUMENT)
        when:
            def l_result = T_XmlProc.getDatasetVersionNumber()
        then:
            l_result != null
    }
    
    def "09 CefHeaderXPath_Tests: getVersionNumber"() {

        setup:
            def T_XmlProc = new CefHeaderXPath(TEST_XML_DOCUMENT)
        when:
            def l_result = T_XmlProc.getVersionNumber()
        then:
            l_result != null
    }
    
    def "10 CefHeaderXPath_Tests: getMeta"() {

        setup:
            def T_XmlProc = new CefHeaderXPath(TEST_XML_DOCUMENT)
        when:
            def l_result = T_XmlProc.getMeta("DATASET_CAVEATS")
        then:
            l_result != null
    }
    
    def "11 CefHeaderXPath_Tests: getMetaList"() {

        setup:
            def T_XmlProc = new CefHeaderXPath(TEST_XML_DOCUMENT)
        when:
            def l_result = T_XmlProc.getMetaList()
        then:
            l_result != null
    }
    
    def "12 CefHeaderXPath_Tests: getMetaEntry"() {

        setup:
            def T_XmlProc = new CefHeaderXPath(TEST_XML_DOCUMENT)
        when:
            def l_result = T_XmlProc.getMetaEntry("LOGICAL_FILE_ID")
        then:
            l_result != null
    }
    
    def "13 CefHeaderXPath_Tests: getMetaEntryPair"() {

        setup:
            def T_XmlProc = new CefHeaderXPath(TEST_XML_DOCUMENT)
        when:
            def l_result = T_XmlProc.getMetaEntryPair("FILE_TIME_SPAN")
        then:
            l_result != null
    }
    
    def "14 CefHeaderXPath_Tests: getMetaPairNames"() {

        setup:
            def T_XmlProc = new CefHeaderXPath(TEST_XML_DOCUMENT)
        when:
            def l_result = T_XmlProc.getMetaPairNames()
        then:
            l_result != null && l_result.size() > 0
    }
}
