package pl.sda.springproject.service;

import pl.sda.springproject.model.Ebook;

import java.util.List;
import java.util.Optional;

public interface EbookService {
    Optional<Ebook> findBydId(long id);
    List<Ebook> findAll();
    void delete(long id);
    Ebook add(Ebook ebook);
}
