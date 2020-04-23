package base.learnPackage; // 声明包名

import base.learnPackage.learnImportPackage.LearnImportPackage; // 导入包的LearnImportPackage类

/**
 * @author LiFu
 * @date 2020/4/23 下午4:20
 * @description learn package
 */
public class LearnPackage {
    public static void main(String[] args) {
        // 可以调用，因为LearnPackage和LearnPackageN1在同一个包
        LearnPackageN1 lpn1 = new LearnPackageN1();
        lpn1.say();

        new LearnImportPackage();

//    Java编译器最终编译出的.class文件只使用完整类名，因此，在代码中，当编译器遇到一个class名称时：
//        如果是完整类名，就直接根据完整类名查找这个class；
//        如果是简单类名，按下面的顺序依次查找：
//            查找当前package是否存在这个class；
//            查找import的包是否包含这个class；
//            查找java.lang包是否包含这个class。
    }

    // 不用public、protected、private修饰的字段和方法就是包作用域
    void hello() {
        System.out.println("Hello!");
    }
}

