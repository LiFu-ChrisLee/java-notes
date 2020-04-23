package base.learnOverload;

/**
 * @author LiFu
 * @date 2020/4/22 下午4:10
 * @description learn overload
 */
public class LearnOverload {
    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.hello();
        hello.hello("a");
        hello.hello("b", 10);
    }
}

class Hello {
    // 如果有一系列方法，它们的功能都是类似的，只有参数有所不同，那么，可以把这一组方法名做成同名方法，称为方法重载（Overload）
    public void hello() {
        System.out.println("Hello, world!");
    }

    public void hello(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public void hello(String name, int age) {
        if (age < 18) {
            System.out.println("Hi, " + name + "!");
        } else {
            System.out.println("Hello, " + name + "!");
        }
    }
}