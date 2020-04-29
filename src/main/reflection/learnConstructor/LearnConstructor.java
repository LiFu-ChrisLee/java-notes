package learnConstructor;

import java.lang.reflect.Constructor;

/**
 * @author LiFu
 * @date 2020/4/29 上午10:16
 * @description learn constructor
 */
public class LearnConstructor {
    public static void main(String[] args) throws Exception {
        // 如果通过反射来创建新的实例，可以调用Class提供的newInstance()方法，只能调用该类的public无参数构造方法
        Person p = Person.class.newInstance();

        // 为了调用任意的构造方法，Java的反射API提供了Constructor对象，它包含一个构造方法的所有信息，可以创建一个实例
        // Constructor对象和Method非常类似，不同之处仅在于它是一个构造方法，并且，调用结果总是返回实例
        Constructor pCst = Person.class.getDeclaredConstructor(String.class);
        // 调用非public的Constructor时，必须首先通过setAccessible(true)设置允许访问
        pCst.setAccessible(true);
        // Constructor总是当前类定义的构造方法，和父类无关，因此不存在多态的问题
        Person p1 = (Person) pCst.newInstance("123");

//        通过Class实例获取Constructor的方法如下：
//        getConstructor(Class...)：获取某个public的Constructor；
//        getDeclaredConstructor(Class...)：获取某个Constructor；
//        getConstructors()：获取所有public的Constructor；
//        getDeclaredConstructors()：获取所有Constructor。

    }
}

class Person {
    private String name = "";

    public Person() {
    }

    private Person(String name) {
        this.name = name;
    }
}