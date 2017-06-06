package myspring;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import javax.annotation.PostConstruct;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Evegeny on 06/06/2017.
 */
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private Reflections scanner = new Reflections("myspring");

    private List<ObjectConfigurer> objectConfigurers = new ArrayList<>();
    private List<ProxyConfigurer> proxyConfigurers = new ArrayList<>();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    private ObjectFactory() {
        Set<Class<? extends ObjectConfigurer>> classes = scanner.getSubTypesOf(ObjectConfigurer.class);
        for (Class<? extends ObjectConfigurer> configurerClass : classes) {
            if (!Modifier.isAbstract(configurerClass.getModifiers())) {
                objectConfigurers.add(configurerClass.newInstance());
            }
        }
        Set<Class<? extends ProxyConfigurer>> subTypesOf = scanner.getSubTypesOf(ProxyConfigurer.class);
        for (Class<? extends ProxyConfigurer> proxyConfClass : subTypesOf) {
            if (!Modifier.isAbstract(proxyConfClass.getModifiers())) {
                proxyConfigurers.add(proxyConfClass.newInstance());
            }
        }
    }



    @SneakyThrows
    public <T> T createObject(Class<T> type) throws IllegalAccessException, InstantiationException {
        type = resolveImpl(type);
        T t = type.newInstance();
        configure(t);
        runInitMethods(type, t);
        t = proxyIt(type, t);

        return t;


    }

    private <T> T proxyIt(Class<T> type, T t) {
        for (ProxyConfigurer proxyConfigurer : proxyConfigurers) {
            t = proxyConfigurer.wrapWithProxy(t, type);
        }
        return t;
    }

    private <T> void runInitMethods(Class<T> type, T t) throws IllegalAccessException, InvocationTargetException {
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(t);
            }
        }
    }


    private <T> void configure(T t) {
        for (ObjectConfigurer objectConfigurer : objectConfigurers) {
            objectConfigurer.configure(t);
        }
    }

    private <T> Class<T> resolveImpl(Class<T> type) {
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
        return type;
    }


}
