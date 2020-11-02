package pro.incq.dsaa.linear.stack;

/**
 * @author yun.516@gmail.com
 */
public class LeetCodeSolution {
    /**
     * https://leetcode-cn.com/problems/valid-parentheses/
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        Stack stack = new Stack(s.length());
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private static final class Stack {
        char[] data;
        int size = 0;

        Stack(int capacity) {
            data = new char[capacity];
        }

        void push(char c) {
            data[size++] = c;
        }

        char pop() {
            return data[--size];
        }

        boolean isEmpty() {
            return size == 0;
        }
    }

    /**
     * https://leetcode-cn.com/problems/longest-valid-parentheses/
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        final int n = s.length();
        IntStack s1 = new IntStack(n);
        IntStack s2 = new IntStack(n);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                s1.push(i);
            } else if (!s1.isEmpty()) {
                int a1 = s1.pop();
                int b1 = i;
                while (s2.size >= 2) {
                    int b2 = s2.pop();
                    int a2 = s2.pop();
                    if (a1 < a2 && b1 > b2) {
                    } else if (a1 == b2 + 1) {
                        a1 = a2;
                    } else {
                        s2.push(a2);
                        s2.push(b2);
                        break;
                    }
                }
                s2.push(a1);
                s2.push(b1);
            }
        }
        int max = 0;
        while (!s2.isEmpty()) {
            int x = s2.pop() - s2.pop() + 1;
            if (x > max) {
                max = x;
            }
        }
        return max;
    }

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length <= 0) {
            return 0;
        }
        IntStack stack = new IntStack(tokens.length);
        for (String token : tokens) {
            char c = token.charAt(0);
            if ('+' == c && token.length() == 1) {
                stack.push(stack.pop() + stack.pop());
            } else if ('-' == c && token.length() == 1) {
                int v = stack.pop();
                stack.push(stack.pop() - v);
            } else if ('*' == c) {
                stack.push(stack.pop() * stack.pop());
            } else if ('/' == c) {
                int v = stack.pop();
                stack.push(stack.pop() / v);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    private static class IntStack {
        int[] data;
        int size;

        IntStack(int capacity) {
            data = new int[capacity];
        }

        void push(int v) {
            data[size++] = v;
        }

        int pop() {
            return data[--size];
        }

        boolean isEmpty() {
            return size <= 0;
        }
    }
}
