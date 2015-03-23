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

    def builder = MarkupBuilder.newInstance()
//x     def builder = DOMBuilder.newInstance()
//x     def builder = JsonBuilder.newInstance()
//x     def builder = NodeBuilder.newInstance()
    

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

def reader  = new StringReader(CAR_RECORDS)
def doc     = DOMBuilder.parse(reader)
def records = doc.documentElement

//x def builder = MarkupBuilder.newInstance()

//x records.append(doc.createNode("k", "v" ))



println(records)

              
              
              
