package learnSignature;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;

/**
 * @author LiFu
 * @date 2020/5/21 下午4:40
 * @description learn signature
 */
public class LearnSignature {
    public static void main(String[] args) throws Exception {
        // 生成RSA公钥/私钥:
        KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
        kpGen.initialize(1024);
        KeyPair kp = kpGen.generateKeyPair();
        PrivateKey sk = kp.getPrivate();
        PublicKey pk = kp.getPublic();

        // 待签名的消息:
        byte[] message = "Hello, I am Bob!".getBytes(StandardCharsets.UTF_8);

        // 用私钥签名:
        Signature s = Signature.getInstance("SHA1withRSA");
        s.initSign(sk);
        s.update(message);
        byte[] signed = s.sign();
        System.out.println(String.format("signature: %x", new BigInteger(1, signed)));

        // 用公钥验证:
        Signature v = Signature.getInstance("SHA1withRSA");
        v.initVerify(pk);
        v.update(message);
        boolean valid = v.verify(signed);
        System.out.println("valid? " + valid);

        // DSA签名
        // 除了RSA可以签名外，还可以使用DSA算法进行签名。DSA是Digital Signature Algorithm的缩写，它使用ElGamal数字签名算法。
        // DSA只能配合SHA使用，常用的算法有：
        // SHA1withDSA
        // SHA256withDSA
        // SHA512withDSA
        // 和RSA数字签名相比，DSA的优点是更快

        // ECDSA签名
        // 椭圆曲线签名算法
        // 特点是可以从私钥推出公钥
    }
}
