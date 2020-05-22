package base;

import java.util.Arrays;

/**
 * @author LiFu
 * @date 2020/5/21 下午5:51
 * @description learn base
 */
public class LearnBase {
    public static void main(String[] args) {
        String[] array = new String[] { "Apple", "Orange", "Banana", "Lemon" };
        // lambda函数代替Comparator实例中的方法实现
        Arrays.sort(array, (s1, s2) -> {
            return s1.compareTo(s2);
        });
        System.out.println(String.join(", ", array));
    }
}

// 我们把只定义了单方法的接口称之为FunctionalInterface，用注解@FunctionalInterface标记
// @FunctionalInterface
// public interface Comparator<T> {
//
//     抽象方法，接口方法
//     int compare(T o1, T o2);
//
//     Object定义的方法，非接口方法
//     boolean equals(Object obj);
//
//     default方法，非接口方法
//     default Comparator<T> reversed() {
//         return Collections.reverseOrder(this);
//     }
//
//     default Comparator<T> thenComparing(Comparator<? super T> other) {
//         ...
//     }
//     ...
// }
