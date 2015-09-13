CEF_PASS_HOME=..
LOGS_FOLDER=$CEF_PASS_HOME/../_logs
APP_JAR=$CEF_PASS_HOME/app/build/libs/cefpass-0.1.0.jar  
RESOURCES=$CEF_PASS_HOME/app/src/test/resources
##x CEF_FOLDER=$RESOURCES/R_0_00___START_META___META_UNCLOSED
CEF_FOLDER=$RESOURCES/$1
CEH_FOLDER=$CEF_FOLDER
CEF_FILE=$CEF_FOLDER/C3_CP_EDI_EGD__20111009_V01.cef

# echo '- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -'
# echo $1
# echo $2
# echo $CEF_FOLDER
# echo $CEF_FILE
# echo '- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -'

java -jar $APP_JAR -f $CEF_FILE -i $CEH_FOLDER -l $LOGS_FOLDER -r $2    