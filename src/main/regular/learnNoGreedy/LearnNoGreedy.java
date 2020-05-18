package learnNoGreedy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author LiFu
 * @date 2020/5/18 上午11:24
 * @description learn no greedy
 */
public class LearnNoGreedy {
    public static void main(String[] args) {
        // 贪婪模式
        Pattern pattern = Pattern.compile("(\\d+)(0*)");
        Matcher matcher = pattern.matcher("1230000");
        if (matcher.matches()) {
            System.out.println("group1=" + matcher.group(1)); // "1230000"
            System.out.println("group2=" + matcher.group(2)); // ""
        }

        // 非贪婪模式
        Pattern pattern1 = Pattern.compile("(\\d+?)(0*)");
        Matcher matcher1 = pattern1.matcher("1230000");
        if (matcher1.matches()) {
            System.out.println("group1=" + matcher1.group(1)); // "123"
            System.out.println("group2=" + matcher1.group(2)); // "0000"
        }

        // 正则表达式(\d??)(9*)，注意\d?表示匹配0个或1个数字，后面第二个?表示非贪婪匹配
        // 给定字符串"9999"，匹配到的两个子串分别是""和"9999"
        Pattern pattern2 = Pattern.compile("(\\d??)(9*)");
        Matcher matcher2 = pattern2.matcher("9999");
        if (matcher2.matches()) {
            System.out.println("group1=" + matcher2.group(1)); // ""
            System.out.println("group2=" + matcher2.group(2)); // "9999"
        }
    }
}
