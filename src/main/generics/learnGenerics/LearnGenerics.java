package learnGenerics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiFu
 * @date 2020/4/30 上午11:34
 * @description learn generics
 */
public class LearnGenerics {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(1);
        System.out.println(al.get(0));
        List<Integer> list = (List<Integer>) al;
        // ArrayList<Integer>和ArrayList<Number>两者完全没有继承关系
        // ArrayList<Number> list = (ArrayList<Number>) al;
        al = null;
        System.out.println(list);
    }
}
