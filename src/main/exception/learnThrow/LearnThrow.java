package learnThrow;

import java.util.Scanner;

/**
 * @author LiFu
 * @date 2020/4/28 下午2:26
 * @description learn throw
 */
public class LearnThrow {
    public static void main(String[] args) {
        try {
            process1();
        } catch (Exception e) {
            // 通过printStackTrace()可以打印出方法的调用栈
            e.printStackTrace();
        }
    }

    private static void process1() {
        try {
            process2();
        } catch (Exception e) {
            // 为了能追踪到完整的异常栈，在构造异常的时候，把原始的Exception实例传进去，新的Exception就可以持有原始Exception信息
            throw new IllegalArgumentException(e);
        }
    }

    private static void process2() {
        Scanner sc = new Scanner(System.in);
        System.out.println(Integer.parseInt(sc.nextLine()));
    }
}
