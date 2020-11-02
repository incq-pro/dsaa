package pro.incq.dsaa.hash;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @author yun.516@gmail.com
 */
public class MyHashMap<K, V> {

    private LinkedList<Entry<K, V>>[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        data = new LinkedList[16];
    }

    public V put(K k, V v) {
        Objects.requireNonNull(k);
        Objects.requireNonNull(v);
        ensureCapacity(size + 1);
        return doPut(k, v);
    }

    private V doPut(K k, V v) {
        int h = hash(k.hashCode());
        LinkedList<Entry<K, V>> entries = data[h];
        if (entries == null) {
            entries = new LinkedList<>();
            entries.add(new Entry<>(k, v));
            data[h] = entries;
            ++size;
            return null;
        }
        for (Entry<K, V> entry : entries) {
            if (entry.k.equals(k)) {
                V ret = entry.v;
                entry.v = v;
                return ret;
            }
        }
        entries.add(new Entry<>(k, v));
        ++size;
        return null;
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity(int capacity) {
        if (size >= capacity) {
            return;
        }
        if (data == null) {
            data = new LinkedList[capacity];
            return;
        }
        LinkedList<Entry<K, V>>[] old = data;
        data = new LinkedList[capacity];
        for (LinkedList<Entry<K, V>> l : old) {
            if (l == null) {
                continue;
            }
            for (Entry<K, V> entry : l) {
                doPut(entry.k, entry.v);
            }
        }
    }

    public V get(K k) {
        if (k == null) {
            return null;
        }
        int h = hash(k.hashCode());
        LinkedList<Entry<K, V>> l = data[h];
        if (l == null) {
            return null;
        }
        for (Entry<K, V> entry : l) {
            if (entry.k.equals(k)) {
                return entry.v;
            }
        }
        return null;
    }

    public void remove(K k) {
        if (k == null) {
            return;
        }
        int h = hash(k.hashCode());
        LinkedList<Entry<K, V>> l = data[h];
        if (l == null) {
            return;
        }
        Iterator<Entry<K, V>> iter = l.iterator();
        while (iter.hasNext()) {
            Entry<K, V> v = iter.next();
            if (v.k.equals(k)) {
                iter.remove();
                --size;
                return;
            }
        }
    }

    private int hash(int h) {
        return h % data.length;
    }


    private static class Entry<K, V> {
        final K k;
        V v;
        Entry<K, V> next;


        public Entry(K k, V v) {
            this.k = k;
            this.v = v;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Entry) {
                if (this == o) {
                    return true;
                }
                Entry<K, V> other = (Entry<K, V>) o;
                return k.equals(other.k) && v.equals(other.v);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return k.hashCode() + v.hashCode();
        }
    }
}
