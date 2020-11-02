package pro.incq.dsaa.linear.excise;

import java.util.Stack;

public class SuffixExpr322 {
    public static int suffixExpr(String expr) {
        String[] tokens = expr.split(" ");
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens) {
            if ("+".equals(token)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(token)) {
                int a1 = stack.pop();
                int a2 = stack.pop();
                stack.push(a2 - a1);
            } else if ("*".equals(token)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(token)) {
                int a1 = stack.pop();
                int a2 = stack.pop();
                stack.push(a2 / a1);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String expr = "1 2 + 3 * *";
        System.out.println(suffixExpr(expr));
    }
}
