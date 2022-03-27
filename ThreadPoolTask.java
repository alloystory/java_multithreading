public class ThreadPoolTask implements Runnable {
  private int work;

  public ThreadPoolTask(int work) {
    this.work = work;
  }

  @Override
  public void run() {
    System.out.println(work);
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
    }
  }
}
