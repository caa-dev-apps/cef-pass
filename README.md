## cef-pass

a cef file validator


### Overview

There are 5 main stages in the cef file validation process which are handled by the cef-pass App.

1. Processing Command line inputs.
    Inputs are passed on the command line as detailed below

    ```console
    $ java -jar ./cefpass-0.1.0.jar -h

        usage: java -jar cefpass-0.1.0.jar -f <path-to-cef> -i <search include dirs> -x <xml-schema files>
         -c,--comments-on        (Optional) include comments in the output data(XML). Default=False
         -e,--config-env <arg>   (Optional) A config environment tag (e.g. dev, test, default=none)
         -f,--cef <arg>          (Required) path to cef file
         -g,--config <arg>       (Optional) A groovy dsl config file
         -h,--help               usage information
         -i,--include <arg>      (Optional) list of include folders to search for ceh files
         -l,--logs <arg>         (Optional) path to logs folder
         -o,--output <arg>       (Optional) Output Results Level(0,1,2,3): 0:Debug 1:Info 2:Stages 3:Result Only
         -q,--qv                 (Optional) quick validation (only checks 1st data row). Default=False
         -r,--rule-id <arg>      (Optional) Test specific Rule Id. Default=All e.g. "1.02"
         -s,--stop               (Optional) No-Stop on Fail. Default=False
         -u,--xo                 (Optional) output header meta data in xml format. Default=False
         -x,--xsd <arg>          (Optional) list of xml schema files to validate header data against
         -z,--debug-info         (Optional) Outputs the cmdline args data and exits immediately. For debug Only!
                                  
    $                              

    ``` 
    e.g.      
    ```console                        
    $ java -jar ./cefpass-0.1.0.jar -f $CEF_PASS_HOME/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/EDI/C3_CP_EDI_EGD__20111009_V01.cef.gz -i $CEF_PASS_HOME/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/CEF/_TEST_SAMPLES/MULTI_LEVEL_INCLUDES,$CEF_PASS_HOME/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS,$CEF_PASS_HOME/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS/EDI,$CEF_PASS_HOME/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS/EFW,$CEF_PASS_HOME/_CEF_CEH_EXAMPLES_2013_VALIDATOR_/HEADERS/PEACE
    ```     
    
2. cef header processing.
    - parse cef header data along with any included ceh files
    - store data in memory for further rule based tests
        - xml document

            
3. xml schema (xsd) validation.
    One or more xml schema files may be optionally included on the command line for validating the generated xml version of the header meta data
    (attributes, meta-data descriptions and variable definitions)
    
4. A set of rules which test the header data for correctness.
    These rules are currently small groovy scripts which are run against the data generated in step 2.

5. Data Validation.
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

    
### Status
    stages
    1. passing
    2. passing
    3. basic version
    4. in dev
    5. next
        