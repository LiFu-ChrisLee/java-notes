package learnJUnit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author LiFu
 * @date 2020/5/14 下午2:43
 * @description learn JUnit
 */
public class LearnJUnitTest {
//    assertEquals(): 期待结果相等
//    assertTrue(): 期待结果为true
//    assertFalse(): 期待结果为false
//    assertNotNull(): 期待结果为非null
//    assertArrayEquals(): 期待结果为数组并与期望数组每个元素的值均相等
//    assertEquals(double expected, double actual, double delta)这个重载方法，需要指定一个误差值
    @Test
    public void testFact() {
        assertEquals(1, LearnJUint.fact(1));
        assertEquals(2, LearnJUint.fact(2));
        assertEquals(6, LearnJUint.fact(3));
        assertEquals(3628800, LearnJUint.fact(10));
        assertEquals(2432902008176640000L, LearnJUint.fact(20));
    }
}
