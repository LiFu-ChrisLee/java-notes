package base.learnMethod;

import java.util.Arrays;

/**
 * @author LiFu
 * @date 2020/4/22 下午3:02
 * @description learn method
 */
public class LearnMethod {
    public static void main(String[] args) {
        Person ming = new Person();
        ming.setName("Xiao Ming"); // 设置name
//        ming.setAge(12); // 设置age
        ming.setBirth(1990);
        System.out.println(ming.getName() + ", " + ming.getAge());

        Group gp = new Group();
        gp.setNames("a", "b", "c");
        System.out.println(Arrays.toString(gp.getNames()));
        gp.setNames("a", "b");
        System.out.println(Arrays.toString(gp.getNames()));

        // 基本类型参数的传递，是调用方值的复制。双方各自的后续修改，互不影响
        Person wu = new Person();
        int birth = 1990;
        wu.setBirth(birth);
        System.out.println(wu.getAge());
        birth = 1991;
        System.out.println(wu.getAge());

        // 引用类型参数的传递，调用方的变量，和接收方的参数变量，指向的是同一个对象。双方任意一方对这个对象的修改，都会影响对方
        AgeList al = new AgeList();
        int[] ages = {1,2,3};
        al.setAges(ages);
        System.out.println(Arrays.toString(al.getAges()));
        ages[1] = 4;
        System.out.println(Arrays.toString(al.getAges()));

        // p里面的name复制了指向"Bob"的指针，当bob改为指向"Alice"的指针时，p里面name的指针不变
        Person p = new Person();
        String bob = "Bob";
        p.setName(bob); // 传入bob变量
        System.out.println(p.getName()); // "Bob"
        bob = "Alice"; // bob改名为Alice
        System.out.println(p.getName()); // "Bob"还是"Alice"? "Bob"
    }
}

class Person {
    private String name;
//    private int age;
    private int birth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
//        return age;
        return calcAge();
    }

//    public void setAge(int age) {
//        this.age = age;
//    }

    // private方法:
    private int calcAge() {
        return 2019 - this.birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }
}

class Group {
    private String[] names;

    // 可变参数用类型...定义，可变参数相当于数组类型
    public void setNames(String... names) {
        this.names = names;
    }

    public String[] getNames() {
        return names;
    }
}

class AgeList {
    private int[] ages;

    public int[] getAges() {
        return ages;
    }

    public void setAges(int[] ages) {
        this.ages = ages;
    }
}