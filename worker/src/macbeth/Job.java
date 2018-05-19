package macbeth;

import java.util.Random;

public class Job extends Thread {

    private int jobSize;

    public Job(int jobSize, String name) {
        super(name);
        this.jobSize = jobSize;
    }

    public void doWork() {
        Random random = new Random();
        for (int i=0; i<jobSize; i++) {
            System.out.println("Building object " + i + " for " + getName());
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void run() {
        doWork();
    }

    public static void main(String[] args) {
        Job job1 = new Job(10, "Job #1");
        Job job2 = new Job(20, "Job #2");

        job1.start();
        job2.start();
    }
}
