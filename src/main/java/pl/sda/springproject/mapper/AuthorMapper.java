package pl.sda.springproject.mapper;

import pl.sda.springproject.dto.EbookAuthorDtoOut;
import pl.sda.springproject.dto.SimpleEbookDtoOut;
import pl.sda.springproject.model.Author;

import java.util.stream.Collectors;

public class AuthorMapper {
    public static EbookAuthorDtoOut mapToDto(Author author){
        return EbookAuthorDtoOut.builder()
                .id(author.getId())
                .alterName(author.getAlterName())
                .name(author.getName())
                .birthDate(author.getBirthDate())
                .ebooks(
                        author.getEbooks().stream()
                                .map(e -> SimpleEbookDtoOut.builder()
                                        .id(e.getId())
                                        .title(e.getTitle())
                                        .format(e.getFormat())
                                        .build())
                                .collect(Collectors.toList())
                )
                .build();
    }
}
