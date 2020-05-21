package learnHmac;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author LiFu
 * @date 2020/5/21 上午10:08
 * @description learn Hmac
 */
public class LearnHmac {
    public static void main(String[] args) throws Exception {
        // Hmac本质上就是把key混入摘要的算法。验证此哈希时，除了原始的输入数据，还要提供key

        // 通过名称HmacMD5获取KeyGenerator实例
        KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5");
        // 通过KeyGenerator创建一个SecretKey实例
        SecretKey key = keyGen.generateKey();
        // 打印随机生成的key:
        byte[] secureKey = key.getEncoded();
        System.out.println(new BigInteger(1, secureKey).toString(16));
        // 通过名称HmacMD5获取Mac实例
        Mac mac = Mac.getInstance("HmacMD5");
        // 用SecretKey初始化Mac实例
        mac.init(key);
        // 对Mac实例反复调用update(byte[])输入数据
        mac.update("HelloWorld".getBytes(StandardCharsets.UTF_8));
        // 调用Mac实例的doFinal()获取最终的哈希值
        byte[] result = mac.doFinal();
        System.out.println(new BigInteger(1, result).toString(16));

        // 有了Hmac计算的哈希和SecretKey，从一个byte[]数组恢复
        byte[] secureKey1 = new byte[] { 106, 70, -110, 125, 39, -20, 52, 56, 85, 9, -19, -72, 52, -53, 52, -45, -6, 119, -63,
                30, 20, -83, -28, 77, 98, 109, -32, -76, 121, -106, 0, -74, -107, -114, -45, 104, -104, -8, 2, 121, 6,
                97, -18, -13, -63, -30, -125, -103, -80, -46, 113, -14, 68, 32, -46, 101, -116, -104, -81, -108, 122,
                89, -106, -109 };

        SecretKey key1 = new SecretKeySpec(secureKey1, "HmacMD5");
        Mac mac1 = Mac.getInstance("HmacMD5");
        mac1.init(key1);
        mac1.update("HelloWorld".getBytes(StandardCharsets.UTF_8));
        byte[] result1 = mac1.doFinal();
        System.out.println(Arrays.toString(result1)); // [126, 59, 37, 63, 73, 90, 111, -96, -77, 15, 82, -74, 122, -55, -67, 54]
    }
}
