package pl.sda.springproject.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarDto {
    private String brand;
    private String model;
    private int productionYear;
}
