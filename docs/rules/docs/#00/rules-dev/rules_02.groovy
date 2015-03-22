##  Rule:              2.00
##  Scope:             GENERAL
##  Keyword:           START_META/END_META
##  Data.type:         METADATA
##  Cardinality:       NA
##  Description:       All START_META must have END_META
##  Error.Type:        Fatal Error
##  Error.Message:     Syntax error – START_META/ END_META mismatch
##  Caveats:           NA

def Rule_2_00()
{
}


##  Rule:              2.01
##  Scope:             GENERAL
##  Keyword:           START_META/END_META
##  Data.type:         METADATA
##  Cardinality:       NA
##  Description:       Must have ENTRY= field
##  Error.Type:        Fatal Error
##  Error.Message:     VARIABLE <x> EMPTY
##  Caveats:           NA

def Rule_2_01()
{
}


##  Rule:              2.02
##  Scope:             GENERAL
##  Keyword:           START_META/END_META
##  Data.type:         METADATA
##  Cardinality:       NA
##  Description:       If VALUE_TYPE provided, value must be of type indicated
##  Error.Type:        Fatal Error
##  Error.Message:     VARIABLE <x> VALUE DOES NOT MATCH TYPE
##  Caveats:           NA

def Rule_2_02()
{
}


##  Rule:              2.03
##  Scope:             GENERAL
##  Keyword:           START_META/END_META
##  Data.type:         METADATA
##  Cardinality:       1
##  Description:       REQUIRED VARIABLES (below)
##  Error.Type:        Fatal Error
##  Error.Message:     MISSING <x> VARIABLE
##  Caveats:           NA

def Rule_2_03()
{
}


##  Rule:              2.04
##  Scope:             GENERAL
##  Keyword:           FILE_TYPE
##  Data.type:         METADATA
##  Cardinality:       1
##  Description:       must be cef
##  Error.Type:        Fatal Error
##  Error.Message:     FILE_TYPE is not CEF, unable to validate non CEF files
##  Caveats:           NA

def Rule_2_04()
{
}


##  Rule:              2.05
##  Scope:             GENERAL
##  Keyword:           DATASET_VERSION
##  Data.type:         METADATA
##  Cardinality:       1
##  Description:       must be valid integer
##  Error.Type:        Fatal Error
##  Error.Message:     Invalid value
##  Caveats:           NA

def Rule_2_05()
{
}


##  Rule:              2.06
##  Scope:             GENERAL
##  Keyword:           LOGICAL_FILE_ID
##  Data.type:         METADATA
##  Cardinality:       1
##  Description:       Same as Filename without extension
##  Error.Type:        Fatal Error?
##  Error.Message:     Logical File ID does not match filename
##  Caveats:           NA

def Rule_2_06()
{
}


##  Rule:              2.07
##  Scope:             GENERAL
##  Keyword:           VERSION_NUMBER
##  Data.type:         METADATA
##  Cardinality:       1
##  Description:       VERSION_NUMBER must match version number in filename
##  Error.Type:        Fatal Error
##  Error.Message:     VERSION_NUMBER does not match version in filename
##  Caveats:           NA

def Rule_2_07()
{
}


##  Rule:              2.08
##  Scope:             GENERAL
##  Keyword:           VERSION_NUMBER
##  Data.type:         METADATA
##  Cardinality:       1
##  Description:       must be valid integer
##  Error.Type:        Fatal Error
##  Error.Message:     Invalid value
##  Caveats:           NA

def Rule_2_08()
{
}


##  Rule:              2.09
##  Scope:             GENERAL
##  Keyword:           FILE_TIME_SPAN
##  Data.type:         METADATA
##  Cardinality:       1
##  Description:       must be ISO_TIME_RANGE
##  Error.Type:        Fatal Error
##  Error.Message:     VARIABLE <x> Invalid Format
##  Caveats:           NA

def Rule_2_09()
{
}


##  Rule:              2.10
##  Scope:             GENERAL
##  Keyword:           FILE_TIME_SPAN
##  Data.type:         METADATA
##  Cardinality:       1
##  Description:       START_TIME must be before STOP TIME
##  Error.Type:        Fatal Error
##  Error.Message:     VARIABLE <x> Start Time must be before Stop time
##  Caveats:           NA

def Rule_2_10()
{
}


##  Rule:              2.11
##  Scope:             GENERAL
##  Keyword:           FILE_TIME_SPAN
##  Data.type:         METADATA / DATA
##  Cardinality:       1
##  Description:       Timespan of data RECORDS must be between FILE_TIME_SPAN
##  Error.Type:        Fatal Error
##  Error.Message:     Data outside FILE_TIME_SPAN
##  Caveats:           NA

def Rule_2_11()
{
}



