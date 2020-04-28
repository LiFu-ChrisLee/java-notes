package learnCommonsLogging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Arrays;

/**
 * @author LiFu
 * @date 2020/4/28 下午4:43
 * @description learn common logging
 */
public class LearnCommonsLogging {
    public static void main(String[] args) {
        // Commons Logging定义了6个日志级别
        // FATAL
        // ERROR
        // WARNING
        // INFO
        // DEBUG
        // TRACE
        Log log = LogFactory.getLog(LearnCommonsLogging.class);
        // 默认级别是INFO
        log.info("start...");

        try {
            System.out.println(Arrays.toString("".getBytes("invalidCharsetName")));
        } catch (Exception e) {
            // common logging提供了非常有用的重载方法
            log.error("error", e);
        }

        log.warn("end.");

        // 最佳实践

        // 在开发阶段，始终使用Commons Logging接口来写入日志，并且开发阶段无需引入Log4j。如果需要把日志写入文件， 只需要把正确的配置文件和Log4j相关的jar包放入classpath，就可以自动把日志切换成使用Log4j写入，无需修改任何代码。
    }
}
