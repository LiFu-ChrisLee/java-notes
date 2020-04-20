package base.learnDouble;

/**
 * @author LiFu
 * @date 2020/4/17 下午4:44
 * @description learn double
 */
public class LearnDouble {
    public static void main(String[] args) {
        double x = 1.0 / 10;
        double y = 1 - 9.0 / 10;
        // 观察x和y是否相等:
        System.out.println(x);
        System.out.println(y);

        // 比较x和y是否相等，先计算其差的绝对值:
        double r = Math.abs(x - y);
        // 再判断绝对值是否足够小:
        if (r < 0.00001) {
            // 可以认为相等
            System.out.println("相等");
        } else {
            // 不相等
            System.out.println("不相等");
        }

//        整数与浮点数运算，整数自动转为浮点数
        int n = 5;
        double d = 1.2 + 24.0 / n; // 6.0
        System.out.println(d);

//        整数与整数运算时，不会转为浮点数
        d = 1.2 + 24 / 5; // 5.2
        System.out.println(d);

        // 四舍五入，可以对浮点数加上0.5再强制转型
        double e = 2.6;
        int m = (int) (e + 0.5);
        System.out.println(m);
    }
}
