package pl.sda.springproject.dto;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.PESEL;
import org.hibernate.validator.constraints.pl.REGON;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
public class BookDto {

    @NotNull
    @Length(min = 2, max=100, message = "Podaj tytuł o długości od 2 do 100 znaków!")
    String title;
    @NotNull
    @Pattern(regexp = "[a-zA-z\\s]{3,25}", message = "Nie możesz używać znaków specjalnych ani cyfr!")
    String author;
}
