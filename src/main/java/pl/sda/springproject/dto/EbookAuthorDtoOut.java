package pl.sda.springproject.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class EbookAuthorDtoOut {
    private long id;
    private String name;
    private String alterName;
    private LocalDate birthDate;
    private List<SimpleEbookDtoOut> ebooks;
}
