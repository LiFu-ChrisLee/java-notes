package learnJUnit;

/**
 * @author LiFu
 * @date 2020/5/14 下午2:33
 * @description learn JUnit
 */
public class LearnJUint {
    public static void main(String[] args) {
        // TDD，测试驱动开发，是指先编写接口，紧接着编写测试。编写完测试后，我们才开始真正编写实现代码。在编写实现代码的过程中，一边写，一边测，什么时候测试全部通过了，那就表示编写的实现完成了
    }

    public static long fact(long n) {
        long r = 1;
        for (long i = 1; i <= n; i++) {
            r = r * i;
        }
        return r;
    }
}
