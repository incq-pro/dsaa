package pro.incq.dsaa.analysis.excise;

/**
 * a > b
 * gcd(a, b) is
 * 2gcd(a / 2, b / 2), if a is even, b is even
 * gcd(a/2, b), if a is even, b is odd
 * gcd(a, b / 2), if a is odd , b is even
 * gcd((a+b)/2, (a-b)/2), if a is odd, b is odd
 */
public class RecursiveGcd {
    // a > b
    public static int recursiveGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        if (a % 2 == 0) {
            if (b % 2 == 0) {
                return 2 * recursiveGcd(a / 2, b / 2);
            } else {
                if (a / 2 < b) {
                    return recursiveGcd(b, a / 2);
                } else {
                    return recursiveGcd(a / 2, b);
                }
            }
        } else {
            if (b % 2 == 0) {
                return recursiveGcd(a, b / 2);
            } else {
                return recursiveGcd((a + b) / 2, (a - b) / 2);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(recursiveGcd(6, 5));
        System.out.println(recursiveGcd(6, 3));
        System.out.println(recursiveGcd(9, 6));
        System.out.println(recursiveGcd(9, 3));
    }
}
