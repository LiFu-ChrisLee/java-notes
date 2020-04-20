package base.learnCharStr;

/**
 * @author LiFu
 * @date 2020/4/20 下午3:41
 * @description 请将下面一组int值视为字符的Unicode码，把它们拼成一个字符串：
 */
public class ExerciseCharStr {
    public static void main(String[] args) {
        int a = 72;
        int b = 105;
        int c = 65281;
        String s = "" + (char) a + (char) b + (char) c;
        System.out.println(s);
    }
}
