package at.htlklu.threads.coruption;

public class MainThread {
    public static void main(String[] args) throws InterruptedException {
        StringBuilder appendedName = new StringBuilder();

        CorruptThreadStringBuilder thread1 = new CorruptThreadStringBuilder(appendedName, "Ruben", 1000);
        thread1.start();
        CorruptThreadStringBuilder thread2 = new CorruptThreadStringBuilder(appendedName, "Oobas", 1000);
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("Länge: " + appendedName.length());
    }
}
