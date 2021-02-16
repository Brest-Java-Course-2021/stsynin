package by.epam.brest.model;

import java.time.LocalDate;

public class Train {

    private static final int MAX_NAME_LENGTH = 128;

    private String name;

    private String destination;

    private LocalDate departureDate;

    public Train() {
    }

    public Train(String name, String destination, LocalDate departureDate) {
        this.setName(name);
        this.setDestination(destination);
        this.setDepartureDate(departureDate);
    }

    public String getName() {
        return name;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new StorageException("too long train name string");
        }
        if (!name.matches("[a-z0-9]*")) {
            throw new StorageException("train name contains incorrect chars: " + name);
        }
        this.name = name;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }
}
