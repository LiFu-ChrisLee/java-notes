package core.learnString;

import java.nio.charset.StandardCharsets;

/**
 * @author LiFu
 * @date 2020/4/24 上午9:41
 * @description learn string
 */
public class LearnString {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "HELLo";
        // 两个字符串比较，必须总是使用equals()方法
        System.out.println(s1.equals(s2));
        // 忽略大小写比较，使用equalsIgnoreCase()方法
        System.out.println(s1.equalsIgnoreCase(s2));
        // 是否包含子串:
        s1.contains("ll");
        s1.indexOf("l"); // 2
        s1.lastIndexOf("l"); // 3
        s1.startsWith("He"); // true
        s1.endsWith("lo"); // true

        // 提取子串的例子：
        s1.substring(2); // "llo"
        s1.substring(2, 4); // "ll"

        // 使用trim()方法可以移除字符串首尾空白字符。空白字符包括空格，\t，\r，\n
        "  \tHello\r\n ".trim(); // "Hello"

        // strip()方法也可以移除字符串首尾空白字符，类似中文的空格字符\u3000也会被移除
        "\u3000Hello\u3000".strip(); // "Hello"
        " Hello ".stripLeading(); // "Hello "
        " Hello ".stripTrailing(); // " Hello"

        // 判断字符串是否为空和空白字符串
        "".isEmpty(); // true，因为字符串长度为0
        "  ".isEmpty(); // false，因为字符串长度不为0
        "  \n".isBlank(); // true，因为只包含空白字符
        " Hello ".isBlank(); // false，因为包含非空白字符

        // 替换子串
        s1.replace('l', 'w'); // 所有字符'l'被替换为'w'
        "A,,B;C ,D".replaceAll("[,;\\s]+", ","); // "A,B,C,D"

        // 分割字符串
        "A,,B;C ,D".split("[,;\\s]+"); // {"A", "B", "C", "D"}

        // 拼接字符串
        String[] arr = {"A", "B", "C"};
        String s = String.join("***", arr); // "A***B***C"

        // 把任意基本类型或引用类型转换为字符串
        String.valueOf(123); // "123"
        String.valueOf(45.67); // "45.67"
        String.valueOf(true); // "true"
        String.valueOf(new Object()); // 类似java.lang.Object@636be97c

        // String和char[]类型可以互相转换
        char[] cs = "Hello".toCharArray(); // String -> char[]
        new String(cs); // char[] -> String

        // Java的String和char在内存中总是以Unicode编码表示
        // 编码
        // 手动把字符串转换成其他编码
        byte[] b = "Hello".getBytes(StandardCharsets.UTF_8); // 按UTF-8编码转换
        // 把已知编码的byte[]转换为String
        new String(b, StandardCharsets.UTF_8);
    }
}
