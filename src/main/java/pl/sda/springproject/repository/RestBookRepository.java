package pl.sda.springproject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import pl.sda.springproject.model.Book;

@RepositoryRestResource(path = "books", collectionResourceRel = "books")
public interface RestBookRepository extends PagingAndSortingRepository<Book, Long> {
    @RestResource(path = "title")
    Page<Book> findBooksByTitleContains(@Param("pattern") String title, Pageable p);
}
