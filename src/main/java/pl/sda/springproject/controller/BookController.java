package pl.sda.springproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.springproject.dto.BookDto;
import pl.sda.springproject.service.BookService;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/book/add")
    public String bookAddForm(){
        return "/book/add-book-form";
    }

    @PostMapping("/book/add")
    public String bookAdd(@ModelAttribute BookDto bookDto, Model model){
        model.addAttribute("book", bookService.add(bookDto));
        return "/book/confirm-add-book";
    }

    @GetMapping("/book/list")
    public String bookList(Model model){
        model.addAttribute("books", bookService.findAll());
        return "/book/list";
    }
}
