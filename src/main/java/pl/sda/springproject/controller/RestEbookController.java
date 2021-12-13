package pl.sda.springproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.springproject.dto.EbookDtoOut;
import pl.sda.springproject.mapper.EbookMapper;
import pl.sda.springproject.model.Author;
import pl.sda.springproject.model.Ebook;
import pl.sda.springproject.service.EbookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/ebooks")
public class RestEbookController {
    private final EbookService ebookService;

    public RestEbookController(EbookService ebookService) {
        this.ebookService = ebookService;
    }

    @GetMapping("")
    public List<EbookDtoOut> findAll(){
        return ebookService.findAll().stream()
                .map(EbookMapper::mapToDtoOut)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}/authors")
    public List<Author> findBookAuthors(@PathVariable long id){
        return ebookService.findBydId(id).get().getAuthors().stream()
                .map(author -> {
                    final Optional<Author> oa = ebookService.findAuthorById(author.getId());
                    if (oa.isPresent()){
                        return oa.get();
                    }
                    return null;
                })
                .filter(item -> item != null)
                .collect(Collectors.toList());
    }

    @PostMapping("")
    public ResponseEntity<Ebook> add(@RequestBody Ebook ebook){
        return ResponseEntity.ok(ebookService.add(ebook));
    }
}
