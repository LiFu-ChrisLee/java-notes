package procedureCtrl.breakContinue;

/**
 * @author LiFu
 * @date 2020/4/21 下午6:40
 * @description learn break continue
 */
public class LearnBreakContinue {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; ; i++) {
            System.out.println("begin i = " + i);
            if (i % 2 == 0) {
                continue; // continue语句会结束自己所在的那一层循环的本次循环
            }
            sum = sum + i;
            System.out.println("end i = " + i);
            if (sum > 99) {
                break; // break语句会跳出自己所在的那一层循环
            }
        }
        System.out.println(sum); // 25
    }
}
