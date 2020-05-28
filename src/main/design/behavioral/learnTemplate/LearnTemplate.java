package behavioral.learnTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author LiFu
 * @date 2020/5/28 下午3:58
 * @description learn Template
 */
public class LearnTemplate {
    public static void main(String[] args) {
        // 定义一个操作中的算法的骨架，而将一些步骤延迟到子类中，使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
        // 主要思想是，定义一个操作的一系列步骤，对于某些暂时确定不下来的步骤，就留给子类去实现好了，这样不同的子类就可以定义出不同的步骤。

        AbstractSetting setting1 = new LocalSetting();
        System.out.println("test = " + setting1.getSetting("test"));
        System.out.println("test = " + setting1.getSetting("test"));

        AbstractSetting setting2 = new TreeMapSetting();
        System.out.println("autosave = " + setting2.getSetting("autosave"));
        System.out.println("autosave = " + setting2.getSetting("autosave"));
    }
}

// 骨架
// 从数据库读取设置的类
// 怎么实现缓存，暂时没想好，但不妨碍我们先写出使用缓存的代码
abstract class AbstractSetting {
    // 使用 final 保护骨架方法，防止子类复写
    public final String getSetting(String key) {
        // 先从缓存读取:
        String value = lookupCache(key);
        if (value == null) {
            // 在缓存中未找到,从数据库读取:
            value = readFromDatabase(key);
            System.out.println("[DEBUG] load from db: " + key + " = " + value);
            // 放入缓存:
            putIntoCache(key, value);
        } else {
            System.out.println("[DEBUG] load from cache: " + key + " = " + value);
        }
        return value;
    }

    private String readFromDatabase(String key) {
        return "读取 " + key;
    }

    abstract protected String lookupCache(String key);

    abstract protected void putIntoCache(String key, String value);
}

// 用一个Map做缓存，那么可以写一个LocalSetting
class LocalSetting extends AbstractSetting {
    private final Map<String, String> cache = new HashMap<>();

    protected String lookupCache(String key) {
        return cache.get(key);
    }

    protected void putIntoCache(String key, String value) {
        cache.put(key, value);
    }
}

// 使用TreeMap做缓存，那么可以再写一个TreeMapSetting
class TreeMapSetting extends AbstractSetting {
    private final Map<String, String> cache = new TreeMap<>();

    protected String lookupCache(String key) {
        return cache.get(key);
    }

    protected void putIntoCache(String key, String value) {
        cache.put(key, value);
    }
}
