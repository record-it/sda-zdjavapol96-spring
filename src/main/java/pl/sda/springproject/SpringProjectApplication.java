package pl.sda.springproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.springproject.dto.BookDto;
import pl.sda.springproject.dto.CarDto;
import pl.sda.springproject.service.BookService;
import pl.sda.springproject.service.CarService;

@SpringBootApplication
public class SpringProjectApplication implements CommandLineRunner {
    private final BookService bookService;
    private final CarService carService;

    public SpringProjectApplication(BookService bookService, CarService carService) {
        this.bookService = bookService;
        this.carService = carService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        bookService.add(BookDto.builder()
                .author("Bloch")
                .title("Java")
                .build());
        bookService.add(BookDto.builder()
                .author("Freeman")
                .title("C#")
                .build());
        carService.add(CarDto.builder()
                .model("A4")
                .brand("Audi")
                .productionYear(2020)
                .build());
    }
}
