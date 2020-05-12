package learnOutputStream;

import java.io.*;
import java.util.Arrays;

/**
 * @author LiFu
 * @date 2020/5/11 下午5:33
 * @description 利用InputStream和OutputStream，编写一个复制文件的程序，它可以带参数运行
 */
public class ExerciseOutputStream {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            throw new IllegalArgumentException("参数不正确");
        }

        String sourcePath = args[0];
        String copyPath = args[1];

        // 读源文件
        try (InputStream sourceStream = new FileInputStream(sourcePath)) {
            byte[] cache = sourceStream.readAllBytes();

            try (OutputStream copyStream = new FileOutputStream(copyPath)) {
                copyStream.write(cache);
            }
        }

        File temp = new File(copyPath);
        if (temp.isFile() && temp.delete()) {
            System.out.println("copy 成功，并删除复制的文件");
        }
    }
}
