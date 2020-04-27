package core.learnEnum;

/**
 * @author LiFu
 * @date 2020/4/27 下午2:37
 * @description learn enum
 */
public class LearnEnum {
    public static void main(String[] args) {
        // 返回常量名
        String s = Weekday.SUN.name(); // "SUN"
        // 返回定义的常量的顺序，从0开始计数
        int n = Weekday.MON.ordinal(); // 1

        Weekday day = Weekday.SUN;
        switch(day) {
            case MON:
            case TUE:
            case WED:
            case THU:
            case FRI:
                System.out.println("Today is " + day + ". Work at office!");
                break;
            case SAT:
            case SUN:
                System.out.println("Today is " + day + ". Work at home!");
                break;
            default:
                throw new RuntimeException("cannot process " + day);
        }
    }
}

enum Weekday {
    MON(1, "星期一"), TUE(2, "星期二"), WED(3, "星期三"), THU(4, "星期四"), FRI(5, "星期五"), SAT(6, "星期六"), SUN(0, "星期日");

    public final int dayValue;
    private final String chinese;

    private Weekday(int dayValue, String chinese) {
        this.dayValue = dayValue;
        this.chinese = chinese;
    }

    @Override
    public String toString() {
        return this.chinese;
    }
}

//enum 的实现
//public final class Color extends Enum { // 继承自Enum，标记为final class
//    // 每个实例均为全局唯一:
//    public static final Color RED = new Color();
//    public static final Color GREEN = new Color();
//    public static final Color BLUE = new Color();
//    // private构造方法，确保外部无法调用new操作符:
//    private Color() {}
//}
