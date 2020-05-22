package learnStream.learnReduce;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author LiFu
 * @date 2020/5/22 下午3:22
 * @description learn reduce
 */
public class LearnReduce {
    public static void main(String[] args) {
        // 首先初始化结果为指定值（这里是0），acc是上次计算的结果
        int sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).reduce(0, (acc, n) -> acc + n);
        // 相当于
        // Stream<Integer> stream = ...
        // int sum = 0;
        // for (n : stream) {
        //     sum = (sum, n) -> sum + n;
        // }
        System.out.println(sum); // 45

        int s = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).reduce(1, (acc, n) -> acc * n);
        System.out.println(s); // 362880

        // 按行读取配置文件:
        List<String> props = List.of("profile=native", "debug=true", "logging=warn", "interval=500");
        Map<String, String> map = props.stream()
                // 把k=v转换为Map[k]=v:
                .map(kv -> {
                    String[] ss = kv.split("=", 2);
                    return Map.of(ss[0], ss[1]);
                })
                // 把所有Map聚合到一个Map:
                .reduce(new HashMap<>(), (m, kv) -> {
                    m.putAll(kv);
                    return m;
                });
        // 打印结果:
        map.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });
    }
}
