package learnStream.learnCreate;

import java.util.function.Supplier;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author LiFu
 * @date 2020/5/22 上午11:32
 * @description 编写一个能输出斐波拉契数列（Fibonacci）的LongStream
 */
public class ExerciseCreate {
    public static void main(String[] args) {
        Stream<Long> ls = Stream.generate(new FibonacciSupplier());
        ls.limit(10).forEach(System.out::println);
    }
}

class FibonacciSupplier implements Supplier<Long> {
    long first = 1;
    long second = 1;
    @Override
    public Long get() {
        long out = first;
        first = second;
        second += out;
        return out;
    }
}