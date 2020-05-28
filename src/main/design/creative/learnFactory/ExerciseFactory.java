package creative.learnFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author LiFu
 * @date 2020/5/25 下午2:45
 * @description 使用静态工厂方法实现一个类似20200202的整数转换为LocalDate
 */
public class ExerciseFactory {
    public static void main(String[] args) {
        LocalDate ld = LocalDateFactory.fromInt(20200202);
        System.out.println(ld.toString());
    }
}


class LocalDateFactory {
    public static LocalDate fromInt(int yyyyMMdd) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        return LocalDate.parse(String.valueOf(yyyyMMdd), dtf);
    }
}
