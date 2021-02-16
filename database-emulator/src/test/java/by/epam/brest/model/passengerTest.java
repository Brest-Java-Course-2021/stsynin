package by.epam.brest.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class passengerTest {

    @Test
    public void test_fieldCorrectness() {
        String name = "small foot";
        Train train = new Train();
        Passenger passenger = new Passenger(name, train);
        assertEquals("wrong passenger name", name, passenger.getName());
        assertEquals("wrong train", train, passenger.getTrain());
    }

    @Test
    public void test_setters() {
        Passenger passenger = new Passenger();
        String newName = "bigfoot";
        Train newTrain = new Train();
        passenger.setName(newName);
        passenger.setTrain(newTrain);
        assertEquals("wrong passenger name", newName, passenger.getName());
        assertEquals("wrong train", newTrain, passenger.getTrain());
    }

    @Test(expected = StorageException.class)
    public void test_nameLength() {
        String name = "z".repeat(129);
        new Passenger(name, null);
    }
}
