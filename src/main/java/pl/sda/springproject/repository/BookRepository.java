package pl.sda.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.springproject.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
