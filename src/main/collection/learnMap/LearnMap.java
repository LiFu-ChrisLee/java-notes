package learnMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiFu
 * @date 2020/5/7 下午2:23
 * @description learn map
 */
public class LearnMap {
    public static void main(String[] args) {
        Student s = new Student("Ming", 99);
        Map<String, Student> map = new HashMap<>();
        // put()方法的签名是V put(K key, V value)，如果放入的key已经存在，put()方法会返回被删除的旧的value，否则，返回null
        map.put("Ming", s); // 将"Ming"和Student实例映射并关联
        Student target = map.get("Ming"); // 通过key查找并返回映射的Student实例
        System.out.println(target == s); // true，同一个实例
        System.out.println(target.score); // 99
        Student another = map.get("Bob"); // 通过另一个key查找
        System.out.println(another); // 未找到返回null

        // keySet()方法返回的Set集合，它包含不重复的key的集合
        for (String k : map.keySet()) {
            System.out.println(k + ": " + map.get(k));
        }

        // 同时遍历key和value
        for (Map.Entry<String, Student> entry : map.entrySet()) {
            String key = entry.getKey();
            Student value = entry.getValue();
            System.out.println(key + " = " + value);
        }
    }
}

class Student {
    public String name;
    public int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
