package learnOutputStream;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author LiFu
 * @date 2020/5/11 下午5:20
 * @description learn OutputStream
 */
public class LearnOutputStream {
    public static void main(String[] args) throws Exception {
//        OutputStream也是抽象类，它是所有输出流的超类。这个抽象类定义的一个最重要的方法就是void write(int b)，签名如下：
        //        public abstract void write(int b) throws IOException;
        //        这个方法会写入一个字节到输出流。要注意的是，虽然传入的是int参数，但只会写入一个字节，即只写入int最低8位表示字节的部分（相当于b & 0xff）
        //        OutputStream还提供了一个flush()方法，它的目的是将缓冲区的内容真正输出到目的地

//        每次写入一个字节非常麻烦，更常见的方法是一次性写入若干字节。这时，可以用OutputStream提供的重载方法void write(byte[])来实现：
        try (OutputStream output = new FileOutputStream("./temp.txt")) {
            output.write("Hello".getBytes(StandardCharsets.UTF_8)); // Hello
        }
        File opFile = new File("./temp.txt");
        if (opFile.isFile()) {
            if (opFile.delete()) {
                System.out.println("删除成功");
            }
        }

        // ByteArrayOutputStream可以在内存中模拟一个OutputStream
        byte[] data;
        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            output.write("Hello ".getBytes(StandardCharsets.UTF_8));
            output.write("world!".getBytes(StandardCharsets.UTF_8));
            data = output.toByteArray();
        }
        System.out.println(new String(data, StandardCharsets.UTF_8));
    }
}
