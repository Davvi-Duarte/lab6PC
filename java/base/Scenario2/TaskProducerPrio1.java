import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class TaskProducerPrio1 implements Runnable {

    BlockingQueue<Task> taskPool;

    public TaskProducerPrio1(BlockingQueue<Task> taskPool) {
        this.taskPool = taskPool;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(7000);
                taskPool.add(new Task(1000 + (long) (new Random().nextFloat() * (15000 - 1000)), 1));
            }
        } catch (InterruptedException ex) {
            // TODO: handle exception
        }
    }
}