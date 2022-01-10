package pl.sda.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.springproject.model.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    
}
