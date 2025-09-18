package at.htlklu;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class PartyBoat {
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

            //BOOK;C4;Alexander
            String[] tokens;
            String command;
            String answer = "Unknown command";
            Map<String, String> bookings = new HashMap<>();


            if (socket.isConnected()) {
                System.out.println("Client connected");
                out.println("Connection established");
            }

            while ((line = in.readLine()) != null) {
                tokens = line.split(";");
                command = tokens[0].toUpperCase();

                switch (command) {
                    case "BOOK":
                        answer = bookings.put(tokens[1], tokens[2]) == null ? "Booking successful" : "Seat already booked";
                        break;
                    case "CHECK":
                        answer = bookings.get(tokens[1]);
                        break;
                    case "LIST":
                        answer = bookings.toString();
                        break;
                    default:
                        answer = "Invalid command";

                }

                out.println(answer);
            }
            System.out.println("Client disconnected");
        } catch (IOException e) {
            throw new RuntimeException(e);
    }

    }
}
