package pl.sda.springproject.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Ebook {
    private long id;
    private String title;
    private Author author;
    private String format;
}
