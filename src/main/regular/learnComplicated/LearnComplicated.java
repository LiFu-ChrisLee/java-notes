package learnComplicated;

/**
 * @author LiFu
 * @date 2020/5/15 下午5:25
 * @description learn complicated
 */
public class LearnComplicated {
    public static void main(String[] args) {
        // 开头和结尾
        // ^表示开头，$表示结尾

        // 指定范围
        // [...]可以匹配范围内的字符
        //     0-9：字符0~9；
        //     a-f：字符a~f；
        //     A-F：字符A~F。

        // 匹配任意字符，但不包括数字
        // [^0-9]

        // 或规则匹配
        // 用|连接的两个正则规则是或规则
        // AB|CD表示可以匹配AB或CD
        String re = "java|php";
        System.out.println("java".matches(re));
        System.out.println("php".matches(re));
        System.out.println("go".matches(re));

        // 括号
        // 用(...)把子规则括起来表示
        String re1 = "learn\\s(java|php|go)";
        System.out.println("learn java".matches(re1));
        System.out.println("learn Java".matches(re1));
        System.out.println("learn php".matches(re1));
        System.out.println("learn Go".matches(re1));
    }
}
