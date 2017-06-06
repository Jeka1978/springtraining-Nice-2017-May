package tdd;

import lombok.Setter;

/**
 * Created by Evegeny on 06/06/2017.
 */
public class TaxCalc {
    @Setter
    private MaamService maamService;



    public double withMaam(double price) {
        return maamService.getMaam()*price+price;
    }
}
