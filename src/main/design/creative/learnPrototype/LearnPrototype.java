package creative.learnPrototype;

import java.util.Arrays;

/**
 * @author LiFu
 * @date 2020/5/25 下午5:26
 * @description learn prototype
 */
public class LearnPrototype {
    public static void main(String[] args) {
        // 用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
        // 因为很多实例会持有类似文件、Socket这样的资源，而这些资源是无法复制给另一个对象共享的，只有存储简单类型的“值”对象可以复制

        // 原型:
        String[] original = { "Apple", "Pear", "Banana" };
        // 新对象:
        String[] copy = Arrays.copyOf(original, original.length);

        Student std1 = new Student();
        std1.setId(123);
        std1.setName("Bob");
        std1.setScore(88);
        // 复制新对象:
        Student std2 = std1.copy();
        System.out.println(std1);
        System.out.println(std2);
        System.out.println(std1 == std2); // false

    }
}

class Student {
    private int id;
    private String name;
    private int score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student copy() {
        Student std = new Student();
        std.id = this.id;
        std.name = this.name;
        std.score = this.score;
        return std;
    }
}
