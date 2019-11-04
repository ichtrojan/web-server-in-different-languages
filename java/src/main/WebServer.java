package main;


import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    ServerSocket serverSocket;


    public static void main(String [] args) throws Exception{
        new WebServer().startServer();
    }

    public void startServer() throws Exception{
        serverSocket = new ServerSocket(10010);

        acceptRequests();
    }

    private void acceptRequests() throws Exception{
        while(true){//We have to accept all requests
            Socket s = serverSocket.accept();
            ConnectionHandler connectionHandler = new ConnectionHandler(s);
            connectionHandler.start();// this will call the run() method
        }
    }
}
