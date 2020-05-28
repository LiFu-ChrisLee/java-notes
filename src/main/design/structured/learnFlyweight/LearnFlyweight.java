package structured.learnFlyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiFu
 * @date 2020/5/27 下午3:26
 * @description learn Flyweight
 */
public class LearnFlyweight {
    public static void main(String[] args) {
        // 运用共享技术有效地支持大量细粒度的对象。
        // 如果一个对象实例一经创建就不可变，那么反复创建相同的实例就没有必要，直接向调用方返回一个共享的实例就行，这样即节省内存，又可以减少创建对象的过程，提高运行速度。

        // 当传入的int范围在-128~+127之间时，会直接返回缓存的Integer实例
        Integer n1 = Integer.valueOf(100);
        Integer n2 = Integer.valueOf(100);
        System.out.println(n1 == n2); // true

        // 总是使用工厂方法而不是new操作符创建实例，可获得享元模式的好处
        Student st = Student.create(1, "1");
    }
}

class Student {
    // 持有缓存:
    private static final Map<String, Student> cache = new HashMap<>();

    // 静态工厂方法:
    public static Student create(int id, String name) {
        String key = id + "\n" + name;
        // 先查找缓存:
        Student st = cache.get(key);
        if (st == null) {
            // 未找到,创建新对象:
            System.out.println(String.format("create new Student(%s, %s)", id, name));
            st = new Student(id, name);
            // 放入缓存:
            cache.put(key, st);
        } else {
            // 缓存中存在:
            System.out.println(String.format("return cached Student(%s, %s)", st.id, st.name));
        }
        return st;
    }

    private final int id;
    private final String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}