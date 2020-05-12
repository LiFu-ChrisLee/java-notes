package learnZip;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author LiFu
 * @date 2020/5/12 上午10:31
 * @description learn Zip
 */
public class LearnZip {
    public static void main(String[] args) throws Exception {
        // 读取zip包
        try (ZipInputStream zip = new ZipInputStream(new FileInputStream("some.zip"))) {
            ZipEntry entry;
            while ((entry = zip.getNextEntry()) != null) {
                String name = entry.getName();
                System.out.println(name);

                // 如果是文件可以读取文件内容
                if (!entry.isDirectory()) {
                    int n;
                    while ((n = zip.read()) != -1) {
                        System.out.println(n);
                    }
                }
            }
        }

        // 写入zip包
        try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream("some.zip"))) {
            File[] files = new File[]{
                    new File("aaa"),
                    new File("bbb")
            };

            for (File file : files) {
                // 如果要实现目录层次结构，new ZipEntry(name)传入的name要用相对路径
                zip.putNextEntry(new ZipEntry(file.getName()));
                zip.write(getFileDataAsBytes(file));
                zip.closeEntry();
            }
        }
    }

    private static byte[] getFileDataAsBytes(File file) throws Exception {
        InputStream fInput = new FileInputStream(file);
        return fInput.readAllBytes();
    }
}
