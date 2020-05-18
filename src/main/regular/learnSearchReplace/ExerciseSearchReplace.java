package learnSearchReplace;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author LiFu
 * @date 2020/5/18 上午11:52
 * @description 请编写一个简单的模板引擎，利用正则表达式实现这个功能。
 */

/*
 * 模板引擎是指，定义一个字符串作为模板：
 * Hello, ${name}! You are learning ${lang}!
 * 其中，以${key}表示的是变量，也就是将要被替换的内容
 * 当传入一个Map<String, String>给模板后，需要把对应的key替换为Map的value。
 * 例如，传入Map为：
 * {
 *      "name": "Bob",
 *      "lang": "Java"
 * }
 * 然后，${name}被替换为Map对应的值"Bob”，${lang}被替换为Map对应的值"Java"，最终输出的结果为：
 * Hello, Bob! You are learning Java!
 */
public class ExerciseSearchReplace {
    public static void main(String[] args) {
        String raw = "Hello, ${name}! You are learning ${lang}!";
        Map<String, String> varsMap = Map.of("name", "Bob", "lang", "Java");
        String outer = replaceVars(raw, varsMap);
        if (outer.equals("Hello, Bob! You are learning Java!")) {
            System.out.println("替换成功");
        } else {
            System.out.println("替换失败");
        }
    }

    private static String replaceVars(String raw, Map<String, String> varsMap) {
        String outer = raw;
        for (String key : varsMap.keySet()) {
            String re = String.format("\\$\\{%s\\}", key);
            outer = outer.replaceAll(re, varsMap.get(key));
        }
        return outer;
    }
}
