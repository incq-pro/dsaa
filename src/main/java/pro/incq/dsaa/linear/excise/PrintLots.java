package pro.incq.dsaa.linear.excise;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class PrintLots {
    public static void printLots(Collection<Integer> l, Collection<Integer> p) {
        int li = -1;
        Iterator<Integer> iter = l.iterator();
        for(Integer pi : p) {
            while (iter.hasNext()) {
                Integer item = iter.next();
                if (++li == pi) {
                    System.out.println(item);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Collection<Integer> l = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Collection<Integer> p = Arrays.asList(1, 3, 5, 7);
        printLots(l, p);
    }
}
