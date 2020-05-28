package behavioral.learnMemento;

/**
 * @author LiFu
 * @date 2020/5/28 上午10:46
 * @description learn Memento
 */
public class LearnMemento {
    public static void main(String[] args) {
        // 在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。

        // 标准的备忘录模式有这么几种角色：
        //     Memento：存储的内部状态；
        //     Originator：创建一个备忘录并设置其状态；
        //     Caretaker：负责保存备忘录。


    }
}

class TextEditor {
    private final StringBuilder buffer = new StringBuilder();

    public void add(char ch) {
        buffer.append(ch);
    }

    public void add(String s) {
        buffer.append(s);
    }

    public void delete() {
        if (buffer.length() > 0) {
            buffer.deleteCharAt(buffer.length() - 1);
        }
    }

    // 获取状态:
    public String getState() {
        return buffer.toString();
    }

    // 恢复状态:
    public void setState(String state) {
        this.buffer.delete(0, this.buffer.length());
        this.buffer.append(state);
    }
}
