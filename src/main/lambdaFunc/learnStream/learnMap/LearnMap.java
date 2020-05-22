package learnStream.learnMap;

import java.util.List;

/**
 * @author LiFu
 * @date 2020/5/22 下午2:50
 * @description learn map
 */
public class LearnMap {
    public static void main(String[] args) {
        // Stream.map()是Stream最常用的一个转换方法，它把一个Stream转换为另一个Stream
        List.of("  Apple ", " pear ", " ORANGE", " BaNaNa ")
                .stream()
                .map(String::trim) // 去空格
                .map(String::toLowerCase) // 变小写
                .forEach(System.out::println); // 打印
    }
}
