package pl.sda.springproject.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class AuthorDtoOut {
    private String name;
    private String alterName;
    private LocalDate birthDate;
}
