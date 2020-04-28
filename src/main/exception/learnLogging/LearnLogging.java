package learnLogging;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * @author LiFu
 * @date 2020/4/28 下午4:26
 * @description learn logging
 */
public class LearnLogging {
    public static void main(String[] args) {
        // JDK的Logging定义了7个日志级别，从严重到普通：
        // SEVERE
        // WARNING
        // INFO
        // CONFIG
        // FINE
        // FINER
        // FINEST
        Logger logger = Logger.getGlobal();
        // 默认级别是INFO，因此，INFO级别以下的日志，不会被打印出来
        logger.info("start process...");
        logger.warning("memory is running out...");
        logger.fine("ignored.");
        logger.severe("process will be terminated...");

        try {
            System.out.println(Arrays.toString("".getBytes("invalidCharsetName")));
        } catch (Exception e) {
            logger.severe(Arrays.toString(e.getStackTrace()));
        }
    }
}
