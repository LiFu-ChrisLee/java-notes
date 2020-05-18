package learnGroup;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author LiFu
 * @date 2020/5/18 上午11:10
 * @description 利用分组匹配，从字符串"23:01:59"提取时、分、秒
 */
public class ExerciseGroup {
    public static void main(String[] args) {
        String re = "(2[0-3]|[01]\\d):([0-5]\\d):([0-5]\\d)";
        String time = "23:01:59";
        Pattern pa = Pattern.compile(re);
        Matcher ma = pa.matcher(time);
        if (ma.matches()) {
            String hour = ma.group(1);
            String minute = ma.group(2);
            String second = ma.group(3);
            System.out.println(hour);
            System.out.println(minute);
            System.out.println(second);
        } else {
            System.out.println("未匹配");
        }
    }
}
