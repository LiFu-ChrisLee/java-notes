package behavioral.learnInterpreter;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author LiFu
 * @date 2020/5/27 下午5:57
 * @description learn Interpreter
 */
public class LearnInterpreter {
    public static void main(String[] args) {
        // 给定一个语言，定义它的文法的一种表示，并定义一个解释器，这个解释器使用该表示来解释语言中的句子。

        log("[{}] start {} at {}...", LocalTime.now().withNano(0), "engine", LocalDate.now()); // [11:02:18] start engine at 2020-02-21...

        log("[{}]", "hh");
    }

    private static void log(String pattern, Object... params) {
        String out = pattern;
        for (Object p : params) {
            out = out.replaceFirst("\\{}", p.toString());
        }
        System.out.println(out);
    }
}
