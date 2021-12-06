package pl.sda.springproject.service;

import pl.sda.springproject.dto.BookDto;
import pl.sda.springproject.model.Book;

import java.util.List;

public interface BookService {
    Book add(BookDto newBook);
    List<Book> findAll();
    void rateBook(long bookId, int rating);
}
