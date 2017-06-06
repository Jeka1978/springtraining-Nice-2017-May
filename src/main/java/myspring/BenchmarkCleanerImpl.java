package myspring;

/**
 * Created by Evegeny on 06/06/2017.
 */
public class BenchmarkCleanerImpl implements Cleaner {
    @InjectByFieldType
    private CleanerImpl cleaner;
    @Override
    public void clean() {
        long start = System.nanoTime();
        cleaner.clean();
        long end = System.nanoTime();
        System.out.println(end-start);
    }
}
