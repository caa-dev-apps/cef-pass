/*
 * This Spock specification was auto generated by running 'gradle init --type groovy-library'
 * by 'sp' at '19/07/14 22:43' with Gradle 1.12
 *
 * @author sp, @date 19/07/14 22:43
 */

import spock.lang.Specification

import cefpass.App


class AppTest extends Specification{

    def TEST_SEARCH_FOLDERS = [
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/_TEST_SAMPLES/MULTI_LEVEL_INCLUDES",
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS",
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS/EDI",
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS/EFW",
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS/PEACE"
    ]

    def TEST_FILES = [
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_EGD__20111009_V01.cef.gz",
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_EGD__20111009_V01.cef",
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_EGD__20111020_V01.cef.gz",
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_EGD__20111021_V01.cef.gz",
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_EGD__20111022_V01.cef.gz",
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_QZC__20111009_V01.cef.gz",
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_QZC__20111020_V01.cef.gz",
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_QZC__20111021_V01.cef.cef",
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_QZC__20111021_V01.cef.gz",
        "C:/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_QZC__20111022_V01.cef.gz"
    ]


    def "First Test: App.m1"() {
    
        setup:
        App app = new App()
        when:
        def result = app.m1()
        then:
        result == true
    }
    
    
    def "Second Test (args): App.stages"() {
    
        setup:
        def App app = new App()
        String[] l_args = [
            "-f",
            TEST_FILES[0],
            "-i",
            TEST_SEARCH_FOLDERS.join(",")
        ]
        
        when:
        def result = app.stages(l_args)
        then:
        result == true
    }
    
    
}