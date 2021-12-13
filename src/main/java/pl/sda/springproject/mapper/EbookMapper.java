package pl.sda.springproject.mapper;
import pl.sda.springproject.dto.AuthorDtoOut;
import pl.sda.springproject.dto.EbookDtoOut;
import pl.sda.springproject.model.Ebook;
import pl.sda.springproject.model.Tag;

import java.util.stream.Collectors;

public class EbookMapper {

    static public EbookDtoOut mapToDtoOut(Ebook ebook) {
        return EbookDtoOut.builder()
                .authors(
                        ebook.getAuthors().stream()
                                .map(a -> AuthorDtoOut.builder()
                                        .name(a.getName())
                                        .alterName(a.getAlterName())
                                        .birthDate(a.getBirthDate())
                                        .build()
                                ).collect(Collectors.toSet())
                )
                .title(ebook.getTitle())
                .tags(ebook.getTags().stream().map(Tag::getLabel).collect(Collectors.toSet()))
                .format(ebook.getFormat())
                .id(ebook.getId())
                .build();
    }
}
