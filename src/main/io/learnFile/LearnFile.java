package learnFile;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author LiFu
 * @date 2020/5/11 下午4:26
 * @description learn File
 */
public class LearnFile {
    public static void main(String[] args) throws Exception {
        File f = new File("/usr/bin/javac");

        // 返回构造方法传入的路径
        System.out.println(f.getPath());
        // 返回绝对路径
        System.out.println(f.getAbsolutePath());
        // 返回规范路径
        System.out.println(f.getCanonicalPath());
        // 当前平台的系统分隔符
        System.out.println(File.separator);

        // 是否是一个已存在的文件
        System.out.println(f.isFile());
        // 是否是一个已存在的目录
        System.out.println(f.isDirectory());

//        判断文件的权限和大小：
    //        boolean canRead()：是否可读；
    //        boolean canWrite()：是否可写；
    //        boolean canExecute()：是否可执行；
    //        long length()：文件字节大小。

        // 通过createNewFile()创建一个新文件，用delete()删除该文件
        File file = new File("./aaa");
        if (file.createNewFile()) {
            System.out.println("文件创建成功");
        }

        if (file.delete()) {
            System.out.println("删除文件成功");
        }

        File tempF = File.createTempFile("tmp-", ".txt"); // 提供临时文件的前缀和后缀
        tempF.deleteOnExit(); // JVM退出时自动删除
        System.out.println(tempF.isFile());
        System.out.println(tempF.getAbsolutePath());

        // 当File对象表示一个目录时，可以使用list()和listFiles()列出目录下的文件和子目录名
        // listFiles()提供了一系列重载方法，可以过滤不想要的文件和目录
        File f1 = new File("/home");
        File[] fs1 = f1.listFiles(); // 列出所有文件和子目录
        printFiles(fs1);
        File[] fs2 = f1.listFiles(new FilenameFilter() { // 仅列出.txt
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt"); // 返回true表示接受该文件
            }
        });
        printFiles(fs2);

//        File对象如果表示一个目录，可以通过以下方法创建和删除目录：
    //        boolean mkdir()：创建当前File对象表示的目录；
    //        boolean mkdirs()：创建当前File对象表示的目录，并在必要时将不存在的父目录也创建出来；
    //        boolean delete()：删除当前File对象表示的目录，当前目录必须为空才能删除成功。

//        Java标准库还提供了一个Path对象，它位于java.nio.file包。Path对象和File对象类似，但操作更加简单
        Path p1 = Paths.get(".", "project", "study"); // 构造一个Path对象
        System.out.println(p1);
        Path p2 = p1.toAbsolutePath(); // 转换为绝对路径
        System.out.println(p2);
        Path p3 = p2.normalize(); // 转换为规范路径
        System.out.println(p3);
        File f2 = p3.toFile(); // 转换为File对象
        System.out.println(f2);
        for (Path p : Paths.get("..").toAbsolutePath()) { // 可以直接遍历Path
            System.out.println("  " + p);
        }
    }

    static void printFiles(File[] files) {
        System.out.println("==========");
        if (files != null) {
            for (File f : files) {
                System.out.println(f);
            }
        }
        System.out.println("==========");
    }
}
