package structured.learnAdapter;

import java.util.concurrent.Callable;

/**
 * @author LiFu
 * @date 2020/5/26 上午9:25
 * @description learn adapter
 */
public class LearnAdapter {
    public static void main(String[] args) {
        // 将一个类的接口转换成客户希望的另外一个接口，使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。

        Callable<Long> callable = new Task(123450000L);
        // Thread thread = new Thread(callable); // compile error!
        Thread thread = new Thread(new RunnableAdapter(callable));
        thread.start();

        // 编写一个Adapter的步骤如下：
        //     实现目标接口，这里是Runnable；
        //     内部持有一个待转换接口的引用，这里是通过字段持有Callable接口；
        //     在目标接口的实现方法内部，调用待转换接口的方法。

    }
}

class Task implements Callable<Long> {
    private final long num;

    public Task(long num) {
        this.num = num;
    }

    public Long call() {
        long r = 0;
        for (long n = 1; n <= this.num; n++) {
            r = r + n;
        }
        System.out.println("Result: " + r);
        return r;
    }
}

class RunnableAdapter implements Runnable {
    // 引用待转换接口:
    private final Callable<?> callable;

    public RunnableAdapter(Callable<?> callable) {
        this.callable = callable;
    }

    // 实现指定接口:
    public void run() {
        // 将指定接口调用委托给转换接口调用:
        try {
            callable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
