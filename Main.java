public class Main {
  private static final int NUM_THREADS = 3;

  public static void main(String[] args) {
    // runSimpleMultithreadExtendsThread();
    runSimpleMultithreadImplementsRunnable();
  }

  public static void runSimpleMultithreadExtendsThread() {
    System.out.println("running SimpleMultithreadExtendsThread");
    for (int i = 0; i < NUM_THREADS; i++) {
      SimpleMultithreadExtendsThread thread = new SimpleMultithreadExtendsThread(i);
      thread.start();
    }
  }

  public static void runSimpleMultithreadImplementsRunnable() {
    System.out.println("running SimpleMultithreadImplementsRunnable");
    for (int i = 0; i < NUM_THREADS; i++) {
      SimpleMultithreadImplementsRunnable runnable = new SimpleMultithreadImplementsRunnable(i);
      Thread thread = new Thread(runnable);
      thread.start();
    }
  }
}