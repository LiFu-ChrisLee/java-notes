package learnInherit;

import java.util.Arrays;

/**
 * @author LiFu
 * @date 2020/4/29 上午10:37
 * @description learn inherit
 */
public class LearnInherit {
    public static void main(String[] args) {
        Class i = Integer.class;
        // 获取父类的Class
        Class n = i.getSuperclass();
        System.out.println(n);
        // 获取interface
        Class[] is = i.getInterfaces();
        System.out.println(Arrays.toString(is));

        // 获取接口的父接口要用getInterfaces()
        System.out.println(Arrays.toString(is[0].getInterfaces()));

        // 判断一个实例是否是某个类型时，正常情况下，使用instanceof操作符
        Integer it = 1;
        System.out.println(it instanceof Number); // true

        // 要判断一个向上转型是否成立，可以调用isAssignableFrom()
        System.out.println(Number.class.isAssignableFrom(Integer.class)); // true
    }
}
