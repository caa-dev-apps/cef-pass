package cefpass

public class App {
    boolean m1() {
        println "Hello, World!"
        true
//x         false
    }

    public void test_batch() {
        new CmdLineSamples().test_batch();
    }
    
    public static void main(String[] i_args) {
        println "Hello, World!"
    
        App a = new App();
        a.test_batch();
    }
}
