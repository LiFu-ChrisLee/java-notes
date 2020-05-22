package learnStream.others;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author LiFu
 * @date 2020/5/22 下午3:53
 * @description learn others
 */
public class Others {
    public static void main(String[] args) {
        // 排序，转换操作
        List<String> list = List.of("Orange", "apple", "Banana")
                .stream()
                // 要求Stream的每个元素必须实现Comparable接口。如果要自定义排序，传入指定的Comparator即可
                //         .sorted(String::compareToIgnoreCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(list);

        // 去重，转换操作
        List<String> list1 = List.of("A", "B", "A", "C", "B", "D")
                .stream()
                .distinct()
                .collect(Collectors.toList()); // [A, B, C, D]
        System.out.println(list1);

        // 截取，转换操作
        List<String> list2 = List.of("A", "B", "C", "D", "E", "F")
                .stream()
                .skip(2) // 跳过A, B
                .limit(3) // 截取C, D, E
                .collect(Collectors.toList()); // [C, D, E]
        System.out.println(list2);

        // 合并，合并操作
        Stream<String> s1 = List.of("A", "B", "C").stream();
        Stream<String> s2 = List.of("D", "E").stream();
// 合并:
        Stream<String> s = Stream.concat(s1, s2);
        System.out.println(s.collect(Collectors.toList())); // [A, B, C, D, E]

        // flatMap，合并操作
        Stream<List<Integer>> st = Stream.of(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9));
        Stream<Integer> i = st.flatMap(Collection::stream);
        System.out.println(i.collect(Collectors.toList()));

        // 并行，并行处理
        List<String> list3 = List.of("A", "B", "C", "D", "E", "F")
                .stream()
                .parallel() // 变成一个可以并行处理的Stream
                .sorted() // 可以进行并行排序
                .collect(Collectors.toList());
        System.out.println(list3);

        // 其他聚合方法
        //     count()：用于返回元素个数；
        //     max(Comparator<? super T> cp)：找出最大元素；
        //     min(Comparator<? super T> cp)：找出最小元素。
        // 针对IntStream、LongStream和DoubleStream
        //     sum()：对所有元素求和；
        //     average()：对所有元素求平均数。

        // 测试Stream的元素是否满足以下条件
        //     boolean allMatch(Predicate<? super T>)：测试是否所有元素均满足测试条件；
        //     boolean anyMatch(Predicate<? super T>)：测试是否至少有一个元素满足测试条件。

        // forEach()，它可以循环处理Stream的每个元素


        // Stream提供的常用操作有：
        //     转换操作：map()，filter()，sorted()，distinct()；
        //     合并操作：concat()，flatMap()；
        //     并行处理：parallel()；
        //     聚合操作：reduce()，collect()，count()，max()，min()，sum()，average()；
        //     其他操作：allMatch(), anyMatch(), forEach()。
    }
}
