package pl.sda.springproject.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.springproject.model.Author;
import pl.sda.springproject.model.Ebook;
import pl.sda.springproject.model.Tag;
import pl.sda.springproject.repository.AuthorRepository;
import pl.sda.springproject.repository.EbookRepository;
import pl.sda.springproject.repository.TagRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Primary
public class JpaEbookService implements EbookService{
    private final EbookRepository ebooks;
    private final AuthorRepository authors;
    private final TagRepository tags;

    public JpaEbookService(EbookRepository ebooks, AuthorRepository authors, TagRepository tags) {
        this.ebooks = ebooks;
        this.authors = authors;
        this.tags = tags;
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

    @Override
    public List<Ebook> findEbooksByTag(String tag){
        final Optional<Tag> optionalTag = tags.findTagByLabel(tag);
        if (optionalTag.isPresent()) {
            return ebooks.findEbooksByTagsContains(optionalTag.get());
        } else {
            return Collections.emptyList();
        }
    }
}
