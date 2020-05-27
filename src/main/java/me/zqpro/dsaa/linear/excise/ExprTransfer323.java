package me.zqpro.dsaa.linear.excise;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExprTransfer323 {
    public static String infixExprToSuffix(String infix) {
        List<String> result = new ArrayList<>();
        String[] tokens = infix.split(" ");
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if ("(".equals(token)) {
                stack.push(token);
            } else if (")".equals(token)) {
                String t;
                while (!"(".equals(t = stack.pop())) {
                    result.add(t);
                }
            } else if ("+".equals(token) || "-".equals(token)) {
                if (!stack.empty()) {
                    String t = stack.peek();
                    if (!"(".equals(t)) {
                        result.add(stack.pop());
                    }
                }
                stack.push(token);
            } else if ("*".equals(token) || "/".equals(token)) {

            } else {
                result.add(token);
            }
        }
        return String.join(" ", result);
    }

    public static void main(String[] args) {
        infixExprToSuffix("a * ( b + c * d )");
    }
}
