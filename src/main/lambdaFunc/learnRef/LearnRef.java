package learnRef;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author LiFu
 * @date 2020/5/22 上午9:33
 * @description learn reference
 */
public class LearnRef {
    public static void main(String[] args) {
        String[] array = new String[] { "Apple", "Orange", "Banana", "Lemon" };

        // 静态方法引用
        // Arrays.sort(array, LearnRef::cmp);

        // 实例方法引用
        // 因为实例方法有一个隐含的this参数，String类的compareTo()方法在实际调用的时候，第一个隐含参数总是传入this，相当于静态方法：
        // public static int compareTo(this, String o);
        // 所以，String.compareTo()方法也可作为方法引用传入。
        Arrays.sort(array, String::compareTo);
        System.out.println(String.join(", ", array));

        List<String> names = List.of("Bob", "Alice", "Tim");
        // 构造方法引用
        // 实例类型被看做返回类型
        List<Person> persons = names.stream().map(Person::new).collect(Collectors.toList());
        System.out.println(persons);
    }

    static int cmp(String s1, String s2) {
        return s1.compareTo(s2);
    }
}

class Person {
    String name;
    public Person(String name) {
        this.name = name;
    }
    public String toString() {
        return "Person:" + this.name;
    }
}
