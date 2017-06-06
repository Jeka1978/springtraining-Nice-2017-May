package myspring;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.util.Set;

/**
 * Created by Evegeny on 06/06/2017.
 */
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private Reflections scanner = new Reflections("myspring");

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    private ObjectFactory() {
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        if (type.isInterface()) {
            Class<T> impl = config.getImpl(type);
            if (impl == null) {
                Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
                if (classes.size() != 1) {
                    throw new RuntimeException(type + " has 0 or more than one impl. Please write needed impl in your config");
                }
                impl = (Class<T>) classes.iterator().next();
            }
            type = impl;
        }
        T t = type.newInstance();

        return t;


    }



















}
