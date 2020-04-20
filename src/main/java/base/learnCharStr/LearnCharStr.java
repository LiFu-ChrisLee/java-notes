package base.learnCharStr;

/**
 * @author LiFu
 * @date 2020/4/17 下午5:37
 * @description learn char and string
 */
public class LearnCharStr {
    public static void main(String[] args) {
        String s1 = "abc\"xyz"; // 包含7个字符: a, b, c, ", x, y, z
        String s2 = "abc\\xyz"; // 包含7个字符: a, b, c, \, x, y, z
//        \" 表示字符"
//        \' 表示字符'
//        \\ 表示字符\
//        \n 表示换行符
//        \r 表示回车符
//        \t1 表示Tab
//        \\u#### 表示一个Unicode编码的字符
        String s3 = "ABC\n\u4e2d\u6587"; // 包含6个字符: A, B, C, 换行符, 中, 文
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

//        字符串连接
        String ss1 = "Hello";
        String ss2 = "world";
        String ss = ss1 + " " + ss2 + "!";
        System.out.println(ss);

//        如果用+连接字符串和其他数据类型，会将其他数据类型先自动转型为字符串，再连接
        int age = 25;
        String si = "age is " + age;
        System.out.println(si);

        String sss = "hello";
        String t1 = sss;
        sss = "world";
        System.out.println(t1); // t是"hello"还是"world"?
    }
}
