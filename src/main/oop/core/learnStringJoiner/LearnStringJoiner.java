package core.learnStringJoiner;

import java.util.StringJoiner;

/**
 * @author LiFu
 * @date 2020/4/24 上午11:35
 * @description learn StringJoiner
 */
public class LearnStringJoiner {
    public static void main(String[] args) {
        String[] names = {"Bob", "Alice", "Grace"};
        StringJoiner sj = new StringJoiner(", ", "Hello ", "!");
        for (String name : names) {
            sj.add(name);
        }
        System.out.println(sj.toString());

        // 不需要指定“开头”和“结尾”的时候，用String.join()更方便
        System.out.println(String.join(", ", names));
    }
}
