package learnArray.multidimensionalArray;

import java.util.Arrays;

/**
 * @author LiFu
 * @date 2020/4/22 上午11:38
 * @description learn multidimensional array
 */
public class LearnMultidimensionalArray {
    public static void main(String[] args) {
        int[][][] ns = {
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                },
                {
                        {10, 11},
                        {12, 13}
                },
                {
                        {14, 15, 16},
                        {17, 18}
                }
        };
        // 用来打印多维数组
        System.out.println(Arrays.deepToString(ns));
    }
}
