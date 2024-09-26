import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

public class scenario1 {

    public static void main(String[] args) {
        BlockingQueue<Task> taskQueue = new LinkedBlockingQueue<>();
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        
        TaskProducer produtor0 = new TaskProducer(taskQueue);
        TaskProducer produtor1 = new TaskProducer(taskQueue);
        TaskProducer produtor2 = new TaskProducer(taskQueue);
        TaskProducer produtor3 = new TaskProducer(taskQueue);
        TaskProducer produtor4 = new TaskProducer(taskQueue);

        Node consumidor0 = new Node(taskQueue);
        Node consumidor1 = new Node(taskQueue);
        Node consumidor2 = new Node(taskQueue);

        executorService.submit(produtor0);
        executorService.submit(produtor1);
        executorService.submit(produtor2);
        executorService.submit(produtor3);
        executorService.submit(produtor4);

        executorService.submit(consumidor0);
        executorService.submit(consumidor1);
        executorService.submit(consumidor2);

    }
}
