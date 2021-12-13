package pl.sda.springproject.service;

import org.springframework.stereotype.Service;
import pl.sda.springproject.model.Author;
import pl.sda.springproject.model.Ebook;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MemoryEbookService implements EbookService{

    private Map<Long, Ebook> ebooks = new HashMap<>();
    private AtomicLong index = new AtomicLong(0);

    @Override
    public Optional<Ebook> findBydId(long id) {
        return Optional.ofNullable(ebooks.get(id));
    }

    @Override
    public List<Ebook> findAll() {
        return new ArrayList<>(ebooks.values());
    }

    @Override
    public void delete(long id) {
        ebooks.remove(id);
    }

    @Override
    public Ebook add(Ebook ebook){
        ebook.setId(index.incrementAndGet());
        ebooks.put(ebook.getId(), ebook);
        return  ebook;
    }

    @Override
    public Optional<Author> findAuthorById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Ebook> findEbooksByTag(String tag) {
        return Collections.emptyList();
    }
}
