package creative.learnFactory;

import java.math.BigDecimal;

/**
 * @author LiFu
 * @date 2020/5/25 上午11:23
 * @description learn factory
 */
public class LearnFactory {
    public static void main(String[] args) {
        // 定义一个用于创建对象的接口，让子类决定实例化哪一个类。Factory Method使一个类的实例化延迟到其子类。

        // 使用静态方法创建产品的方式称为静态工厂方法（Static Factory Method）
        // 调用方可以完全忽略真正的工厂
        // 好处是允许创建产品的代码独立地变换，而不会影响到调用方
        NumberFactory factory = NumberFactory.getFactory();
        Number result = factory.parse("123.456");
        System.out.println(result);
    }
}

interface NumberFactory {
    // 创建方法:
    Number parse(String s);

    // 获取工厂实例:
    static NumberFactory getFactory() {
        return impl;
    }

    NumberFactory impl = new NumberFactoryImpl();
}

class NumberFactoryImpl implements NumberFactory {
    public Number parse(String s) {
        return new BigDecimal(s);
    }
}
