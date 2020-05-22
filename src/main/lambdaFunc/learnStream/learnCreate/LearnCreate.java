package learnStream.learnCreate;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author LiFu
 * @date 2020/5/22 上午10:32
 * @description learn create
 */
public class LearnCreate {
    public static void main(String[] args) throws Exception {
        // Stream.of()
        Stream<String> stream = Stream.of("A", "B", "C", "D");
        // forEach()方法相当于内部循环调用，
        // 可传入符合Consumer接口的void accept(T t)的方法引用：
        stream.forEach(System.out::println);

        // 基于数组或Collection
        Stream<String> stream1 = Arrays.stream(new String[]{"A", "B", "C"});
        Stream<String> stream2 = List.of("X", "Y", "Z").stream();
        stream1.forEach(System.out::println);
        stream2.forEach(System.out::println);

        // 基于Supplier
        // 基于Supplier创建的Stream会不断调用Supplier.get()方法来不断产生下一个元素，这种Stream保存的不是元素，而是算法，它可以用来表示无限序列。
        Stream<Integer> natual = Stream.generate(new NatualSupplier());
        // 注意：无限序列必须先变成有限序列再打印:
        natual.limit(20).forEach(System.out::println);

        // 其他方法
        // Files类的lines()方法
        try (Stream<String> lines = Files.lines(Paths.get("src/res/default.properties"))) {
            lines.forEach(System.out::println);
        }
        // Pattern对象的splitAsStream()方法
        Pattern p = Pattern.compile("\\s+");
        Stream<String> s = p.splitAsStream("The quick brown fox jumps over the lazy dog");
        s.forEach(System.out::println);

        // 基本类型
        // 将int[]数组变为IntStream:
        IntStream is = Arrays.stream(new int[] { 1, 2, 3 });
        // 将Stream<String>转换为LongStream:
        LongStream ls = List.of("1", "2", "3").stream().mapToLong(Long::parseLong);
    }
}

class NatualSupplier implements Supplier<Integer> {
    int n = 0;

    public Integer get() {
        n++;
        return n;
    }
}
