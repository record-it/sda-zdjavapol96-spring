package pl.sda.springproject.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDto {
    String title;
    String author;
}
