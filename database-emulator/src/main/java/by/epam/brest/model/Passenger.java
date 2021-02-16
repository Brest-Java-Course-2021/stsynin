package by.epam.brest.model;

public class Passenger {

    private String name;

    private Train train;

    public Passenger() {
    }

    public Passenger(String name, Train train) {
        this.setName(name);
        this.train = train;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 128) {
            throw new StorageException("too long string");
        }
        this.name = name;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}
