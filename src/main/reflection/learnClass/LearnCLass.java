package learnClass;

/**
 * @author LiFu
 * @date 2020/4/28 下午5:23
 * @description learn class
 */
public class LearnCLass {
    public static void main(String[] args) throws ClassNotFoundException {
        // 由于JVM为每个加载的class创建了对应的Class实例，并在实例中保存了该class的所有信息，包括类名、包名、父类、实现的接口、所有方法、字段等，因此，如果获取了某个Class实例，我们就可以通过这个Class实例获取到该实例对应的class的所有信息。

        // 这种通过Class实例获取class信息的方法称为反射（Reflection）。

        // 获取一个class的Class实例
        // 方法一：直接通过一个class的静态变量class获取
        Class cls = String.class;
        System.out.println(cls);
        // 方法二：如果我们有一个实例变量，可以通过该实例变量提供的getClass()方法获取
        String s = "Hello";
        cls = s.getClass();
        System.out.println(cls);
        // 方法三：如果知道一个class的完整类名，可以通过静态方法Class.forName()获取
        cls = Class.forName("java.lang.String");
        System.out.println(cls);

        // 注意一下Class实例比较和instanceof的差别
//        Integer n = 123;
//
//        boolean b1 = n instanceof Integer; // true，因为n是Integer类型
//        boolean b2 = n instanceof Number; // true，因为n是Number类型的子类
//
//        boolean b3 = n.getClass() == Integer.class; // true，因为n.getClass()返回Integer.class
//        boolean b4 = n.getClass() == Number.class; // false，因为Integer.class!=Number.class

        printClassInfo("".getClass());
        printClassInfo(Runnable.class);
        printClassInfo(java.time.Month.class);
        printClassInfo(String[].class);
        printClassInfo(int.class);

//        // 获取String的Class实例:
//        Class cls1 = String.class;
//        // 创建一个String实例，只能调用public的无参数构造方法:
//        String s = (String) cls1.newInstance();

        // JVM在执行Java程序的时候，并不是一次性把所有用到的class全部加载到内存，而是第一次需要用到class时才加载
        // 利用JVM动态加载class的特性，我们才能在运行期根据条件加载不同的实现类
    }

    static void printClassInfo(Class cls) {
//        class 全称
        System.out.println("Class name: " + cls.getName());
//        class 简称
        System.out.println("Simple name: " + cls.getSimpleName());
//        包名
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
//        是否为接口
        System.out.println("is interface: " + cls.isInterface());
//        是否为枚举
        System.out.println("is enum: " + cls.isEnum());
//        是否为数组
        System.out.println("is array: " + cls.isArray());
//        是否为基础 class，如 int
        System.out.println("is primitive: " + cls.isPrimitive());
        System.out.println();
    }
}
