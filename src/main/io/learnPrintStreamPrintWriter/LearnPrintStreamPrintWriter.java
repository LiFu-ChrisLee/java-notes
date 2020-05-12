package learnPrintStreamPrintWriter;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author LiFu
 * @date 2020/5/12 下午3:14
 * @description learn PrintStream PrintWriter
 */
public class LearnPrintStreamPrintWriter {
    public static void main(String[] args) {
        // PrintStream，不会抛出IOException
        // System.out是系统默认提供的PrintStream，表示标准输出：
        System.out.print(12345); // 输出12345
        System.out.print(new Object()); // 输出类似java.lang.Object@3c7a835a
        System.out.println("Hello"); // 输出Hello并换行

        // System.out是标准输出；
        // System.err是标准错误输出。

        // PrintWriter
        // PrintStream最终输出的总是byte数据，而PrintWriter则是扩展了Writer接口，它的print()/println()方法最终输出的是char数据
        StringWriter buffer = new StringWriter();
        try (PrintWriter pw = new PrintWriter(buffer)) {
            pw.println("Hello");
            pw.println(12345);
            pw.println(true);
        }
        System.out.println(buffer.toString());
    }
}
