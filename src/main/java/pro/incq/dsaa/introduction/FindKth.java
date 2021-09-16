package pro.incq.dsaa.introduction;

import java.util.Arrays;
import java.util.Random;

/**
 * excise 1.1
 */
public class FindKth {
    private static final Random random = new Random(System.currentTimeMillis());

    private static int[] genRandomNumbers(int n) {
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = random.nextInt();
        }
        return numbers;
    }

    public static int findKth(int[] numbers, int k) {
        Arrays.sort(numbers);
        return numbers[k];
    }

    public static void main(String[] args) {
        int max = 100000000;
        int[] baseNumbers = genRandomNumbers(max);
        int sum = 0;
        for (int i = 1; i < 100; i++) {
            int count = i * 10;
            int k = count / 2;
            int[] numbers = new int[count];
            System.arraycopy(baseNumbers, 0, numbers, 0, count);
            sum += findKth(numbers, k);
        }
        for (int i = 10; i <= max; i *= 10) {
            int count = i;
            int k = count / 2;
            int[] numbers = new int[count];
            System.arraycopy(baseNumbers, 0, numbers, 0, count);
            long now = System.currentTimeMillis();
            int kth = findKth(numbers, k);
            System.out.printf("%d: %d, %d\n", count, kth, System.currentTimeMillis() - now);
            sum += kth;
        }
        System.out.println(sum);
    }


}
