


        
        
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