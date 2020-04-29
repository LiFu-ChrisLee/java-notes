package learnMethod;

import java.lang.reflect.Method;

/**
 * @author LiFu
 * @date 2020/4/28 下午7:43
 * @description learn method
 */
public class LearnMethod {
    public static void main(String[] args) throws Exception {
//        Method getMethod(name, Class...)：获取某个public的Method（包括父类）
//        Method getDeclaredMethod(name, Class...)：获取当前类的某个Method（不包括父类）
//        Method[] getMethods()：获取所有public的Method（包括父类）
//        Method[] getDeclaredMethods()：获取当前类的所有Method（不包括父类）

        Class stdClass = Student.class;
        // 获取public方法getScore，参数为String:
        System.out.println(stdClass.getMethod("getScore", String.class));
        // 获取继承的public方法getName，无参数:
        System.out.println(stdClass.getMethod("getName"));
        // 获取private方法getGrade，参数为int:
        System.out.println(stdClass.getDeclaredMethod("getGrade", int.class));

//        一个Method对象包含一个方法的所有信息：
//        getName()：返回方法名称，例如："getScore"；
//        getReturnType()：返回方法返回值类型，也是一个Class实例，例如：String.class；
//        getParameterTypes()：返回方法的参数类型，是一个Class数组，例如：{String.class, int.class}；
//        getModifiers()：返回方法的修饰符，它是一个int，不同的bit表示不同的含义。

        // String对象:
        String s = "Hello world";
        // 获取String substring(int)方法，参数为int:
        Method m = String.class.getMethod("substring", int.class, int.class);
        // 在s对象上调用该方法并获取结果:
        String r = (String) m.invoke(s, 6, 8);
        // 打印调用结果:
        System.out.println(r);

        // 调用非public方法
        Person p = new Person();
        Class pCls = p.getClass();
        Method pM = pCls.getDeclaredMethod("setName", String.class);
        pM.setAccessible(true);
        pM.invoke(p, "hei");
        System.out.println(p.getName());

        Student st = new Student();
        // 多态
        // 相当于：
        // Person p = new Student();
        // p.hello();
        Method pMH = pCls.getMethod("hello");
        pMH.invoke(st);
    }
}

class Student extends Person {
    public int getScore(String type) {
        return 99;
    }

    private int getGrade(int year) {
        return 1;
    }

    public void hello() {
        System.out.println("Student:hello");
    }
}

class Person {
    private String name = "";

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        if (!name.equals("")) {
            return name;
        }
        return "Person";
    }

    public void hello() {
        System.out.println("Person:hello");
    }
}
