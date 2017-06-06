package myspring;

/**
 * Created by Evegeny on 06/06/2017.
 */
public interface ProxyConfigurer {
    <T> T wrapWithProxy(T t, Class<T> type);
}
