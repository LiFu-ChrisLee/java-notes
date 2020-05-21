package learnEncode;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

/**
 * @author LiFu
 * @date 2020/5/18 下午3:51
 * @description learn encode
 */
public class LearnEncode {
    public static void main(String[] args) {
        // ASCII码
        // 字母	    ASCII编码
        // A	    0x41
        // B	    0x42
        // C	    0x43
        // D	    0x44

        // Unicode编码，使用UTF-8编码
        // 汉字	    Unicode编码	    UTF-8编码
        // 中	    0x4e2d	        0xe4b8ad
        // 文	    0x6587	        0xe69687
        // 编	    0x7f16	        0xe7bc96
        // 码	    0x7801	        0xe7a081

        // URL编码
        // 如果字符是A~Z，a~z，0~9以及-、_、.、*，则保持不变；
        // 如果是其他字符，先转换为UTF-8编码，然后对每个字节以%XX表示。

        // 中的UTF-8编码是0xe4b8ad，因此，它的URL编码是%E4%B8%AD
        // 文的UTF-8编码是0xe69687，因此，它的URL编码是%E6%96%87
        // !虽然是ASCII字符，也要对其编码为%21
        String encoded = URLEncoder.encode("中文!", StandardCharsets.UTF_8);
        System.out.println(encoded); // %E4%B8%AD%E6%96%87%21
        // URLEncoder把空格字符编码成+，而现在的URL编码标准要求空格被编码为%20，不过，服务器都可以处理这两种情况
        String decoded = URLDecoder.decode("%E4%B8%AD%E6%96%87%21", StandardCharsets.UTF_8);
        System.out.println(decoded);

        // Base64编码
        // 原理是把3字节的二进制数据按6bit一组，用4个int整数表示，然后查表，把int整数用索引对应到字符，得到编码后的字符串
        // 例子：3个byte数据分别是e4、b8、ad，按6bit分组得到39、0b、22和2d
        // 因为6位整数的范围总是0~63，所以，能用64个字符表示：字符A~Z对应索引0~25，字符a~z对应索引26~51，字符0~9对应索引52~61，最后两个索引62、63分别用字符+和/表示
        // 编码
        byte[] input = new byte[]{(byte) 0xe4, (byte) 0xb8, (byte) 0xad};
        String b64encoded = Base64.getEncoder().encodeToString(input);
        System.out.println(b64encoded);
        // 解码
        byte[] output = Base64.getDecoder().decode("5Lit");
        System.out.println(Arrays.toString(output)); // [-28, -72, -83]}
        // 编码的时候可以用withoutPadding()去掉=，解码出来的结果是一样的
        byte[] input1 = new byte[] { (byte) 0xe4, (byte) 0xb8, (byte) 0xad, 0x21 };
        String b64encoded1 = Base64.getEncoder().encodeToString(input1);
        String b64encoded2 = Base64.getEncoder().withoutPadding().encodeToString(input1);
        System.out.println(b64encoded1);
        System.out.println(b64encoded2);
        byte[] output1 = Base64.getDecoder().decode(b64encoded2);
        System.out.println(Arrays.toString(output1));
        // 针对URL的Base64编码可以在URL中使用的Base64编码，它仅仅是把+变成-，/变成_
        byte[] input2 = new byte[] { 0x01, 0x02, 0x7f, 0x00 };
        String b64encoded3 = Base64.getUrlEncoder().encodeToString(input2);
        System.out.println(b64encoded3);
        byte[] output2 = Base64.getUrlDecoder().decode(b64encoded3);
        System.out.println(Arrays.toString(output2));
    }
}
