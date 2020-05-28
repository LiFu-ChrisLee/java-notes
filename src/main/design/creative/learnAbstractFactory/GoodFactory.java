package creative.learnAbstractFactory;

import java.io.IOException;
import java.nio.file.Path;

/**
 * @author LiFu
 * @date 2020/5/25 下午3:43
 * @description good doc
 */
public class GoodFactory implements AbstractFactory {
    @Override
    public HtmlDocument createHtml(String md) {
        return new GoodHtmlDocument(md);
    }

    @Override
    public WordDocument createWord(String md) {
        return new GoodWordDocument(md);
    }
}

class GoodHtmlDocument implements HtmlDocument {
    private final String md;

    public GoodHtmlDocument(String md) {
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

class GoodWordDocument implements WordDocument {
    private final String md;

    public GoodWordDocument(String md) {
        this.md = md;
    }

    @Override
    public void save(Path path) {
        System.out.println(md);
    }
}
