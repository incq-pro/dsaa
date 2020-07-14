package me.zqpro.dsaa.linear.excise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeUnionSortedList {
    // a b is ordered
    public static List<Integer> merge(List<Integer> a, List<Integer> b) {
        List<Integer> ret = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < a.size() && j < b.size()) {
            if (a.get(i) > b.get(j)) {
                j++;
            } else if (a.get(i) < b.get(j)) {
                i++;
            } else {
                int m = a.get(i);
                ret.add(m);
                while (i < a.size() && a.get(i) == m) {
                    i++;
                }
                while (j < b.size() && b.get(j) == m) {
                    j++;
                }
            }
        }
        return ret;
    }

    public static List<Integer> union(List<Integer> a, List<Integer> b) {
        List<Integer> c = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < a.size() && j < b.size()) {
            int value;
            if (a.get(i) < b.get(j)) {
                value = a.get(i);
                i++;
            } else {
                value = b.get(j);
                j++;
            }
            c.add(value);
            while (i < a.size() && a.get(i) == value) {
                i++;
            }
            while (j < b.size() && b.get(j) == value) {
                j++;
            }
        }
        while (i < a.size()) {
            int value = a.get(i);
            c.add(value);
            i++;
            while (i < a.size() && a.get(i) == value) {
                i++;
            }
        }
        while (j < b.size()) {
            int value = b.get(j);
            c.add(value);
            j++;
            while (j < b.size() && b.get(j) == value) {
                j++;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> b = Arrays.asList(1, 3, 5, 5, 5, 5, 5, 5, 5, 7, 9);
        System.out.println(merge(a, b));
        System.out.println(union(a, b));
    }
}
