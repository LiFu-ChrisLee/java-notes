package learnCondition;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author LiFu
 * @date 2020/5/14 下午4:31
 * @description 
 */
public class LearnConditionTest {
    LearnCondition config;

    @BeforeEach
    void methodStart() {
        config = new LearnCondition();
    }

    @AfterEach
    void methodEnd() {
        config = null;
    }

    // 条件测试
    @Disabled // 不运行
    @Test
    void testBug101() {
        // 这个测试不会运行
    }

    @Test
    @EnabledOnOs(OS.WINDOWS) // 只在windows上运行
    void testWindows() {
        assertEquals("C:\\test.ini", config.getConfigFile("test.ini"));
    }

    @Test
    @DisabledOnOs(OS.WINDOWS) // 在windows上不运行
    void testLinuxAndMac() {
        assertEquals("/usr/local/test.cfg", config.getConfigFile("test.cfg"));
    }

    @Test
    @DisabledOnJre(JRE.JAVA_8) // 只能在Java 9或更高版本执行的测试
    void testOnJava9OrAbove() {
        // this test is disabled on java 8
    }

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*") // 只能在64位操作系统上执行的测试
    void testOnlyOn64bitSystem() {
        // this test is only run on 64 bit system
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "DEBUG", matches = "true") // 需要传入环境变量DEBUG=true才能执行的测试
    void testOnlyOnDebugMode() {
        // this test is only run on DEBUG=true
    }

//    @Test
//    @EnabledIf("java.time.LocalDate.now().getDayOfWeek()==java.time.DayOfWeek.SUNDAY") // 万能的@EnableIf可以执行任意Java语句并根据返回的boolean决定是否执行测试
//    void testOnlyOnSunday() {
//        // this test is only run on Sunday
//    }
}
