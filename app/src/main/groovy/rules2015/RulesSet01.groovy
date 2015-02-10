package rules2015



public class RulesSet01
{

    // ##  Rule:              1.00
    // ##  Scope:             GLOBAL
    // ##  Keyword:           FILE_NAME
    // ##  Data.type:         METADATA
    // ##  Cardinality:       1
    // ##  Description:       Name of file on disk equals FILE_NAME
    // ##  Error.Type:        Fatal Error
    // ##  Error.Message:     Filename and metadata filename do not match
    // ##  Caveats:           Within Double Quotes

    def Rule_1_00()
    {
    }



    // ##  Rule:              1.01
    // ##  Scope:             GLOBAL
    // ##  Keyword:           FILE_NAME
    // ##  Data.type:         METADATA
    // ##  Cardinality:       1
    // ##  Description:       Must exist
    // ##  Error.Type:        Fatal Error
    // ##  Error.Message:     Missing FILE_NAME
    // ##  Caveats:           Within Double Quotes

    def Rule_1_01()
    {
    }



    // ##  Rule:              1.02
    // ##  Scope:             GLOBAL
    // ##  Keyword:           FILE_FORMAT_VERSION
    // ##  Data.type:         METADATA
    // ##  Cardinality:       1
    // ##  Description:       Must exist
    // ##  Error.Type:        Fatal Error
    // ##  Error.Message:     Missing FILE_FORMAT_VERSION
    // ##  Caveats:           Within Double Quotes

    def Rule_1_02()
    {
    }



    // ##  Rule:              1.03
    // ##  Scope:             GLOBAL
    // ##  Keyword:           END_OF_RECORD_MARKER
    // ##  Data.type:         METADATA
    // ##  Cardinality:       1
    // ##  Description:       Must exist BUT may be blank
    // ##  Error.Type:        Fatal Error
    // ##  Error.Message:     Missing END_OF_RECORD_MARKER
    // ##  Caveats:           Within Double Quotes

    def Rule_1_03()
    {
    }



    // ##  Rule:              1.04
    // ##  Scope:             GLOBAL
    // ##  Keyword:           INCLUDE
    // ##  Data.type:         METADATA
    // ##  Cardinality:       0..n
    // ##  Description:       All include files must exist
    // ##  Error.Type:        Warning
    // ##  Error.Message:     Include file may not exist, but all required metadata may exist in other files?
    // ##  Caveats:           Within Double Quotes

    def Rule_1_04()
    {
    }


    public def rules()
    {
        println("Hello, World!")
        println("def rules_01()")
    }
}





















