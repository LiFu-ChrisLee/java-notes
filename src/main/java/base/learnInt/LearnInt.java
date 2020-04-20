package base.learnInt;

/**
 * @author LiFu
 * @date 2020/4/17 下午3:42
 * @description learn int
 */
public class LearnInt {
    public static void main(String[] args) {
        int i = 167776589; // 00001010 00000000 00010001 01001101
        int n = 167776512; // 00001010 00000000 00010001 00000000
        System.out.println(i & n); // 167776512
    }
}
