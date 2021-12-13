package pl.sda.springproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.springproject.dto.BookDto;
import pl.sda.springproject.dto.CarDto;
import pl.sda.springproject.model.Author;
import pl.sda.springproject.model.Ebook;
import pl.sda.springproject.model.Tag;
import pl.sda.springproject.repository.BookRepository;
import pl.sda.springproject.service.BookService;
import pl.sda.springproject.service.CarService;
import pl.sda.springproject.service.EbookService;
import pl.sda.springproject.service.JpaBookService;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringProjectApplication implements CommandLineRunner {
    private BookService bookService;
    private final CarService carService;
    private final EbookService ebookService;
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    public SpringProjectApplication(CarService carService, EbookService ebookService, JpaBookService bookService) {
        this.bookService = bookService;
        this.carService = carService;
        this.ebookService = ebookService;
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
        bookService.add(BookDto.builder()
                .author("Freeman")
                .title("ASP.NET")
                .build());
        bookService.add(BookDto.builder()
                .author("Bloch")
                .title("Effective Java")
                .build());
        carService.add(CarDto.builder()
                .model("A4")
                .brand("Audi")
                .productionYear(2020)
                .build());
        ebookService.add(
                Ebook.builder()
                        .authors(
                                new HashSet<>(Set.of(
                                Author.builder()
                                        .id(2)
                                        .name("Bloch")
                                        .birthDate(LocalDate.of(1998, 10, 10))
                                        .build()
                                )
                        ))
                        .tags(
                                new HashSet<>(
                                        Set.of(
                                                Tag.builder()
                                                        .label("Java")
                                                        .build(),
                                                Tag.builder()
                                                        .label("Programming")
                                                        .build(),
                                                Tag.builder()
                                                        .label("Training")
                                                        .build()
                                        )
                                )
                        )
                        .title("Java")
                        .format("pdf")
                        .build()
        );

        System.out.println(bookRepository.countByAuthor("Bloch"));
        System.out.println(bookRepository.findBooksByAuthor("Bloch"));
        System.out.println(bookRepository.findBooksByTitleContains("Ja"));
    }
}
