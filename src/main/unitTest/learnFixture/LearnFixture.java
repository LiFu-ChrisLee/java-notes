package learnFixture;

/**
 * @author LiFu
 * @date 2020/5/14 下午3:23
 * @description learn Fixture
 */
public class LearnFixture {
    private long n = 0;

    public long add(long x) {
        n = n + x;
        return n;
    }

    public long sub(long x) {
        n = n - x;
        return n;
    }
}
