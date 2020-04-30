package learnExtends;

/**
 * @author LiFu
 * @date 2020/4/30 下午4:52
 * @description learn extends
 */
public class LearnExtends {
    public static void main(String[] args) {
        Pair<Integer> p = new Pair<>(123, 456);
        int n = add(p);
        System.out.println(n);
    }

    // 上界通配符（Upper Bounds Wildcards），即把泛型类型T的上界限定在Number了
    // 使用Pair<? extends Number>使得方法接收所有泛型类型为Number或Number子类的Pair类型
    // 换句话说，使用<? extends Number>作为方法参数，表示方法内部代码对于参数只能读，不能写
    static int add(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        // 含参方法需要传入<? extends Number>类型，然而不存在这种类型，故无法调用此方法
        // p.setFirst(new Integer(100));
        // p.isSame(new Integer(100));
        return first.intValue() + last.intValue();
    }
}

class Pair<T> {
    private T first;
    private final T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public boolean isSame(T other) {
        return first.equals(other);
    }

    public T getLast() {
        return last;
    }

    public void setFirst(T first) {
        this.first = first;
    }
}

// 在定义泛型类型Pair<T>的时候，也可以使用extends通配符来限定T的类型
class Pair2<T extends Number> {}