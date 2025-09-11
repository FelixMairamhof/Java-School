package at.htlklu;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        final int port = 8080;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();

            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(os), true);
            String line;
            while ((line = in.readLine()) != null) {
                    System.out.printf("Server received: %s %n", line);
                    out.println("Echo: " + line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
    }

    }
}
