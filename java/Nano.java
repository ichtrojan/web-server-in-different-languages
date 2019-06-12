import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Tunji035
 */
public class Nano {
    
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9080);
        try (Socket socket = ss.accept()) {
            socket.getOutputStream().write("Nano server running! powered by Java!".getBytes());
        }
    }
    
}
