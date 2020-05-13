package learnDateTimeFormatter;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author LiFu
 * @date 2020/5/13 下午4:54
 * @description learn DateTimeFormatter
 */
public class LearnDateTimeFormatter {
    public static void main(String[] args) {
        // 创建DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println(formatter.format(zdt));

        // 另一种创建DateTimeFormatter的方法是，传入格式化字符串时，同时指定Locale
        var zhFormatter = DateTimeFormatter.ofPattern("yyyy MMM dd EE HH:mm", Locale.CHINA);
        System.out.println(zhFormatter.format(zdt));

        var usFormatter = DateTimeFormatter.ofPattern("EE, MMM/dd/yyyy HH:mm", Locale.US);
        System.out.println(usFormatter.format(zdt));

        // 按照ISO 8601格式显示
        System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now()));
    }
}
