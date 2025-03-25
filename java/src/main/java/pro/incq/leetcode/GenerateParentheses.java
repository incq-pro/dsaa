package pro.incq.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22 括号生成
 * https://leetcode.cn/problems/generate-parentheses/
 */
public class GenerateParentheses {

    public static void main(String[] args) {

        GenerateParentheses generateParentheses = new GenerateParentheses();
        for (int i = 1; i < 8; i++) {
            System.out.println(i);
            System.out.println(generateParentheses.generateParenthesis(i));
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>(0x1 << (n - 1));
        char[] current = new char[n * 2];
        doGenerate(0, n, current, 0, result);
        return result;
    }

    private void doGenerate(int stack, int left, char[] current, int index, List<String> result) {
        if (stack == 0 && left == 0) {
            result.add(new String(current));
        }
        if (stack > 0) {
            current[index] = ')';
            doGenerate(stack - 1, left, current, index + 1, result);
        }
        if (left > 0) {
            current[index] = '(';
            doGenerate(stack + 1, left - 1, current, index + 1, result);
        }
    }
}
