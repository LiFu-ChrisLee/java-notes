package base.learnBoolean;

/**
 * @author LiFu
 * @date 2020/4/17 下午5:32
 * @description 判断指定年龄是否是小学生（6～12岁）
 */
public class ExerciseBoolean {
    public static void main(String[] args) {
        int age = (int) (Math.random() * 15);
        // primary student的定义: 6~12岁
        boolean isPrimaryStudent = age >= 6 && age <= 12;
        System.out.println("age is " + age);
        System.out.println(isPrimaryStudent ? "Yes" : "No");
    }
}
