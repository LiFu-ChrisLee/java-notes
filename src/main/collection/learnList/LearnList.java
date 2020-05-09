package learnList;

import java.util.*;

/**
 * @author LiFu
 * @date 2020/5/7 上午9:47
 * @description learn list
 */
public class LearnList {
    public static void main(String[] args) {
//        List<E>接口，可以看到几个主要的接口方法：
//        在末尾添加一个元素：void add(E e)
//        在指定索引添加一个元素：void add(int index, E e)
//        删除指定索引的元素：int remove(int index)
//        删除某个元素：int remove(Object e)
//        获取指定索引的元素：E get(int index)
//        获取链表大小（包含元素的个数）：int size()

        // 创建
        List<Integer> list1 = new ArrayList<>(); // 可以添加 null
        List<Integer> list2 = new LinkedList<>(); // 可以添加 null
        List<Integer> list3 = List.of(1, 2, 5); // 不能添加 null

        // 遍历
        // 不推荐，LinkedList索引越大，访问速度越慢
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list3.get(i));
        }

        // 推荐，利用Iterator高效遍历
        // Iterator本身也是一个对象，但它是由List的实例调用iterator()方法的时候创建的
        // boolean hasNext()判断是否有下一个元素
        // E next()返回下一个元素
        for (Iterator it = list2.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }

        // 推荐，for each内部使用Iterator实现
        for (Integer i : list3) {
            System.out.println(i);
        }

        // List和Array转换
        // 调用toArray()方法，返回Object[]，会丢失类型信息
        Object[] arr1 = list3.toArray();
        System.out.println(Arrays.toString(arr1));

        // 给toArray(T[])传入一个类型相同的Array，List内部自动把元素复制到传入的Array中
        Integer[] arr2 = list3.toArray(new Integer[list3.size()]);
        System.out.println(Arrays.toString(arr2));

        // 通过List接口定义的T[] toArray(IntFunction<T[]> generator)方法
        Integer[] arr3 = list3.toArray(Integer[]::new);
        System.out.println(Arrays.toString(arr3));

        // 反过来，把Array变为List就简单多了，通过List.of(T...)方法最简单
        List<Integer> list4 = List.of(arr3); // 返回的是一个只读List
        System.out.println(list4);
    }
}
