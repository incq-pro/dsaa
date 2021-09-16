package pro.incq.dsaa.analysis.excise;

/**
 * 最大的子序列和
 *
 * @author yun.516@gmail.com
 */
public class MaxSubSum {

    public static int maxSubSum3(int[] a) {
        return 0;
    }

    private static int maxSubSum3(int[] a, int low, int high) {
        return 0;
    }

    public static int maxSubSum4(int[] a) {
        int maxSum = 0;
        int thisMax = 0;
        for (int j = 0; j < a.length; j++) {
            thisMax += a[j];
            if (thisMax > maxSum) {
                maxSum = thisMax;
            } else if (thisMax < 0) {
                thisMax = 0;
            }
        }
        return maxSum;
    }

    public static int minSubSum4(int[] a) {
        int minSum = 0;
        int thisMin = 0;
        for (int j = 0; j < a.length; j++) {
            thisMin += a[j];
            if (thisMin < minSum) {
                minSum = thisMin;
            } else if (thisMin > 0) {
                thisMin = 0;
            }
        }
        return minSum;
    }

    public static MaxSumResult maxSubSum44WithResult(int[] a) {
        int maxSum = 0;
        int maxSumStart = -1;
        int maxSumEnd = -1;

        int thisMax = 0;
        int thisStart = 0;
        for (int j = 0; j < a.length; j++) {
            thisMax += a[j];
            if (thisMax > maxSum) {
                maxSum = thisMax;
                maxSumStart = thisStart;
                maxSumEnd = j;
            } else if (thisMax < 0) {
                thisMax = 0;
                thisStart = j + 1;
            }
        }
        MaxSumResult result = new MaxSumResult();
        result.sum = maxSum;
        result.start = maxSumStart;
        result.end = maxSumEnd;
        return result;
    }


    private static class MaxSumResult {
        public int sum;
        public int start;
        public int end;

        @Override
        public String toString() {
            return "" + sum + ":" + start + ":" + end;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, -1, 2, 8, -4, 5, -3};
//        System.out.println(maxSubSum4(a));
//        System.out.println(minSubSum4(a));
        System.out.println(maxSubSum44WithResult(a));
    }
}
