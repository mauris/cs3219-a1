/**
 * @author Yong Shan Xian
 */

package kwic.dataflow;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

class Pipe<T> {
  private Queue<T> buffer = new LinkedList<T>();

  private final Semaphore isAvailable = new Semaphore(0);
  private final Semaphore bufferSemaphore = new Semaphore(1);

  public void put(T value) {
    try {
      bufferSemaphore.acquire();
      buffer.offer(value);
      isAvailable.release();
      bufferSemaphore.release();
    } catch(InterruptedException ex) {
      System.out.println(ex);
    }
  }

  public T nextOrWait() {
    try {
      isAvailable.acquire();
      bufferSemaphore.acquire();
      T value = buffer.poll();
      bufferSemaphore.release();
      return value;
    } catch(InterruptedException ex) {
      System.out.println(ex);
    }
    return null;
  }
}
