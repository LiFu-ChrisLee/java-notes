package learnUseG;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LiFu
 * @date 2020/4/30 下午2:22
 * @description learn use
 */
public class LearnUseG {
    public static void main(String[] args) {
        // 可以省略后面的Number，编译器可以自动推断泛型类型：
        List<Number> list = new ArrayList<>();
        System.out.println(list);

        Person[] ps = new Person[]{
                new Person("Bob", 61),
                new Person("Alice", 88),
                new Person("Lily", 75),
        };
        // Arrays.sort(Object[])可以对任意数组进行排序，但待排序的元素必须实现Comparable<T>这个泛型接口
        Arrays.sort(ps);
        System.out.println(Arrays.toString(ps));
    }
}

//public interface Comparable<T> {
//    /**
//     * 返回-1: 当前实例比参数o小
//     * 返回0: 当前实例与参数o相等
//     * 返回1: 当前实例比参数o大
//     */
//    int compareTo(T o);
//}

class Person implements Comparable<Person> {
    String name;
    int score;

    Person(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.score;
    }

    @Override
    public int compareTo(@NotNull Person person) {
        return this.name.compareTo(person.name);
    }
}