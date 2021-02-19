package by.epam.brest.model;

import by.epam.brest.files.CSVFileReader;
import by.epam.brest.files.FileReader;
import by.epam.brest.selector.PriceSelector;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class Calc implements Status {

    PriceSelector priceSelector = new PriceSelector();

    @Override
    public Status handle(Scanner scanner) {
        //TODO: to find best place for this function
        FileReader distancePriceFileReader = new CSVFileReader();
        try {
            Map<Integer, BigDecimal> distancePriceMap = distancePriceFileReader.readData("price_distance.csv");
            Map<Integer, BigDecimal> weightPriceMap = distancePriceFileReader.readData("price_weight.csv");

            System.out.println("Result: " + userData.get(0).multiply(priceSelector.selectPriceValue(distancePriceMap, userData.get(0)))
                    .add(userData.get(1).multiply(priceSelector.selectPriceValue(weightPriceMap, userData.get(1)))));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            userData.clear();
        }
        return new ReadData();
    }

    @Override
    public StatusType getType() {
        return StatusType.CALC;
    }
}