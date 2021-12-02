package pl.sda.springproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.springproject.model.Book;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    private List<Book> books = new ArrayList<>(List.of(
            Book.builder()
                    .title("Java")
                    .author("Bloch")
                    .id(1L)
                    .rating(3)
                    .build(),
            Book.builder()
                    .title("C#")
                    .author("Freeman")
                    .id(2L)
                    .rating(5)
                    .build()
    ));
    long index = 2;

    @GetMapping("/book/add")
    public String bookAddForm(){
        return "/book/add-book-form";
    }

    @PostMapping("/book/add")
    public String bookAdd(@ModelAttribute Book book, Model model){
        book.setId(++index);
        book.setRating(0);
        books.add(book);
        model.addAttribute("book", book);
        return "/book/confirm-add-book";
    }

    @GetMapping("/book/list")
    public String bookList(Model model){
        model.addAttribute("books", books);
        return "/book/list";
    }
}
