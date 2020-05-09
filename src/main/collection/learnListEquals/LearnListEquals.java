package learnListEquals;

import java.util.List;
import java.util.Objects;

/**
 * @author LiFu
 * @date 2020/5/7 上午11:31
 * @description learn equals
 */
public class LearnListEquals {
    public static void main(String[] args) {
//        equals()方法要求我们必须满足以下条件：
        //        自反性（Reflexive）：对于非null的x来说，x.equals(x)必须返回true；
        //        对称性（Symmetric）：对于非null的x和y来说，如果x.equals(y)为true，则y.equals(x)也必须为true；
        //        传递性（Transitive）：对于非null的x、y和z来说，如果x.equals(y)为true，y.equals(z)也为true，那么x.equals(z)也必须为true；
        //        一致性（Consistent）：对于非null的x和y来说，只要x和y状态不变，则x.equals(y)总是一致地返回true或者false；
        //        对null的比较：即x.equals(null)永远返回false。

//        正确编写方法：
        //        先确定实例“相等”的逻辑，即哪些字段相等，就认为实例相等；
        //        用instanceof判断传入的待比较的Object是不是当前类型，如果是，继续比较，否则，返回false；
        //        对引用类型用Objects.equals()比较，对基本类型直接用==比较。

        List<Person> list = List.of(
                new Person("X", "Ming", 18),
                new Person("X", "Hong", 25),
                new Person("Bob", "Smith", 20)
        );
        // 在List中查找元素时，List的实现类通过元素的equals()方法比较两个元素是否相等
        boolean exist = list.contains(new Person("Bob", "Smith", 20));
        System.out.println(exist ? "测试成功!" : "测试失败!");
    }
}

class Person {
    String firstName;
    String lastName;
    int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        boolean bl = false;
        if (obj instanceof Person) {
            Person ps = (Person) obj;
            bl = Objects.equals(this.firstName, ps.firstName) && Objects.equals(this.lastName, ps.lastName) && this.age == ps.age;
        }
        return bl;
    }
}
