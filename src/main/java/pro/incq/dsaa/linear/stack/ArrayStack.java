package pro.incq.dsaa.linear.stack;

/**
 * @author yun.516@gmail.com
 */
public class ArrayStack {
    private String[] items;
    private int size;

    public ArrayStack(int capacity) {
        items = new String[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean push(String item) {
        ensureCapacity();
        items[size++] = item;
        return true;
    }

    public String pop() {
        if (size <= 0) {
            return null;
        }
        String ret = items[size - 1];
        items[size - 1] = null;
        size--;
        return ret;
    }

    public String head() {
        if (size <= 0) {
            return null;
        }
        return items[size - 1];
    }

    private void ensureCapacity() {
        if (size == items.length) {
            String[] newItems = new String[size * 2];
            System.arraycopy(items, 0, newItems, 0, size);
            items = newItems;
        }
    }
}
