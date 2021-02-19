package by.epam.brest;

import by.epam.brest.model.ReadData;
import by.epam.brest.model.Status;
import by.epam.brest.model.StatusType;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Distance
        // Price per km
        // Weight
        // Price per kg
        // Result = d * pr1 + w * pr2

        Scanner scanner = new Scanner(System.in);
        Status currentStatus = new ReadData();
        while (currentStatus.getType() != StatusType.EXIT) {
            currentStatus = currentStatus.handle(scanner);
        }
    }

}