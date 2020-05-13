package learnZonedDateTime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author LiFu
 * @date 2020/5/12 下午5:59
 * @description learn ZonedDateTime
 */
public class LearnZonedDateTime {
    public static void main(String[] args) {
//        可以简单地把ZonedDateTime理解成LocalDateTime加ZoneId
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        ZonedDateTime zny = ZonedDateTime.now(ZoneId.of("America/New_York")); // 用指定时区获取当前时间
        System.out.println(zbj);
        System.out.println(zny);

        // 给一个LocalDateTime附加一个ZoneId，就可以变成ZonedDateTime
        LocalDateTime ldt = LocalDateTime.of(2019, 9, 15, 15, 16, 17);
        ZonedDateTime zbj1 = ldt.atZone(ZoneId.systemDefault());
        ZonedDateTime zny1 = ldt.atZone(ZoneId.of("America/New_York"));
        System.out.println(zbj1);
        System.out.println(zny1);

        // ZonedDateTime对象，通过withZoneSameInstant()将关联时区转换到另一个时区，转换后日期和时间都会相应调整
        // 以中国时区获取当前时间:
        ZonedDateTime zbj2 = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        // 转换为纽约时间:
        ZonedDateTime zny2 = zbj2.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(zbj2);
        System.out.println(zny2);

        // 有了ZonedDateTime，将其转换为本地时间就非常简单
        LocalDateTime ldt1 = zbj.toLocalDateTime();
        System.out.println(ldt1);
    }
}
