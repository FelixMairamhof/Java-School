package at.htl.net;

import java.util.Map;

public class Protocol {

    private boolean isDisplayOn = false;
    private Map<String, Stock> stocks;

    public Protocol(Map<String, Stock> stocks) {
        this.stocks = stocks;
    }


    public String handleRequest(String request) {
        String[] tokens = request.split(" ");
        String command = tokens[0].toUpperCase();

        if(!isDisplayOn){
            if(command.equals("ON")){
                isDisplayOn = true;
                return "DISPLAY ON";
            } else {
                return "SEND ON FIRST";
            }
        }else{
            if(command.equals("OFF")){
                isDisplayOn = false;
                return "DISPLAY OFF";
            } else if(command.equals("ADD")){
                if (stocks.get(tokens[1]) != null) {
                    return "STOCK ALREADY EXISTS";
                } else {
                    String symbol = tokens[1];
                    double change = Double.parseDouble(tokens[3]);
                    String name = tokens[2];
                    int volume = Integer.parseInt(tokens[4]);
                    new Stock(symbol, change, name, volume);
                    stocks.put(symbol, new Stock(symbol, change, name, volume));
                    return "ADDED";
                }
            }else if (command.equals("SHOW")){
                StringBuilder sb = new StringBuilder();
                for (Stock stock : stocks.values()) {
                    sb.append("Symbol: ").append(stock.getSymbol())
                      .append(", Name: ").append(stock.getName())
                      .append(", Change: ").append(stock.getChange())
                      .append(", Volume: ").append(stock.getVolume())
                      .append("\r\n");
                }
                return sb.toString().trim();

            }else if (command.equals("UPDATE")){
                Stock stock = stocks.get(tokens[1]);
                if (stock != null) {
                    double change = Double.parseDouble(tokens[3]);
                    int volume = Integer.parseInt(tokens[4]);
                    String name = tokens[2].toString();
                    stock.setChange(change);
                    stock.setVolume(volume);
                    stock.setName(name);
                    return "UPDATE DONE, USE SHOW TO VERIFY";
                } else {
                    String symbol = tokens[1];
                    double change = Double.parseDouble(tokens[3]);
                    String name = tokens[2];
                    int volume = Integer.parseInt(tokens[4]);
                    new Stock(symbol, change, name, volume);
                    stocks.put(symbol, new Stock(symbol, change, name, volume));
                    return "ADDED";
                }

            }else {
                return "INVALID COMMAND";
            }
        }
    }
}
