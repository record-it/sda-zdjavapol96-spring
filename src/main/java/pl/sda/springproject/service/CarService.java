package pl.sda.springproject.service;

import pl.sda.springproject.dto.CarDto;
import pl.sda.springproject.model.Car;

import java.util.List;

public interface CarService {
    Car add(CarDto carDto);
    List<Car> findAll();

}
