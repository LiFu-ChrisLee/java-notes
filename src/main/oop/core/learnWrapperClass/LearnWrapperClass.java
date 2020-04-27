package core.learnWrapperClass;

/**
 * @author LiFu
 * @date 2020/4/24 上午11:45
 * @description learn wrapper class
 */
public class LearnWrapperClass {
    public static void main(String[] args) {
        // 基本类型：byte，short，int，long，boolean，float，double，char
        // 引用类型：所有class和interface类型
        // 引用类型可以赋值为null，表示空，但基本类型不能赋值为null

        // 自动装箱（Auto Boxing）
        Integer n = 100; // 编译器自动使用Integer.valueOf(int)
        int x = n; // 编译器自动使用Integer.intValue()

        // 自动拆箱（Auto Unboxing）
        Integer m = x;

        // 对两个Integer实例进行比较要特别注意：绝对不能用==比较，因为Integer是引用类型，必须使用equals()比较
        System.out.println(n.equals(m));
    }
}
