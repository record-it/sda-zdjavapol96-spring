package pl.sda.springproject.console;

import org.springframework.stereotype.Component;

@Component
public class ConsoleOutput {
    private final Calculator calculator;

    public ConsoleOutput(Calculator calculator) {
        this.calculator = calculator;
    }

    public void print(String name){
        System.out.println("Hello " + name);
    }

    public Calculator getCalculator() {
        return calculator;
    }
}
