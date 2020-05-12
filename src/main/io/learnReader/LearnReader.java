package learnReader;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author LiFu
 * @date 2020/5/12 下午2:19
 * @description learn Reader
 */
public class LearnReader {
    public static void main(String[] args) throws Exception {
//        InputStream	                        Reader
//        字节流，以byte为单位	                    字符流，以char为单位
//        读取字节（-1，0~255）：int read()	    读取字符（-1，0~65535）：int read()
//        读到字节数组：int read(byte[] b)	        读到字符数组：int read(char[] c)

        String path = LearnReader.class.getResource("/default.properties").getPath();
        try (Reader reader = new FileReader(path, StandardCharsets.UTF_8)) {
            // 一次性读取若干字符并填充到char[]数组的方法
            char[] c = new char[20];
            int n;
            while ((n = reader.read(c)) != -1) {
                System.out.println("read " + n + " chars.");
            }
        }

        // CharArrayReader可以在内存中模拟一个Reader，它的作用实际上是把一个char[]数组变成一个Reader
        try (Reader reader = new CharArrayReader("H".toCharArray())) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.println(c);
            }
        }

        // StringReader可以直接把String作为数据源，它和CharArrayReader几乎一样
        try (Reader reader = new StringReader("H")) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.println(c);
            }
        }

        // 构造InputStreamReader时，我们需要传入InputStream，还需要指定编码，就可以得到一个Reader对象
        try (Reader reader = new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8)) {
            char[] c = new char[20];
            int n;
            while ((n = reader.read(c)) != -1) {
                System.out.println("read " + n + " chars.");
            }
        }
    }
}
