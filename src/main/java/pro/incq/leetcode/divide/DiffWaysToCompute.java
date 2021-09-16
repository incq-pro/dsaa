package pro.incq.leetcode.divide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiffWaysToCompute {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for(Integer l : left) {
                    for(Integer r : right) {
                        switch (c) {
                            case '+':
                                result.add(l + r);
                                break;
                            case  '-':
                                result.add(l - r);
                                break;
                            case '*':
                                result.add(l * r);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
        if(result.isEmpty()) {
            return Collections.singletonList(Integer.parseInt(expression));
        }
        return result;
    }

    public static void main(String[] args) {
        DiffWaysToCompute s = new DiffWaysToCompute();
        System.out.println(s.diffWaysToCompute("1+2*3"));
    }
}