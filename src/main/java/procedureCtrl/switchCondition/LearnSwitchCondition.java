package procedureCtrl.switchCondition;

import java.util.Scanner;

/**
 * @author LiFu
 * @date 2020/4/21 下午3:57
 * @description learn switch condition
 */
public class LearnSwitchCondition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("select:");
        int option = scanner.nextInt();
        // 清空缓存的\n
        scanner.nextLine();
        switch (option) {
            case 1:
                System.out.println("Selected 1");
                break;
            case 2:
                System.out.println("Selected 2");
                break;
            case 3:
                System.out.println("Selected 3");
                break;
            default:
                System.out.println("Not selected");
                break;
        }

        System.out.println("select:");
        String fruit = scanner.nextLine();
        switch (fruit) {
            case "apple":
                System.out.println("Selected apple");
                break;
            case "pear":
                System.out.println("Selected pear");
                break;
            case "mango":
                System.out.println("Selected mango");
                break;
            default:
                System.out.println("No fruit selected");
                break;
        }
    }
}
