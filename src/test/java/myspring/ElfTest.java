package myspring;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Evegeny on 06/06/2017.
 */
public class ElfTest {
    @Test
    public void main() throws Exception {
        Elf elf = ObjectFactory.getInstance().createObject(Elf.class);
        Assert.assertTrue(elf.getPower()>10&&elf.getPower()<20);
    }

}