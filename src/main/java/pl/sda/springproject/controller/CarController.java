package pl.sda.springproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.springproject.dto.CarDto;
import pl.sda.springproject.service.CarService;

@Controller
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping("/car/add")
    public String carAddForm(){
        return "/car/add-car-form";
    }

    @PostMapping("/car/add")
    public String carAdd(@ModelAttribute CarDto carDto, Model model){
        model.addAttribute("car", carService.add(carDto));
        return "/car/confirm-add-car";
    }
}
