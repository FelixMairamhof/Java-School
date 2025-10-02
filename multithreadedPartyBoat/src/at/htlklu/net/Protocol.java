package at.htlklu.net;

import java.util.Map;
import java.util.stream.Collectors;

public class Protocol {
    private Map<String, String> bookings;

    public String handleRequest(String request){
        String[] tokens = request.split(";");
        String command = tokens[0].toUpperCase();
        String response;
        switch (command) {
            case "BOOK":
                if(bookings.get(tokens[1]) == null){
                    bookings.put(tokens[1], tokens[2]);
                    response = String.format("%s;%s", tokens[1], tokens[2]);
                }else{
                    response = String.format("%s is not available", tokens[1]);
                }
                break;
            case "CHECK":
                if(bookings.get(tokens[1]) == null){
                    response = String.format("%s is available", tokens[1]);
                }else{
                    response = String.format("%s is not available", tokens[1]);
                }
                break;
            case "LIST":
                response = bookings.entrySet().stream().map(e -> e.getKey() + ":" + e.getValue()).collect(Collectors.joining(";"));
                break;
            default:
                response = "Invalid command!";
        }

        return response;
    }

}
