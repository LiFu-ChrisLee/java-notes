package learnRules;

/**
 * @author LiFu
 * @date 2020/5/15 下午2:58
 * @description learn rules
 */
public class LearnRules {
    public static void main(String[] args) {
        String re1 = "abc";
        System.out.println("abc".matches(re1));
        System.out.println("Abc".matches(re1));
        System.out.println("abcd".matches(re1));

        String re2 = "a\\&c"; // 对应的正则是a\&c
        System.out.println("a&c".matches(re2));
        System.out.println("a-c".matches(re2));
        System.out.println("a&&c".matches(re2));

        // 匹配任意字符                   正则.         字符串.

        // 匹配数字                      正则\d        字符串\\d

        // 匹配一个字母、数字或下划线        正则\w         字符串\\w

        // 匹配空格字符，包括空格和制表符    正则\s         字符串\\s

        // 匹配非数字，\W、\S同理           正则\D         字符串\\D

        String re3 = "java\\d"; // 对应的正则是java\d
        System.out.println("java9".matches(re3));
        System.out.println("java10".matches(re3));
        System.out.println("javac".matches(re3));

        String re4 = "java\\D";
        System.out.println("javax".matches(re4));
        System.out.println("java#".matches(re4));
        System.out.println("java5".matches(re4));

        // 重复匹配
        // 修饰符*可以匹配任意个字符，包括0个字符
        // 修饰符+可以匹配至少一个字符
        // 修饰符?可以匹配0个或一个字符
        // 修饰符{n}可以匹配n个字符
        // 修饰符{n,m}可以匹配n~m个字符
        // 修饰符{n,}可以匹配至少n个字符
    }
}
