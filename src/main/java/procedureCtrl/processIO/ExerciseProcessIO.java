package procedureCtrl.processIO;

import java.util.Scanner;

/**
 * @author LiFu
 * @date 2020/4/21 上午11:01
 * @description 输入上次考试成绩（int）和本次考试成绩（int），然后输出成绩提高的百分比，保留两位小数位（例如，21.75%）
 */
public class ExerciseProcessIO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("previous grade:");
        int previousGrade = scanner.nextInt();
        System.out.println("current grade:");
        int currentGrade = scanner.nextInt();

        double percentage = (currentGrade - previousGrade) * 100.0 / previousGrade;

        System.out.printf("grade upper %.2f%%.", percentage);
    }
}
