package main;

import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class WebRequest {
    String fileName ;

    //A constructor that accepts a string
    public WebRequest(String request){
        try{
            String lines[] = request.split("\n");
            fileName = lines[0].split(" ")[1];

            System.out.println("File name:"+fileName);
            System.out.println("Lines:"+lines[0]);
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

}
