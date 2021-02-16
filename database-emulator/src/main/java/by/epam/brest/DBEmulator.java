package by.epam.brest;

import java.util.ArrayList;
import java.util.List;

public class DBEmulator {

    private List<Object> storage = new ArrayList<>();

    public int size() {
        return storage.size();
    }

    public int saveEntity(Object o) {
        storage.add(o);
        return storage.size();
    }
}
