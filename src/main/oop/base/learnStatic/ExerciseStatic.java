package base.learnStatic;

/**
 * @author LiFu
 * @date 2020/4/23 下午3:27
 * @description 给People类增加一个静态字段count和静态方法getCount，统计实例创建的个数
 */
public class ExerciseStatic {
    public static void main(String[] args) {
        new People();
        new People();
        new People();
        System.out.println(People.getCount());
    }
}

class People {
    private static int count = 0;

    public People() {
        count++;
    }

    public static int getCount() {
        return count;
    }
}