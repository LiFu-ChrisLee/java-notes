package learnStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author LiFu
 * @date 2020/5/9 上午11:36
 * @description learn stack
 */
public class LearnStack {
    public static void main(String[] args) {
//        用Deque可以实现Stack的功能：
//        把元素压栈：push(E)/addFirst(E)；
//        把栈顶的元素“弹出”：pop(E)/removeFirst()；
//        取栈顶元素但不弹出：peek(E)/peekFirst()。

        // Deque作为Stack使用时，注意只调用push()/pop()/peek()方法，不要调用addFirst()/removeFirst()/peekFirst()方法，这样代码更加清晰

//         Stack在计算机中使用非常广泛，JVM在处理Java方法调用的时候就会通过栈这种数据结构维护方法调用的层次。
//        JVM会创建方法调用栈，每调用一个方法时，先将参数压栈，然后执行对应的方法；当方法返回时，返回值压栈，调用方法通过出栈操作获得方法返回值。
//        因为方法调用栈有容量限制，嵌套调用过多会造成栈溢出，即引发StackOverflowError

        // 对整数进行进制的转换就可以利用栈
        int n = 12500;
        Deque<String> stack = new LinkedList<>();
        for (; n > 0; n /= 16) {
            int tem = n % 16;
            stack.push(getHexString(tem));
        }

        StringBuilder s = new StringBuilder();
        while (stack.peek() != null) {
            s.append(stack.pop());
        }
        System.out.println(s);
    }

    private static String getHexString(int i) {
        String s = null;
        if (i < 10) {
            s = String.valueOf(i);
        } else {
            switch (i) {
                case 10:
                    s = "A";
                    break;
                case 11:
                    s = "B";
                    break;
                case 12:
                    s = "C";
                    break;
                case 13:
                    s = "D";
                    break;
                case 14:
                    s = "E";
                    break;
                case 15:
                    s = "F";
                    break;
                default:
                    break;
            }
        }
        return s;
    }
}