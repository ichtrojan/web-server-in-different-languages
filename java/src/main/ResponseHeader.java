package main;

import java.io.File;
import java.util.Date;

public class ResponseHeader {

    String responseCode;
    String responseBody;
    File fileContent;

    public ResponseHeader(File fileContent, String responseCode) {
        this.fileContent = fileContent;
        this.responseCode = responseCode;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    @Override
    public String toString() {
       String responseBody = "HTTP/1.1"+ responseCode +" OK \r\n";
        responseBody += "Access-Control-Allow-Origin: * \r\n";
        responseBody += "Content-Type: text/html; charset=utf-8 \r\n";
        responseBody += "Content-Length:" + fileContent.length() + " \r\n";
        responseBody += "Connection: close \r\n";
        responseBody += "Date: " + new Date().toString() + "\r\n";
        responseBody += "\r\n";

        return responseBody;

    }
}
