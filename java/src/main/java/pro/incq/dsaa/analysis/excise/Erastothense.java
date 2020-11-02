package pro.incq.dsaa.analysis.excise;

import java.util.ArrayList;
import java.util.List;

public class Erastothense {
    public static List<Integer> getPrimes(int n) {
        List<Integer> ret = new ArrayList<>();
        ret.add(1);
        int numbers[] = new int[n + 1];
        for(int i = 2; i <= n; i++) {
            if (numbers[i] == 0) {
                ret.add(i);
                for(int j = 1; j * i <= n; j++) {
                    numbers[j * i] = 1;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(getPrimes(10));
    }
}
