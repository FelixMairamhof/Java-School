package at.htlklu.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

public class Task extends Thread{

    private Socket socket;
    private Map<String, String> bookings;

    public Task(Socket socket, Map<String, String> bookings) {
        this.socket = socket;
        this.bookings = bookings;
    }

    @Override
    public void run() {
        Protocol protocol = new Protocol();
        while (true){
            try (PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                 BufferedReader in = new BufferedReader( new InputStreamReader(socket.getInputStream()))){

                String request;
                while ((request = in.readLine()) != null) {
                    System.out.println("Received: " + request);
                    String response = protocol.handleRequest(request);
                    out.println(response);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
