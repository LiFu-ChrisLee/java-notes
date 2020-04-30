package learnNew;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author LiFu
 * @date 2020/4/29 下午5:41
 * @description learn new
 */
public class LearnNew {
    public static void main(String[] args) {

    }
}

//有一些注解可以修饰其他注解，这些注解就称为元注解（meta annotation）
//    @Target可以定义Annotation能够被应用于源码的哪些位置
//    @Target定义的value是ElementType[]数组，只有一个元素时，可以省略数组的写法
//        类或接口：ElementType.TYPE；
//        字段：ElementType.FIELD；
//        方法：ElementType.METHOD；
//        构造方法：ElementType.CONSTRUCTOR；
//        方法参数：ElementType.PARAMETER。

//    @Retention定义了Annotation的生命周期，默认为CLASS
//        仅编译期：RetentionPolicy.SOURCE；
//        仅class文件：RetentionPolicy.CLASS；
//        运行期：RetentionPolicy.RUNTIME。

//    @Repeatable
//        使用@Repeatable这个元注解可以定义Annotation是否可重复。这个注解应用不是特别广泛

//    @Inherited
//        使用@Inherited定义子类是否可继承父类定义的Annotation
//        @Inherited仅针对@Target(ElementType.TYPE)类型的annotation有效，并且仅针对class的继承，对interface的继承无效

//必须设置@Target和@Retention，@Retention一般设置为RUNTIME，因为我们自定义的注解通常要求在运行期读取

//使用@interface语法来定义注解（Annotation）
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface Report {
    // 注解的参数类似无参数方法，可以用default设定一个默认值（强烈推荐）
    int type() default 0;

    String level() default "info";

    // 最常用的参数应当命名为value
    String value() default "";
}
