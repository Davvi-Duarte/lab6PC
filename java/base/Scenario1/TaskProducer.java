import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class TaskProducer implements Runnable {

    BlockingQueue<Task> taskPool;

    public TaskProducer(BlockingQueue<Task> taskPool) {
        this.taskPool = taskPool;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(5000);
                taskPool.add(new Task(1000 + (long) (new Random().nextFloat() * (15000 - 1000))));
            }
        } catch (InterruptedException ex) {
            // TODO: handle exception
        }
    }
}