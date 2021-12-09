package pl.sda.springproject.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import pl.sda.springproject.dto.BookDto;
import pl.sda.springproject.model.Book;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service("MemoryBookService")
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

    @Override
    public void deleteById(long id) {
        books.remove(id);
    }

    @Override
    public Book update(Book ebook){
        books.remove(ebook.getId());
        books.put(ebook.getId(), ebook);
        return ebook;
    }

    @Override
    public Book updateTitle(long id, String newTitle){
        books.get(id).setTitle(newTitle);
        return books.get(id);
    }

    @Override
    public Book updateAuthor(long id, String newAuthor){
        books.get(id).setAuthor(newAuthor);
        return books.get(id);
    }

    @Override
    public List<Book> ranking() {
        throw new UnsupportedOperationException("Zaimplementuj!!");
    }

    @Override
    public void rateBook(long id) {
        throw new UnsupportedOperationException("Zaimplementuj!!");
    }

    @Override
    public Page<Book> findPage(int page, int size) {
        throw new UnsupportedOperationException();
    }


}
