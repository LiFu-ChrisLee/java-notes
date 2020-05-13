package exerciseDate;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author LiFu
 * @date 2020/5/13 下午5:24
 * @description exercise date
 */
public class ExerciseDate {
    public static void main(String[] args) {
        // 旧API转新API
        // Date -> Instant:
        Instant ins1 = (new Date()).toInstant();
        System.out.println(ins1);

        // Calendar -> Instant -> ZonedDateTime:
        Calendar calendar = Calendar.getInstance();
        Instant ins2 = Calendar.getInstance().toInstant();
        ZonedDateTime zdt = ins2.atZone(calendar.getTimeZone().toZoneId());
        System.out.println(zdt);

        // 新API转旧API
        // ZonedDateTime -> long:
        ZonedDateTime zdt1 = ZonedDateTime.now();
        long ts = zdt1.toEpochSecond() * 1000;

        // long -> Date:
        Date date = new Date(ts);
        System.out.println(date);

        // long -> Calendar:
        Calendar calendar1 = Calendar.getInstance();
        calendar1.clear();
        calendar1.setTimeZone(TimeZone.getTimeZone(zdt1.getZone().getId()));
        calendar1.setTimeInMillis(ts);
        System.out.println(calendar1.getTime());

        // 在数据库中存储日期和时间
//        在数据库中，也存在几种日期和时间类型：
        //        DATETIME：表示日期和时间；
        //        DATE：仅表示日期；
        //        TIME：仅表示时间；
        //        TIMESTAMP：和DATETIME类似，但是数据库会在创建或者更新记录的时候同时修改TIMESTAMP。
//
//        在使用Java程序操作数据库时，我们需要把数据库类型与Java类型映射起来。下表是数据库类型与Java新旧API的映射关系：
        //        数据库	        对应Java类（旧）	        对应Java类（新）
        //        DATETIME	    java.util.Date	        LocalDateTime
        //        DATE	        java.sql.Date	        LocalDate
        //        TIME	        java.sql.Time	        LocalTime
        //        TIMESTAMP	    java.sql.Timestamp	    LocalDateTime

        long ts1 = 1574208900000L;
        System.out.println(timestampToString(ts1, Locale.CHINA, "Asia/Shanghai"));
        System.out.println(timestampToString(ts1, Locale.US, "America/New_York"));
    }

    static String timestampToString(long epochMilli, Locale lo, String zoneId) {
        Instant ins = Instant.ofEpochMilli(epochMilli);
        DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT);
        return f.withLocale(lo).format(ZonedDateTime.ofInstant(ins, ZoneId.of(zoneId)));
    }
}
