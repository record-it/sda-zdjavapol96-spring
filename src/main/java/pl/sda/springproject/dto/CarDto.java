package pl.sda.springproject.dto;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class CarDto {
    private String brand;
    @NotNull
    private String model;
    @Range(min = 1900)
    private int productionYear;
}
