package learnGroup;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author LiFu
 * @date 2020/5/18 上午10:59
 * @description learn group
 */
public class LearnGroup {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("(\\d{3,4})\\-(\\d{7,8})");
        Matcher m = p.matcher("010-12345678");
        if (m.matches()) {
            String whole = m.group(0);
            String g1 = m.group(1);
            String g2 = m.group(2);
            System.out.println(whole);
            System.out.println(g1);
            System.out.println(g2);
        } else {
            System.out.println("匹配失败!");
        }
    }
}
