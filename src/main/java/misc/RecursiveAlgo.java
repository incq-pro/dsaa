package misc;

/**
 * @author yun.516@gmail.com
 */
public class RecursiveAlgo {
    public static int stairsStep(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return stairsStep(n - 1) + stairsStep(n - 2);
        }
    }

    public static int stairStepLoop(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int ret = 0;
        int prepre = 1;
        int pre = 2;
        for (int i = 3; i <= n; i++) {
            ret = pre + prepre;
            prepre = pre;
            pre = ret;
        }
        return ret;
    }
}
