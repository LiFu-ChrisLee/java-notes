package structured.learnDecorator;

/**
 * @author LiFu
 * @date 2020/5/27 上午11:08
 * @description learn decorator
 */
public class LearnDecorator {
    public static void main(String[] args) {
        // 动态地给一个对象添加一些额外的职责。就增加功能来说，相比生成子类更为灵活。
        // 如果我们要新增核心功能，就增加Component的子类，例如ByteInputStream。如果我们要增加附加功能，就增加Decorator的子类，例如CipherInputStream。

        TextNode n1 = new SpanNode();
        TextNode n2 = new BoldDecorator(new UnderlineDecorator(new SpanNode()));
        TextNode n3 = new ItalicDecorator(new BoldDecorator(new DivNode()));
        n1.setText("Hello");
        n2.setText("Decorated");
        n3.setText("World");
        System.out.println(n1.getText()); // 输出<span>Hello</span>

        System.out.println(n2.getText()); // 输出<b><u><span>Decorated</span></u></b>

        System.out.println(n3.getText()); // 输出<i><b><div>World</div></b></i>
    }
}

// 顶层接口
interface TextNode {
    // 设置text:
    void setText(String text);
    // 获取text:
    String getText();
}

// 核心功能，直接继承顶层接口
// 核心节点
class SpanNode implements TextNode {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return "<span>" + text + "</span>";
    }
}

// 核心节点
class DivNode implements TextNode {
    private String text;

    @Override
    public String getText() {
        return "<div>" + text + "</div>";
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }
}

// 附加功能，使用Decorator
// 为了实现Decorator模式，需要有一个抽象的Decorator类
// NodeDecorator类的核心是持有一个TextNode，即将要把功能附加到的TextNode实例
abstract class NodeDecorator implements TextNode {
    protected final TextNode target;

    protected NodeDecorator(TextNode target) {
        this.target = target;
    }

    public void setText(String text) {
        this.target.setText(text);
    }
}

// 加粗功能
class BoldDecorator extends NodeDecorator {
    public BoldDecorator(TextNode target) {
        super(target);
    }

    public String getText() {
        return "<b>" + this.target.getText() + "</b>";
    }
}

// 下划线功能
class UnderlineDecorator extends NodeDecorator {
    public UnderlineDecorator(TextNode target) {
        super(target);
    }

    @Override
    public String getText() {
        return "<u>" + this.target.getText() + "</u>";
    }
}

// 斜体功能
class ItalicDecorator extends NodeDecorator {
    public ItalicDecorator(TextNode target) {
        super(target);
    }

    @Override
    public String getText() {
        return "<i>" + this.target.getText() + "</i>";
    }
}
