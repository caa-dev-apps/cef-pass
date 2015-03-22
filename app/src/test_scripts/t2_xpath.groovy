//x #!/usr/bin/groovy
//x 
import javax.xml.xpath.*
import javax.xml.parsers.DocumentBuilderFactory

//x def testxml = '''
//x                 <Employee>
//x                   <ID>..</ID>
//x                   <E-mail>..</E-mail>
//x                   <custom_1>foo</custom_1>
//x                   <custom_2>bar</custom_2>
//x                   <custom_3>base</custom_3>
//x                 </Employee>
//x   '''
//x 
//x def processXml( String xml, String xpathQuery ) {
//x     def xpath = XPathFactory.newInstance().newXPath()
//x     def builder     = DocumentBuilderFactory.newInstance().newDocumentBuilder()
//x     def inputStream = new ByteArrayInputStream( xml.bytes )
//x     def records     = builder.parse(inputStream).documentElement
//x //x     xpath.evaluate( xpathQuery, records )
//x     xpath.evaluate( xpathQuery, records, XPathConstants.NODESET )
//x }
//x 
//x //x println processXml( testxml, '//*[starts-with(name(), "custom")]' )
//x 
//x def result = processXml( testxml, '//*[starts-with(name(), "custom")]' )
//x result.length.times{
//x         println result.item(it).textContent
//x }




import groovy.xml.MarkupBuilder
import groovy.xml.DOMBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.*

void dump(i_tree) {
    def writer = new StringWriter()
    i_tree.print(new PrintWriter(writer))
    println writer.toString()    
}

