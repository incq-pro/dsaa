package stack;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yun.516@gmail.com
 */
public class ExpressCalculator {
    private static final Map<String, Integer> OPERATORS = new HashMap<>();

    static {
        OPERATORS.put("+", 1);
        OPERATORS.put("-", 1);
        OPERATORS.put("*", 10);
        OPERATORS.put("/", 10);
    }

    public static boolean priority(String op1, String op2) {
        return OPERATORS.get(op1).compareTo(OPERATORS.get(op2)) >= 0;
    }

    public static boolean isOperator(String item) {
        return OPERATORS.containsKey(item);
    }

    public static int op(String v1, String op, String v2) {
        int i1 = Integer.valueOf(v1);
        int i2 = Integer.valueOf(v2);
        switch (op) {
            case "+":
                return i1 + i2;
            case "-":
                return i1 - i2;
            case "*":
                return i1 * i2;
            case "/":
                return i1 / i2;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static int calculate(String express) {
        String[] items = express.split(" ");
        ArrayStack stack1 = new ArrayStack(items.length / 2 + 1);
        LinkedStack stack2 = new LinkedStack();

        for (String item : items) {
            item = item.trim();
            if (isOperator(item)) {
                String lastOp = stack2.head();
                if (lastOp == null) {
                } else if (priority(lastOp, item)) {
                    stack2.pop();
                    String v2 = stack1.pop();
                    String v1 = stack1.pop();
                    int v3 = op(v1, lastOp, v2);
                    stack1.push("" + v3);
                }
                stack2.push(item);
            } else {
                stack1.push(item);
            }
        }
        String opItem;
        while ((opItem = stack2.pop()) != null) {
            String v2 = stack1.pop();
            String v1 = stack1.pop();
            int v3 = op(v1, opItem, v2);
            stack1.push("" + v3);
        }
        return Integer.valueOf(stack1.pop());
    }
}
