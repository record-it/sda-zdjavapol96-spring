package pl.sda.springproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.springproject.dto.BookDto;
import pl.sda.springproject.service.BookService;

@SpringBootApplication
public class SpringProjectApplication implements CommandLineRunner {
    private final BookService bookService;

    public SpringProjectApplication(BookService bookService) {
        this.bookService = bookService;
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
    }
}
