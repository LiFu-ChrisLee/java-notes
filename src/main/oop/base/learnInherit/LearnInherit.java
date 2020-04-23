package base.learnInherit;

/**
 * @author LiFu
 * @date 2020/4/22 下午5:19
 * @description learn inherit
 */
public class LearnInherit {
    public static void main(String[] args) {
        // instanceof实际上判断一个变量所指向的实例是否是指定类型，或者这个类型的子类
        Student s = new Student();
        System.out.println(s instanceof Person);
        System.out.println(s instanceof Student);

        // 把一个子类类型安全地变为更加抽象的父类类型的赋值，向上转型（upcast）
        Person p = new Student();
        System.out.println(p instanceof Person);
        System.out.println(p instanceof Student);

        // 父类类型强制转型为子类类型，向下转型（downcast）
        Student s1 = (Student) p;
        System.out.println(s1 instanceof Person);
        System.out.println(s1 instanceof Student);
    }
}

//超类（super class），父类（parent class），基类（base class）
//无extends，自动加上extends Object
class Person {
    // 子类无法访问父类的private字段或者private方法
//    private String name;
    private int age;

    // 用protected修饰的字段可以被子类访问
    // protected关键字可以把字段和方法的访问权限控制在继承树内部，一个protected字段和方法可以被其子类，以及子类的子类所访问
    protected String name;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
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
}

//子类（subclass），扩展类（extended class）
class Student extends Person {
    private int score;

    public Student() {
    }

    public Student(int age, String name, int score) {
        // 任何class的构造方法，第一行语句必须是调用父类的构造方法
        // 如果没有明确地调用父类的构造方法，编译器会帮我们自动加一句super()
        // 如果父类没有默认的构造方法，子类就必须显式调用super()并给出参数以便让编译器定位到父类的一个合适的构造方法
        // 子类不会继承任何父类的构造方法。子类默认的构造方法是编译器自动生成的，不是继承的
        super(age, name);
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String hello() {
        // super关键字表示父类（超类）。子类引用父类的字段时，可以用super.fieldName
        // return "Hello, " + super.name;
        // 这里使用super.name，或者this.name，或者name，效果都是一样的。编译器会自动定位到父类的name字段
        return "Hello, " + name;
    }
}