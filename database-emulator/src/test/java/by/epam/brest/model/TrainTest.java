package by.epam.brest.model;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class TrainTest {

    @Test
    public void test_fieldCorrectness() {
        String name = "small1";
        String destination = "hell";
        LocalDate departureDate = LocalDate.now();

        Train train = new Train(name, destination, departureDate);
        assertEquals("wrong train name", name, train.getName());
        assertEquals("wrong train destination", destination, train.getDestination());
        assertEquals("wrong train departure time", departureDate, train.getDepartureDate());
    }

    @Test
    public void test_setters() {
        Train train = new Train();
        String newName = "boeing";
        String newDestination = "hell";
        LocalDate newDepartureDate = LocalDate.now();

        train.setName(newName);
        train.setDestination(newDestination);
        train.setDepartureDate(newDepartureDate);

        assertEquals("wrong train name", newName, train.getName());
        assertEquals("wrong train destination", newDestination, train.getDestination());
        assertEquals("wrong train departure time", newDepartureDate, train.getDepartureDate());
    }

    @Test(expected = StorageException.class)
    public void test_nameLength() {
        String name = "z".repeat(129);
        new Train(name, null, LocalDate.now());
    }

    @Test(expected = StorageException.class)
    public void test_nameWithCapital() {
        new Train("Name", null, LocalDate.now());
    }

    @Test(expected = StorageException.class)
    public void test_nameWithSpace() {
        new Train("n ame", null, LocalDate.now());
    }
}