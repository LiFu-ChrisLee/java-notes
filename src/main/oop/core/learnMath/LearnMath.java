package core.learnMath;

import java.util.Random;

/**
 * @author LiFu
 * @date 2020/4/27 下午6:03
 * @description learn math
 */
public class LearnMath {
    public static void main(String[] args) {
        // 绝对值
        System.out.println(Math.abs(-7));
        // 取最大或最小值
        System.out.println(Math.min(1, 2));
        System.out.println(Math.max(1, 2));
        // 计算计算x的y次方
        System.out.println(Math.pow(2, 3));
        // 计算2次根
        System.out.println(Math.sqrt(4));
        // 计算计算e的x次方
        System.out.println(Math.exp(2));
        // 计算以e为底的对数
        System.out.println(Math.log(2));
        // 计算以10为底的对数
        System.out.println(Math.log10(100));
        // 三角函数
        System.out.println(Math.sin(3.14));
        System.out.println(Math.cos(3.14));
        System.out.println(Math.tan(3.14));
        System.out.println(Math.asin(1));
        // 几个数学常量
        System.out.println(Math.PI);
        System.out.println(Math.E);
        // 生成一个随机数x，x的范围是0 <= x < 1
        System.out.println(Math.random());
        // 生成一个区间在[MIN, MAX)的随机数
        System.out.println(randomNum(10, 12));

        // Random用来创建伪随机数。所谓伪随机数，是指只要给定一个初始的种子，产生的随机数序列是完全一样的
        Random r = new Random(12345);
        for (int i = 0; i < 10; i++) {
            System.out.println(r.nextInt(100));
        }
        // 51, 80, 41, 28, 55...

        // SecureRandom的安全性是通过操作系统提供的安全的随机种子来生成随机数。这个种子是通过CPU的热噪声、读写磁盘的字节、网络流量等各种随机事件产生的“熵”
    }

    public static double randomNum(double min, double max) {
        return min + Math.random() * (max - min);
    }
}
