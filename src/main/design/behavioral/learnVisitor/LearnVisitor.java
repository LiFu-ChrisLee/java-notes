package behavioral.learnVisitor;

import java.io.File;
import java.util.List;

/**
 * @author LiFu
 * @date 2020/5/28 下午4:23
 * @description learn Visitor
 */
public class LearnVisitor {
    public static void main(String[] args) {
        // 表示一个作用于某对象结构中的各元素的操作。它使你可以在不改变各元素的类的前提下定义作用于这些元素的新操作。

        // 查找.java文件，就传入JavaFileVisitor
        FileStructure fs = new FileStructure(new File("."));
        fs.handle(new JavaFileVisitor());
    }

    // 代码的问题在于，扫描目录的逻辑和处理.java文件的逻辑混在了一起。如果下次需要增加一个清理.class文件的功能，就必须再重复写扫描逻辑
    void scan(File dir, List<File> collector) {
        for (File file : dir.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".java")) {
                collector.add(file);
            } else if (file.isDirectory()) {
                // 递归调用:
                scan(file, collector);
            }
        }
    }
}

// 访问者模式先把数据结构（这里是文件夹和文件构成的树型结构）和对其的操作（查找文件）分离开，以后如果要新增操作（例如清理.class文件），只需要新增访问者，不需要改变现有逻辑
// 定义访问者接口，即该访问者能够干的事情
interface Visitor {
    // 访问文件夹:
    void visitDir(File dir);

    // 访问文件:
    void visitFile(File file);
}

// 定义能持有文件夹和文件的数据结构FileStructure
class FileStructure {
    // 根目录:
    private final File path;

    public FileStructure(File path) {
        this.path = path;
    }

    // 给FileStructure增加一个handle()方法，传入一个访问者
    public void handle(Visitor visitor) {
        scan(this.path, visitor);
    }

    private void scan(File file, Visitor visitor) {
        if (file.isDirectory()) {
            // 让访问者处理文件夹:
            visitor.visitDir(file);
            for (File sub : file.listFiles()) {
                // 递归处理子文件夹:
                scan(sub, visitor);
            }
        } else if (file.isFile()) {
            // 让访问者处理文件:
            visitor.visitFile(file);
        }
    }
}

class JavaFileVisitor implements Visitor {
    public void visitDir(File dir) {
        System.out.println("Visit dir: " + dir);
    }

    public void visitFile(File file) {
        if (file.getName().endsWith(".java")) {
            System.out.println("Found java file: " + file);
        }
    }
}

// 如果要清理.class文件，可以再写一个ClassFileCleanerVisitor
class ClassFileCleanerVisitor implements Visitor {
    public void visitDir(File dir) {
    }

    public void visitFile(File file) {
        if (file.getName().endsWith(".class")) {
            System.out.println("Will clean class file: " + file);
        }
    }
}
