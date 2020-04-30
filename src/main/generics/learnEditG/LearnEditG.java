package learnEditG;

/**
 * @author LiFu
 * @date 2020/4/30 下午3:08
 * @description learn edit
 */
public class LearnEditG {
    public static void main(String[] args) {

    }
}

class Pair<T, K> {
    private final T first;
    private final K last;

    public Pair(T first, K last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public K getLast() {
        return last;
    }

    // 静态泛型方法应该使用其他类型区分:
    public static <L> Pair<L, L> create(L first, L last) {
        return new Pair<>(first, last);
    }
}