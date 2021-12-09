package pl.sda.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.sda.springproject.model.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBooksByAuthor(String author);
    int countByAuthor(String author);
    List<Book> findBooksByTitleContains(String title);

    @Query(value = "select b from Book b order by b.rating desc", nativeQuery = false)
    List<Book> findBooksRanking();
}
