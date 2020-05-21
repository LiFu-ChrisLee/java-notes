package learnHash;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * @author LiFu
 * @date 2020/5/20 下午5:35
 * @description learn hash
 */
public class LearnHash {
    public static void main(String[] args) throws Exception {
        // 哈希算法（Hash）又称摘要算法（Digest），它的作用是：对任意一组输入数据进行计算，得到一个固定长度的输出摘要
        //     相同的输入一定得到相同的输出；
        //     不同的输入大概率得到不同的输出。

        System.out.printf("0x%x\n", "hello".hashCode()); // 0x5e918d2
        System.out.printf("0x%x\n", "hello, java".hashCode()); // 0x7a9d88e8
        System.out.printf("0x%x\n", "hello, bob".hashCode()); // 0xa0dbae2f

        // 哈希碰撞，两个不同的输入得到了相同的输出
        System.out.printf("0x%x\n", "AaAaAa".hashCode()); // 0x7460e8c0
        System.out.printf("0x%x\n", "BBAaBB".hashCode()); // 0x7460e8c0

        // 常用的哈希算法有：
        // 算法	            输出长度（位）	        输出长度（字节）
        // MD5	            128 bits	        16 bytes
        // SHA-1	        160 bits	        20 bytes
        // RipeMD-160	    160 bits	        20 bytes
        // SHA-256	        256 bits	        32 bytes
        // SHA-512	        512 bits	        64 bytes

        // md5
        // 创建一个MessageDigest实例:
        MessageDigest md = MessageDigest.getInstance("MD5");
        // 反复调用update输入数据:
        md.update("Hello".getBytes(StandardCharsets.UTF_8));
        md.update("World".getBytes(StandardCharsets.UTF_8));
        byte[] result = md.digest(); // 16 bytes: 68e109f0f40ca72a15e05cc22786f8e6
        System.out.println(new BigInteger(1, result).toString(16));

        // SHA-1
        // 创建一个MessageDigest实例:
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        // 反复调用update输入数据:
        sha1.update("Hello".getBytes(StandardCharsets.UTF_8));
        sha1.update("World".getBytes(StandardCharsets.UTF_8));
        byte[] result1 = sha1.digest(); // 20 bytes: db8ac1c259eb89d4a131b253bacfca5f319d54f2
        System.out.println(new BigInteger(1, result1).toString(16));
    }
}
