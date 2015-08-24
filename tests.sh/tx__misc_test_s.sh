##x CEF_PASS_HOME=..
##x LOGS_FOLDER=$CEF_PASS_HOME/../_logs
##x APP_JAR=$CEF_PASS_HOME/app/build/libs/cefpass-0.1.0.jar  
##x RESOURCES=$CEF_PASS_HOME/app/src/test/resources
##x ##x CEF_FOLDER=$RESOURCES/R_0_00___START_META___META_UNCLOSED
##x CEF_FOLDER=$RESOURCES/$1
##x CEH_FOLDER=$CEF_FOLDER
##x CEF_FILE=$CEF_FOLDER/C3_CP_EDI_EGD__20111009_V01.cef

# echo '- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -'
# echo $1
# echo $2
# echo $CEF_FOLDER
# echo $CEF_FILE
# echo '- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -'

##x echo '+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++'
##x echo $1
##x echo $2
##x echo '+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++'

## java -jar $APP_JAR -f $CEF_FILE -i $CEH_FOLDER -l $LOGS_FOLDER -z
##x java -jar $APP_JAR -f $CEF_FILE -i $CEH_FOLDER -l $LOGS_FOLDER -r $2    

echo '+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++'
echo '$1: '   $1
echo '$2: '   $2
echo '$@: '   $@
echo '+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++'