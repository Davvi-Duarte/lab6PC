import java.util.Date;
import java.util.Random;

public class Task implements Comparable<Task> {
    private long id;

    private int priority;

    private Date tempoInicio;

    public Task(long id, int priority) {
        this.id = id;
        this.priority = priority;
        this.tempoInicio = new Date();
    }

    public long getId() { return this.id; }

    public Date getTempoInicio() { return this.tempoInicio; }

    public int getPriority() { return this.priority; }

    public void execute() {
        try {
            // generating a number between 1000 and 15000
            long execDuration = 1000 + (long) (new Random().nextFloat() * (15000 - 1000));
            Thread.sleep(execDuration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(Task comparing) {
        return Integer.compare(this.priority, comparing.getPriority());
    }
}
