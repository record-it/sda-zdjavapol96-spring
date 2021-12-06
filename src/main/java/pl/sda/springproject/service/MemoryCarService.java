package pl.sda.springproject.service;

import org.springframework.stereotype.Service;
import pl.sda.springproject.dto.CarDto;
import pl.sda.springproject.model.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        cars.put(car.getId(), car);
        return car;
    }

    @Override
    public List<Car> findAll() {
        return new ArrayList<>(cars.values());
    }
}
