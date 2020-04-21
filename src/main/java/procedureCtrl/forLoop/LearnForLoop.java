package procedureCtrl.forLoop;

/**
 * @author LiFu
 * @date 2020/4/21 下午6:18
 * @description learn for loop
 */
public class LearnForLoop {
    public static void main(String[] args) {
        int[] ns = {1, 4, 9, 16, 25};
        // for，不常用，取数组角标时才使用
        for (int i = 0; i < ns.length; i++) {
            System.out.println(ns[i]);
        }

        // for each，常用
        for (int n : ns) {
            System.out.println(n);
        }
    }
}
