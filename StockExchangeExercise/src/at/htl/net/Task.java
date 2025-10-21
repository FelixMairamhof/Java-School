package at.htl.net;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Task extends  Thread{

    Socket socket;
    Map<String, Stock> stocks;
    public Task(Socket socket, Map<String, Stock> stocks) {
        this.socket = socket;
        this.stocks = stocks;
    }

    @Override
    public void run() {
        System.out.println("Task running in thread: " + Thread.currentThread().getName());

        try(PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));){

            String request;
            String response;
            Protocol protocol = new Protocol(stocks);

            while ((request = in.readLine()) != null) {
                System.out.println("Received from client: " + request);
                response = protocol.handleRequest(request);
                out.println(response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
