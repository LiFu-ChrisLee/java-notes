package learnInputStream;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author LiFu
 * @date 2020/5/11 下午5:00
 * @description learn InputStream
 */
public class LearnInputStream {
    public static void main(String[] args) throws Exception {
//        InputStream并不是一个接口，而是一个抽象类，它是所有输入流的超类。这个抽象类定义的一个最重要的方法就是int read()，签名如下：
        //        public abstract int read() throws IOException;
        //        这个方法会读取输入流的下一个字节，并返回字节表示的int值（0~255）。如果已读到末尾，返回-1表示不能继续读取了

        // FileInputStream就是从文件流中读取数据
        // 创建一个FileInputStream对象:
//        InputStream input = null;
//        try {
//            input = new FileInputStream("README.md");
//            for (; ; ) {
//                int n = input.read(); // 反复调用read()方法，直到返回-1
//                if (n == -1) {
//                    break;
//                }
//                System.out.println(n); // 打印byte的值
//            }
//        } finally {
//            if (input != null) {
//                input.close(); // 关闭流
//            }
//        }
        // Java 7 try resource 写法
        try (InputStream input = new FileInputStream("README.md")) {
            for (; ; ) {
                int n = input.read(); // 反复调用read()方法，直到返回-1
                if (n == -1) {
                    break;
                }
                System.out.println(n); // 打印byte的值
            }
        } // 对象实现了java.lang.AutoCloseable接口，自动关闭流

        // 利用缓冲区一次性读取多个字符
        try (InputStream input = new FileInputStream("README.md")) {
            // 定义1000个字节大小的缓冲区:
            byte[] buffer = new byte[1000];
            int n;
            while ((n = input.read(buffer)) != -1) { // 读取到缓冲区
                System.out.println("read " + n + " bytes.");
            }
        }

        // ByteArrayInputStream可以在内存中模拟一个InputStream
        byte[] data = {72, 101, 108, 108, 111, 33};
        try (InputStream input = new ByteArrayInputStream(data)) {
            int n;
            while ((n = input.read()) != -1) {
                System.out.println((char) n);
            }
        }
    }
}
