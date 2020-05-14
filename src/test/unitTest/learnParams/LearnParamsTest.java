package learnParams;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author LiFu
 * @date 2020/5/14 下午5:32
 * @description
 */
public class LearnParamsTest {
    @Disabled
    @ParameterizedTest // 参数化测试的注解
    @ValueSource(ints = {0, 1, 5, 100})
        // 用一组正数进行测试
    void testAbs(int x) {
        assertEquals(x, Math.abs(x));
    }

    @Disabled
    @ParameterizedTest
    @ValueSource(ints = {-1, -5, -100})
        // 用一组负数进行测试
    void testAbsNegative(int x) {
        assertEquals(-x, Math.abs(x));
    }

    @Disabled
    @ParameterizedTest
    // @MethodSource也允许指定方法名。但使用默认同名方法最方便
    @MethodSource
        // 通过@MethodSource注解，需要编写一个同名的静态方法来提供测试参数
    void testCapitalize(String input, String result) {
        assertEquals(result, LearnParams.capitalize(input));
    }

    private static List<Arguments> testCapitalize() {
        return List.of(
                Arguments.arguments("abc", "Abc"),
                Arguments.arguments("APPLE", "Apple"),
                Arguments.arguments("gooD", "Good")
        );
    }

    @Disabled
    @ParameterizedTest
    // 通过@CsvSource注解，每一个字符串表示一行，一行包含的若干参数用,分隔
    @CsvSource({
            "abc, Abc",
            "APPLE, Apple",
            "gooD, Good"
    })
    void testCapitalize1(String input, String result) {
        assertEquals(result, LearnParams.capitalize(input));
    }

    @ParameterizedTest
    // 通过@CsvFileSource注解，文件放在test根目录
    @CsvFileSource(resources = {"/test-capitalize.csv"})
    void testCapitalize2(String input, String result) {
        assertEquals(result, LearnParams.capitalize(input));
    }
}
