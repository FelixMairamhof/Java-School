package at.htlklu.threads.creation;

public class MainThread {
    public static void main(String[] args) {
        ChildThread childThread = new ChildThread();
        childThread.start();

        for (int i =0; i < 10; i++){
            System.out.println("Main Thread");
            try {
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        childThread.setRunning(false);
        System.out.println("Main Thread finished, stopping Child Thread");
    }
}
