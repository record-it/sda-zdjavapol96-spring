package pl.sda.springproject.console;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Calculator {
    private int accu = 0;
    private Random random;

    public Calculator(Random random) {
        this.random = random;
    }

    public int add(int a){
        accu += a;
        return accu;
    }

    public int mul(int a){
        accu *= a;
        return accu;
    }

    public int addRandom(int a){
        return a + random.nextInt();
    }
}
