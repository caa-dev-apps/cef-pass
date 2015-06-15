package cefpass

///////////////////////////////////////////////////////////////////////////////
//

public class DataTypes
{
    
    static def VALUE_TYPES = [
        "CHAR",
        "DOUBLE",
        "FLOAT",
        "INT",
        "ISO_TIME",
        "ISO_TIME_RANGE"
    ]

    ///////////////////////////////////////////////////////////////////////////////
    //
    

    def static isValidString(i_value)
    {
        return Utils.isQuotedString(i_value)
    }
    
    def static isValidDouble(i_value)
    {
        def r = false
        
        try {
            Double.parseDouble(i_value);
            r = true;
        } 
        catch (Exception e) { }
        
        r
    }        
    
    def static isValidFloat(i_value)
    {
        def r = false
        
        try {
            Float.parseFloat(i_value);
            r = true;
        } 
        catch (Exception e) { }
        
        r
    }
    
    def static isValidInt(i_value)
    {
        def r = false
        
        try {
            Integer.parseInt(i_value);
            r = true;
        } 
        catch (Exception e) { }
        
        r
    }
    
    def static isValidISOTime(i_value)
    {
        def r = false
        
        try {
            def i = Instant.parse(i_value)
            println i
            
            r = true;
        } 
        catch (Exception e) { println e }
        
        r
    }
    
    def static isValidISOTimeRange(i_value)
    {
        true
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    //
    
    static def isValidType(i_valueType)
    {
        i_valueType.toUpperCase() in VALUE_TYPES
    }

    // SWITCHED ORDER!!!!!!!
    static def isEntryTypeMatch(i_valueType, i_value)
    {
        def rs = false
        
        if((i_valueType != null) && (i_value != null))
        {
            def l_value_type = i_valueType.toUpperCase();
            
            if(l_value_type.equals("CHAR"))                   rs = isValidString(i_value)
            else if(l_value_type.equals("DOUBLE"))            rs = isValidDouble(i_value)
            else if(l_value_type.equals("FLOAT"))             rs = isValidFloat(i_value)
            else if(l_value_type.equals("INT"))               rs = isValidInt(i_value)
            else if(l_value_type.equals("ISO_TIME"))          rs = isValidISOTime(i_value)
            else if(l_value_type.equals("ISO_TIME_RANGE"))    rs = isValidISOTimeRange(i_value)
        }
    
        rs
    }
    
    static def isEntryTypeMatch(i_map)
    {
        println i_map
        
        isEntryTypeMismatch(i_map["ENTRY"], 
                            i_map["VALUE_TYPE"])
    }
}
