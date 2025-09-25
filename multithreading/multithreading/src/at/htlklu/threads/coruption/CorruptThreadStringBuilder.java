package at.htlklu.threads.coruption;

public class CorruptThreadStringBuilder extends Thread{
    private StringBuilder appendName;
    private String name;
    private int runs;
    public CorruptThreadStringBuilder(StringBuilder appendName, String name, int runs) {
        this.appendName = appendName;
        this.name = name;
        this.runs = runs;
    }
    @Override
    public void run() {
        //DANGEROUS CODE but if we use synchronized(appendName) { ... } it would be safe or just use StringBuffer
            for (int i = 0; i < runs; i++) {
                synchronized (appendName) {
                    appendName.append(name);
                }
            }
    }
}
