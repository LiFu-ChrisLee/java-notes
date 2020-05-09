package learnSet;

import java.util.*;

/**
 * @author LiFu
 * @date 2020/5/8 下午3:46
 * @description learn Set
 */
public class LearnSet {
    public static void main(String[] args) {
//        Set用于存储不重复的元素集合，它主要提供以下几个方法：
//        将元素添加进Set<E>：boolean add(E e)
//        将元素从Set<E>删除：boolean remove(Object e)
//        判断是否包含元素：boolean contains(Object e)


//        HashSet是无序的，因为它实现了Set接口，并没有实现SortedSet接口；
//        TreeSet是有序的，因为它实现了SortedSet接口。

        // 使用Set去除重复的消息
        List<Message> received = List.of(
                new Message(1, "Hello!"),
                new Message(2, "发工资了吗？"),
                new Message(2, "发工资了吗？"),
                new Message(3, "去哪吃饭？"),
                new Message(3, "去哪吃饭？"),
                new Message(4, "Bye")
        );
        List<Message> displayMessages = process(received);
        for (Message message : displayMessages) {
            System.out.println(message.text);
        }
    }

    static List<Message> process(List<Message> received) {
        Set<Message> set = new HashSet<>(received);
        return new ArrayList<>(set);
    }
}

class Message {
    public final int sequence;
    public final String text;

    public Message(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Message) {
            Message msg = (Message) o;
            return Objects.equals(msg.sequence, sequence) && Objects.equals(msg.text, text);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sequence, text);
    }
}
