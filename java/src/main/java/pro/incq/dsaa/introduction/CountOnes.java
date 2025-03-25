package pro.incq.dsaa.introduction;

/**
 * excise 1.5
 */
public class CountOnes {
    public static int countOnes(int n) {
        if (n == 0){
            return 0;
        }
        if (n % 2 != 0) {
            return 1 + countOnes(n / 2);
        } else {
            return countOnes(n / 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(countOnes(-1));
        System.out.println(countOnes(2));
        System.out.println(countOnes(3));
        System.out.println(countOnes(4));
        System.out.println(countOnes(5));
    }
}
