package pl.sda.springproject.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pl.sda.springproject.model.Book;

@Repository
public interface PagingBookRepository extends PagingAndSortingRepository<Book, Long> {
}
