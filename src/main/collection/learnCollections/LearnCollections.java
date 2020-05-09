package learnCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author LiFu
 * @date 2020/5/9 下午3:34
 * @description learn Collections
 */
public class LearnCollections {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        // 给一个Collection类型的集合添加若干元素
        Collections.addAll(list, 1, 2, 3);
        System.out.println(list);

//        Collections提供了一系列方法来创建空集合：
//        创建空List：List<T> emptyList()
//        创建空Map：Map<K, V> emptyMap()
//        创建空Set：Set<T> emptySet()
        List<Integer> list1 = Collections.emptyList();
        // 空集合无法添加删除元素
        // list1.add(1);
        System.out.println(list1);

//        创建单元素集合
//        Collections提供了一系列方法来创建一个单元素集合：
//        创建一个元素的List：List<T> singletonList(T o)
//        创建一个元素的Map：Map<K, V> singletonMap(K key, V value)
//        创建一个元素的Set：Set<T> singleton(T o)
        List<Integer> list2 = Collections.singletonList(1);
        System.out.println(list2);
        // 用of(T...)更方便
        List<Integer> list3 = List.of(1);
        System.out.println(list3);
        List<Integer> list4 = List.of(1, 3, 2, 4);
        System.out.println(list4);

//        Collections可以对List进行排序。因为排序会直接修改List元素的位置，因此必须传入可变List
        List<Integer> list5 = new ArrayList<>(list4);
        Collections.sort(list5);
        System.out.println(list5);

//        Collections提供了洗牌算法，即传入一个有序的List，可以随机打乱List内部元素的顺序，效果相当于让计算机洗牌
        Collections.shuffle(list5);
        System.out.println(list5);

//        Collections还提供了一组方法把可变集合封装成不可变集合：
//        封装成不可变List：List<T> unmodifiableList(List<? extends T> list)
//        封装成不可变Set：Set<T> unmodifiableSet(Set<? extends T> set)
//        封装成不可变Map：Map<K, V> unmodifiableMap(Map<? extends K, ? extends V> m)
        // 实际上是通过创建一个代理对象，拦截掉所有修改方法实现的
        List<String> mutable = new ArrayList<>();
        mutable.add("apple");
        mutable.add("pear");
        // 变为不可变集合:
        List<String> immutable = Collections.unmodifiableList(mutable);
        // immutable.add("orange"); // UnsupportedOperationException!
        System.out.println(immutable); // [apple, pear]
        mutable.add("banana");
        // 继续对原始的可变List进行增删是可以的，并且，会直接影响到封装后的“不可变”List
        System.out.println(mutable); // [apple, pear, banana]
        System.out.println(immutable); // [apple, pear, banana]
        // 如果我们希望把一个可变List封装成不可变List，那么，返回不可变List后，最好立刻扔掉可变List的引用
        mutable = null;

//        Collections还提供了一组方法，可以把线程不安全的集合变为线程安全的集合：
//        变为线程安全的List：List<T> synchronizedList(List<T> list)
//        变为线程安全的Set：Set<T> synchronizedSet(Set<T> s)
//        变为线程安全的Map：Map<K,V> synchronizedMap(Map<K,V> m)
//        Java 5开始，引入了更高效的并发集合类，所以上述这几个同步方法已经没有什么用了
    }
}
