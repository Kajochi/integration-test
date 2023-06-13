package com.example.integrationtest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bikes")
@RequiredArgsConstructor
public class BikeController {

    private final BikeService bikeService;

    @PostMapping
    Bike createBike(Bike bike){
        return bikeService.createBike(bike);
    }

}
