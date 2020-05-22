package learnStream.learnOutput;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author LiFu
 * @date 2020/5/22 下午3:37
 * @description learn output
 */
public class LearnOutput {
    public static void main(String[] args) {
        // 转换操作，不进行任何计算
        // map()、filter()、reduce()
        // 聚合操作，对Stream的每个元素进行计算
        // reduce()

        // 输出为List
        Stream<String> stream = Stream.of("Apple", "", null, "Pear", "  ", "Orange");
        List<String> list = stream
                .filter(s -> s != null && !s.isBlank())
                .collect(Collectors.toList());
        System.out.println(list);

        // 输出为数组
        List<String> list1 = List.of("Apple", "Banana", "Orange");
        String[] array = list1.stream().toArray(String[]::new);
        System.out.println(Arrays.toString(array));

        // 输出为Map
        Stream<String> stream1 = Stream.of("APPL:Apple", "MSFT:Microsoft");
        Map<String, String> map = stream1
                .collect(Collectors.toMap(
                        // 把元素s映射为key:
                        s -> s.substring(0, s.indexOf(':')),
                        // 把元素s映射为value:
                        s -> s.substring(s.indexOf(':') + 1)));
        System.out.println(map);

        // 分组输出
        List<String> list2 = List.of("Apple", "Banana", "Blackberry", "Coconut", "Avocado", "Cherry", "Apricots");
        // 一个是分组的key，这里使用s -> s.substring(0, 1)，表示只要首字母相同的String分到一组
        // 第二个是分组的value，这里直接使用Collectors.toList()，表示输出为List
        Map<String, List<String>> groups = list2.stream()
                .collect(Collectors.groupingBy(s -> s.substring(0, 1), Collectors.toList()));
        System.out.println(groups);
    }
}
