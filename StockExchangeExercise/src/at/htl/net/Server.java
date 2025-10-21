package at.htl.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Server {
    public static void main(String[] args) {
        final int port = 8888;

        try {
            Socket clientSocket;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            Map<String, Stock> stocks = Collections.synchronizedMap(new HashMap<>());

            while (true) {
                 clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());
                Task task = new Task(clientSocket, stocks);
                task.start();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
