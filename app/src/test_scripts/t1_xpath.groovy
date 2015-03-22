#!/usr/bin/groovy

import javax.xml.xpath.*
import javax.xml.parsers.DocumentBuilderFactory

def testxml = '''
                <Employee>
                  <ID>..</ID>
                  <E-mail>..</E-mail>
                  <custom_1>foo</custom_1>
                  <custom_2>bar</custom_2>
                  <custom_3>base</custom_3>
                </Employee>
  '''

def processXml( String xml, String xpathQuery ) {
    def xpath = XPathFactory.newInstance().newXPath()
    def builder     = DocumentBuilderFactory.newInstance().newDocumentBuilder()
    def inputStream = new ByteArrayInputStream( xml.bytes )
    def records     = builder.parse(inputStream).documentElement
//x     xpath.evaluate( xpathQuery, records )
    xpath.evaluate( xpathQuery, records, XPathConstants.NODESET )
}

//x println processXml( testxml, '//*[starts-with(name(), "custom")]' )

def result = processXml( testxml, '//*[starts-with(name(), "custom")]' )
result.length.times{
        println result.item(it).textContent
}