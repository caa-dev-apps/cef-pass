@Grapes(
	@Grab(group='org.springframework', module='spring-core', version='4.1.6.RELEASE')
)

import java.io.File
import org.springframework.util.ResourceUtils


//x Spring has some handy utils so you don't have that spaces problem:
//x 
//x ResourceUtils.getFile(this.getClass().getResource("/filename.txt"))

//x //x package cefpass
//x @Grab(group='joda-time', module='joda-time', version='2.3')
//x @Grab('org.springframework:spring-orm:3.2.5.RELEASE')


///////////////////////////////////////////////////////////////////////////////
//

public class Utils
{
    static def fileExists(i_path)          { File f = new File(i_path); (f != null && f.isFile()) }
    static def directoryExists(i_path)     { File f = new File(i_path); (f != null && f.isDirectory()) }

    static def fileExistsS(i_path)         { fileExists(i_path)         ? "OK" : "NOT FOUND" }
    static def directoryExistsS(i_path)    { directoryExists(i_path)    ? "OK" : "NOT FOUND" }
    
}

def str = "Hello, World!"

def l_p0 = "file:/C:/work.dev/2015.03.22 github cef pass v2/v0/cef-pass/app/build/resources/test/RuleSet00_00/C3_CP_EDI_EGD__20111009_V01.cef"
//x def l_p0 = "file://C:/work.dev/2015.03.22 github cef pass v2/v0/cef-pass/app/build/resources/test/RuleSet00_00/C3_CP_EDI_EGD__20111009_V01.cef"
def l_p1 = "file:/C:/work.dev/2015.03.22%20github%20cef%20pass%20v2/v0/cef-pass/app/build/resources/test/RuleSet00_00/C3_CP_EDI_EGD__20111009_V01.cef"
def l_p2 = l_p1.substring(6)


//x URL url = this.getClass().getResource("/test.wsdl");
//x File testWsdl = new File(url.getFile());
URL l_u1 = new URL("file:///C:/work.dev/2015.03.22%20github%20cef%20pass%20v2/v0/cef-pass/app/build/resources/test/RuleSet00_00/C3_CP_EDI_EGD__20111009_V01.cef")

println "l_u1.getFile:      " + l_u1.getFile()
println "l_u1.getPath:      " + l_u1.getPath()

println "l_u1.toURI:        " + l_u1.toURI()
println "toExternalForm:    " + l_u1.toExternalForm()
println "l_u1.getPath:      " + l_u1.getPath()


println "l_p0 exists:       " + Utils.fileExistsS(l_u1.getFile())
println "l_p1 exists:       " + Utils.fileExistsS(l_p1)
println "l_p2 exists:       " + Utils.fileExistsS(l_p2)


