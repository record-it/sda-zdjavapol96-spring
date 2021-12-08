package pl.sda.springproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
