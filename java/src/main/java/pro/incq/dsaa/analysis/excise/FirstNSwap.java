package pro.incq.dsaa.analysis.excise;

import java.util.Arrays;
import java.util.Random;

public class FirstNSwap {

    private static final Random random = new Random(System.currentTimeMillis());

    public static void fill1(int[] a) {
        for (int i = 0; i < a.length; i++) {
            boolean found = false;
            do {
                int r = random.nextInt(a.length) + 1;
                found = false;
                for (int j = 0; j < i; j++) {
                    if (a[j] == r) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    a[i] = r;
                }
            } while (found);
        }
    }

    public static void fill2(int[] a) {
        int[] used = new int[a.length];
        for(int i = 0; i < a.length; i++) {
            for(;;) {
                int r = random.nextInt(a.length) + 1;
                if (used[r - 1] == 0) {
                    a[i] = r;
                    used[r - 1] = 1;
                    break;
                }
            }
        }
    }

    public static void fill3(int[] a) {
        for(int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }
        for(int i = 0; i < a.length; i++) {
            int r = random.nextInt(i + 1);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void main(String[] args) {
        for (Integer i : Arrays.asList(250, 500, 1000, 2000, 4000, 8000)) {
            test(i / 100, 3);
        }
    }

    public static void test(int n, int f) {
        System.out.println("n: " + n);
        int[] a = new int[n];

        long last = System.currentTimeMillis();
        switch (f) {
            case 1:
                fill1(a);
                break;
            case 2:
                fill2(a);
                break;
            case 3:
                fill3(a);
                break;
        }
        long now = System.currentTimeMillis();
        System.out.println(now - last);
        System.out.println(Arrays.toString(a));
    }
}
