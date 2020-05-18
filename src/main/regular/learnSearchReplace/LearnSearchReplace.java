package learnSearchReplace;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author LiFu
 * @date 2020/5/18 上午11:41
 * @description learn search replace
 */
public class LearnSearchReplace {
    public static void main(String[] args) {
        // 分割字符串
        System.out.println(Arrays.toString("a b c".split("\\s"))); // { "a", "b", "c" }
        System.out.println(Arrays.toString("a b  c".split("\\s"))); // { "a", "b", "", "c" }
        System.out.println(Arrays.toString("a, b ;; c".split("[\\,\\;\\s]+"))); // { "a", "b", "c" }

        // 搜索字符串
        String s = "the quick brown fox jumps over the lazy dog.";
        Pattern p = Pattern.compile("\\wo\\w");
        Matcher m = p.matcher(s);

        // 反复调用find()方法，在整个串中搜索能匹配上\\wo\\w规则的子串
        while (m.find()) {
            String sub = s.substring(m.start(), m.end());
            System.out.println(sub);
        }

        // 替换字符串
        String s1 = "The     quick\t\t brown   fox  jumps   over the  lazy dog.";
        String r = s1.replaceAll("\\s+", " ");
        System.out.println(r); // "The quick brown fox jumps over the lazy dog."

        // 反向引用
        // 第二个参数可以使用$1、$2来反向引用匹配到的子串
        String s2 = "the quick brown fox jumps over the lazy dog.";
        String r1 = s2.replaceAll("\\s([a-z]{4})\\s", " <b>$1</b> ");
        System.out.println(r1);
    }
}
