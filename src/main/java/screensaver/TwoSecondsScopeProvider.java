package screensaver;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by Evegeny on 19/06/2017.
 */
public class TwoSecondsScopeProvider implements Scope {

    private Cache<String, Object> cache = CacheBuilder.newBuilder()
            .expireAfterWrite(2, TimeUnit.SECONDS).build();


    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object bean = cache.getIfPresent(name);
        if (bean == null) {
            bean = objectFactory.getObject();
            cache.put(name,bean);
        }
        return bean;
    }


    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
