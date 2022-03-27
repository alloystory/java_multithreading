public class SimpleMultithreadExtendsThread extends Thread {
  private int threadId;

  public SimpleMultithreadExtendsThread(int threadId) {
    this.threadId = threadId;
  }

  @Override
  public void run() {
    System.out.println(this.threadId + " here");

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
