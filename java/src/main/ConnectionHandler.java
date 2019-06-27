package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectionHandler extends Thread {//This class is a thread

    Socket socket;

    PrintWriter printWriter;

    BufferedReader bufferedReader;

    //this constructor accepts a socket
    public ConnectionHandler(Socket socketSent) throws  Exception{

        this.socket = socketSent;
        this.bufferedReader =  new BufferedReader(new InputStreamReader(socketSent.getInputStream()));
        this.printWriter = new PrintWriter(socketSent.getOutputStream());

    }

    //a thread class always contains a run() method to start the thread
    @Override
    public void run() {
        try{
            String req = "";

            while(bufferedReader.ready() || req.length() == 0)
                req += (char) bufferedReader.read();
            System.out.println(req);
            WebRequest webRequest = new WebRequest(req);

            WebResponse webResponse = new WebResponse(webRequest);

            printWriter.write(webResponse.response.toCharArray());

            printWriter.close();
            bufferedReader.close();
            socket.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
