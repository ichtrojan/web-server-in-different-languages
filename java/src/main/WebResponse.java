package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class WebResponse {
    WebRequest webRequest;

    String response = "";

    //Root path of the server
    String root;
    public WebResponse(WebRequest webRequestSent) {
        this.webRequest = webRequestSent;

        root = System.getProperty("user.dir");
        FileInputStream fileInputStream;
        try {
            File f = new File(root + webRequestSent.fileName);
            fileInputStream = new FileInputStream(f);

            ResponseHeader responseHeader =  new ResponseHeader(f, "200");
            response += responseHeader;

            int s;
            while ((s = fileInputStream.read()) != -1) {
                response += (char) s;
            }
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            File f = new File(root + "/404.html");
            try {
                fileInputStream = new FileInputStream(f);
                ResponseHeader responseHeader =  new ResponseHeader(f, "404");
                response += responseHeader;

                int s;
                while ((s = fileInputStream.read()) != -1) {
                    response += (char) s;
                }
                fileInputStream.close();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }catch (IOException io){

            }
        } catch (Exception e) {
            response += response.replace("200", "500");
        }
    }

    // return supported MIME Types
    private String getMimeType(String requestedFile) {
        if (requestedFile.endsWith(".htm")  ||  requestedFile.endsWith(".html"))
            return "text/html";
        else
            return "text/plain";
    }

    private byte[] getFileData(File file, int fileLength) throws IOException {
        FileInputStream fileIn = null;
        byte[] fileData = new byte[fileLength];

        try {
            fileIn = new FileInputStream(file);
            fileIn.read(fileData);
        } finally {
            if (fileIn != null)
                fileIn.close();
        }

        return fileData;
    }
}
