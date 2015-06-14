package cefpass

///////////////////////////////////////////////////////////////////////////////
//

public class DataTypes
{
//x     enum Types {
//x         (CHAR, "CHAR"),
//x         (DOUBLE, "DOUBLE"),
//x         (FLOAT, "FLOAT"),
//x         (INT, "INT"),
//x         (ISO_TIME, "ISO_TIME"),
//x         (ISO_TIME_RANGE, "ISO_TIME_RANGE")
//x     }
    
    TYPES = [
        "CHAR",
        "DOUBLE",
        "FLOAT",
        "INT",
        "ISO_TIME",
        "ISO_TIME_RANGE"
    ]
        
    static isValidType(i_type)
    {
        i_type.toUpperCase() in TYPES
    }

    static isEntryTypeMatch(i_entry, i_value_type)
    {
        def rs = false
        if(isValidType(i_value_type)
        {
            switch(i_value_type)
            {
                case "CHAR" :
                    rs = Utils.isQuotedString(i_entry)
                break
                case "DOUBLE" :
                    rs = Utils.isValidDouble(i_entry);
                break
                case "FLOAT" :
                    rs = Utils.isValidFloat(i_entry);
                break
                case "INT" :
                    rs = Utils.isValidInt(i_entry);
                break
                case "ISO_TIME" :
                    rs = Utils.isValidISOTime(i_entry);
                break
                case "ISO_TIME_RANGE" :
                    rs = Utils.isValidISOTimeRange(i_entry;
                break
            }
        }

        rs
    }
    
    static isEntryTypeMatch(i_map)
    {
        println i_map
        
        isEntryTypeMismatch(i_map["ENTRY"], 
                            i_map["VALUE_TYPE"])
    }
}
