import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class Scenario2 {

    public static void main(String[] args) {
        PriorityBlockingQueue<Task> taskQueue = new PriorityBlockingQueue<Task>();
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        
        TaskProducerPrio0 produtor0 = new TaskProducerPrio0(taskQueue);
        TaskProducerPrio1 produtor1 = new TaskProducerPrio1(taskQueue);
        TaskProducerPrio2 produtor2 = new TaskProducerPrio2(taskQueue);

        Node consumidor0 = new Node(taskQueue);
        Node consumidor1 = new Node(taskQueue);
        Node consumidor2 = new Node(taskQueue);

        executorService.submit(produtor0);
        executorService.submit(produtor1);
        executorService.submit(produtor2);

        executorService.submit(consumidor0);
        executorService.submit(consumidor1);
        executorService.submit(consumidor2);

    }
}
