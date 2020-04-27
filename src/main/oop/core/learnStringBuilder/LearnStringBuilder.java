package core.learnStringBuilder;

/**
 * @author LiFu
 * @date 2020/4/24 上午10:30
 * @description learn string builder
 */
public class LearnStringBuilder {
    public static void main(String[] args) {
        // 每次循环都会创建新的字符串对象，浪费内存
        String s = "";
        for (int i = 0; i < 1000; i++) {
            s = s + i;
        }

        // 往StringBuilder中新增字符时，不会创建新的临时对象
        StringBuilder sb = new StringBuilder(1024);
        for (int i = 0; i < 1000; i++) {
            // 链式操作
            sb.append(i).append(",");
        }
        String s1 = sb.toString();
    }
}
