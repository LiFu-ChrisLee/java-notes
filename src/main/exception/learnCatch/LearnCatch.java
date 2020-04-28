package learnCatch;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * @author LiFu
 * @date 2020/4/28 上午11:10
 * @description learn catch
 */
public class LearnCatch {
    public static void main(String[] args) throws Exception {
        // 存在多个catch的时候，catch的顺序非常重要：子类必须写在前面
        try {
            process1();
            process2();
            process3();
            process4();
            System.out.println("success");
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        } catch (NumberFormatException | IllegalAccessException e) {
            // 处理NumberFormatException和IllegalAccessException的代码是相同的，所以我们可以把它两用|合并到一起
            System.out.println("NumberFormatException | IllegalAccessException");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            // finally语句之前就算有throw也会被执行
            System.out.println("END");
        }

    }

    private static void process1() throws IOException {
        double a = Math.random();
        if (a > 0.5) {
            throw new IOException();
        }
    }

    private static void process2() throws NumberFormatException {
        double a = Math.random();
        if (a > 0.5) {
            throw new NumberFormatException();
        }
    }

    private static void process3() throws IllegalAccessException {
        double a = Math.random();
        if (a > 0.5) {
            throw new IllegalAccessException();
        }
    }

    private static void process4() throws Exception {
        double a = Math.random();
        if (a > 0.5) {
            throw new Exception();
        }
    }
}
