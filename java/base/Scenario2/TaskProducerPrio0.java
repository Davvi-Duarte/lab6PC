import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class TaskProducerPrio0 implements Runnable {

    BlockingQueue<Task> taskPool;

    public TaskProducerPrio0(PriorityBlockingQueue<Task> taskPool) {
        this.taskPool = taskPool;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(13000);
                taskPool.add(new Task(1000 + (long) (new Random().nextFloat() * (15000 - 1000)), 0));
            }
        } catch (InterruptedException ex) {
            // TODO: handle exception
        }
    }
}