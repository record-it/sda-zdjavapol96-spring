package pl.sda.springproject.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SimpleEbookDtoOut {
    private long id;
    private String title;
    private String format;
}
