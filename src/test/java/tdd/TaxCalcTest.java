package tdd;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * Created by Evegeny on 06/06/2017.
 */
public class TaxCalcTest {
    @Test
    public void withMaam() throws Exception {
        TaxCalc taxCalc = new TaxCalc();
        MaamService mock = Mockito.mock(MaamService.class);
        Mockito.when(mock.getMaam()).thenReturn(0.20);
        taxCalc.setMaamService(mock);

        double withMaam = taxCalc.withMaam(100);
        Assert.assertEquals(120,withMaam,0.0001);

    }

}