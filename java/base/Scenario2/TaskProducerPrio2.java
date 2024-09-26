import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class TaskProducerPrio2 implements Runnable {

    BlockingQueue<Task> taskPool;

    public TaskProducerPrio2(BlockingQueue<Task> taskPool) {
        this.taskPool = taskPool;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(3000);
                taskPool.add(new Task(1000 + (long) (new Random().nextFloat() * (15000 - 1000)), 2));
            }
        } catch (InterruptedException ex) {
            // TODO: handle exception
        }
    }
}