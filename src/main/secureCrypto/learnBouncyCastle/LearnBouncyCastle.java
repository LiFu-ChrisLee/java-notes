package learnBouncyCastle;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.Security;

/**
 * @author LiFu
 * @date 2020/5/20 下午6:04
 * @description learn BouncyCastle
 */
public class LearnBouncyCastle {
    public static void main(String[] args) throws Exception {
        // 注册BouncyCastle:
        Security.addProvider(new BouncyCastleProvider());
        // 按名称正常调用:
        MessageDigest md = MessageDigest.getInstance("RipeMD160");
        md.update("HelloWorld".getBytes(StandardCharsets.UTF_8));
        byte[] result = md.digest(); // ecabeaa2eb986c85e6a6ea2c22b248ab6916de35
        System.out.println(new BigInteger(1, result).toString(16));
    }
}
