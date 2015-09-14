CEF_PASS_HOME=../..
CEF_TEST_HOME=.
LOGS_FOLDER=$CEF_TEST_HOME/logs
APP_JAR=$CEF_PASS_HOME/app/build/libs/cefpass-0.1.0.jar  
CEF_FOLDER=$CEF_TEST_HOME/CEF
CEH_FOLDER=$CEF_TEST_HOME/HEADERS
CEH_FOLDER_1=$CEH_FOLDER/header_includes
CEH_FOLDER_2=$CEH_FOLDER_1/aux1

# java -jar cefpass-0.1.0.jar -l logs -o 1 -i HEADERS/header_includes/ -i HEADERS/header_includes/aux1/ -f CEF/C1_CP_AUX_MAARBLE_ULF_PC1__20100211_035905_20100211_035925_V00.cef.gz
# java -jar cefpass-0.1.0.jar -l logs -o 1 -i HEADERS/header_includes/ -i HEADERS/header_includes/aux1/ -f CEF/C1_CP_AUX_MAARBLE_ULF_PC1__20010522_202305_20010522_202406_V00.cef.gz
# java -jar cefpass-0.1.0.jar -l logs -o 1 -i HEADERS/header_includes/ -i HEADERS/header_includes/aux1/ -f /c/catalog57/products/aux1/csds/2011/C1_CP_AUX_SPIN_TIME__20110709_000000_20110710_000000_V05.cef.gz
# java -jar cefpass-0.1.0.jar -l logs -o 1 -i HEADERS/header_includes/ -i HEADERS/header_includes/aux1/ -f CEF/C1_CP_AUX_SPIN_TIME__20110705_000000_20110706_000000_V05.cef.gz
# java -jar cefpass-0.1.0.jar -l logs -o 1 -i HEADERS/header_includes/ -i HEADERS/header_includes/cis/ -f CEF/C1_CP_CIS-CODIF_H1_1D_PEF__20040616_V01.cef.gz
# java -jar cefpass-0.1.0.jar -l logs -o 1 -i HEADERS/header_includes/ -i HEADERS/header_includes/cis/ -f CEF/C1_CP_CIS-CODIF_H1_1D_PEF__20010101_V01.cef.gz

# java -jar cefpass-0.1.0.jar -l logs -o 1 -i HEADERS/header_includes/ -i HEADERS/header_includes/aux1/ -f CEF/C1_CP_AUX_MAARBLE_ULF_PC1__20100211_035905_20100211_035925_V00.cef.gz

java -jar $APP_JAR -i $CEH_FOLDER_1 -i $CEH_FOLDER_2 -l $LOGS_FOLDER -o 1 -f $CEF_FOLDER/C1_CP_AUX_MAARBLE_ULF_PC1__20100211_035905_20100211_035925_V00.cef.gz
