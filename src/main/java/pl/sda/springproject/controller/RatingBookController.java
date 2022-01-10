package pl.sda.springproject.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.springproject.model.UserApp;
import pl.sda.springproject.service.BookService;

@Controller
public class RatingBookController {
    private final BookService bookService;

    public RatingBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book/ranking")
    public String rankingList(Model model){
        model.addAttribute("books", bookService.findAll());
        return "/book/ranking-list";
    }

    @GetMapping("/book/vote")
    public String voteList(Model model){
        model.addAttribute("books", bookService.findAll());
        return "/book/vote-list";
    }

    @PostMapping("/book/vote")
    public String vote(@RequestParam long id, Model model, @AuthenticationPrincipal UserApp user){
        bookService.rateBook(id, user.getId(),1);
//        model.addAttribute("bookId", id);
//        model.addAttribute("books", bookService.findAll());
        System.out.println(user.getEmail());
        return "redirect:/book/ranking";
    }
}
