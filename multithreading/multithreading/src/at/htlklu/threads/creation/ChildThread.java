package at.htlklu.threads.creation;

public class ChildThread extends Thread {

    public void setRunning(boolean running) {
        this.running = running;
    }

    private boolean running = true;

    @Override
    public void run() {
        while (running){
            System.out.println("\tChild Thread");
            try {
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\tChild Thread finished");
    }
}
