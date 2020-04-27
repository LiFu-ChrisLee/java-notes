package core.learnBigInteger;

import java.math.BigInteger;

/**
 * @author LiFu
 * @date 2020/4/27 下午3:06
 * @description learn BigInteger
 */
public class LearnBigInteger {
    public static void main(String[] args) {
        BigInteger bi = new BigInteger("1234567890");
        BigInteger b1 = new BigInteger("3");
        // 只能使用实例方法
        System.out.println(bi.pow(5)); // 2867971860299718107233761438093672048294900000
        System.out.println(bi.add(b1)); // 1234567893
        System.out.println(bi.multiply(b1)); // 3703703670

//        转换为byte：byteValue() byteValueExact()
//        转换为short：shortValue() shortValueExact()
//        转换为int：intValue() intValueExact()
//        转换为long：longValue() longValueExact()
//        转换为float：floatValue() floatValueExact()
//        转换为double：doubleValue() doubleExact()
        System.out.println(bi.longValue()); // 1234567890

        BigInteger n = new BigInteger("999999").pow(99);
        float f = n.floatValue();
        System.out.println(f); // Infinity
    }
}
