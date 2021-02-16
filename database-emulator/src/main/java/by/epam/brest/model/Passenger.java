package by.epam.brest.model;

public class Passenger {

    private static final int MAX_NAME_LENGTH = 128;

    private String name;

    private Train train;

    public Passenger() {
    }

    public Passenger(String name, Train train) {
        this.setName(name);
        this.setTrain(train);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new StorageException("too long passenger name string");
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
