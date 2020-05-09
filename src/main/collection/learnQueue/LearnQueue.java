package learnQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiFu
 * @date 2020/5/8 下午4:41
 * @description learn queue
 */
public class LearnQueue {
    public static void main(String[] args) {
//        Queue实现了一个先进先出（FIFO）的数据结构
//        队列接口Queue定义了以下几个方法：
//        int size()：获取队列长度；
//        boolean add(E)/boolean offer(E)：添加元素到队尾；
//        E remove()/E poll()：获取队首元素并从队列中删除；
//        E element()/E peek()：获取队首元素但并不从队列中删除。

//                              throw Exception	        返回false或null
//        添加元素到队尾	        add(E e)	            boolean offer(E e)
//        取队首元素并删除	        E remove()	            E poll()
//        取队首元素但不删除	    E element()	            E peek()

        Queue<String> q = new LinkedList<>();
        // 添加3个元素到队列:
        q.offer("apple");
        q.offer("pear");

        // 从队列取出元素:
        System.out.println(q.poll()); // apple
        System.out.println(q.peek()); // pear，poll()删除首元素
        System.out.println(q.poll()); // pear，peek()不删除元素
        System.out.println(q.poll()); // null，因为队列是空的
        System.out.println(q.peek()); // null，因为队列是空的
    }
}
