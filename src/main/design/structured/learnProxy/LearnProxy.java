package structured.learnProxy;

/**
 * @author LiFu
 * @date 2020/5/27 下午3:55
 * @description learn proxy
 */
public class LearnProxy {
    public static void main(String[] args) {
        // 为其他对象提供一种代理以控制对这个对象的访问。

        // 远程代理 Remote Proxy
        // 本地的调用者持有的接口实际上是一个代理，这个代理负责把对接口的方法访问转换成远程调用，然后返回结果

        // 虚代理 Virtual Proxy
        // 它让调用者先持有一个代理对象，但真正的对象尚未创建。如果没有必要，这个真正的对象是不会被创建的，直到客户端需要真的必须调用时，才创建真正的对象

        // 保护代理 Protection Proxy
        // 它用代理对象控制对原始对象的访问，常用于鉴权

        // 智能引用 Smart Reference
        // 它也是一种代理对象，如果有很多客户端对它进行访问，通过内部的计数器可以在外部调用者都不使用后自动释放它
    }
}

