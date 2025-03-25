package pro.incq.leetcode;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/valid-parentheses/
 * <p>
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * @author zhangqiang
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        try {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else if (c == ')') {
                    if (!stack.pop().equals('(')) {
                        return false;
                    }
                } else if (c == ']') {
                    if (!stack.pop().equals('[')) {
                        return false;
                    }
                } else if (c == '}') {
                    if (!stack.pop().equals('{')) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }


    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();
        System.out.println(v.isValid("(())"));
        System.out.println(v.isValid("(()"));
        System.out.println(v.isValid("())"));
        System.out.println(v.isValid(""));
    }
}
