package pl.sda.springproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.springproject.dto.CarDto;
import pl.sda.springproject.model.Car;
import pl.sda.springproject.service.CarService;

@RestController
public class RestCarController {
    private final CarService carService;

    public RestCarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/api/v1/cars/{id}")
    public ResponseEntity<Car> findById(@PathVariable long id){
        return ResponseEntity.of(carService.findById(id));
    }

    @PostMapping("/api/v1/cars")
    public ResponseEntity<Car> add(@RequestBody CarDto dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(carService.add(dto));
    }
}
