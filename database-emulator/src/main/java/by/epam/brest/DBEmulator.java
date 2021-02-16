package by.epam.brest;

import by.epam.brest.model.Train;

import java.util.ArrayList;
import java.util.List;

public class DBEmulator {

    private final List<Object> storage = new ArrayList<>();

    public int size() {
        return storage.size();
    }

    public int saveEntity(Object o) {
        if (storage.contains(o)) {
            return -1;
        }
        storage.add(o);
        return storage.size() - 1;
    }

    public void clear() {
        storage.clear();
    }

    public Object readEntity(int index) {
        return storage.get(index);
    }

    public void deleteEntity(int index) {
        storage.remove(index);
    }

    public int getIndex(Object o) {
        return storage.indexOf(o);
    }

    public void updateEntity(int index, Object o) {
        storage.remove(index);
        storage.add(index, o);
    }
}
