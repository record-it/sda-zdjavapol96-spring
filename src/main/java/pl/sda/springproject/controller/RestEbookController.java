package pl.sda.springproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.springproject.dto.EbookDtoOut;
import pl.sda.springproject.mapper.EbookMapper;
import pl.sda.springproject.model.Ebook;
import pl.sda.springproject.service.EbookService;

import java.util.List;
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

    @PostMapping("")
    public ResponseEntity<Ebook> add(@RequestBody Ebook ebook){
        return ResponseEntity.ok(ebookService.add(ebook));
    }
}
