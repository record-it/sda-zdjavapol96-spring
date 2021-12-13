package pl.sda.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.springproject.model.Ebook;

@Repository
public interface EbookRepository extends JpaRepository<Ebook, Long> {
}
