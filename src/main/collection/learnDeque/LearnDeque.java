package learnDeque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author LiFu
 * @date 2020/5/9 上午11:23
 * @description learn Deque
 */
public class LearnDeque {
    public static void main(String[] args) {
//        允许两头都进，两头都出，这种队列叫双端队列（Double Ended Queue），学名Deque。
//        Java集合提供了接口Deque来实现一个双端队列，它的功能是：
//        既可以添加到队尾，也可以添加到队首；
//        既可以从队首获取，又可以从队尾获取。

//                              Queue	                        Deque
//        添加元素到队尾	        add(E e) / offer(E e)	        addLast(E e) / offerLast(E e)
//        取队首元素并删除	        E remove() / E poll()	        E removeFirst() / E pollFirst()
//        取队首元素但不删除	    E element() / E peek()	        E getFirst() / E peekFirst()
//        添加元素到队首	        无	                            addFirst(E e) / offerFirst(E e)
//        取队尾元素并删除	        无	                            E removeLast() / E pollLast()
//        取队尾元素但不删除	    无	                            E getLast() / E peekLast()

        // 避免把null添加到队列
        Deque<Integer> dq = new LinkedList<>();
        dq.offerLast(1);
        dq.offerLast(2);
        dq.offerLast(3);
        System.out.println(dq.pollLast()); // 3
        System.out.println(dq.pollFirst()); // 1
        System.out.println(dq.pollLast()); // 2
        System.out.println(dq.pollFirst()); // null
    }
}
