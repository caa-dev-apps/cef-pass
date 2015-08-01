
// default
settings.outputResultsLevel = 1                         // options.o, 0, 2, 1
 
environments {
    development {
        settings.outputResultsLevel = 2
    }
    test {
        settings.outputResultsLevel = 1
    }
    production {
        settings.outputResultsLevel = 0
    }
}    

settings {
     isCommentsOn          = true
     filepath              = "C:/work.dev/2015.03.22 github cef pass v2/v0/cef-pass/app/src/test/resources/R_0_00___START_META___META_UNCLOSED/C3_CP_EDI_EGD__20111009_V01.cef.gz"
//x     searchFolders         = [
//x                                 "C:/work.dev/2015.03.22 github cef pass v2/v0/cef-pass/app/src/test/resources/R_0_00___START_META___META_UNCLOSED"
//x                             ]
    logsFolder            = "C:/Dump/_logs"
    //x xmlSchemas            = "XML-SCHEMAS-TEST"

    outputHeaderXML       = true
    quickValidation       = true
    
    testRuleId            = 1.02
    stopOnFail            = true
    outputResultsLevel    = 1
}