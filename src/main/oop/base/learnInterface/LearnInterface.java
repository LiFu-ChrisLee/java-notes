package base.learnInterface;

/**
 * @author LiFu
 * @date 2020/4/23 上午11:35
 * @description learn interface
 */
public class LearnInterface {
    public static void main(String[] args) {

    }
}

//如果一个抽象类没有字段，所有方法全部都是抽象方法，就可以把该抽象类改写为接口：interface
//接口定义的所有方法默认都是public abstract的，所以这两个修饰符不需要写出来（写不写效果都一样）
interface PersonSay {
    void say();

    // default方法
    default void talk() {
        System.out.println("talk");
    }
}

//一个interface可以继承自另一个interface
interface PersonMethods extends PersonSay {
    void run();

    String getName();
}

interface PersonHello {
    void hello(String anotherName);
}

//一个类可以实现多个interface
abstract class Person implements PersonMethods, PersonHello {
    protected String name;

    public Person(String name) {
        this.name = name;
    }
}

class Student extends Person {
    public Student(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Hello " + name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void hello(String anotherName) {
        System.out.println("Hello" + anotherName);
    }

    @Override
    public void say() {
        System.out.println("Say something");
    }
}