package creative.learnAbstractFactory;

import java.io.IOException;
import java.nio.file.Path;

/**
 * @author LiFu
 * @date 2020/5/25 下午3:43
 * @description fast doc
 */
public class FastFactory implements AbstractFactory {

    @Override
    public HtmlDocument createHtml(String md) {
        return new FastHtmlDocument(md);
    }

    @Override
    public WordDocument createWord(String md) {
        return new FastWordDocument(md);
    }
}

class FastHtmlDocument implements HtmlDocument {
    private final String md;

    public FastHtmlDocument(String md) {
        this.md = md;
    }

    @Override
    public String toHtml() {
        System.out.println(md);
        return null;
    }

    @Override
    public void save(Path path) {

    }
}

class FastWordDocument implements WordDocument {
    private final String md;

    public FastWordDocument(String md) {
        this.md = md;
    }

    @Override
    public void save(Path path) {
        System.out.println(md);
    }
}