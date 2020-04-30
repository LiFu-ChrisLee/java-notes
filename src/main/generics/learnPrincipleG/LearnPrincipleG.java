package learnPrincipleG;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author LiFu
 * @date 2020/4/30 下午3:56
 * @description learn principle
 */
public class LearnPrincipleG {
    public static void main(String[] args) {
//        Java使用擦拭法实现泛型，导致了：
//        编译器把类型<T>视为Object；
//        编译器根据<T>实现安全的强制转型。

//        Java泛型的局限
//        一：<T>不能是基本类型，例如int，因为实际类型是Object，Object类型无法持有基本类型
//        二：无法取得带泛型的Class
//        三：无法判断带泛型的Class
//        四：不能实例化T类型

        Pair<String> p1 = new Pair<>("Hello", "world");
        Pair<Integer> p2 = new Pair<>(123, 456);
        Class c1 = p1.getClass();
        Class c2 = p2.getClass();
        // 对Pair<String>和Pair<Integer>类型获取Class时，获取到的是同一个Class，也就是Pair类的Class
        System.out.println(c1 == c2); // true
        System.out.println(c1 == Pair.class); // true

        // 在继承了泛型类型的情况下，子类可以获取父类的泛型类型
        Class<IntPair> clazz = IntPair.class;
        Type t = clazz.getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) t;
            Type[] types = pt.getActualTypeArguments(); // 可能有多个泛型类型
            Type firstType = types[0]; // 取第一个泛型类型
            Class<?> typeClass = (Class<?>) firstType;
            System.out.println(typeClass); // Integer
        }
    }
}


class Pair<T> {
    private final T first;
    private final T last;

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
}

//泛型继承
class IntPair extends Pair<Integer> {
    public IntPair(Integer first, Integer last) {
        super(first, last);
    }
}
