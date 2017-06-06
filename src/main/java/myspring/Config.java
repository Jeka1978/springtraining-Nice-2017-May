package myspring;

/**
 * Created by Evegeny on 06/06/2017.
 */
public interface Config {
    <T> Class<T> getImpl(Class<T> type);
}
