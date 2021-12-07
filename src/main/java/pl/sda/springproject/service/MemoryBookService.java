package pl.sda.springproject.service;

import org.springframework.stereotype.Service;
import pl.sda.springproject.dto.BookDto;
import pl.sda.springproject.model.Book;
import pl.sda.springproject.service.BookService;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class MemoryBookService implements BookService {

    private Map<Long, Book> books = new HashMap<>();
    private AtomicLong index = new AtomicLong(0);

    @Override
    public Book add(BookDto newBook) {
        final Book book = Book.builder()
                .author(newBook.getAuthor())
                .title(newBook.getTitle())
                .id(index.incrementAndGet())
                .rating(0)
                .build();
        books.put(book.getId(), book);
        return book;
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books.values())
                .stream()
                .sorted((book1, book2) -> Integer.compare(book2.getRating(), book1.getRating()))
                .collect(Collectors.toList());

    }

    @Override
    public void rateBook(long bookId, int rating) {
        Book book = books.get(bookId);
        if (book != null){
            book.setRating(book.getRating() + rating);
        }
    }

    @Override
    public Optional<Book> findById(long id) {
        return Optional.ofNullable(books.get(id));
    }
}
