package by.epam.brest.model;

import by.epam.brest.files.FileReader;
import by.epam.brest.selector.PriceSelector;

import java.util.Scanner;

abstract class AbstractStatus implements Status {

    PriceSelector priceSelector;
    FileReader fileReader;
    Scanner scanner;

    public AbstractStatus(PriceSelector priceSelector, FileReader fileReader, Scanner scanner) {
        this.priceSelector = priceSelector;
        this.fileReader = fileReader;
        this.scanner = scanner;
    }
}
