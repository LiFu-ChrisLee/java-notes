package base.learnAbstract;

import org.jetbrains.annotations.NotNull;

/**
 * @author LiFu
 * @date 2020/4/23 上午10:00
 * @description 用抽象类给一个有工资收入和稿费收入的小伙伴算税
 */
public class ExerciseAbstract {
    public static void main(String[] args) {
        Income[] incomes = new Income[]{
                new CommonIncome(3000),
                new Salary(7500),
                new StateCouncilSpecialAllowance(15000)
        };
        System.out.println(totalTax(incomes));
    }

    private static double totalTax(Income ... incomes) {
        double total = 0;
        for (Income income : incomes) {
            total = total + income.getTax();
        }
        return total;
    }
}

abstract class Income {
    protected double income;
    public Income(double income) {
        this.income = income;
    }
    public abstract double getTax();
}

class CommonIncome extends Income {
    public CommonIncome(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        return income * 0.1;
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