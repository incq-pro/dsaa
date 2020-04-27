package me.zqpro.dsaa.analysis;

public class PowerN {
    public static int power(int x, int n) {
        int w = x;
        int ret = 1;
        if ((n & 0x1) == 1) {
            ret *= w;
        }
        n >>= 1;
        while (n != 0) {
            w *= w;
            if ((n & 0x01) == 1) {
                ret *= w;
            }
            n = n >> 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(power(2, 10));
    }
}
