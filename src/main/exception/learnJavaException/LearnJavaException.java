package learnJavaException;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LiFu
 * @date 2020/4/28 上午9:31
 * @description learn Java Exception
 */
public class LearnJavaException {
    public static void main(String[] args) {
//        Java规定：
//        必须捕获的异常，包括Exception及其子类，但不包括RuntimeException及其子类，这种类型的异常称为Checked Exception。
//        不需要捕获的异常，包括Error及其子类，RuntimeException及其子类。
        try {
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            byte[] bs = toGBK(s);
            System.out.println(Arrays.toString(bs));
        } catch (Exception e) {
            // 所有异常都可以调用printStackTrace()方法打印异常栈，这是一个简单有用的快速打印异常的方法
            e.printStackTrace();
        }
    }

    static byte[] toGBK(String s) throws UnsupportedEncodingException {
        // 用指定编码转换String为byte[]:
        return s.getBytes("abc");
    }
}
