package learnSLF4J;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;

import java.util.Arrays;

/**
 * @author LiFu
 * @date 2020/4/28 下午4:56
 * @description learn SLF4J
 */
public class LearnSLF4J {
    public static void main(String[] args) {
        Logger log = (Logger) LogFactory.getLog(LearnSLF4J.class);
        log.info("start...");

        try {
            System.out.println(Arrays.toString("".getBytes("invalidCharsetName")));
        } catch (Exception e) {
            // common logging提供了非常有用的重载方法
            log.error("error", e);
        }

        log.warn("end.");

        // SLF4J和Logback可以取代CommonsLogging和Log4j；

        // 始终使用SLF4J的接口写入日志，使用Logback只需要配置，不需要修改代码。
    }
}
