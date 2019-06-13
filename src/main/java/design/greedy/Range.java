package design.greedy;

/**
 * @author yun.516@gmail.com
 */
public class Range {
    public static int[][] max(int[][] ranges) {
        int minL = Integer.MAX_VALUE;
        int maxR = Integer.MIN_VALUE;
        for (int[] range : ranges) {
            if (range[0] < minL) {
                minL = range[0];
            }
            if (range[1] > maxR) {
                maxR = range[1];
            }
        }
        int retI = 0;
        int[][] ret = new int[ranges.length][];
        int next = 0;
        // -1 is not found
        while (next != -1) {
            next = -1;
            for (int i = 0; i < ranges.length; i++) {
                int[] range = ranges[i];
                if (range != null) {
                    if (range[0] >= minL) {
                        if (next == -1) {
                            next = i;
                        } else {
                            if (range[1] < ranges[next][1]) {
                                next = i;
                            }
                        }
                    }
                }
            }
            if (next != -1) {
                ret[retI++] = ranges[next];
                minL = ranges[next][1];
                ranges[next] = null;
            }
        }
        return ret;
    }
}
