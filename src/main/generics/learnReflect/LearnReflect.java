package learnReflect;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;

/**
 * @author LiFu
 * @date 2020/4/30 下午6:19
 * @description learn reflect
 */
public class LearnReflect {
    public static void main(String[] args) throws Exception {
        // Class<T>就是泛型
        Class<Pair> pc = Pair.class;
        // 调用Class的getSuperclass()方法返回的Class类型是Class<? super T>
        Class<? super Pair> pcp = pc.getSuperclass();
        // 构造方法Constructor<T>也是泛型
        Constructor<?> pcc = pc.getDeclaredConstructor();

        // 我们可以声明带泛型的数组，但不能用new操作符创建带泛型的数组
        // 果在方法内部创建了泛型数组，最好不要将它返回给外部使用
        Pair1<String>[] ps = (Pair1<String>[]) new Pair[2];

        String[] ss = Pair1.asArray("a", "b", "c");
    }
}

class Pair {

}

class Pair1<T> extends Pair {
    // 必须借助Class<T>来创建泛型数组
    T[] createArray(Class<T> cls) {
        return (T[]) Array.newInstance(cls, 5);
    }

    // 还可以利用可变参数创建泛型数组T[]
    @SafeVarargs
    static <T> T[] asArray(T... objs) {
        return objs;
    }
}