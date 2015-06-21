import spock.lang.Specification

import cefpass.Utils

///////////////////////////////////////////////////////////////////////////////
//

class U_Utils_Tests extends Specification{

    def setup()
    {
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    //
    
    def "Utils.getFilename_OK"() {
        when:   
            def result = "C3_CP_EDI_EGD__20111009_V01.cef.gz"
                            .equals(Utils.getFilename("C:/Dump/123/456/C3_CP_EDI_EGD__20111009_V01.cef.gz"))
        then:
            result == true
    }
    
    def "Utils.getCefFilename_OK"() {
        when:   
            def result = "C3_CP_EDI_EGD__20111009_V01.cef"
                            .equals(Utils.getCefFilename("C:/Dump/123/456/C3_CP_EDI_EGD__20111009_V01.cef"))
        then:
            result == true
    }

    def "Utils.getCefLogicalFileId_OK"() {
        when:   
            def result = "C3_CP_EDI_EGD__20111009_V01"
                            .equals(Utils.getCefLogicalFileId("C3_CP_EDI_EGD__20111009_V01.cef"))
        then:
            result == true
    }

    def "Utils.getCefFileVersion_OK"() {
        when:   
            def result = "01"
                            .equals(Utils.getCefFileVersion("C3_CP_EDI_EGD__20111009_V01.cef"))
        then:
            result == true
    }
}

