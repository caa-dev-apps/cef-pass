package cefpass

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

//-----------------------------------------------------------------------------

public class XSDValidataion
{

    def static boolean validateXMLSchema(String xsdPath, String xmlPath){
        boolean l_result = false;
        try {
            SchemaFactory factory = 
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
            
            l_result = true
            
        } catch (IOException | SAXException e) {
            System.out.println("Exception: "+e.getMessage());
        }
        
        if(l_result == false) println "XML Validation Error!"
        else                  println "XML Validation OK!"
        
        return l_result
    }
}


