CEF_PASS_HOME=..
LOGS_FOLDER=$CEF_PASS_HOME/../_logs
APP_JAR=$CEF_PASS_HOME/app/build/libs/cefpass-0.1.0.jar  
RESOURCES=$CEF_PASS_HOME/app/src/test/resources
CEF_FOLDER=$RESOURCES/R_0_00___START_META___META_UNCLOSED
CEH_FOLDER=$CEF_FOLDER
CEF_FILE=$CEF_FOLDER/C3_CP_EDI_EGD__20111009_V01.cef

## These are all failing tests
                                    
java -jar $APP_JAR -f $CEF_FILE -i $CEH_FOLDER -l $LOGS_FOLDER
       