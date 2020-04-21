package procedureCtrl.processIO;

import java.util.Scanner;

/**
 * @author LiFu
 * @date 2020/4/21 上午10:24
 * @description learn process io
 */
public class LearnProcessIO {
    public static void main(String[] args) {
        // 格式化输出
        // %d	格式化输出整数
        // %x	格式化输出十六进制整数
        // %o	格式化输出八进制整数
        // %f	格式化输出浮点数
        // %e	格式化输出科学计数法表示的浮点数
        // %s	格式化字符串
        double d = 3.1415926;
        System.out.printf("%.2f\n", d); // 显示两位小数3.14
        System.out.printf("%.4f\n", d); // 显示4位小数3.1416

        // 由于%表示占位符，因此，连续两个%%表示一个%字符本身
        System.out.printf("%%");

        // 把一个整数格式化成十六/八进制，并用0补足8位
        int n = 12345000;
        System.out.printf("n=%d, hex=%08x\n", n, n); // 注意，两个%占位符必须传入两个数
        System.out.printf("n=%d, hex=%08o\n", n, n); // 注意，两个%占位符必须传入两个数

        Scanner scanner = new Scanner(System.in);
        System.out.println("name:");
        String name = scanner.nextLine();
        System.out.println("age:");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.printf("name: %s, age: %d.\n", name, age);

        // scanner.nextInt()，scanner.nextDouble()等在读取完之后会在scanner对象缓存一个\n，在之后紧跟scanner.nextLine()的话会导致无法读取输入，故应该在这些方法后面紧跟一个scanner.nextLine()来消除\n
    }
}
