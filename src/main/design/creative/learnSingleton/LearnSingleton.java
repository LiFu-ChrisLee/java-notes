package creative.learnSingleton;

/**
 * @author LiFu
 * @date 2020/5/25 下午5:47
 * @description learn Singleton
 */
public class LearnSingleton {
    public static void main(String[] args) {
        // 保证一个类仅有一个实例，并提供一个访问它的全局访问点

        Singleton sl = Singleton.getInstance();

        String name = World.INSTANCE.getName();
    }
}

class Singleton {
    // 静态字段引用唯一实例:
    private static final Singleton INSTANCE = new Singleton();

    // 延时加载
    // private static Singleton INSTANCE = null;

    // 使用Singleton模式的时候，最好不要延迟加载，这样会使代码更简单
    // 通过静态方法返回实例:
    // public synchronized static Singleton getInstance() {
    //     // 由于Java的内存模型，双重检查在这里不成立
    //     // if (INSTANCE == null) {
    //     //     synchronized (Singleton.class) {
    //     //         if (INSTANCE == null) {
    //     //             INSTANCE = new Singleton();
    //     //         }
    //     //     }
    //     // }
    //
    //     // 延时加载，多线程时出现竞争，但加锁会严重影响并发性能
    //     if (INSTANCE == null) {
    //         INSTANCE = new Singleton();
    //     }
    //     return INSTANCE;
    // }

    public static Singleton getInstance() {
        return INSTANCE;
    }

    // private构造方法保证外部无法实例化:
    private Singleton() {
    }
}

// 使用枚举类实现单例更好
enum World {
    // 唯一枚举:
    INSTANCE;

    private String name = "world";

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

