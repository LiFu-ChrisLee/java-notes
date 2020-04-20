package base.learnArray;

/**
 * @author LiFu
 * @date 2020/4/20 下午4:14
 * @description learn array
 */
public class LearnArray {
    public static void main(String[] args) {
        // 5位同学的成绩:
        int[] ns1 = new int[5];
        System.out.println(ns1.length); // 5
//        System.out.println(ns1[5]); // 索引n不能超出范围

//        直接指定初始化的元素，这样就不必写出数组大小，而是由编译器自动推算数组大小
        // 5位同学的成绩:
        int[] ns2 = new int[] { 68, 79, 91, 85, 62 };
        System.out.println(ns2.length); // 编译器自动推算数组大小为5

//        数组是引用类型，并且数组大小不可变
        // 5位同学的成绩:
        int[] ns3;
        ns3 = new int[] { 68, 79, 91, 85, 62 };
        System.out.println(ns3.length); // 5
        ns3 = new int[] { 1, 2, 3 };
        System.out.println(ns3.length); // 3

        String[] names = {"ABC", "XYZ", "zoo"};
        String s = names[1];
        names[1] = "cat";
        System.out.println(s); // s是"XYZ"还是"cat"? "XYZ"
    }
}
