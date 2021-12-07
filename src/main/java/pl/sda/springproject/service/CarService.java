package pl.sda.springproject.service;

import pl.sda.springproject.dto.CarDto;
import pl.sda.springproject.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    Car add(CarDto carDto);
    List<Car> findAll();
    Optional<Car> findById(long id);

    void deleteById(long id);
}
