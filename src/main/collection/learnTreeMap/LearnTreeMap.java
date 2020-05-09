package learnTreeMap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author LiFu
 * @date 2020/5/8 上午9:40
 * @description learn TreeMap
 */
public class LearnTreeMap {
    public static void main(String[] args) {
        // SortedMap保证遍历时以Key的顺序来进行排序
        // 使用TreeMap时，放入的Key必须实现Comparable接口
        Map<String, Integer> map = new TreeMap<>();
        map.put("orange", 1);
        map.put("apple", 2);
        map.put("pear", 3);
        for (String key : map.keySet()) {
            System.out.println(key); // apple, orange, pear
        }

        // Comparator接口要求实现一个比较方法，它负责比较传入的两个元素a和b，如果a排位于b，则返回负数，通常是-1，如果a==b，则返回0，如果a>b，则返回正数，通常是1
        Map<Student, Integer> map2 = new TreeMap<>(new Comparator<Student>() {
            public int compare(Student p1, Student p2) {
                // 用于通过key查找value
                if (p1.score == p2.score) {
                    return 0;
                }
                return p1.score > p2.score ? -1 : 1;
                // 也可用Integer.compare()
//                return Integer.compare(p1.score, p2.score);
            }
        });
        map2.put(new Student("Tom", 77), 1);
        map2.put(new Student("Bob", 66), 2);
        map2.put(new Student("Lily", 99), 3);
        for (Student key : map2.keySet()) {
            System.out.println(key);
        }
        System.out.println(map2.get(new Student("Bob", 66))); // 2
    }
}

class Student {
    public String name;
    public int score;
    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public String toString() {
        return String.format("{%s: score=%d}", name, score);
    }
}
