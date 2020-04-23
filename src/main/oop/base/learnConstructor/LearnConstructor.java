package base.learnConstructor;

/**
 * @author LiFu
 * @date 2020/4/22 下午3:41
 * @description learn constructor
 */
public class LearnConstructor {
    public static void main(String[] args) {
        // 匹配Person(String name, int age)构造方法
        Person ming = new Person("ming", 12);
        System.out.println(ming.getName());
        System.out.println(ming.getAge());
        // 匹配Person()构造方法
        Person wu = new Person();
        System.out.println(wu.getName());
        System.out.println(wu.getAge());
    }
}

class Person {
    private String name; // 默认初始化为null
    private int age; // 默认初始化为0
    private int birth = 1991; // 自定义初始化

    // 多构造函数
    Person() {
        // 一个构造方法可以调用其他构造方法，这样做的目的是便于代码复用
        this("Unnamed", 0);
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public int getBirth() {
        return birth;
    }
}