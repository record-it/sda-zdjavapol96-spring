package pl.sda.springproject.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class EbookDtoOut {
    private long id;
    private String title;
    private Set<AuthorDtoOut> authors;
    private Set<String> tags;
    private String format;
}
