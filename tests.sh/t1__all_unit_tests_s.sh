CEF_PASS_HOME=..
LOGS_FOLDER=$CEF_PASS_HOME/../_logs
APP_JAR=$CEF_PASS_HOME/app/build/libs/cefpass-0.1.0.jar  
RESOURCES=$CEF_PASS_HOME/app/src/test/resources
CEF_FOLDER=$RESOURCES/$1
CEH_FOLDER=$CEF_FOLDER
CEF_FILE=$CEF_FOLDER/C3_CP_EDI_EGD__20111009_V01.cef

# echo '- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -'
# echo $1
# echo $2                           -o,--output <arg>       (Optional) Output Results Level(0,1,2,3): 0:Debug 1:Info 2:Stages 3:Result Only
# echo $CEF_FOLDER
# echo $CEF_FILE
# echo '- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -'

## java -jar $APP_JAR -f $CEF_FILE -i $CEH_FOLDER -l $LOGS_FOLDER -z
java -jar $APP_JAR -f $CEF_FILE -i $CEH_FOLDER -l $LOGS_FOLDER -o $2