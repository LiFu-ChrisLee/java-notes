package creative.learnBuilder;

/**
 * @author LiFu
 * @date 2020/5/25 下午4:01
 * @description learn builder
 */
public class LearnBuilder {
    public static void main(String[] args) {
        // 将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。

        // 生成器模式（Builder）是使用多个“小型”工厂来最终创建出一个完整对象。

        HtmlBuilder hb = new HtmlBuilder();
        String out = hb.toHtml("# 123\n> 444\n---\naaa");
        System.out.println(out);
    }
}

class HtmlBuilder {
    private final HeadingBuilder headingBuilder = new HeadingBuilder();
    private final HrBuilder hrBuilder = new HrBuilder();
    private final ParagraphBuilder paragraphBuilder = new ParagraphBuilder();
    private final QuoteBuilder quoteBuilder = new QuoteBuilder();

    public String toHtml(String markdown) {
        StringBuilder buffer = new StringBuilder();
        markdown.lines().forEach(line -> {
            if (line.startsWith("#")) {
                buffer.append(headingBuilder.buildHeading(line)).append('\n');
            } else if (line.startsWith(">")) {
                buffer.append(quoteBuilder.buildQuote(line)).append('\n');
            } else if (line.startsWith("---")) {
                buffer.append(hrBuilder.buildHr(line)).append('\n');
            } else {
                buffer.append(paragraphBuilder.buildParagraph(line)).append('\n');
            }
        });
        return buffer.toString();
    }
}

class HeadingBuilder {
    public String buildHeading(String line) {
        int n = 0;
        while (line.charAt(0) == '#') {
            n++;
            line = line.substring(1);
        }
        return String.format("<h%d>%s</h%d>", n, line.strip(), n);
    }
}

class HrBuilder {
    public String buildHr(String line) {
        return "<hr/>";
    }
}

class ParagraphBuilder {
    public String buildParagraph(String line) {
        return String.format("<p>%s</p>", line.strip());
    }
}

class QuoteBuilder {
    public String buildQuote(String line) {
        while (line.charAt(0) == '>') {
            line = line.substring(1);
        }
        return String.format("<em>%s</em>", line.strip());
    }
}

