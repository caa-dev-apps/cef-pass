## cef-pass

a cef file validator


### Overview

There are 5 main stages in the cef file validation process which are handled by the cef-pass App.

1. Command line inputs processing.
    Inputs are passed on the command line as detailed below

    ```console
    $ java -jar ./cefpass-0.1.0.jar -h

        usage: java -jar cefpass-0.1.0.jar -f <path-to-cef> -i<search include dirs> -x <xml-schema files>
         -f,--cef <cef>           (Required) path to cef file
         -h,--help                usage information
         -i,--include <include>   (Optional) list of include folders to search for
                                  ceh files
         -l,--logs <logs>         path to logs folder
         -o,--xo                  output header meta data in xml format
         -q,--qv                  quick validation (only checks 1st data row)
         -x,--xsd <xsd>           (Optional) list of xml schema files to validate
                                  header data against
    $                              

    ``` 
    e.g.      
    ```console                        
    $ java -jar ./cefpass-0.1.0.jar -f $CEF_PASS_HOME/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_EGD__20111009_V01.cef.gz -i $CEF_PASS_HOME/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/_TEST_SAMPLES/MULTI_LEVEL_INCLUDES,$CEF_PASS_HOME/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS,$CEF_PASS_HOME/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS/EDI,$CEF_PASS_HOME/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS/EFW,$CEF_PASS_HOME/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS/PEACE
    ```     
    
2. cef header processing
    - parse cef header data along with any included ceh files
    - store data in memory for later tests
        - as node tree
        - xml document
        - json document (for optional javascript rules/tests)

            
3. xml schema (xsd) validation            
    One or more xml schema files may be optionally included on the command line for validating the generated xml version of the header meta data
    (attributes, meta-data descriptions and variable definitions)
    
4. A set of rules which test the header data for correctness.
    These rules are currently small groovy scripts which are run against the data generated in step 2.

5. Data Validation
    Each row of data is checked for
    - increasing timestamps 
    - correct number of values
    - value types, matching header variable definitions
    - end of line marker
   



### To Build and Run

```console
Either
$ gradle build & java -jar ./build/libs/cefpass-0.1.0.jar
or 
$ cd src/main/groovy
$ groovy ./cefpass/App.groovy
```    

    
### TODO 
    stages
    1. testing
    2. testing
    3. in progress
    4. in progress
    5. in progress
        