package pl.sda.springproject.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EbookDtoOut {
    private long id;
    private String title;
    private AuthorDtoOut author;
    private String format;
}
