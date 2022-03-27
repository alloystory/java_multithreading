public class InstanceLockExample {
  private int count = 0;

  public void reset() {
    this.count = 0;
  }

  public void unsafeIncrement() {
    this.count++;
  }

  public int getCount() {
    return this.count;
  }

  // public void safeIncrement() {
  // synchronized (this) {
  // this.count++;
  // }
  // }

  public synchronized void safeIncrement() {
    this.count++;
  }
}
