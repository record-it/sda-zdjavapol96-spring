package pl.sda.springproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.springproject.dto.BookDto;
import pl.sda.springproject.model.Book;
import pl.sda.springproject.service.BookService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable long id){
         return ResponseEntity.of(bookService.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<Book> add(@RequestBody BookDto dto){
        final Book book = bookService.add(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(book);
    }

    @PostMapping("/onlyId")
    public ResponseEntity<Map<String, Object>> addBook(@RequestBody BookDto bookDto){
        final Book book = bookService.add(bookDto);
        Map<String, Object> response = new HashMap<>();
        response.put("id", book.getId());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        bookService.deleteById(id);
    }


    @PutMapping("")
    public ResponseEntity<Book> updateEntity(@RequestBody Book book){
        return ResponseEntity.ok(bookService.update(book));
    }
}
