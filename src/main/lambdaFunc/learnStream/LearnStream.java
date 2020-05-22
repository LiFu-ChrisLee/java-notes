package learnStream;

/**
 * @author LiFu
 * @date 2020/5/22 上午10:18
 * @description learn stream
 */
public class LearnStream {
    public static void main(String[] args) {
        //          java.io	                java.util.stream
        // 存储	    顺序读写的byte或char	    顺序输出的任意Java对象实例
        // 用途	    序列化至文件或网络	        内存计算／业务逻辑

        //          java.util.List	        java.util.stream
        // 元素	    已分配并存储在内存	        可能未分配，实时计算
        // 用途	    操作一组已存在的Java对象	惰性计算

        // Stream的特点
        // 它可以“存储”有限个或无限个元素，元素有可能已经全部存储在内存中，也有可能是根据需要实时计算出来的
        // 一个Stream可以轻易地转换为另一个Stream，而不是修改原Stream本身
        // 真正的计算通常发生在最后结果的获取，也就是惰性计算，一个Stream转换为另一个Stream时，实际上只存储了转换规则，并没有任何计算发生

        // Stream API的基本用法：创建一个Stream，然后做若干次转换，最后调用一个求值方法获取真正计算的结果
        // int result = createNaturalStream() // 创建Stream
        //         .filter(n -> n % 2 == 0) // 任意个转换
        //         .map(n -> n * n) // 任意个转换
        //         .limit(100) // 任意个转换
        //         .sum(); // 最终计算结果

    }
}
