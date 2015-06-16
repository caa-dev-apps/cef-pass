package cefpass

import java.time.Instant
 
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
            //x println i
            r = true;
        } 
        catch (Exception e) { }
        
        r
    }
    
    // e.g. "2011-10-09T00:00:00Z/2011-10-10T00:00:00Z"
    def static isValidISOTimeRange(i_value)
    {
        def r = false
        
        try {
            def ix = i_value.indexOf("/")
            
            if(ix > 0) {
                r = isValidISOTime(i_value.substring(0, ix)) && 
                    isValidISOTime(i_value.substring(ix + 1)) 
            }
        } 
        catch (Exception e) { println e }
    
        r
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

