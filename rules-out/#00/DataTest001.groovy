package rules

// #### This is the first rule in the set
// The purpose of this rule is to test if the global attributes contained within the main cef file are correct

public class DataTest001 {

    def about = """ About: This is DataTest001 """

    def test(i_header_data) {
        println about 
    }
    
}
