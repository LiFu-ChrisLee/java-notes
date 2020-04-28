package learnAlert;

import java.util.Scanner;

/**
 * @author LiFu
 * @date 2020/4/28 下午3:40
 * @description learn Alert
 */
public class LearnAlert {
    public static void main(String[] args) {
//        语句assert x >= 0;即为断言，断言条件x >= 0预期为true。如果计算结果为false，则断言失败，抛出AssertionError。
//
//        使用assert语句时，还可以添加一个可选的断言消息：

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        // 要执行assert语句，必须给Java虚拟机传递-enableassertions（可简写为-ea）参数启用断言
        assert x >= 0 : "x must >= 0";
        System.out.println(x);
    }
}
