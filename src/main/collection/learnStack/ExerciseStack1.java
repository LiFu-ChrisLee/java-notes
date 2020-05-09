package learnStack;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * @author LiFu
 * @date 2020/5/9 下午2:05
 * @description 请利用Stack把字符串中缀表达式编译为后缀表达式，然后再利用栈执行后缀表达式获得计算结果
 */
public class ExerciseStack1 {
    public static void main(String[] args) {
        String exp = "1 + 2 * (9 - 5) * 4 + 4 / 2";
        SuffixExpression se = compile(exp);
        int result = (int) se.execute();
        System.out.println(exp + " = " + result + " " + (result == 1 + 2 * (9 - 5) * 4 + 4 / 2 ? "✓" : "✗"));
    }

    static SuffixExpression compile(String exp) {
        return new SuffixExpression(exp);
    }
}

// 思路：https://blog.csdn.net/u011587070/article/details/81660741
class SuffixExpression {
    private String exp;
    Map<String, Integer> lv = new HashMap<>();

    public SuffixExpression(@NotNull String exp) {
        this.lv.put("+", 1);
        this.lv.put("-", 1);
        this.lv.put("*", 2);
        this.lv.put("/", 2);
        this.lv.put("(", 3); // 直接压栈
        this.lv.put(")", 0); // 退栈到"("
        this.exp = exp;
    }

    private double calc(Double topTwo, Double topOne, String operator) {
        double res = 0;
        switch (operator) {
            case "+":
                res = topTwo + topOne;
                break;
            case "-":
                res = topTwo - topOne;
                break;
            case "*":
                res = topTwo * topOne;
                break;
            case "/":
                res = topTwo / topOne;
                break;
            default:
                break;
        }
        return res;
    }

    public double execute() {
        Deque<Double> nums = new LinkedList<>();
        Deque<String> operators = new LinkedList<>();
        String[] expArr = this.exp.split("\\s*");

        for (String s : expArr) {
            if (!s.equals("")) {
                try {
                    // 如果能转换则说明是数
                    nums.push(Double.valueOf(s));
                } catch (Exception e) {
                    // 不能转换则是符号
                    if (operators.peek() != null) {
                        // 拿到符号栈顶的优先级
                        Integer topLv = this.lv.get(operators.peek());
                        // 拿当前符号的优先级
                        Integer currentLv = this.lv.get(s);

                        // 如果当前优先级高，则直接压栈
                        if (currentLv < topLv && !s.equals("(")) {
                            // 当前优先级低，则计算当前所有数栈的结果，并将结果压栈，"("除外
                            Double res = nums.pop();
                            while (nums.peek() != null) {
                                // 带括号运算到"("为止
                                if (operators.peek() != null && operators.peek().equals("(")) {
                                    // 如果当前是")"则删除"("
                                    if (s.equals(")")) {
                                        operators.pop();
                                    }
                                    break;
                                }
                                res = calc(nums.pop(), res, operators.pop());
                            }
                            nums.push(res);
                        }

                        // 最后将当前操作符压栈，")"不压栈
                        if (!s.equals(")")) {
                            operators.push(s);
                        }
                    } else {
                        // 符号栈无元素则直接压栈
                        operators.push(s);
                    }
                }
            }
        }

        // 计算最后结果
        double result = 0;
        if (nums.peek() != null) {
            result = nums.pop();
            while (operators.peek() != null) {
                result = calc(nums.pop(), result, operators.pop());
            }
        }
        return result;
    }

    public double execute(Map<String, Integer> env) {
        for (String key : env.keySet()) {
            this.exp = this.exp.replace(key, env.get(key).toString());
        }

        return execute();
    }
}
