package myJunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Evegeny on 06/06/2017.
 */
public class MyJunitRunner {
    public void runAllTestMethods(Object o) throws InvocationTargetException, IllegalAccessException {
        Class<?> clazz = o.getClass();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("test")) {
                method.invoke(o);
            }
        }
    }
}
