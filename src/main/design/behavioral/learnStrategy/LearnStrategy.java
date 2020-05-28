package behavioral.learnStrategy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author LiFu
 * @date 2020/5/28 下午3:48
 * @description learn Strategy
 */
public class LearnStrategy {
    public static void main(String[] args) {
        // 定义一系列的算法，把它们一个个封装起来，并且使它们可相互替换。本模式使得算法可独立于使用它的客户而变化。
        // 核心思想是在一个计算方法中把容易变化的算法抽出来作为“策略”参数传进去，从而使得新增策略不必修改原有逻辑。

        // 策略模式，它实际上指，在一个方法中，流程是确定的，但是，某些关键步骤的算法依赖调用方传入的策略，这样，传入不同的策略，即可获得不同的结果，大大增强了系统的灵活性。

        String[] array = { "apple", "Pear", "Banana", "orange" };
        // 关键步骤传入算法
        sort(array, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(array));
    }

    // 排序流程确定是冒泡排序
    private static <T> void sort(T[] a, Comparator<? super T> c) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (c.compare(a[j], a[j + 1]) > 0) { // 注意这里比较两个元素的大小依赖传入的策略
                    T temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
}
