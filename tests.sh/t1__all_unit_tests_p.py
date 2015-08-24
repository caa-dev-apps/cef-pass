import os
import subprocess

# -o,--output <arg>       (Optional) Output Results Level(0,1,2,3): 0:Debug 1:Info 2:Stages 3:Result Only
def t1_tests(i_output):
    l_cwd = os.getcwd()
    print "Current Working Directory = " + l_cwd

    FOLDERS = [
    ##x     "R_0_00___START_META___META_UNCLOSED",
    ##x     "R_0_01___START_META___VARIABLE_UNCLOSED",
    ##x     "R_0_02___START_META___NAME_ERROR",
    ##x     "R_0_10___END_META___VARIABLE_OPENED",
    ##x     "R_0_11___END_META___META_UNOPENED",
    ##x     "R_0_12___END_META___NAME_ERROR",
    ##x     "R_0_20___START_VARIABLE___VARIABLE_UNCLOSED",
    ##x     "R_0_21___START_VARIABLE___META_UNCLOSED",
    ##x     "R_0_22___START_VARIABLE___NAME_ERROR",
    ##x     "R_0_30___END_VARIABLE___META_OPENED",
    ##x     "R_0_31___END_VARIABLE___VARIABLE_UNOPENED",
    ##x     "R_0_32___END_VARIABLE___NAME_ERROR",
    ##x     "R_0_40___INCLUDE_FILE_DUPLICATE",
    ##x     "R_0_41___INCLUDE_FILE_UNFOUND",
    ##x     "R_0_42___INCLUDE_FILE_LEVEL_8",
    ##x     "R_0_50___MALFORMED_READ_LINE",
        "R_0_51___MALFORMED_STRING_QUOTES",
        "R_1_00___FILENAME_MUST_EXIST",
    ##x     "R_1_01___FILENAME_MATCHES_ACTUAL",
    ##x     "R_1_02___FILE_FORMAT_VERSION_MUST_EXIST",
    ##x     "R_1_03___END_OF_RECORD_MARKER_MUST_EXIST",
        "R_2_00___MUST_HAVE_ENTRY",
    ##x     "R_2_02___ENTRY_MISMATCH_VALUE_TYPE",
    ##x     "R_2_03___REQUIRED_VARIABLES_XXXX",
    ##x     "R_2_04___FILE_TYPE_MUST_BE_CEF",
    ##x     "R_2_05___DATASET_VERSION_MUST_BE_VALID_INTEGER",
    ##x     "R_2_06___LOGICAL_FILE_ID_MATCHES_FILENAME",
    ##x     "R_2_07___VERSION_NUMBER_MUST_BE_VALID_INTEGER",
    ##x     "R_2_08___VERSION_NUMBER_MATCHES_FILENAME",
    ##x     "R_2_09___FILE_TIME_SPAN_MUST_BE_ISO_TIME_RANGE",
    ##x     "R_2_10___FILE_TIME_SPAN_START_TIME_MUST_BE_BEFORE_STOP_TIME",
    ##x     "R_2_11___DATA_RECORD_TIME_STAMP_MUST_BE_BETWEEN_FILE_TIME_SPAN"
    ]

    for l_folder in FOLDERS:
        ##x print l_folder
        print "__________________________________________________________________________________________________________________________________________________"
        
        ##x res = subprocess.check_output("sh ./t1__all_unit_tests_s.sh " + l_folder, stderr=subprocess.STDOUT)
        res = subprocess.check_output("sh ./t1__all_unit_tests_s.sh " + 
                                     l_folder +
                                     " " +
                                     i_output, 
                                     stderr=subprocess.STDOUT)
        print res

