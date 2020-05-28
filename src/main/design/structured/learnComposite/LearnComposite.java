package structured.learnComposite;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author LiFu
 * @date 2020/5/26 上午11:29
 * @description learn composite
 */
public class LearnComposite {
    public static void main(String[] args) {
        // 将对象组合成树形结构以表示“部分-整体”的层次结构，使得用户对单个对象和组合对象的使用具有一致性。
        //     使用Composite模式时，需要先统一单个节点以及“容器”节点的接口
        //     作为容器节点的ElementNode又可以添加任意个Node，这样就可以构成层级结构

        // 通过ElementNode、TextNode和CommentNode，我们就可以构造出一颗树
        Node root = new ElementNode("school");
        root.add(new ElementNode("classA")
                .add(new TextNode("Tom"))
                .add(new TextNode("Alice")));
        root.add(new ElementNode("classB")
                .add(new TextNode("Bob"))
                .add(new TextNode("Grace"))
                .add(new CommentNode("comment...")));
        System.out.println(root.toXml());
    }
}

// 抽象出节点类型Node
interface Node {
    // 添加一个节点为子节点:
    Node add(Node node);
    // 获取子节点:
    List<Node> children();
    // 输出为XML:
    String toXml();
}

// <abc>这样的节点，我们称之为ElementNode
class ElementNode implements Node {
    private final String name;
    private final List<Node> list = new ArrayList<>();

    public ElementNode(String name) {
        this.name = name;
    }

    public Node add(Node node) {
        list.add(node);
        return this;
    }

    public List<Node> children() {
        return list;
    }

    public String toXml() {
        String start = "<" + name + ">\n";
        String end = "</" + name + ">\n";
        StringJoiner sj = new StringJoiner("", start, end);
        list.forEach(node -> sj.add(node.toXml() + "\n"));
        return sj.toString();
    }
}

// 普通文本，我们把它看作TextNode
class TextNode implements Node {
    private final String text;

    public TextNode(String text) {
        this.text = text;
    }

    public Node add(Node node) {
        throw new UnsupportedOperationException();
    }

    public List<Node> children() {
        return List.of();
    }

    public String toXml() {
        return text;
    }
}

// 注释节点
class CommentNode implements Node {
    private final String text;

    public CommentNode(String text) {
        this.text = text;
    }

    public Node add(Node node) {
        throw new UnsupportedOperationException();
    }

    public List<Node> children() {
        return List.of();
    }

    public String toXml() {
        return "<!-- " + text + " -->";
    }
}
