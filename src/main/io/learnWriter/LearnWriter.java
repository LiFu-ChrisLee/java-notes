package learnWriter;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author LiFu
 * @date 2020/5/12 下午2:52
 * @description learn Writer
 */
public class LearnWriter {
    public static void main(String[] args) throws Exception {
//        OutputStream	                            Writer
//        字节流，以byte为单位	                        字符流，以char为单位
//        写入字节（0~255）：void write(int b)	        写入字符（0~65535）：void write(int c)
//        写入字节数组：void write(byte[] b)	        写入字符数组：void write(char[] c)
//        无对应方法	                                写入String：void write(String s)

        String path = "readme.txt";
        File file = new File(path);
        if (file.createNewFile() || file.exists()) {
            try (Writer writer = new FileWriter(path, StandardCharsets.UTF_8)) {
                writer.write('H'); // 写入单个字符
                writer.write("Hello".toCharArray()); // 写入char[]
                writer.write("Hello"); // 写入String
            }
        }

        // CharArrayWriter可以在内存中创建一个Writer，它的作用实际上是构造一个缓冲区，可以写入char，最后得到写入的char[]数组
        try (CharArrayWriter writer = new CharArrayWriter()) {
            writer.write("65");
            writer.write('6');
            writer.write(67);
            System.out.println(writer);
        }

        // StringWriter也是一个基于内存的Writer，它和CharArrayWriter类似
        try (Writer writer = new StringWriter()) {
            writer.write("65");
            writer.write('6');
            writer.write(67);
            System.out.println(writer);
        }

        // OutputStreamWriter就是一个将任意的OutputStream转换为Writer的转换器
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8)){
            writer.write('H'); // 写入单个字符
            writer.write("Hello".toCharArray()); // 写入char[]
            writer.write("Hello"); // 写入String
        }

        if (file.exists() && file.delete()) {
            System.out.println("删除成功");
        }
    }
}