protected def createTree() {
//x     def builder = MarkupBuilder.newInstance()
    def builder = DOMBuilder.newInstance()
    
    def root = builder.root() {   
      FILE_NAME('"C3_CP_EDI_EGD__20111009_V01.cef"')
      FILE_FORMAT_VERSION('"CEF-2.0"')
      meta(name:'LOGICAL_FILE_ID') {
        ENTRY('"C3_CP_EDI_EGD__20111009_V01"')
      }
      meta(name:'VERSION_NUMBER') {
        ENTRY('"01"')
      }
      meta(name:'FILE_TIME_SPAN') {
        VALUE_TYPE('ISO_TIME_RANGE')
        ENTRY('2011-10-09T00:00:00Z/2011-10-10T00:00:00Z')
      }
      meta(name:'GENERATION_DATE') {
        VALUE_TYPE('ISO_TIME')
        ENTRY('2012-04-11T15:57:15Z')
      }
      meta(name:'FILE_CAVEATS') {
        ENTRY('"CAA_EDITOF_V1_04  2011-04-04T10:30:00Z"')
      }
      include('"C3_CH_EDI_EGD_DATASET.ceh"')
      include('"C3_CH_EDI3_INST.ceh"')
      include('"CL_CH_EDI_EXP.ceh"')
      include('"CL_CH_MISSION.ceh"')
      meta(name:'MISSION') {
        ENTRY('"Cluster"')
      }
      meta(name:'MISSION_TIME_SPAN') {
        VALUE_TYPE('ISO_TIME_RANGE')
        ENTRY('2000-08-16T12:39:00Z/2009-12-31T23:59:59Z')
      }
      meta(name:'MISSION_AGENCY') {
        ENTRY('"ESA"')
      }
      meta(name:'MISSION_DESCRIPTION') {
        ENTRY('"The aim of the Cluster mission is to study small-scale structures of the magnetosphere "')
        ENTRY('"and its environment in three dimensions. To achieve this, Cluster is constituted of four "')
        ENTRY('"identical spacecraft that will flight in a tetrahedral configuration. The separation distances "')
        ENTRY('"between the spacecraft will be varied between ~40 km and 10 000 km, according to the "')
        ENTRY('"key scientific regions."')
      }
      meta(name:'MISSION_KEY_PERSONNEL') {
        ENTRY('"Philippe Escoubet>Philippe.Escoubet@esa.int >Cluster Project Scientist"')
      }
      meta(name:'MISSION_REFERENCES') {
        ENTRY('"The Cluster and Phoenix Missions>Cluster project and instrument teams>Space Sci. Rev. 79, Nos. 1-2, 1997"')
      }
      meta(name:'MISSION_REGION') {
        ENTRY('"Solar_Wind"')
        ENTRY('"Bow_Shock"')
        ENTRY('"Magnetosheath"')
        ENTRY('"Magnetopause"')
        ENTRY('"Magnetosphere"')
        ENTRY('"Magnetotail"')
        ENTRY('"Polar_Cap"')
        ENTRY('"Auroral_Region"')
        ENTRY('"Cusp"')
        ENTRY('"Radiation_Belt"')
        ENTRY('"Plasmasphere"')
      }
      meta(name:'MISSION_CAVEATS') {
        ENTRY('"*CL"')
      }
      meta(name:'EXPERIMENT') {
        ENTRY('"EDI"')
      }
      meta(name:'EXPERIMENT_DESCRIPTION') {
        ENTRY('"Electron Drift Instrument"')
        ENTRY('"Electric field measured by the drift velocity "')
        ENTRY('"of monoenergetic artificial electron beams "')
        ENTRY('"injected perpendicularly to the ambient magnetic field"')
      }
      meta(name:'INVESTIGATOR_COORDINATES') {
        ENTRY('"Goetz Paschmann>PI>goetz.paschmann@mpe.mpg.de"')
        ENTRY('"Roy Torbert>PI>roy.torbert@unh.edu"')
        ENTRY('"Jack Quinn>CoPI>jmquinn@bu.edu"')
      }
      meta(name:'EXPERIMENT_REFERENCES') {
        ENTRY('"*CL_CD_EDI_CAAICD"')
        ENTRY('"*CL_CD_EDI_USERMAN"')
        ENTRY('"AnnGeo_FirstResults.pdf"')
        ENTRY('"AnnGeo_JQuinn1669.pdf"')
        ENTRY('"http://www.mpe.mpg.de/CLUSTER/EDI-Pages/edi_page.html"')
      }
      meta(name:'EXPERIMENT_KEY_PERSONNEL') {
        ENTRY('"Edita Georgescu>Archive Scientist>eg@mps.mpg.de"')
        ENTRY('"Hans Vaith>Experiment Engineer>hans.vaith@unh.edu"')
        ENTRY('"Mark Chutter>Software Engineer>mark.chutter@unh.edu"')
        ENTRY('"Pamela Puhl-Quinn>Software Engineer>pamela.puhlquinn@aer.com"')
      }
      meta(name:'EXPERIMENT_CAVEATS') {
//x         ENTRY('"EDI experiment is operated in 2 modes 'Electric Field'"')
//x         ENTRY('"and 'Ambient Electron' mode, see CaveatList files for"')
        ENTRY('"specific time intervals"')
        ENTRY('""')
        ENTRY('"Large data gaps may occur due to: "')
        ENTRY('"- highly variable magnetic and/or electric fields"')
        ENTRY('"- high ambient electron fluxes"')
        ENTRY('"- radiation induced hardware failures"')
        ENTRY('""')
        ENTRY('"Smaller data gaps occur in MCP calibration mode or "')
        ENTRY('"at regularly scheduled BM3 dumps"')
        ENTRY('""')
//x         ENTRY('"Data availability in 'Electric field' mode is documented"')
        ENTRY('"in the QSTAT files with 10 min resolution"')
        ENTRY('""')
      }
      include('"C3_CH_OBS.ceh"')
      meta(name:'OBSERVATORY') {
        ENTRY('"Cluster-3"')
      }
      meta(name:'OBSERVATORY_CAVEATS') {
        ENTRY('"*C3_CQ"')
      }
      meta(name:'OBSERVATORY_DESCRIPTION') {
        ENTRY('"Cluster-3 (Samba)"')
        ENTRY('"Launched: 16 Jul 2000"')
        ENTRY('"ESA Number: 3"')
        ENTRY('"COSPAR ID: 2000-041A"')
        ENTRY('"USSPACECOM catalogue number: 26410"')
        ENTRY('"CSDS Code: C3"')
        ENTRY('"ESOC FD code: S3"')
        ENTRY('"ESA Flight Model Number: FM7"')
      }
      meta(name:'OBSERVATORY_TIME_SPAN') {
        VALUE_TYPE('ISO_TIME_RANGE')
        ENTRY('2000-07-16T12:39:00Z/2009-12-31T23:59:59Z')
      }
      meta(name:'OBSERVATORY_REGION') {
        ENTRY('"Solar_Wind"')
        ENTRY('"Bow_Shock"')
        ENTRY('"Magnetosheath"')
        ENTRY('"Magnetopause"')
        ENTRY('"Magnetosphere"')
        ENTRY('"Magnetotail"')
        ENTRY('"Polar_Cap"')
        ENTRY('"Auroral_Region"')
        ENTRY('"Cusp"')
        ENTRY('"Radiation_Belt"')
        ENTRY('"Plasmasphere"')
      }
      meta(name:'INSTRUMENT_NAME') {
        ENTRY('"EDI3"')
      }
      meta(name:'INSTRUMENT_DESCRIPTION') {
        ENTRY('"EDI Experiment on Cluster C3"')
      }
      meta(name:'INSTRUMENT_TYPE') {
        ENTRY('"Electron_Drift"')
      }
      meta(name:'MEASUREMENT_TYPE') {
        ENTRY('"Electric_Field"')
      }
      meta(name:'INSTRUMENT_CAVEATS') {
        ENTRY('" "')
      }
      meta(name:'DATASET_ID') {
        ENTRY('"C3_CP_EDI_EGD"')
      }
      meta(name:'DATA_TYPE') {
        ENTRY('"CP>CAA Parameter"')
      }
      meta(name:'DATASET_TITLE') {
        ENTRY('"Electron Gyrotime Data"')
      }
      meta(name:'DATASET_DESCRIPTION') {
        ENTRY('"This dataset contains measurements of the gyro-time of emitted "')
        ENTRY('"electrons from the EDI experiment on the Cluster C3 spacecraft"')
        ENTRY('"The kinetic energy of the emitted electrons is: 1. or 0.5 keV (kine_flag=0,1) "')
      }
      meta(name:'CONTACT_COORDINATES') {
        ENTRY('"EditaGeorgescu>Archive Scientist>eg@mps.mpg.de"')
      }
      meta(name:'PROCESSING_LEVEL') {
        ENTRY('"Auxiliary"')
      }
      meta(name:'TIME_RESOLUTION') {
        ENTRY('0.015625')
      }
      meta(name:'MAX_TIME_RESOLUTION') {
        ENTRY('0.015625')
      }
      meta(name:'MIN_TIME_RESOLUTION') {
        ENTRY('1.e31')
      }
      meta(name:'DATASET_CAVEATS') {
        ENTRY('"No regularly spaced time series!"')
        ENTRY('"MAX_TIME_RESOLUTION is given for burst mode"')
        ENTRY('"MIN_TIME_RESOLUTION is set to fill_value"')
        ENTRY('"Time_tags are the registered UT at electron detection"')
        ENTRY('"To convert gyrotime microseconds to B in nT use for"')
        ENTRY('"kine_flag=0: 35793.785"')
        ENTRY('"kine_flag=1: 35758.831"')
        ENTRY('""')
      }
      meta(name:'ACKNOWLEDGEMENT') {
        ENTRY('"Please acknowledge the EDI team and ESA Cluster Active Archive"')
        ENTRY('" when using this data"')
      }
      meta(name:'METADATA_TYPE') {
        ENTRY('"CAA"')
      }
      meta(name:'METADATA_VERSION') {
        ENTRY('"2.0"')
      }
      meta(name:'FILE_TYPE') {
        ENTRY('"cef"')
      }
      meta(name:'DATASET_VERSION') {
        ENTRY('"2.0"')
      }
      var(name:'time_tags__C3_CP_EDI_EGD') {
        PARAMETER_TYPE('"Support_Data"')
        CATDESC('"Time Tag"')
        UNITS('"s"')
        SI_CONVERSION('"1.0>s"')
        FIELDNAM('"Universal Time"')
        FILLVAL('9999-12-31T23:59:59.999999Z')
        SIGNIFICANT_DIGITS('27')
        LABLAXIS('"UT"')
        VALUE_TYPE('ISO_TIME')
        DELTA_PLUS('0.244e-6')
        DELTA_MINUS('0.244e-6')
      }
      var(name:'tof__C3_CP_EDI_EGD') {
        PARAMETER_TYPE('"Data"')
        ENTITY('"Electron"')
        PROPERTY('"Time-of-Flight"')
        CATDESC('"electron gyration time"')
        VALUE_TYPE('FLOAT')
        FIELDNAM('"Time-of-Flight"')
        FILLVAL('0.000')
        SIGNIFICANT_DIGITS('10')
        QUALITY('"2"')
        LABLAXIS('"tof"')
        SI_CONVERSION('"1.0e-6>s"')
        UNITS('"microseconds"')
        DEPEND_0('time_tags__C3_CP_EDI_EGD')
      }
      var(name:'sigma_tof__C3_CP_EDI_EGD') {
        PARAMETER_TYPE('"Data"')
        ENTITY('"Electron"')
        PROPERTY('"Time-of-Flight"')
        CATDESC('"electron gyration time standard deviation"')
        VALUE_TYPE('FLOAT')
        FIELDNAM('"Time-of-Flight standard deviation"')
        FILLVAL('0.000')
        SIGNIFICANT_DIGITS('10')
        QUALITY('"2"')
        LABLAXIS('"sigma_tof"')
        SI_CONVERSION('"1.0e-6>s"')
        UNITS('"microseconds"')
        DEPEND_0('time_tags__C3_CP_EDI_EGD')
      }
      var(name:'gdu_flag__C3_CP_EDI_EGD') {
        PARAMETER_TYPE('"Support_Data"')
        ENTITY('"Electron"')
        PROPERTY('"Time-of-Flight"')
        CATDESC('"Detector Unit"')
        VALUE_TYPE('INT')
        FIELDNAM('"Detector Unit"')
        FILLVAL('0')
        SIGNIFICANT_DIGITS('1')
        LABLAXIS('"DU"')
        UNITS('"Unitless"')
        DEPEND_0('time_tags__C3_CP_EDI_EGD')
      }
      var(name:'kine_flag__C3_CP_EDI_EGD') {
        PARAMETER_TYPE('"Support_Data"')
        ENTITY('"Electron"')
        PROPERTY('"Time-of-Flight"')
        CATDESC('"electron gyration time"')
        VALUE_TYPE('INT')
        FIELDNAM('"Kinetic Energy Flag"')
        FILLVAL('9')
        SIGNIFICANT_DIGITS('1')
        LABLAXIS('"KinEnFlag"')
        UNITS('"Unitless"')
        DEPEND_0('time_tags__C3_CP_EDI_EGD')
      }
      DATA_UNTIL('EOF')
    }
        
    return root
}

def tree = createTree()
dump tree

//x println tree.getClass()
//x 
//x println tree.FILE_NAME
//x tree.FILE_NAME.find { println it.value }

def xpath = XPathFactory.newInstance().newXPath()
println xpath.getClass()              
              
def nodes = xpath.evaluate(
              '//var',             // '//task',
              tree,                 // myTodos,
              XPathConstants.NODESET
            )
            
println nodes            

nodes.each {
  println xpath.evaluate('ENTITY/text()', it)
}              
              
              
//x tree.var.find { it['@name'] == 'kine_flag__C3_CP_EDI_EGD' }.location[0]['@name'] == 'London'              
println tree.var.find { it['@name'] == 'kine_flag__C3_CP_EDI_EGD' }
              
              
              
              