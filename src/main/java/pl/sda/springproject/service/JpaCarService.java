package pl.sda.springproject.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.sda.springproject.dto.CarDto;
import pl.sda.springproject.model.Car;
import pl.sda.springproject.repository.CarRepository;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class JpaCarService implements CarService{
    private final CarRepository carRepository;

    public JpaCarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car add(CarDto carDto) {
        Car car = Car.builder()
                .brand(carDto.getBrand())
                .model(carDto.getModel())
                .productionYear(carDto.getProductionYear())
                .build();
        return carRepository.save(car);
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> findById(long id) {
        return carRepository.findById(id);
    }

    @Override
    public void deleteById(long id) {
        carRepository.deleteById(id);
    }
}
