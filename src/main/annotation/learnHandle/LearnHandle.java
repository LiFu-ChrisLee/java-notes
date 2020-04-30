package learnHandle;

import java.lang.annotation.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author LiFu
 * @date 2020/4/30 上午10:24
 * @description learn handle
 */
public class LearnHandle {
    public static void main(String[] args) throws Exception {
//        使用反射API判断某个注解是否存在于Class、Field、Method或Constructor：
//        Class.isAnnotationPresent(Class)
//        Field.isAnnotationPresent(Class)
//        Method.isAnnotationPresent(Class)
//        Constructor.isAnnotationPresent(Class)

        System.out.println(Person.class.isAnnotationPresent(NeedVal.class));
        Field pf = Person.class.getDeclaredField("name");
        System.out.println(pf.isAnnotationPresent(NeedVal.class));
        Constructor<Person> pc = Person.class.getConstructor(String.class);
        System.out.println(pc.isAnnotationPresent(NeedVal.class));
        Method pm = Person.class.getDeclaredMethod("setName", String.class);
        System.out.println(pm.isAnnotationPresent(NeedVal.class));

//        使用反射API读取Annotation：
//        Class.getAnnotation(Class)
//        Field.getAnnotation(Class)
//        Method.getAnnotation(Class)
//        Constructor.getAnnotation(Class)

        Person p;
        if (Math.random() > 0.5) {
            p = new Person();
        } else {
            p = new Person("hei");
        }

        Annotation[] pfa = pf.getAnnotations();
        for (Annotation a : pfa) {
            if (a instanceof NeedVal) {
                NeedVal nv = (NeedVal) a;
                pf.setAccessible(true);
                Object val = pf.get(p);
                System.out.println("name: " + val);
                if (nv.value() && val instanceof String) {
                    if (val.equals("")) {
                        System.out.println("空");
                    } else {
                        System.out.println("非空");
                    }
                } else {
                    System.out.println("未检测");
                }
            }
        }
    }
}

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface NeedVal {
    boolean value() default true;
}

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface Max {
    int value() default 10;
}

class Person {
    @NeedVal
    @Max
    private String name = "";

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}