package learnPriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author LiFu
 * @date 2020/5/8 下午4:52
 * @description learn PriorityQueue
 */
public class LearnPriorityQueue {
    public static void main(String[] args) {
        // PriorityQueue和Queue的区别在于，它的出队顺序与元素的优先级有关，对PriorityQueue调用remove()或poll()方法，返回的总是优先级最高的元素。

        // PriorityQueue允许我们提供一个Comparator对象来判断两个元素的顺序
        Queue<User> q = new PriorityQueue<>(new UserComparator());
        // 添加3个元素到队列:
        q.offer(new User("Bob", "A1"));
        q.offer(new User("Alice", "A2"));
        q.offer(new User("Boss", "V1"));
        q.offer(new User("Chris", "A10"));
        System.out.println(q.poll()); // Boss/V1
        System.out.println(q.poll()); // Bob/A1
        System.out.println(q.poll()); // Alice/A2
        System.out.println(q.poll()); // Chris/A10
        System.out.println(q.poll()); // null，因为队列为空
    }
}

class UserComparator implements Comparator<User> {
    public int compare(User u1, User u2) {
        if (u1.number.charAt(0) == u2.number.charAt(0)) {
            // 如果两人的号都是A开头或者都是V开头，比较号的大小，号小的在前面，Integer默认小号在前:
            Integer u1n = Integer.valueOf(u1.number.replaceAll("[AV]", ""));
            Integer u2n = Integer.valueOf(u2.number.replaceAll("[AV]", ""));
            return u1n.compareTo(u2n);
        }
        if (u1.number.charAt(0) == 'V') {
            // u1的号码是V开头，优先级高，返回-1:
            return -1;
        } else {
            return 1;
        }
    }
}

class User {
    public final String name;
    public final String number;

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return name + "/" + number;
    }
}

