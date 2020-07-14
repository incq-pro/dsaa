package me.zqpro.dsaa.linear.queue;


/**
 * @author yun.516@gmail.com
 */
public class ArrayQueue {
    private String[] items;
    private int head;
    private int tail;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        head = 0;
        tail = 0;
    }

    public int size() {
        return tail - head;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean enqueue(String item) {
        if (tail == items.length) {
            if (head == 0) {
                return false;
            }
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        items[tail++] = item;
        return true;
    }

    public String dequeue() {
        if (isEmpty()) {
            return null;
        }
        return items[head++];
    }
}
