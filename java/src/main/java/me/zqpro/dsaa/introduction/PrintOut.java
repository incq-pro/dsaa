package me.zqpro.dsaa.introduction;

/**
 * excise 1.2
 */
public class PrintOut {
    public static void printOut(int n) {
        if (n >= 10) {
            printOut(n / 10);
        }
        printDigit(n % 10);
    }

    public static void printOut(double d) {
        if (d < 0) {
            System.out.print('-');
            d = -d;
        }
        int intPart = (int) d;
        printOut(intPart);
        d -= intPart;
        if (d == 0) {
            return;
        }
        System.out.print(".");
        printDouble(d);
    }

    private static void printDouble(double d) {
        if (d == 0) {
            return;
        }
        d *= 10;
        int intPart = (int) (d);
        printDigit(intPart);
        printDouble(d - intPart);
    }

    private static void printDigit(int n) {
        if (n < 0 || n >= 10) {
            throw new IllegalArgumentException();
        }
        System.out.print(n);
    }


    public static void main(String[] args) {
        printOut(12345);
        System.out.println();
        printOut(-123.48);
        System.out.println();
        printOut(123.48);
    }
}
