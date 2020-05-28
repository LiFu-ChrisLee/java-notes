package behavioral.learnIterator;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author LiFu
 * @date 2020/5/28 上午9:21
 * @description learn Iterator
 */
public class LearnIterator {
    public static void main(String[] args) {
        // 提供一种方法顺序访问一个聚合对象中的各个元素，而又不需要暴露该对象的内部表示。

        ReverseArrayCollection<Integer> rac = new ReverseArrayCollection<>(1, 2, 3, 4);
        for (Integer a : rac) {
            System.out.println(a);
        }
    }
}

class ReverseArrayCollection<T> implements Iterable<T> {
    private final T[] array;

    @SafeVarargs
    public ReverseArrayCollection(T... objs) {
        this.array = Arrays.copyOfRange(objs, 0, objs.length);
    }

    @Override
    public @NotNull Iterator<T> iterator() {
        return new ReverseIterator();
    }

    // 使用内部类的好处是内部类隐含地持有一个它所在对象的this引用，可以通过ReverseArrayCollection.this引用到它所在的集合。
    class ReverseIterator implements Iterator<T> {
        // 索引位置:
        int index;

        public ReverseIterator() {
            // 创建Iterator时,索引在数组末尾:
            this.index = ReverseArrayCollection.this.array.length;
        }

        public boolean hasNext() {
            // 如果索引大于0,那么可以移动到下一个元素(倒序往前移动):
            return index > 0;
        }

        public T next() {
            // 将索引移动到下一个元素并返回(倒序往前移动):
            index--;
            return array[index];
        }
    }
}
