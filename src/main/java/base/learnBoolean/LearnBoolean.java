package base.learnBoolean;

/**
 * @author LiFu
 * @date 2020/4/17 下午5:19
 * @description learn boolean
 */
public class LearnBoolean {
    public static void main(String[] args) {
        int m = (int) (Math.random() * 10);
        int n = (int) Math.pow(-1, m);
        int x = n >= 0 ? 1 :  -1;
        System.out.println(x);
    }
}
