package learnAES;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * @author LiFu
 * @date 2020/5/21 上午10:32
 * @description learn symmetric
 */
public class LearnAES {
    public static void main(String[] args) throws Exception {
        // 常用的对称加密算法
        // 算法	    密钥长度	        工作模式	                    填充模式
        // DES	    56/64	        ECB/CBC/PCBC/CTR/...	    NoPadding/PKCS5Padding/...
        // AES	    128/192/256	    ECB/CBC/PCBC/CTR/...	    NoPadding/PKCS5Padding/PKCS7Padding/...
        // IDEA     128	            ECB	                        PKCS5Padding/PKCS7Padding/...

        // AES加密
        // 原文:
        String message = "Hello, world!";
        System.out.println("Message: " + message);
        // 128位密钥 = 16 bytes Key:
        byte[] key = "1234567890abcABC".getBytes(StandardCharsets.UTF_8);
        // 加密:
        byte[] data = message.getBytes(StandardCharsets.UTF_8);
        byte[] encrypted = encrypt(key, data);
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));
        // 解密:
        byte[] decrypted = decrypt(key, encrypted);
        System.out.println("Decrypted: " + new String(decrypted, StandardCharsets.UTF_8));

        // 原文:
        String message1 = "Hello, world!";
        System.out.println("Message: " + message1);
        // 256位密钥 = 32 bytes Key:
        byte[] key1 = "1234567890abcABC1234567890abcABC".getBytes(StandardCharsets.UTF_8);
        // 加密:
        byte[] data1 = message1.getBytes(StandardCharsets.UTF_8);
        byte[] encrypted1 = encrypt1(key1, data1);
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted1));
        // 解密:
        byte[] decrypted1 = decrypt1(key1, encrypted1);
        System.out.println("Decrypted: " + new String(decrypted1, StandardCharsets.UTF_8));
    }

    // ECB模式
    // 加密:
    public static byte[] encrypt(byte[] key, byte[] input) throws GeneralSecurityException {
        // 根据算法名称/工作模式/填充模式获取Cipher实例
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        // 根据算法名称初始化一个SecretKey实例，密钥必须是指定长度
        SecretKey keySpec = new SecretKeySpec(key, "AES");
        // 使用secretKey初始化Cipher实例，并设置加密或解密模式
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        // 传入明文或密文，获得密文或明文
        return cipher.doFinal(input);
    }

    // 解密:
    public static byte[] decrypt(byte[] key, byte[] input) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKey keySpec = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        return cipher.doFinal(input);
    }

    // CBC模式，它需要一个随机数作为IV参数，这样对于同一份明文，每次生成的密文都不同
    // 加密:
    public static byte[] encrypt1(byte[] key, byte[] input) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        // CBC模式需要生成一个16 bytes的initialization vector:
        SecureRandom sr = SecureRandom.getInstanceStrong();
        byte[] iv = sr.generateSeed(16);
        IvParameterSpec ivPS = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivPS);
        byte[] data = cipher.doFinal(input);
        // IV不需要保密，把IV和密文一起返回:
        return join(iv, data);
    }

    // 解密:
    public static byte[] decrypt1(byte[] key, byte[] input) throws GeneralSecurityException {
        // 把input分割成IV和密文:
        byte[] iv = new byte[16];
        byte[] data = new byte[input.length - 16];
        System.arraycopy(input, 0, iv, 0, 16);
        System.arraycopy(input, 16, data, 0, data.length);
        // 解密:
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivPS = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivPS);
        return cipher.doFinal(data);
    }

    public static byte[] join(byte[] bs1, byte[] bs2) {
        byte[] r = new byte[bs1.length + bs2.length];
        System.arraycopy(bs1, 0, r, 0, bs1.length);
        System.arraycopy(bs2, 0, r, bs1.length, bs2.length);
        return r;
    }
}
