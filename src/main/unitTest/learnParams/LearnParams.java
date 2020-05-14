package learnParams;


/**
 * @author LiFu
 * @date 2020/5/14 下午5:32
 * @description
 */
public class LearnParams {
    public static String capitalize(String s) {
        if (s.length() == 0) {
            return s;
        }
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
}
