package learnArray.multidimensionalArray;

/**
 * @author LiFu
 * @date 2020/4/22 下午2:08
 * @description 用二维数组可以表示一组学生的各科成绩，请计算所有学生的平均分
 */
public class ExerciseMultidimensionalArray {
    public static void main(String[] args) {
        // 用二维数组表示的学生成绩:
        int[][] scores = {
                { 82, 90, 91 },
                { 68, 72, 64 },
                { 95, 91, 89 },
                { 67, 52, 60 },
                { 79, 81, 85 },
        };

        int cnt = 0;
        int sum = 0;
        for (int[] ns: scores) {
            for (int n: ns) {
                sum += n;
                cnt += 1;
            }
        }

        double average = 1.0 * sum / cnt;

        System.out.println(average);

        if (Math.abs(average - 77.733333) < 0.000001) {
            System.out.println("测试成功");
        } else {
            System.out.println("测试失败");
        }
    }
}
