package procedureCtrl.switchCondition;

import java.util.Scanner;

/**
 * @author LiFu
 * @date 2020/4/21 下午4:39
 * @description 使用switch实现一个简单的石头、剪子、布游戏
 */
public class ExerciseSwitchCondition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("石头(1)，剪刀(2)，布(3):");
        int option = scanner.nextInt();
        // 清空缓存的\n
        scanner.nextLine();

        System.out.println("我出石头");
        switch (option) {
            case 1:
                System.out.println("你出石头，谁也没赢");
                break;
            case 2:
                System.out.println("你出剪刀，我赢了");
                break;
            case 3:
                System.out.println("你出布，你赢了");
                break;
            default:
                System.out.println("你输入错误");
        }
    }
}
