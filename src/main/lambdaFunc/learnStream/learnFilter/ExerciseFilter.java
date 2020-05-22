package learnStream.learnFilter;

import java.util.List;

/**
 * @author LiFu
 * @date 2020/5/22 下午3:15
 * @description 使用filter()过滤出成绩及格的同学，并打印出名字
 */
public class ExerciseFilter {
    public static void main(String[] args) {
        List.of(
                new Student("A", 50),
                new Student("B", 55),
                new Student("C", 60),
                new Student("D", 65),
                new Student("E", 70)
        )
                .stream()
                .filter(st -> st.getScore() >= 60)
                .forEach(st -> System.out.println(st.getName()));
    }
}

class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
