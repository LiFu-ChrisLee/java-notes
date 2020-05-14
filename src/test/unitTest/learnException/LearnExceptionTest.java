package learnException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author LiFu
 * @date 2020/5/14 下午4:20
 * @description learn Exception
 */
public class LearnExceptionTest {
    @Test
    void testNegative() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                long a = LearnException.fact(-1);
            }
        });
    }

    @Test
    void testOverRange() {
        // lambda函数式接口实现代码
        assertThrows(ArithmeticException.class, () -> {
            long a = LearnException.fact(21);
        });
    }
}
