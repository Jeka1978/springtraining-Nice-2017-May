package myspring;

import lombok.Data;

import java.util.Random;

/**
 * Created by Evegeny on 06/06/2017.
 */
@Data
public class Elf {
    @InjectRandomInt(min = 10, max = 20)
    private int power;
    @InjectRandomInt(min = 70, max = 90)
    private int accuracy;

    public static void main(String[] args) {
        Elf elf = new Elf();
        System.out.println("elf = " + elf);
    }

}
