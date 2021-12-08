package pl.sda.springproject.service;

import org.springframework.stereotype.Service;
import pl.sda.springproject.dto.CarDto;
import pl.sda.springproject.exception.TooOldCarException;
import pl.sda.springproject.model.Car;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MemoryCarService implements CarService{


    private Map<Long, Car> cars = new HashMap<>();
    private AtomicLong index = new AtomicLong(0);


    @Override
    public Car add(CarDto carDto) {
        Car car = Car.builder()
                .brand(carDto.getBrand())
                .model(carDto.getModel())
                .productionYear(carDto.getProductionYear())
                .id(index.incrementAndGet())
                .build();
        if (LocalDate.now().getYear() - car.getProductionYear() > 20){
            throw new TooOldCarException("Zbyt stary samochód", car.getProductionYear());
        }
        cars.put(car.getId(), car);
        return car;
    }

    @Override
    public List<Car> findAll() {
        return new ArrayList<>(cars.values());
    }

    @Override
    public Optional<Car> findById(long id) {
        return Optional.ofNullable(cars.get(id));
    }

    @Override
    public void deleteById(long id){
        cars.remove(id);
    }

}
