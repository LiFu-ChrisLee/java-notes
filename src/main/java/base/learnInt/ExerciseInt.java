package base.learnInt;

/**
 * @author LiFu
 * @date 2020/4/17 下午3:42
 * @description 计算前N个自然数的和可以根据公示： (1+N)×N​÷2 请根据公式计算前N个自然数的和
 */
public class ExerciseInt {
    public static void main(String[] args) {
        int n = 100;
        // sum = 1 + 2 + ... + n
        int sum = (1 + n) * n / 2;
        System.out.println(sum);
    }
}
