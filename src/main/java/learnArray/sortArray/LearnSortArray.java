package learnArray.sortArray;

import java.util.Arrays;

/**
 * @author LiFu
 * @date 2020/4/22 上午10:29
 * @description learn sort array
 */
public class LearnSortArray {
    public static void main(String[] args) {
        // 冒泡排序
        System.out.println("冒泡排序");
        int[] ns = {28, 12, 89, 73, 65, 18, 96, 50, 8, 36};
        // 排序前:
        System.out.println("排序前");
        System.out.println(Arrays.toString(ns));

        // 遍历所有位置
        for (int i = 0; i < ns.length; i++) {
            // 遍历所有项，注意每遍历一个位置则遍历项数减一，且第一次应遍历到倒数第2个，故j < ns.length - i - 1
            for (int j = 0; j < ns.length - i - 1; j++) {
                // 前一项大于后一项则交换
                if (ns[j] > ns[j + 1]) {
                    int temp = ns[j];
                    ns[j] = ns[j + 1];
                    ns[j + 1] = temp;
                }
            }
        }

        // 排序后:
        System.out.println("排序后");
        System.out.println(Arrays.toString(ns));

        // 双向选择排序
        System.out.println("双向选择排序");
        ns = new int[]{28, 12, 89, 73, 65, 18, 96, 50, 8, 36};
        // 排序前:
        System.out.println("排序前");
        System.out.println(Arrays.toString(ns));

        // 遍历所有位置，由于每次排2位置，故遍历次数减半
        for (int i = 0; i < ns.length / 2; i++) {
            // 将i位置的数暂视为最大数、最小数
            int max, min;
            max = min = ns[i];
            // 记录最大数、最小数位置
            int maIdx, miIdx;
            maIdx = miIdx = i;
            // 遍历所有项，寻找最大数、最小数，注意每次从第i项开始，每遍历一个位置则遍历项数减2，且第一次应遍历到最后，故j < ns.length - i
            for (int j = i; j < ns.length - i; j++) {
                // 如果当前项大于暂存的最大数则记录
                if (ns[j] > max) {
                    max = ns[j];
                    maIdx = j;
                }

                // 如果当前项小于暂存的最小数则记录
                if (ns[j] < min) {
                    min = ns[j];
                    miIdx = j;
                }
            }
            // 交换遍历的最后一项和最大项
            ns[maIdx] = ns[ns.length - i - 1];
            ns[ns.length - i - 1] = max;

            // 交换遍历的第i项和最小项
            ns[miIdx] = ns[i];
            ns[i] = min;
        }

        // 排序后:
        System.out.println("排序后");
        System.out.println(Arrays.toString(ns));
    }
}
