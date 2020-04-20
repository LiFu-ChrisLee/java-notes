package base.learnDouble;

/**
 * @author LiFu
 * @date 2020/4/17 下午5:03
 * @description 根据一元二次方程ax^2+bx+c=0的求根公式，计算出一元二次方程的两个解
 */
public class ExerciseDouble {
    public static void main(String[] args) {
        double a = 1.0;
        double b = 3.0;
        double c = -4.0;

        // 求平方根可用 Math.sqrt():
        // System.out.println(Math.sqrt(2)); ==> 1.414
        double r1, r2;

        double sqrtNum = Math.sqrt((b * b - 4 * a * c));
        r1 = (-b + sqrtNum) / (2 * a);
        r2 = (-b - sqrtNum) / (2 * a);

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r1 == 1 && r2 == -4 ? "测试通过" : "测试失败");
    }
}
