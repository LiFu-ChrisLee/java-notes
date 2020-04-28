package learnNullPointerException;

/**
 * @author LiFu
 * @date 2020/4/28 下午3:32
 * @description learn NullPointerException
 */
public class LearnNullPointerException {
    public static void main(String[] args) {
//        String s = null; // NullPointerException
        String s = ""; // 最好初始化值为空字符串
        System.out.println(s.toLowerCase());
    }
}
