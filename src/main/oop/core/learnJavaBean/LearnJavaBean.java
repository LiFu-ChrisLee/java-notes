package core.learnJavaBean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * @author LiFu
 * @date 2020/4/24 下午5:08
 * @description learn JavaBean
 */
public class LearnJavaBean {
    public static void main(String[] args) throws IntrospectionException {
        // 枚举JavaBean属性
        BeanInfo info = Introspector.getBeanInfo(Person.class);

        // class属性是从Object继承的getClass()方法带来的
        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
            System.out.println(pd.getName());
            System.out.println(pd.getReadMethod());
            System.out.println(pd.getWriteMethod());
        }
    }
}

//JavaBean主要用来传递数据，即把一组数据组合成一个JavaBean便于传输
//若干private实例字段
//通过public方法来读写实例字段
//读写方法符合以下这种命名规范
// 读方法:
//public Type getXyz()
// 写方法:
//public void setXyz(Type value)
//这种class被称为JavaBean
//boolean字段比较特殊，它的读方法一般命名为isXyz()
class Person {
    private String name;
    private int age;
    private boolean child;

    public boolean isChild() {
        return child;
    }

    public void setChild(boolean child) {
        this.child = child;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

