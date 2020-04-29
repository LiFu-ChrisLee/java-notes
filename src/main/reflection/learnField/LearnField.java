package learnField;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author LiFu
 * @date 2020/4/28 下午6:07
 * @description learn field
 */
public class LearnField {
    public static void main(String[] args) throws Exception {
//        Field getField(name)：根据字段名获取某个public的field（包括父类）
//        Field getDeclaredField(name)：根据字段名获取当前类的某个field（不包括父类）
//        Field[] getFields()：获取所有public的field（包括父类）
//        Field[] getDeclaredFields()：获取当前类的所有field（不包括父类）

        Class stdClass = Student.class;
        // 获取public字段"score":
        System.out.println(stdClass.getField("score"));
        // 获取继承的public字段"name":
        System.out.println(stdClass.getField("name"));
        // 获取private字段"grade":
        System.out.println(stdClass.getDeclaredField("grade"));

//        一个Field对象包含了一个字段的所有信息：
//        getName()：返回字段名称，例如，"name"；
//        getType()：返回字段类型，也是一个Class实例，例如，String.class；
//        getModifiers()：返回字段的修饰符，它是一个int，不同的bit表示不同的含义。

        Field f = String.class.getDeclaredField("value");

        System.out.println(f.getName()); // "value"
        System.out.println(f.getType()); // class [B 表示byte[]类型
        int m = f.getModifiers();
        System.out.println(Modifier.isFinal(m)); // true
        System.out.println(Modifier.isPublic(m)); // false
        System.out.println(Modifier.isProtected(m)); // false
        System.out.println(Modifier.isPrivate(m)); // true
        System.out.println(Modifier.isStatic(m)); // false

        // 获取实例的字段值
        Object p = new Person("Ming");
        Class c = p.getClass();
        f = c.getDeclaredField("name");
        // 别管这个字段是不是public，一律允许访问
//        f.setAccessible(true);
        Object value = f.get(p);
        System.out.println(value); // "Ming"
        f.set(p, "Hong");
        System.out.println(f.get(p));
    }
}

class Student extends Person {
    public int score;
    private int grade;

    public Student(String name) {
        super(name);
    }
}

class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }
}
