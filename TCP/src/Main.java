import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        int serverPort = 8080;

        ServerSocket serverSocket = new ServerSocket(serverPort);
        System.out.println("Server is running and waiting for connection");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int bytesRead = inputStream.read(buffer);
        String message = new String(buffer , 0 , bytesRead);
        System.out.println("Recieve message from client: " + message);

        socket.close();
        serverSocket.close();
    }
}

