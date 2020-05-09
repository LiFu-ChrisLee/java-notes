package learnProperties;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @author LiFu
 * @date 2020/5/8 上午10:52
 * @description learn Properties
 */
public class LearnProperties {
    public static void main(String[] args) throws Exception {
        // Java默认配置文件以.properties为扩展名，每行以key=value表示，以#课开头的是注释
        // 创建Properties实例
        Properties props = new Properties();
        // load()打开文件
        // 项目根目录的相对路径
        String f = "src/main/collection/learnProperties/setting.properties";
        // 字节流
//        props.load(new java.io.FileInputStream(f));
        // 字符流
        props.load(new FileReader(f, StandardCharsets.UTF_8));

//        classpath 的路径
//        String f = "/learnProperties/setting.properties";
//        props.load(LearnProperties.class.getResourceAsStream(f));

//        读内存数据
//        String settings = "# test" + "\n" + "course=Java" + "\n" + "last_open_date=2019-08-07T12:35:01";
//        ByteArrayInputStream input = new ByteArrayInputStream(settings.getBytes(StandardCharsets.UTF_8));
//        props.load(input);

        // getProperty()取值，取不到使用默认值，无默认值返回null
        String filepath = props.getProperty("last_open_file");
        String interval = props.getProperty("auto_save_interval", "120");
        System.out.println(filepath);
        System.out.println(interval);

        props.setProperty("url", "http://www.liaoxuefeng.com");
        props.setProperty("language", "Java");
        props.store(new FileOutputStream(f), "这是写入的properties注释");
    }
}
