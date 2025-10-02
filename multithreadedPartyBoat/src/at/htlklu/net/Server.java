package at.htlklu.net;

import java.io.IOException;
import java.net.*;
import java.util.*;


public class Server {
    public static void main(String[] args) {
        final int PORT = 8888;

        Socket socket;
        try {
            Map<String, String> bookings =  Collections.synchronizedMap(new HashMap<>());

            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            while (true){
                socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress());
                Task task = new Task(socket, bookings);
                task.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
