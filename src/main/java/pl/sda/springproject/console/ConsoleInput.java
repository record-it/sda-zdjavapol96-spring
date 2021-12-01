package pl.sda.springproject.console;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleInput {
    private final Scanner scanner = new Scanner(System.in);

    public Scanner getScanner(){
        return scanner;
    }

    public String getName(){
        return scanner.nextLine();
    }
}
