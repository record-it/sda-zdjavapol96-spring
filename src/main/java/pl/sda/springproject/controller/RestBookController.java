package pl.sda.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import pl.sda.springproject.dto.BookDto;
import pl.sda.springproject.model.Book;
import pl.sda.springproject.model.UserApp;
import pl.sda.springproject.service.BookService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/books")
public class RestBookController {

    @Qualifier("JpaBookService")
    @Autowired
    private BookService bookService;


    @GetMapping("")
    public Page<Book> allBooks(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "2") int size){
        return bookService.findPage(page, size);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable long id){
         return ResponseEntity.of(bookService.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<Book> add(@Valid @RequestBody BookDto dto){
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
        //TODO do p????niejszej poprawy, przenie???? do serwisu!!!
        if (bookService.findById(book.getId()).isPresent()){
            return ResponseEntity.ok(bookService.update(book));//edycja istniej??cej ksi????ki
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(bookService.update(book)); //dodanie nowej ksi????ki
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Book> updateProperty(@RequestBody BookDto newValues,
                                               @PathVariable long id){
        //TODO przenie???? do serwisu
        if (newValues.getAuthor() != null){
            return ResponseEntity.ok(bookService.updateAuthor(id, newValues.getAuthor()));
        }
        if (newValues.getTitle() != null){
            return ResponseEntity.ok(bookService.updateTitle(id, newValues.getTitle()));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/ranking")
    public List<Book> ranking(){
        return bookService.ranking();
    }

    @PostMapping("/{id}/rating")
    public void rateBook(@PathVariable long id, @AuthenticationPrincipal UserApp user){
        bookService.rateBook(id, user.getId(), 1);
        System.out.println(user.getEmail());
    }
}
