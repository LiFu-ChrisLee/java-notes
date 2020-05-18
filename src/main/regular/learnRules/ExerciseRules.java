package learnRules;


import java.util.List;

/**
 * @author LiFu
 * @date 2020/5/15 下午5:17
 * @description 1. 正则表达式匹配国内的电话号码规则：3~4位区号加7~8位电话，中间用-连接，例如：010-12345678
 * 2. 国内区号必须以0开头，而电话号码不能以0开头，试修改正则表达式，使之能更精确地匹配
 */
public class ExerciseRules {
    public static void main(String[] args) {
        String re = "\\d{3,4}-\\d{7,8}";
        for (String s : List.of("010-12345678", "020-9999999", "0755-7654321")) {
            if (!s.matches(re)) {
                System.out.println("测试失败: " + s);
                return;
            }
        }
        for (String s : List.of("010 12345678", "A20-9999999", "0755-7654.321")) {
            if (s.matches(re)) {
                System.out.println("测试失败: " + s);
                return;
            }
        }
        System.out.println("测试成功!");

        String re1 = "0\\d{2,3}-[^0]\\d{6,7}";
        for (String s : List.of("010-12345678", "020-9999999", "0755-7654321")) {
            if (!s.matches(re1)) {
                System.out.println("测试失败: " + s);
                return;
            }
        }
        System.out.println("测试成功!");
    }
}
