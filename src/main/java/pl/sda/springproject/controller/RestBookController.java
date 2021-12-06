package pl.sda.springproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.springproject.model.Book;
import pl.sda.springproject.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class RestBookController {
    private  final BookService bookService;

    public RestBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public List<Book> allBooks(){
        return bookService.findAll();
    }
}
