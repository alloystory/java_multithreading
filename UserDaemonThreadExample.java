public class UserDaemonThreadExample extends Thread {
  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println(String.format("isDaemon(): %b, count: %d", this.isDaemon(), i));

      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
      }
    }
  }
}
