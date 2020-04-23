package base.learnStatic;

/**
 * @author LiFu
 * @date 2020/4/23 下午2:25
 * @description learn static
 */
public class LearnStatic {
    public static void main(String[] args) {
        Person.setNumber(99);
        System.out.println(Person.number);
    }
}

//interface是可以有静态字段的，并且静态字段必须为final类型
interface PurePerson {
    public static final int MALE = 1;
    // public static final可以省略
    int FEMALE = 2;
}

class Person {
    public static int number;

    // 静态方法内部，无法访问this变量，也无法访问实例字段，它只能访问静态字段
    // 静态方法常用于工具类和辅助方法。
    public static void setNumber(int value) {
        number = value;
    }
}
