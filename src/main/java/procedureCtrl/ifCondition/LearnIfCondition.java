package procedureCtrl.ifCondition;

/**
 * @author LiFu
 * @date 2020/4/21 上午11:10
 * @description learn if condition
 */
public class LearnIfCondition {
    public static void main(String[] args) {
        // 注意浮点数相等用==判断不靠谱，利用差值小于某个临界值来判断
        double x = 1 - 9.0 / 10;
        if (Math.abs(x - 0.1) < 0.00001) {
            System.out.println("x is 0.1");
        } else {
            System.out.println("x is NOT 0.1");
        }

        // 判断引用类型相等，==只是用来判断指针
        String s1, s2;
        s1 = s2 = "hello";
        System.out.println(s1 == s2); // true

        String s3 = "hello";
        String s4 = "HELLO".toLowerCase();
        System.out.println(s3 == s4); // false

        // 要判断引用类型的变量内容是否相等，必须使用equals()方法
        System.out.println(s3.equals(s4));

        // 要避免NullPointerException错误，可以利用短路运算符&&
    }
}
