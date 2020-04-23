package base.learnAbstract;

/**
 * @author LiFu
 * @date 2020/4/23 上午9:45
 * @description learn abstract
 */
public class LearnAbstract {
    public static void main(String[] args) {
        // 这种尽量引用高层类型，避免引用实际子类型的方式，称之为面向抽象编程
        Person st = new Student();
        st.run();
    }
}

//必须把Person类本身也声明为abstract，才能正确编译它，Person类无法被实例化
//抽象类本身被设计成只能用于被继承，因此，抽象类可以强迫子类实现其定义的抽象方法
abstract class Person {
    // 方法声明为abstract，表示它是一个抽象方法
    public abstract void run();
}

class Student extends Person {
    @Override
    public void run() {
        System.out.println("Student.run");
    }
}

//如果不实现抽象方法，则该子类仍是一个抽象类
abstract class Male extends Person {
    private final String gender = "male";
}