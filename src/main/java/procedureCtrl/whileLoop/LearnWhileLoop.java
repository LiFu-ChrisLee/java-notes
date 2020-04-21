package procedureCtrl.whileLoop;

import java.util.Scanner;

/**
 * @author LiFu
 * @date 2020/4/21 下午4:46
 * @description learn while loop
 */
public class LearnWhileLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("start:");
        int start = scanner.nextInt();

        System.out.println("end:");
        int end = scanner.nextInt();
        scanner.nextLine();

        // while
        int sum = start;
        int n = start + 1;
        while (n <= end) {
            sum += n;
            n ++;
        }
        System.out.printf("sum: %d\n", sum);

        // do-while
        sum = start;
        n = start + 1;
        do {
            sum += n;
            n++;
        }while (n<=end);
    }
}
