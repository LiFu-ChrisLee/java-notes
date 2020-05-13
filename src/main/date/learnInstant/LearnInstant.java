package learnInstant;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author LiFu
 * @date 2020/5/13 下午5:19
 * @description learn Instant
 */
public class LearnInstant {
    public static void main(String[] args) {
        // 用Instant.now()获取当前时间戳，效果和System.currentTimeMillis()类似
        System.out.println(System.currentTimeMillis());

        Instant now = Instant.now();
        System.out.println(now.getEpochSecond()); // 秒
        System.out.println(now.toEpochMilli()); // 毫秒

        // 以指定时间戳创建Instant:
        Instant ins = Instant.ofEpochSecond(1568568760);
        // 获取指定时区的ZonedDateTime
        ZonedDateTime zdt = ins.atZone(ZoneId.systemDefault());
        System.out.println(zdt); // 2019-09-16T01:32:40+08:00[Asia/Shanghai]

    }
}
