package learnMapEqualsHash;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author LiFu
 * @date 2020/5/7 下午6:11
 * @description learn equals hash
 */
public class LearnMapEqualsHash {
    public static void main(String[] args) {
        Map<Person, String> map = new HashMap<>();
        Person p = new Person("A", "A", 10);
        map.put(p, "10");
        System.out.println(map.get(p));
    }
}

class Person {
    String firstName;
    String lastName;
    int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Person) {
            Person p = (Person) o;
            return Objects.equals(p.firstName, firstName) && Objects.equals(p.lastName, lastName) && age == p.age;
        }
        return false;
    }

//    @Override
//    int hashCode() {
//        int h = 0;
//        // 反复使用31*h，这样做的目的是为了尽量把不同的Person实例的hashCode()均匀分布到整个int范围
//        h = 31 * h + firstName.hashCode();
//        h = 31 * h + lastName.hashCode();
//        h = 31 * h + age;
//        return h;
//    }

    @Override
    public int hashCode() {
        // equals()用到的用于比较的每一个字段，都必须在hashCode()中用于计算；equals()中没有使用到的字段，绝不可放在hashCode()中计算
        return Objects.hash(firstName, lastName, age);
    }
}
