package learnFixture;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author LiFu
 * @date 2020/5/14 下午3:23
 * @description learn Fixture
 */
public class LearnFixtureTest {
//    JUnit提供了编写测试前准备、测试后清理的固定代码，我们称之为Fixture
    LearnFixture learnFixture;

    @BeforeEach
    public void setUp() {
        this.learnFixture = new LearnFixture();
    }

    @AfterEach
    public void tearDown() {
        this.learnFixture = null;
    }

    // 注意到每次运行一个@Test方法前，JUnit首先创建一个XxxTest实例，因此，每个@Test方法内部的成员变量都是独立的，不能也无法把成员变量的状态从一个@Test方法带到另一个@Test方法
    @Test
    void testAdd() {
        assertEquals(100, this.learnFixture.add(100));
        assertEquals(150, this.learnFixture.add(50));
        assertEquals(130, this.learnFixture.add(-20));
    }

    @Test
    void testSub() {
        assertEquals(-100, this.learnFixture.sub(100));
        assertEquals(-150, this.learnFixture.sub(50));
        assertEquals(-130, this.learnFixture.sub(-20));
    }

//    上面的测试代码在JUnit中运行顺序如下
//    for (Method testMethod : findTestMethods(CalculatorTest.class)) {
//        var test = new CalculatorTest(); // 创建Test实例
//        invokeBeforeEach(test);
//        invokeTestMethod(test, testMethod);
//        invokeAfterEach(test);
//    }
//    可见，@BeforeEach和@AfterEach会“环绕”在每个@Test方法前后。


//    还有一些资源初始化和清理可能更加繁琐，而且会耗费较长的时间，例如初始化数据库。JUnit还提供了@BeforeAll和@AfterAll，它们在运行所有@Test前后运行，顺序如下：
//    invokeBeforeAll(CalculatorTest.class);
//    for (Method testMethod : findTestMethods(CalculatorTest.class)) {
//        var test = new CalculatorTest(); // 创建Test实例
//        invokeBeforeEach(test);
//        invokeTestMethod(test, testMethod);
//        invokeAfterEach(test);
//    }
//    invokeAfterAll(CalculatorTest.class);
//    因为@BeforeAll和@AfterAll在所有@Test方法运行前后仅运行一次，因此，它们只能初始化静态变量

//    static Database db;
//
//    @BeforeAll
//    public static void initDatabase() {
//        db = createDb(...);
//    }
//
//    @AfterAll
//    public static void dropDatabase() {
//        ...
//    }
}
