package learnSupper;

/**
 * @author LiFu
 * @date 2020/4/30 下午5:17
 * @description learn supper
 */
public class LearnSupper {
    public static void main(String[] args) {
        // Pair<? super Integer>表示，方法参数接受所有泛型类型为Integer或Integer父类的Pair类型
        // 换句话说，使用<? super Integer>通配符作为方法参数，表示方法内部代码对于参数只能写，不能读
        Pair<Number> p1 = new Pair<>(12.3, 4.56);
        Pair<Integer> p2 = new Pair<>(123, 456);
        setSame(p1, 100);
        setSame(p2, 200);
        System.out.println(p1.getFirst() + ", " + p1.getLast());
        System.out.println(p2.getFirst() + ", " + p2.getLast());

        // PECS原则：Producer Extends Consumer Super
        // 如果需要返回T，它是生产者（Producer），要使用extends通配符；如果需要写入T，它是消费者（Consumer），要使用super通配符

        // Java的泛型还允许使用无限定通配符（Unbounded Wildcard Type），即只定义一个?
        // 因为<?>通配符既没有extends，也没有super，因此：
        // 不允许调用set(T)方法并传入引用（null除外）；
        // 不允许调用T get()方法并获取T引用（只能获取Object引用）

        // Pair<?>是所有Pair<T>的超类
        Pair<?> p3 = p1; // 安全地向上转型
        System.out.println(p3);
    }

    static void setSame(Pair<? super Integer> p, Integer n) {
        p.setFirst(n);
        p.setLast(n);
        // 返回泛型的方法，返回值类型为<? super Integer>，除Object外没有符合的
        // Integer x = p.getFirst(); // 无效
        Object x = p.getFirst(); // 有效
        System.out.println(x);
    }

    // <?>只能做一些null判断，可用<T>替换
    static <T> boolean isNull(Pair<T> p) {
        return p.getFirst() == null || p.getLast() == null;
    }
}

class Pair<T> {
    private T first;
    private T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }
    public T getLast() {
        return last;
    }
    public void setFirst(T first) {
        this.first = first;
    }
    public void setLast(T last) {
        this.last = last;
    }
}
