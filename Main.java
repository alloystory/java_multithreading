public class Main {
  public static void main(String[] args) {
    // runSimpleMultithreadExtendsThread();
    // runSimpleMultithreadImplementsRunnable();
    // runSimpleMultithreadReturnsRunnable();
    // runClassLockExample();
    runInstanceLockExample();
  }

  public static void runSimpleMultithreadExtendsThread() {
    System.out.println("running SimpleMultithreadExtendsThread");
    for (int i = 0; i < 3; i++) {
      SimpleMultithreadExtendsThread thread = new SimpleMultithreadExtendsThread(i);
      thread.start();
    }
  }

  public static void runSimpleMultithreadImplementsRunnable() {
    System.out.println("running SimpleMultithreadImplementsRunnable");
    for (int i = 0; i < 3; i++) {
      SimpleMultithreadImplementsRunnable runnable = new SimpleMultithreadImplementsRunnable(i);
      Thread thread = new Thread(runnable);
      thread.start();
    }
  }

  public static void runSimpleMultithreadReturnsRunnable() {
    System.out.println("running SimpleMultithreadReturnsRunnable");
    for (int i = 0; i < 3; i++) {
      Runnable runnable = SimpleMultithreadReturnsRunnable.getRunnable(i);
      Thread thread = new Thread(runnable);
      thread.start();
    }
  }

  public static void runClassLockExample() {
    System.out.println("running ClassLockExample");
    int numThreads = 2;
    int numIncrements = 1_000_000;

    System.out.println("running unsafeIncrement, expects result = " + numThreads * numIncrements);
    Runnable unsafeRunnable = () -> {
      for (int i = 0; i < numIncrements; i++)
        ClassLockExample.unsafeIncrement();
    };
    Thread[] unsafeThreads = new Thread[numThreads];
    for (int i = 0; i < numThreads; i++) {
      unsafeThreads[i] = new Thread(unsafeRunnable);
      unsafeThreads[i].start();
    }
    for (Thread unsafeThread : unsafeThreads) {
      try {
        unsafeThread.join();
      } catch (InterruptedException e) {
      }
    }
    System.out.println("unsafeIncrement result: " + ClassLockExample.getCount());

    ClassLockExample.reset();

    System.out.println("running safeIncrement");
    Runnable safeRunnable = () -> {
      for (int i = 0; i < numIncrements; i++)
        ClassLockExample.safeIncrement();
    };
    Thread[] safeThreads = new Thread[numThreads];
    for (int i = 0; i < numThreads; i++) {
      safeThreads[i] = new Thread(safeRunnable);
      safeThreads[i].start();
    }
    for (Thread safeThread : safeThreads) {
      try {
        safeThread.join();
      } catch (InterruptedException e) {
      }
    }
    System.out.println("safeIncrement result: " + ClassLockExample.getCount());
  }

  public static void runInstanceLockExample() {
    System.out.println("running InstanceLockExample");
    int numThreads = 2;
    int numIncrements = 1_000_000;

    System.out.println("running unsafeIncrement, expects result = " + numThreads * numIncrements);
    final InstanceLockExample exampleInstance = new InstanceLockExample();
    Runnable unsafeRunnable = () -> {
      for (int i = 0; i < numIncrements; i++)
        exampleInstance.unsafeIncrement();
    };
    Thread[] unsafeThreads = new Thread[numThreads];
    for (int i = 0; i < numThreads; i++) {
      unsafeThreads[i] = new Thread(unsafeRunnable);
      unsafeThreads[i].start();
    }
    for (Thread unsafeThread : unsafeThreads) {
      try {
        unsafeThread.join();
      } catch (InterruptedException e) {
      }
    }
    System.out.println("unsafeIncrement result: " + exampleInstance.getCount());

    exampleInstance.reset();

    System.out.println("running safeIncrement");
    Runnable safeRunnable = () -> {
      for (int i = 0; i < numIncrements; i++)
        exampleInstance.safeIncrement();
    };
    Thread[] safeThreads = new Thread[numThreads];
    for (int i = 0; i < numThreads; i++) {
      safeThreads[i] = new Thread(safeRunnable);
      safeThreads[i].start();
    }
    for (Thread safeThread : safeThreads) {
      try {
        safeThread.join();
      } catch (InterruptedException e) {
      }
    }
    System.out.println("safeIncrement result: " + exampleInstance.getCount());
  }
}