package pl.sda.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.springproject.model.Ebook;
import pl.sda.springproject.model.Tag;
import java.util.List;
import java.util.Set;

@Repository
public interface EbookRepository extends JpaRepository<Ebook, Long> {
    //zdefiniuj metodę zwracającą listę Ebook z podanym tagiem
    List<Ebook> findEbooksByTagsContains(Tag tag);
}
