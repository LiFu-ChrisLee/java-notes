package learnIterator;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author LiFu
 * @date 2020/5/9 下午3:25
 * @description learn Iterator
 */
public class LearnIterator {
    public static void main(String[] args) {
        ReverseList<String> rl = new ReverseList<>();
        rl.add("Apple");
        rl.add("Orange");
        rl.add("Pear");
        for (String s : rl) {
            System.out.println(s);
        }
    }
}

class ReverseList<T> implements Iterable<T> {

    private final List<T> list = new ArrayList<>();

    public void add(T t) {
        list.add(t);
    }

    @Override
    public @NotNull Iterator<T> iterator() {
        return new ReverseIterator(list.size());
    }

    // 在编写Iterator的时候，我们通常可以用一个内部类来实现Iterator接口，这个内部类可以直接访问对应的外部类的所有字段和方法。
    class ReverseIterator implements Iterator<T> {
        int index;

        ReverseIterator(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public T next() {
            index--;
            return ReverseList.this.list.get(index);
        }
    }
}
