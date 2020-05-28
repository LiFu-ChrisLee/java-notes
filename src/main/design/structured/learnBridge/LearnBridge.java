package structured.learnBridge;

/**
 * @author LiFu
 * @date 2020/5/26 上午9:45
 * @description learn bridge
 */
public class LearnBridge {
    public static void main(String[] args) {
        // 将抽象部分与它的实现部分分离，使它们都可以独立地变化。
        // 桥接模式就是为了避免直接继承带来的子类爆炸

        // 使用时只需桥接两个维度即可
        Car bigCar = new BigCar(new HybridEngine());
        bigCar.drive();

        Car bossCar = new BossCar(new OilEngine());
        bossCar.drive();
    }
}

interface Engine {
    void start();
}

abstract class Car {
    protected final Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    abstract public void drive();
}

// 将车分为品牌和引擎两个维度，通过桥接避免子类爆炸
abstract class RefinedCar extends Car {
    // 维度二：引擎
    public RefinedCar(Engine engine) {
        super(engine);
    }

    // 维度一：品牌
    abstract public String getBrand();

    @Override
    public void drive() {
        this.engine.start();
        System.out.println("Drive " + getBrand() + " car.");
    }
}

class BigCar extends RefinedCar {
    public BigCar(Engine engine) {
        super(engine);
    }

    @Override
    public String getBrand() {
        return "Big";
    }
}

class BossCar extends RefinedCar {
    public BossCar(Engine engine) {
        super(engine);
    }

    @Override
    public String getBrand() {
        return "Boss";
    }
}

class HybridEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Hybrid Engine start.");
    }
}

class OilEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Oil Engine start.");
    }
}
