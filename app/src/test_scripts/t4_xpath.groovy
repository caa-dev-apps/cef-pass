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
import groovy.json.JsonBuilder

void dump(i_tree) {
    def writer = new StringWriter()
    i_tree.print(new PrintWriter(writer))
    println writer.toString()    
}

def to_string(i_tree) {
    def writer = new StringWriter()
    i_tree.print(new PrintWriter(writer))
    return writer.toString()    
}



protected def createTree() {
    def builder = MarkupBuilder.newInstance()
//x     def builder = DOMBuilder.newInstance()
//x     def builder = JsonBuilder.newInstance()
//x     def builder = NodeBuilder.newInstance()
    
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

println("#### ## # # # # ##  ## ## ## ## # ## # #");


def tree = createTree()
//x dump tree


//x println(to_string(tree))
println("#### ## # # # # ##  ## ## ## ## # ## # #");

//x def t2 = DOMBuilder.newInstance().parse(to_string(tree))
//x dump t2












def test1()
{

  def CAR_RECORDS = '''
    <records>
      <car name='HSV Maloo' make='Holden' year='2006'>
        <country>Australia</country>
        <record type='speed'>Production Pickup Truck with speed of 271kph</record>
      </car>
      <car name='P50' make='Peel' year='1962'>
        <country>Isle of Man</country>
        <record type='size'>Smallest Street-Legal Car at 99cm wide and 59 kg in weight</record>
      </car>
      <car name='Royale' make='Bugatti' year='1931'>
        <country>France</country>
        <record type='price'>Most Valuable Car at $15 million</record>
      </car>
    </records>
  '''

def reader  = new StringReader(XmlExamples.CAR_RECORDS)
def doc     = DOMBuilder.parse(reader)
def records = doc.documentElement

println(records)

}

test1()


//x println tree.size()



//x //x println tree.getClass()
//x //x 
//x //x println tree.FILE_NAME
//x //x tree.FILE_NAME.find { println it.value }
//x 
//x def xpath = XPathFactory.newInstance().newXPath()
//x println xpath.getClass()              
//x               
//x def nodes = xpath.evaluate(
//x               '//var',             // '//task',
//x               tree,                 // myTodos,
//x               XPathConstants.NODESET
//x             )
//x             
//x println nodes            
//x 
//x nodes.each {
//x   println xpath.evaluate('ENTITY/text()', it)
//x }              
//x               
//x               
//x //x tree.var.find { it['@name'] == 'kine_flag__C3_CP_EDI_EGD' }.location[0]['@name'] == 'London'              
//x println tree.var.find { it['@name'] == 'kine_flag__C3_CP_EDI_EGD' }
              
              
              
              
