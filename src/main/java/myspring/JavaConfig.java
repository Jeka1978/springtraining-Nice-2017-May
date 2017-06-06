package myspring;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Evegeny on 06/06/2017.
 */
public class JavaConfig implements Config {
    private Map<Class,Class> map = new HashMap<>();

    public JavaConfig() {
        map.put(Speaker.class, PopupSpeaker.class);

    }

    public <T> Class<T> getImpl(Class<T> type) {
        return map.get(type);
    }
}
