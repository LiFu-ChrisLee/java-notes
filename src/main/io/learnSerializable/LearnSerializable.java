package learnSerializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author LiFu
 * @date 2020/5/12 上午11:29
 * @description learn Serializable
 */
public class LearnSerializable {
    public static void main(String[] args) throws Exception {
//        java.io.Serializable接口没有定义任何方法，它是一个空接口。我们把这样的空接口称为“标记接口”（Marker Interface）

        // 序列化
        // 把一个Java对象变为byte[]数组，需要使用ObjectOutputStream
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        // ObjectOutputStream既可以写入基本类型，如int，boolean，也可以写入String（以UTF-8编码），还可以写入实现了Serializable接口的Object
        try (ObjectOutputStream output = new ObjectOutputStream(buffer)) {
            // 写入int:
            output.writeInt(1);
            // 写入String:
            output.writeUTF("h");
            // 写入Object:
            output.writeObject(1.2);
        }
        System.out.println(Arrays.toString(buffer.toByteArray()));

        // 反序列化
        // ObjectInputStream负责从一个字节流读取Java对象
        ByteArrayInputStream bf = new ByteArrayInputStream(buffer.toByteArray());
        try (ObjectInputStream input = new ObjectInputStream(bf)) {
            int n = input.readInt(); // 1
            System.out.println(n);
            String s = input.readUTF(); // h
            System.out.println(s);
            Double d = (Double) input.readObject(); // 1.2
            System.out.println(d);

            // 除了能读取基本类型和String类型外，调用readObject()可以直接返回一个Object对象。要把它变成一个特定类型，必须强制转型
                // ClassNotFoundException：没有找到对应的Class
                    // 一台电脑上的Java程序把一个Java对象，例如，Person对象序列化以后，通过网络传给另一台电脑上的另一个Java程序，但是这台电脑的Java程序并没有定义Person类
                // InvalidClassException：Class不匹配
                    // 序列化的Person对象定义了一个int类型的age字段，但是反序列化时，Person类定义的age字段被改成了long类型
                    // Java的序列化允许class定义一个特殊的serialVersionUID静态变量，用于标识Java类的序列化“版本”
                    // public class Person implements Serializable {
                        // private static final long serialVersionUID = 2709425275741743919L;
                    // }

        }
    }
}
