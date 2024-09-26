import java.util.Date;
import java.util.concurrent.BlockingQueue;

public class Node implements Runnable {

  BlockingQueue<Task> queue;

  public Node(BlockingQueue<Task> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    try {
      while (true) {
        Task task = queue.take();
        // tempo inicio
        task.execute();
        Date tempoFinal = new Date();
        System.out.println("TASK CONSUMIDA: " + task.getId());
        System.out.println("TEMPO DE VIDA DA TASK: " + (tempoFinal.getTime() - task.getTempoInicio().getTime()) + " ms\n");
      }
    } catch (Exception e) {
      // TODO: handle exception
    }
  }
}
