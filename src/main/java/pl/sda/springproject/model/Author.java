package pl.sda.springproject.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Author {
    private long id;
    private String name;
    private String alterName;
    private LocalDate birthDate;
}