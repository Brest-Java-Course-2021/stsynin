package by.epam.brest;

import by.epam.brest.files.FileReader;
import by.epam.brest.model.ReadData;
import by.epam.brest.model.Status;
import by.epam.brest.model.StatusType;
import by.epam.brest.selector.PriceSelector;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Distance
        // Price per km
        // Weight
        // Price per kg
        // Result = d * pr1 + w * pr2

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");

        FileReader fileReader = applicationContext.getBean(FileReader.class);
        PriceSelector priceSelector = applicationContext.getBean(PriceSelector.class);

        Scanner scanner = new Scanner(System.in);
        Status currentStatus = new ReadData(priceSelector, fileReader, scanner);
        while (currentStatus.getType() != StatusType.EXIT) {
            currentStatus = currentStatus.handle();
        }
    }

}