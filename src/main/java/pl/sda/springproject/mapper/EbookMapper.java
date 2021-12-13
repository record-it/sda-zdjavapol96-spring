package pl.sda.springproject.mapper;
import pl.sda.springproject.dto.EbookDtoOut;
import pl.sda.springproject.model.Ebook;

public class EbookMapper {

    static public EbookDtoOut mapToDtoOut(Ebook ebook) {
        return EbookDtoOut.builder()
                .title(ebook.getTitle())
                .format(ebook.getFormat())
                .id(ebook.getId())
                .build();
    }
}
