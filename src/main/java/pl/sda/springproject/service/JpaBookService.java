package pl.sda.springproject.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
        //TODO zadanie domowe
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

    @Override
    public List<Book> ranking(){
        return bookRepository.findBooksRanking();
    }

    @Override
    @Transactional
    public void rateBook(long id){
        final Optional<Book> opBook = bookRepository.findById(id);
        if (opBook.isPresent()){
            Book book = opBook.get();
            int rating = book.getRating();
            rating++;
            book.setRating(rating);
            bookRepository.save(book);
        }
    }
}
