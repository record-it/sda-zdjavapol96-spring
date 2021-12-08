package pl.sda.springproject.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.sda.springproject.dto.BookDto;
import pl.sda.springproject.model.Book;
import pl.sda.springproject.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service(value = "JpaBookService")
@Primary
public class JpaBookService implements BookService{

    private final BookRepository bookRepository;

    public JpaBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book add(BookDto newBook) {
        final Book book = Book.builder()
                .author(newBook.getAuthor())
                .title(newBook.getTitle())
                .rating(0)
                .build();
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void rateBook(long bookId, int rating) {

    }

    @Override
    public Optional<Book> findById(long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateTitle(long id, String newTitle) {
        return null;
    }

    @Override
    public Book updateAuthor(long id, String newAuthor) {
        return null;
    }
}
