public class ClassLockExample {
  private static int count = 0;

  public static void unsafeIncrement() {
    ClassLockExample.count++;
  }

  public static void reset() {
    ClassLockExample.count = 0;
  }

  public static int getCount() {
    return ClassLockExample.count;
  }

  public static void safeIncrement() {
    synchronized (ClassLockExample.class) {
      ClassLockExample.count++;
    }
  }
}
