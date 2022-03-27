public class SimpleMultithreadReturnsRunnable {

  public static Runnable getRunnable(int threadId) {
    return () -> {
      System.out.println(threadId + " running");

      try {
        System.out.println(threadId + " sleeping");
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      System.out.println(threadId + " finished");
    };
  }
}
