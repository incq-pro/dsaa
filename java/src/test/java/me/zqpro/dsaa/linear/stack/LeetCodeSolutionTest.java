package me.zqpro.dsaa.linear.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yun.516@gmail.com
 */
public class LeetCodeSolutionTest {
    private LeetCodeSolution s;

    @Before
    public void setUp() {
        if (s == null) {
            s = new LeetCodeSolution();
        }
    }

    @Test
    public void isValid() {
        assertTrue(s.isValid(""));
        assertTrue(s.isValid("()"));
        assertTrue(s.isValid("()[]{}"));
        assertTrue(s.isValid("{[]}"));
        assertFalse(s.isValid("(]"));
        assertFalse(s.isValid("(])]"));
    }

    @Test
    public void longestValidParentheses() {
        assertEquals(2, s.longestValidParentheses("(()"));
        assertEquals(4, s.longestValidParentheses(")()())"));
        assertEquals(2, s.longestValidParentheses("(()(()"));
        assertEquals(6, s.longestValidParentheses("(()(())"));
    }

    @Test
    public void evalRPN() {
        assertEquals(9, s.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        assertEquals(6, s.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        assertEquals(22, s.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
        assertEquals(3, s.evalRPN(new String[]{"1", "2", "+"}));
        assertEquals(-1, s.evalRPN(new String[]{"1", "2", "-"}));
        assertEquals(1, s.evalRPN(new String[]{"2", "1", "-"}));
        assertEquals(0, s.evalRPN(new String[]{"2", "4", "/"}));
        assertEquals(3, s.evalRPN(new String[]{"6", "2", "/"}));
    }
}