package procedureCtrl.forLoop;

/**
 * @author LiFu
 * @date 2020/4/21 下午6:24
 * @description 1. 用for循环倒序输出每一个元素； 2. 用for each循环对数组每个元素求和； 3. 用for循环计算π
 * π/4 = 1 - 1/3 + 1/5 ...
 */
public class ExerciseForLoop {
    public static void main(String[] args) {
        // 倒序输出
        int[] ns = {1, 4, 9, 16, 25};
        for (int i = ns.length - 1; i > -1; i--) {
            System.out.println(ns[i]);
        }

        // 元素求和
        ns = new int[]{1, 4, 9, 16, 25};
        int sum = 0;
        for (int n : ns) {
            sum += n;
        }
        System.out.println(sum); // 55

        // 计算π
        double pi = 0;
        for (int n = 1; n < 10000; n++) {
            if (n % 2 == 0) {
                pi -= 1.0 / (2 * n - 1);
            } else {
                pi += 1.0 / (2 * n - 1);
            }
        }
        pi = 4 * pi;
        System.out.println(pi);
    }
}
