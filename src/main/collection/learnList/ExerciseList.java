package learnList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author LiFu
 * @date 2020/5/7 上午10:43
 * @description 给定一组连续的整数，例如：10，11，12，……，20，但其中缺失一个数字，试找出缺失的数字
 */
public class ExerciseList {
    public static void main(String[] args) {
        // 构造从start到end的序列：
        final int start = 10;
        final int end = 20;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        // 随机删除List中的一个元素:
        int removed = list.remove((int) (Math.random() * list.size()));
        int found = findMissingNumber(start, end, list);
        System.out.println(list.toString());
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");


        List<Integer> list2 = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list2.add(i);
        }
        // 洗牌算法suffle可以随机交换List中的元素位置:
        Collections.shuffle(list2);
        // 随机删除List中的一个元素:
        int removed2 = list2.remove((int) (Math.random() * list2.size()));
        int found2 = findMissingNumber2(start, end, list2);
        System.out.println(list2.toString());
        System.out.println("missing number: " + found2);
        System.out.println(removed2 == found2 ? "测试成功" : "测试失败");
    }

    static int findMissingNumber(int start, int end, List<Integer> list) {
        int missed = 0;
        for (int i = 0; i < Math.abs(end - start); i++) {
            if (end < start) {
                i = -i;
            }
            if (list.get(i) != start + i) {
                missed = start + i;
                break;
            }
        }
        return missed;
    }

    static int findMissingNumber2(int start, int end, List<Integer> list) {
        int missed = 0;
        for (int i = start; i < end + 1; i++) {
            if (!list.contains(i)) {
                missed = i;
                break;
            }
        }
        return missed;
    }
}
