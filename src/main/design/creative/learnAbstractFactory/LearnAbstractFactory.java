package creative.learnAbstractFactory;

import java.io.IOException;
import java.nio.file.Path;

/**
 * @author LiFu
 * @date 2020/5/25 下午3:03
 * @description learn AbstractFactory
 */
public class LearnAbstractFactory {
    public static void main(String[] args) throws Exception {
        // 提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。

        AbstractFactory af = AbstractFactory.getInstance("fast");

        HtmlDocument hd = af.createHtml("");
        hd.save(Path.of(""));

        WordDocument wd = af.createWord("");
        wd.save(Path.of(""));
    }
}

interface AbstractFactory {
    static AbstractFactory getInstance(String name) {
        if (name.equalsIgnoreCase("fast")) {
            return new FastFactory();
        } else if (name.equalsIgnoreCase("good")) {
            return new GoodFactory();
        } else {
            throw new IllegalArgumentException("Invalid factory name");
        }
    }

    // 创建Html文档:
    HtmlDocument createHtml(String md);
    // 创建Word文档:
    WordDocument createWord(String md);
}

interface HtmlDocument {
    String toHtml();
    void save(Path path) throws IOException;
}

interface WordDocument {
    void save(Path path) throws IOException;
}
