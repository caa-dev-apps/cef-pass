package rules

public class Manifest {

    def about() {
        """
            This is the main groovy manifest file
        """
    }

    def rules = [
        header: [
            HeaderTest001,
            HeaderTest002,
            HeaderTest003
        ],
        data: [
            DataTest001,
            DataTest002,
            DataTest003
        ]
    ]
        
        
    def run() {
    
        println "header rules:"
    
        rules.header.each {
            it.newInstance().test()
        }
        
        println "data rules:"
        
        rules.data.each {
            it.newInstance().test()
        }
    }
        
        
    public static void main(String[] i_args) {
        println "Hello, World!"
    
        Manifest m = new Manifest();
        println m.run()
        
        
        
        
    }        
}



