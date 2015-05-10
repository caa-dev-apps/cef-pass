import spock.lang.Specification

import cefpass.App
import cefpass.CefHeaderXml

class U_CefHeaderXml_Test extends Specification{

    def "01 CefHeaderXml_Tests: create and merge 2 x CefHeaderXml"() {

        setup:
            def H1 = new CefHeaderXml()

            H1.addComment("Start of H1 Global Attributes")
            H1.addAttr("K1", "V1")
            H1.addAttr("K2", "V2")
            H1.addAttr("K3", "V3")

            H1.addComment("Start of H1 Meta Elements + Values")
            H1.stxMeta("M1")
            H1.addAttr("MK1", "V1")
            H1.addAttr("MK2", "V2")
            H1.addAttr("MK3", "V3")
            H1.etxMeta("M1")

            H1.addComment("Start of H1 Variable Elements + Values")
            H1.stxVar("V1")
            H1.addAttr("VK1", "V1")
            H1.addAttr("VK2", "V2")
            H1.addAttr("VK3", "V3")
            H1.etxVar("V1")

            def H2 = new CefHeaderXml()

            H2.addComment("Start of H2 Global Attributes")
            H2.addAttr("K21", "V21")
            H2.addAttr("K22", "V22")
            H2.addAttr("K23", "V23")

            H2.addComment("Start of H Meta Elements + Values")
            H2.stxMeta("M21")
            H2.addAttr("M2K1", "V21")
            H2.addAttr("MK22", "V22")
            H2.addAttr("MK23", "V23")
            H2.etxMeta("M21")

            H2.addComment("Start of H Variable Elments + Values")
            H2.stxVar("V21")
            H2.addAttr("VK21", "V21")
            H2.addAttr("VK22", "V22")
            H2.addAttr("VK23", "V23")
            H2.etxVar("V21")

            // simulate adding include files
            H1.appendDocument(H2)
            
            //x H1.dumpX()
            
        when:
            def result = (H2.getXmlNodesAsString() != null &&
                          H1.getXmlNodesAsString() != null)
        then:
            result == true
    }
}
