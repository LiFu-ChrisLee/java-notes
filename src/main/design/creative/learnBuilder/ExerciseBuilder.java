package creative.learnBuilder;

import java.lang.reflect.Constructor;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * @author LiFu
 * @date 2020/5/25 下午4:48
 * @description 使用Builder模式实现一个URLBuilder
 */
public class ExerciseBuilder {
    public static void main(String[] args) {
        String url = URLBuilder.builder() // 创建Builder
                .setDomain("www.example.com") // 设置domain
                .setScheme("https") // 设置scheme
                .setPath("/") // 设置路径
                .setQuery(Map.of("a", "123", "q", "K&R")) // 设置query
                .build(); // 完成build
        System.out.println(url);
    }
}

class URLBuilder {
    private String domain = "";
    private String scheme = "";
    private String path = "";
    private String queryString = "";
    private final QueryBuilder qb = new QueryBuilder();

    static URLBuilder builder() {
        return new URLBuilder();
    }

    private URLBuilder() {
    }

    public URLBuilder setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public URLBuilder setScheme(String scheme) {
        this.scheme = scheme;
        return this;
    }

    public URLBuilder setPath(String path) {
        this.path = path;
        return this;
    }

    public URLBuilder setQuery(Map<String, String> queryMap) {
        this.queryString = qb.buildQueryString(queryMap);
        return this;
    }

    public String build() {
        return scheme + "://" + domain + path + "?" + queryString;
    }
}

class QueryBuilder {
    public String buildQueryString(Map<String, String> queryMap) {
        StringJoiner querySJ = new StringJoiner("&");
        queryMap.forEach((k, v) -> querySJ.add(String.format("%s=%s", k, v)));
        return querySJ.toString();
    }
}
