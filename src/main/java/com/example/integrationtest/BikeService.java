package com.example.integrationtest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BikeService {


    private final BikeRepo bikeRepo;
    public Bike createBike(Bike bike) {
        return bikeRepo.createBike(bike);
    }

    public BigDecimal calculateAverageBikePrice(String color) {
        Set<Bike> allBikes = bikeRepo.getAllBikes();
        BigDecimal sumPriceofWithColor = BigDecimal.ZERO;
        int numberOfBikesWithColor = 0;
        for (Bike bike: allBikes) {
            if (bike.color().equals(color)) {
                sumPriceofWithColor.add(bike.price());
            numberOfBikesWithColor++;
            }
        }


        return sumPriceofWithColor.divide(new BigDecimal(numberOfBikesWithColor), RoundingMode.HALF_UP);
    }
}
