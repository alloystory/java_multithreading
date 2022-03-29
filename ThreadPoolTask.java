import java.util.concurrent.Callable;

public class ThreadPoolTask implements Callable<Void> {
  private int work;

  public ThreadPoolTask(int work) {
    this.work = work;
  }

  @Override
  public Void call() {
    System.out.println(work);
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
    }

    return null;
  }
}
