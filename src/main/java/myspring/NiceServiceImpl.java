package myspring;

/**
 * Created by Evegeny on 06/06/2017.
 */
public class NiceServiceImpl implements NiceService {
    @Override
    public void doWork() {
        System.out.println("working...");
    }

    @Override
    @Benchmark
    public void drinkBeer() {
        System.out.println("Leff");
    }
}
