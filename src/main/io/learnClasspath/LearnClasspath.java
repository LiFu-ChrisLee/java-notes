package learnClasspath;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @author LiFu
 * @date 2020/5/12 上午10:56
 * @description learn classpath
 */
public class LearnClasspath {
    public static void main(String[] args) throws Exception {
        // 如果我们把default.properties文件放到classpath中，就不用关心它的实际存放路径
        // 在classpath中的资源文件，路径总是以／开头，我们先获取当前的Class对象，然后调用getResourceAsStream()就可以直接从classpath读取任意的资源文件
        try (InputStream input = LearnClasspath.class.getResourceAsStream("/default.properties")) {
            if (input != null) {
                int n;
                while ((n = input.read()) != -1) {
                    System.out.println(n);
                }
            }

            Properties props = new Properties();
            props.load(input);
            System.out.println(props.getProperty("hello"));
        }
    }
}
