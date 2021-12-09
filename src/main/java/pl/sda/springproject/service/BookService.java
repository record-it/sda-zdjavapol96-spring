package pl.sda.springproject.service;

import pl.sda.springproject.dto.BookDto;
import pl.sda.springproject.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book add(BookDto newBook);
    List<Book> findAll();
    void rateBook(long bookId, int rating);
    Optional<Book> findById(long id);
    void deleteById(long id);

    Book update(Book ebook);

    Book updateTitle(long id, String newTitle);

    Book updateAuthor(long id, String newAuthor);

    List<Book> ranking();

    void rateBook(long id);
}
