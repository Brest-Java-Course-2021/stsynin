package by.epam.brest;

import by.epam.brest.model.Train;
import org.junit.Test;

import static org.junit.Assert.*;

public class DBEmulatorTest {

    DBEmulator trainStorage = new DBEmulator();

    @Test
    public void test_saveEntity() {
        int oldCount = trainStorage.size();
        Train train = new Train();
        assertEquals("new object don't saved", oldCount + 1, trainStorage.saveEntity(train));
    }

    @Test
    public void test_getSize() {
        assertEquals("wrong size", 0, trainStorage.size());
    }

}