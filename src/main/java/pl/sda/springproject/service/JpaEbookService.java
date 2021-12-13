package pl.sda.springproject.service;

import org.springframework.transaction.annotation.Transactional;
import pl.sda.springproject.model.Author;
import pl.sda.springproject.model.Ebook;
import pl.sda.springproject.repository.AuthorRepository;
import pl.sda.springproject.repository.EbookRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class JpaEbookService implements EbookService{
    private final EbookRepository ebooks;
    private final AuthorRepository authors;

    public JpaEbookService(EbookRepository ebooks, AuthorRepository authors) {
        this.ebooks = ebooks;
        this.authors = authors;
    }

    @Override
    public Optional<Ebook> findBydId(long id) {
        return ebooks.findById(id);
    }

    @Override
    public List<Ebook> findAll() {
        return ebooks.findAll();
    }

    @Override
    public void delete(long id) {
        ebooks.deleteById(id);
    }

    @Override
    @Transactional
    public Ebook add(Ebook ebook) {
        Set<Author> ebookAuthors = ebook.getAuthors().stream()
                .map(author -> {
                    final Optional<Author> oa = authors.findAuthorByName(author.getName());
                    if (oa.isPresent()){
                        return oa.get();
                    } else {
                        return authors.save(author);
                    }
                })
                .collect(Collectors.toSet());
        ebook.setAuthors(ebookAuthors);
        return ebooks.save(ebook);
    }

    @Override
    public Optional<Author> findAuthorById(long id){
        return authors.findById(id);
    }
}
