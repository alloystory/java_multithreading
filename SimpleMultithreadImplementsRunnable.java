public class SimpleMultithreadImplementsRunnable implements Runnable {
  private int threadId;

  public SimpleMultithreadImplementsRunnable(int threadId) {
    this.threadId = threadId;
  }

  @Override
  public void run() {
    System.out.println(this.threadId + " running");

    try {
      System.out.println(this.threadId + " sleeping");
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println(this.threadId + " finished");
  }
}
