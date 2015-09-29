
Contents:
    cef-test-schema.xsd              a W3C XML Schema for checking an intermediate XML string 
                                     generated when parsing the header data in a cef file.
                                     more rules need to be added for further checks to be made.
                                     
    cef-meta-nodes.xml               a generated XML file to be used as the basis for XSD related tests.
    
    app-logs.txt                     a text output of the header data part of a cef file 
                                     (matches above xml) - including mixed in ceh data see 
                                     - include-start and include-end tags for hints.
                                     
    test_xsd.groovy                  a groovy script to test the above xsd against the xml
    
    
Method:
        install java                java 8 is recommended though 7 should be fine
        install groovy              following instructions for 
                                        SDKMAN here -> http://www.groovy-lang.org/download.html
        
     
        edit xml and xsd files as required
     
        
Test:        
        groovy test_xsd.groovy      to run test script. 
                                    Failures are quite terse... need to look at getting more details
    