package behavioral.learnObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiFu
 * @date 2020/5/28 上午11:02
 * @description learn Observer
 */
public class LearnObserver {
    public static void main(String[] args) {
        // 定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。

        // 观察者模式（Observer）又称发布-订阅模式（Publish-Subscribe：Pub/Sub）。它是一种通知机制，让发送通知的一方（被观察方）和接收通知的一方（观察者）能彼此分离，互不影响。

        Store s = new Store();
        Admin ad = new Admin("A");
        Customer cu = new Customer("CA");
        s.addObserver(ad);
        s.addObserver(cu);
        s.addNewProduct("PA", 2333);
    }
}

class Store {
    // 引用一个ProductObserver接口，任何人想要观察Store，只要实现该接口，并且把自己注册到Store即可
    private final List<ProductObserver> observers = new ArrayList<>();
    private final Map<String, Product> products = new HashMap<>();

    // 注册观察者:
    public void addObserver(ProductObserver observer) {
        this.observers.add(observer);
    }

    // 取消注册:
    public void removeObserver(ProductObserver observer) {
        this.observers.remove(observer);
    }

    // 通知所有订阅者
    private void onPublished(Product p) {
        for (ProductObserver po : observers) {
            // 异步执行，避免阻塞
            // Thread th = new Thread(new PublishedAdapter(po, p));
            Thread th = new Thread(() -> po.onPublished(p));
            th.start();
        }
    }

    // 通知所有订阅者
    private void onPriceChanged(Product p) {
        for (ProductObserver po : observers) {
            Thread th = new Thread(() -> po.onPriceChanged(p));
            th.start();
        }
    }

    public void addNewProduct(String name, double price) {
        Product p = new Product(name, price);
        products.put(p.getName(), p);
        // 通知所有订阅者:
        onPublished(p);
    }

    public void setProductPrice(String name, double price) {
        Product p = products.get(name);
        p.setPrice(price);
        // 通知所有订阅者:
        onPriceChanged(p);
    }
}

class Product {
    private final String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// 订阅接口
interface ProductObserver {
    void onPublished(Product p);

    void onPriceChanged(Product p);
}

class PublishedAdapter implements Runnable {
    private final ProductObserver po;
    private final Product p;

    public PublishedAdapter(ProductObserver po, Product p) {
        this.po = po;
        this.p = p;
    }

    @Override
    public void run() {
        this.po.onPublished(this.p);
    }
}

class Admin implements ProductObserver {
    private final String name;

    public Admin(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void onPublished(Product p) {
        System.out.println("Product " + p.getName() + " is published! Admin got it!");
    }

    @Override
    public void onPriceChanged(Product p) {
        System.out.println("Product " + p.getName() + "'s price is changed to " + p.getPrice() + "! Admin got it!");
    }
}

class Customer implements ProductObserver {
    private final String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void onPublished(Product p) {
        System.out.println("Product " + p.getName() + " is published! Customer got it!");
    }

    @Override
    public void onPriceChanged(Product p) {
        System.out.println("Product " + p.getName() + "'s price is changed to " + p.getPrice() + "! Customer got it!");
    }
}
