package myJunit;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Evegeny on 06/06/2017.
 */
public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        MyJunitRunner runner = new MyJunitRunner();
        MyTestClass testObj = new MyTestClass();
        runner.runAllTestMethods(testObj);
    }
}
