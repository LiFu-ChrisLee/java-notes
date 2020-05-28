package behavioral.learnCommand;

/**
 * @author LiFu
 * @date 2020/5/27 下午5:44
 * @description learn order
 */
public class LearnCommand {
    public static void main(String[] args) {
        // 将一个请求封装为一个对象，从而使你可用不同的请求对客户进行参数化，对请求排队或记录请求日志，以及支持可撤销的操作。
        // 它减少的是系统各组件的耦合度

        TextEditor editor = new TextEditor();
        editor.add("Command pattern in text editor.\n");
        // 执行一个CopyCommand:
        Command copy = new CopyCommand(editor);
        copy.execute();
        editor.add("----\n");
        // 执行一个PasteCommand:
        Command paste = new PasteCommand(editor);
        paste.execute();
        System.out.println(editor.getState());
    }
}

// 命令模式，把调用方发送命令和执行方执行命令分开
interface Command {
    void execute();
}

// 执行方
class TextEditor {
    private final StringBuilder buffer = new StringBuilder();

    public void copy() {}

    public void paste() {
        String text = "pasted text";
        add(text);
    }

    public void add(String s) {
        this.buffer.append(s);
    }

    public void delete() {
        if (this.buffer.length() > 0) {
            this.buffer.deleteCharAt(this.buffer.length() - 1);
        }
    }

    public String getState() {
        return this.buffer.toString();
    }
}

// 调用方
class CopyCommand implements Command {
    // 持有执行者对象:
    private final TextEditor receiver;

    public CopyCommand(TextEditor receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        this.receiver.copy();
    }
}

// 调用方
class PasteCommand implements Command {
    private final TextEditor receiver;

    public PasteCommand(TextEditor receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        this.receiver.paste();
    }
}