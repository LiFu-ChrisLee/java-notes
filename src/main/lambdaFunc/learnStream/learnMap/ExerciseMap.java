package learnStream.learnMap;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * @author LiFu
 * @date 2020/5/22 下午2:55
 * @description 使用map()把一组String转换为LocalDate并打印
 */
public class ExerciseMap {
    public static void main(String[] args) {
        Arrays.stream(new String[]{
                "2010-01-01",
                "2011-01-01",
                "2012-01-01",
                "2013-01-01",
                "2014-01-01"
        })
                .map(LocalDate::parse)
                .forEach(System.out::println);
    }
}
