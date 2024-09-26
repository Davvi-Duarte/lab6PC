import java.util.Date;
import java.util.Random;

public class Task {
    private long id;

    private Date tempoInicio;

    public Task(long id) {
        this.id = id;
        this.tempoInicio = new Date();
    }

    public long getId() { return this.id; }

    public Date getTempoInicio() { return this.tempoInicio; }

    public void execute() {
        try {
            // generating a number between 1000 and 15000
            long execDuration = 1000 + (long) (new Random().nextFloat() * (15000 - 1000));
            Thread.sleep(execDuration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
