package pro.incq.dsaa.linear.queue;

/**
 * @author yun.516@gmail.com
 */
public class CircularQueue {
    private String[] items;
    private int head;
    private int tail;

    public CircularQueue(int capacity) {
        items = new String[capacity + 1];
    }

    public int size() {
        return (tail - head + items.length) % items.length;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean enqueue(String item) {
        if ((tail + 1) % items.length == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % items.length;
        return true;
    }

    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String ret = items[head];
        // for GC
        items[head] = null;
        head = (head + 1) % items.length;
        return ret;
    }
}
