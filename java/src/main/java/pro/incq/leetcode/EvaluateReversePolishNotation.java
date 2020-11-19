package pro.incq.leetcode;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * 根据 逆波兰表示法，求表达式的值。
 *
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 * @author zhangqiang
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length <= 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens) {
            if ("+".equals(token)) {
                Integer second = stack.pop();
                Integer first = stack.pop();
                stack.push(first + second);
            } else if ("-".equals(token)) {
                Integer second = stack.pop();
                Integer first = stack.pop();
                stack.push(first - second);
            } else if ("*".equals(token)) {
                Integer second = stack.pop();
                Integer first = stack.pop();
                stack.push(first * second);
            } else if ("/".equals(token)) {
                Integer second = stack.pop();
                Integer first = stack.pop();
                stack.push(first / second);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation e  = new EvaluateReversePolishNotation();
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(e.evalRPN(tokens));
    }
}
