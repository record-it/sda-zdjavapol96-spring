package pl.sda.springproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.springproject.dto.EbookAuthorDtoOut;
import pl.sda.springproject.dto.EbookDtoOut;
import pl.sda.springproject.mapper.AuthorMapper;
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

    @GetMapping("/{id}")
    public ResponseEntity<EbookDtoOut> find(@PathVariable long id){
        final Optional<Ebook> optionalEbook = ebookService.findBydId(id);
        if (optionalEbook.isPresent()){
            return ResponseEntity.ok(EbookMapper.mapToDtoOut(optionalEbook.get()));
        }
        return ResponseEntity.of(Optional.empty());
    }


    @GetMapping("/{id}/authors")
    public List<EbookAuthorDtoOut> findBookAuthors(@PathVariable long id){
        return ebookService.findBydId(id).get().getAuthors().stream()
                .map(author -> {
                    final Optional<Author> oa = ebookService.findAuthorById(author.getId());
                    System.out.println(oa.get().getName());
                    if (oa.isPresent()){
                        return AuthorMapper.mapToDto(oa.get());
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

    @GetMapping("/search")
    public List<EbookDtoOut> findByTag(@RequestParam String tag){
        return ebookService.findEbooksByTag(tag).stream()
                .map(EbookMapper::mapToDtoOut)
                .collect(Collectors.toList());
    }
}
