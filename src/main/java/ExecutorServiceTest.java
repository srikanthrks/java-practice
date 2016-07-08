import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by srikanth.kannan on 2/23/16.
 */
public class ExecutorServiceTest {

    public static void main(String args[]){
        new ExecutorServiceTest().testExecutorService();

    }//main

    private void testExecutorService() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Runnable myThread = new ExecutorThreadRunnable("thread1", 10, 2500L);
        executorService.submit(myThread);
        executorService.submit(new ExecutorThreadRunnable("thread2", 10, 2500L));
        executorService.shutdown();
        try {
            executorService.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        } finally {
            if (!executorService.isTerminated()) {
                System.out.println(">>>>> Not all tasks are terminated");
                List<Runnable> runnableList = executorService.shutdownNow();
                System.out.println("threads awaiting termination = " + runnableList);
            } else {
                System.out.println("All tasks are terminated");
            }
        }
    }

    private class ExecutorThreadRunnable implements Runnable {
        String name;
        int count;
        long timeToSleep;
        public ExecutorThreadRunnable(String name, int count, long timeToSleep) {
            this.name = name;
            this.count = count;
            this.timeToSleep = timeToSleep;
        }

        @Override
        public void run() {
            long startTime = System.currentTimeMillis();
            int total = 0;
            for(int i = 1; i <= this.count; i++){
                total = total + 1;
            }
            System.out.println(this.name + " has sum = " + total +
                    " and is sleeping for " + (float) this.timeToSleep/1000 + " seconds");
            try{
                System.out.println(".");
                Thread.sleep(this.timeToSleep);
            }catch(InterruptedException ie){
                long stopTime = System.currentTimeMillis();
                System.out.println(this.name + "'s sleep interrupted in " +
                        (float) (stopTime-startTime)/1000 + " seconds");
            }
        }
    }//ExecutorThreadRunnable
}
