package kwic.dataflow;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

class Pipe<T> {
  private Queue<T> buffer = new LinkedList<T>();

  private final Semaphore isAvailable = new Semaphore(0);

  public synchronized void put(T value) {
    buffer.offer(value);
    isAvailable.release();
  }

  public T nextOrWait() {
    try {
      isAvailable.acquire();
      T value = buffer.poll();
      return value;
    } catch(InterruptedException ex) {

    }
    return null;
  }
}
