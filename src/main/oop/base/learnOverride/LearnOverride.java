package base.learnOverride;

/**
 * @author LiFu
 * @date 2020/4/22 下午5:58
 * @description learn override
 */
public class LearnOverride {
    public static void main(String[] args) {
        // Person类
        Person p = new Student();
        // 多态(Polymorphic)
        // Java的实例方法调用是基于运行时的实际类型的动态调用，而非变量的声明类型
        p.run();

        // 计算收入税
        // 给一个有普通收入、工资收入和享受国务院特殊津贴的小伙伴算税:
        Income[] incomes = new Income[]{
                new Income(3000),
                new Salary(7500),
                new StateCouncilSpecialAllowance(15000)
        };
        System.out.println(totalTax(incomes));
    }

    // 计算收入税
    public static double totalTax(Income... incomes) {
        double total = 0;
        for (Income income : incomes) {
            total = total + income.getTax();
        }
        return total;
    }
}

//Person类
//final修饰的类不能被继承
final class PurePerson {
    // final修饰的字段在初始化后不能被修改
    public final String name;

    // 可以在构造方法中初始化final字段
    public PurePerson(String name) {
        this.name = name;
    }
}

class Person {
    protected String name = "";

    // final修饰的方法不能被Override
    final String say() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String hello() {
        return "Hello, " + name;
    }

    // 覆写Object方法
    // 显示更有意义的字符串:
    @Override
    public String toString() {
        return "Person:name=" + name;
    }

    // 比较是否相等:
    @Override
    public boolean equals(Object o) {
        // 当且仅当o为Person类型:
        if (o instanceof Person) {
            Person p = (Person) o;
            // 并且name字段相同时，返回true:
            return this.name.equals(p.name);
        }
        return false;
    }

    // 计算hash:
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    public void run() {
        System.out.println("Person.run");
    }
}

class Student extends Person {
    // 如果方法签名如果不同，就是Overload，Overload方法是一个新方法；如果方法签名相同，并且返回值也相同，就是Override
    @Override
    public void run() {
        System.out.println("Student.run");
    }

    @Override
    public String hello() {
        // 在子类的覆写方法中，如果要调用父类的被覆写的方法，可以通过super来调用
        return super.hello() + "!";
    }
}

//计算收入税
class Income {
    protected double income;

    public Income(double income) {
        this.income = income;
    }

    public double getTax() {
        return income * 0.1; // 税率10%
    }
}

class Salary extends Income {
    public Salary(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        if (income <= 5000) {
            return 0;
        }
        return (income - 5000) * 0.2;
    }
}

class StateCouncilSpecialAllowance extends Income {
    public StateCouncilSpecialAllowance(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        return 0;
    }
}
