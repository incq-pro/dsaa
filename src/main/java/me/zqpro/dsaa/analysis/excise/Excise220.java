package me.zqpro.dsaa.analysis.excise;


/**
 * Excise 2.20
 */
public class Excise220 {
    public static boolean isPrime(int n) {
        int nsqrt = (int)Math.sqrt(n);
        for (int i = 2; i <= nsqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(7));
    }
}
