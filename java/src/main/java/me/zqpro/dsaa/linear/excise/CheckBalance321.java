package me.zqpro.dsaa.linear.excise;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CheckBalance321 {

    private static final Map<String, String> TOKEN_MAP;

    private static final Map<String, String> TOKEN_MAP2;

    static {
        TOKEN_MAP = new HashMap<>();
        TOKEN_MAP.put("/*", "*/");
        TOKEN_MAP.put("(", ")");
        TOKEN_MAP.put("{", "}");

        TOKEN_MAP2 = new HashMap<>();

        TOKEN_MAP.forEach((k, v) -> TOKEN_MAP2.put(v, k));
    }

    public static boolean checkBalance(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (TOKEN_MAP.containsKey(token)) {
                stack.push(token);
            } else if (TOKEN_MAP2.containsKey(token)) {
                if (stack.isEmpty() || !stack.pop().equals(TOKEN_MAP2.get(token))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] tokens = {
                "/*",
                "*/",
                "{",
                ")"
        };

        System.out.println(checkBalance(tokens));
    }
}
