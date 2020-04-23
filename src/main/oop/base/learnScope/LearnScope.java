package base.learnScope;

/**
 * @author LiFu
 * @date 2020/4/23 下午4:37
 * @description learn scope
 */

//定义为public的class、interface可以被其他任何类访问：
public class LearnScope {
    // 定义为public的field、method可以被其他类访问，前提是首先有访问class的权限
    public String name;

    void foo(String[] args) {
        // 包作用域(default)是指一个类允许访问同一个package的没有public、private修饰的class
        PersonN1 psN1 = new PersonN1();
        // 没有public、protected、private修饰的字段和方法
        psN1.hi();
    }

    public void hello() {
        System.out.println("hello");
    }

    // 定义为private的field、method无法被其他类访问
    private void happy() {
        System.out.println("happy");
    }



//    方法参数name是局部变量，它的作用域是整个方法，即①～⑩；
//    变量s的作用域是定义处到方法结束，即②～⑩；
//    变量len的作用域是定义处到方法结束，即③～⑩；
//    变量p的作用域是定义处到if块结束，即⑤～⑨；
//    变量i的作用域是for循环，即⑥～⑧。
    void hi(String name) { // ①
        String s = name.toLowerCase(); // ②
        int len = s.length(); // ③
        if (len < 10) { // ④
            int p = 10 - len; // ⑤
            for (int i=0; i<10; i++) { // ⑥
                System.out.println(); // ⑦
            } // ⑧
        } // ⑨
    } // ⑩

    // 嵌套类（nested class）
    class Inner {
        // 嵌套类拥有访问private的权限
        public void hi() {
            happy();
        }
    }
}

// 包作用域是指一个类允许访问同一个package的没有public、private修饰的class
class Person {
    // 定义为protected的字段和方法可以被子类访问，以及子类的子类
    protected void hi() {
        System.out.println("hi");
    }

    // 用final修饰method无法被覆写:
    final void say() {
    }

    // 用final修饰局部变量可以阻止被重新赋值
    void hei(final int t) {
    }
}

//final与访问权限不冲突，用final修饰class可以阻止被继承
final class Student extends Person {
    public void hei() {
        hi();
    }
}