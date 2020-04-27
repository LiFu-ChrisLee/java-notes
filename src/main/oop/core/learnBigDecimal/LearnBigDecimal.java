package core.learnBigDecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author LiFu
 * @date 2020/4/27 下午5:45
 * @description learn BigDecimal
 */
public class LearnBigDecimal {
    public static void main(String[] args) {
        BigDecimal bd = new BigDecimal("123.456789");
        BigDecimal bd1 = bd.setScale(4, RoundingMode.HALF_UP);
        BigDecimal bd2 = bd.setScale(4, RoundingMode.DOWN);
        System.out.println(bd);
        System.out.println(bd1);
        System.out.println(bd2);

        // 对BigDecimal做加、减、乘时，精度不会丢失，但是做除法时，存在无法除尽的情况，这时，就必须指定精度以及如何进行截断
        BigDecimal d1 = new BigDecimal("123.456");
        BigDecimal d2 = new BigDecimal("23.456789");
        BigDecimal d3 = d1.divide(d2, 10, RoundingMode.HALF_UP); // 保留10位小数并四舍五入
        System.out.println(d3);

        // 对BigDecimal做除法的同时求余数
        BigDecimal n = new BigDecimal("12.345");
        BigDecimal m = new BigDecimal("0.12");
        BigDecimal[] dr = n.divideAndRemainder(m);
        System.out.println(dr[0]); // 102
        System.out.println(dr[1]); // 0.105

        // 不但要求两个BigDecimal的值相等，还要求它们的scale()相等
        BigDecimal d4 = new BigDecimal("123.456");
        BigDecimal d5 = new BigDecimal("123.45600");
        System.out.println(d4.equals(d5)); // false,因为scale不同
        System.out.println(d4.equals(d5.stripTrailingZeros())); // true,因为d5去除尾部0后scale变为2
        // 必须使用compareTo()方法来比较，它根据两个值的大小分别返回负数、正数和0，分别表示小于、大于和等于
        System.out.println(d4.compareTo(d5)); // 0
    }
}
