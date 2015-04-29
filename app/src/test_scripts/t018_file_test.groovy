


//x File l_file = new File("C:\\work.dev\\2015.03.22 github cef pass v2\\v0\\cef-pass\\app\\src\\test\\resources\\R_0_41___INCLUDE_FILE_UNFOUND\\C3_CP_EDI_EGD__20111009_V01.cef");
//x 
//x println l_file.getAbsolutePath()
//x println l_file.getParent()


def test_string_quotes(k,v)
{
    def res = "ERROR"
    if(v != null)
    {
        def l = v.size()
        if(l > 0)
        {
            def c1 = v[0]
            def c2 = v[l-1]
            
            if((((c1 == '\'') || (c1 == '\"') || (c2 == '\'') || (c2 == '\"'))  && ((c1 != c2) || (l == 1))) == false)
            {
                res = "OK"
            }
        }
    }
    
    println v + " : " + res 
}

def strs = [
    "Hello, World!",
    "\"Hello, World!",
    "Hello, World!\"",
    "\'Hello, World!",
    "Hello, World!\'",
    "",
    "\'",
    "\"",
    "\"1",
    "\'3",
    "\"1\"",
    "\'3\'",
]

strs.each { 
    //x println it
    test_string_quotes("-", it)
}
