package myspring;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Evegeny on 06/06/2017.
 */
public class BenchmarkProxyConfigurer implements ProxyConfigurer, BeanPostProcessor {
    private BenchmarkFlag benchmarkFlag = new BenchmarkFlag();

    @SneakyThrows
    public BenchmarkProxyConfigurer() {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        mBeanServer.registerMBean(benchmarkFlag, new ObjectName("NICE MBEANS", "name", "bechmark"));
    }

    @Override
    public Object wrapWithProxy(Object t, Class type) {
        boolean isMethodWantBenchmark = false;
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Benchmark.class)) {
                isMethodWantBenchmark = true;
                break;
            }
        }

        if (type.isAnnotationPresent(Benchmark.class) || isMethodWantBenchmark) {
            return Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), (proxy, method, args) -> {
                Method originalMethod = type.getMethod(method.getName(), method.getParameterTypes());
                if (benchmarkFlag.isEnabled() && (type.isAnnotationPresent(Benchmark.class) || originalMethod.isAnnotationPresent(Benchmark.class))) {
                    System.out.println("********BENCHMARK of " + method.getName() + " was started *********");
                    long start = System.nanoTime();
                    Object retVal = method.invoke(t, args);
                    long end = System.nanoTime();
                    System.out.println(end - start);
                    System.out.println("********BENCHMARK of " + method.getName() + " was finished *********");
                    return retVal;
                } else {
                    return method.invoke(t, args);
                }
            });
        } else {
            return t;
        }
    }


    private Map<String, Class> map = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        map.put(beanName, beanClass);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return wrapWithProxy(bean,map.get(beanName));
    }
}
