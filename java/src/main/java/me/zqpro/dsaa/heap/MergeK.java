package me.zqpro.dsaa.heap;

/**
 * @author yun.516@gmail.com
 */
public class MergeK {
    public int[] merge(int[][] datas) {
        int total = 0;
        for (int[] data : datas) {
            total += data.length;
        }
        int[] ret = new int[total];
        final int n = datas.length;
        SmallHeap<Node> h = new SmallHeap<>(n);
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            int[] data = datas[i];
            h.add(new Node(data[0], i));
            index[i]++;
        }
        int k = 0;
        while (h.size() > 0) {
            Node s = h.popHead();
            ret[k++] = s.val;
            if (index[s.i] < datas[s.i].length) {
                h.add(new Node(datas[s.i][index[s.i]], s.i));
                index[s.i]++;
            } else {
                for (int i = 0; i < n; i++) {
                    if (index[i] < datas[i].length) {
                        h.add(new Node(datas[i][index[i]], i));
                        index[i]++;
                        break;
                    }
                }
            }
        }

        return ret;
    }

    private static class Node implements Comparable<Node> {
        int val;
        int i;

        Node(int val, int i) {
            this.val = val;
            this.i = i;
        }

        @Override
        public int compareTo(Node o) {
            int v = this.val - o.val;
            if (v != 0) {
                return v;
            }
            return this.i = o.i;
        }
    }
}
