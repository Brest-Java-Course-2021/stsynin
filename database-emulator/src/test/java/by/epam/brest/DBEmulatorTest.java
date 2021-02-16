package by.epam.brest;

import by.epam.brest.model.Train;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DBEmulatorTest {

    DBEmulator trainStorage = new DBEmulator();
    Train train_a = new Train();
    Train train_b = new Train();
    Train train_c = new Train();
    Train train_new = new Train();

    @Before
    public void setupTest() {
        trainStorage.clear();
    }

    @Test
    public void test_saveEntity() {
        int oldCount = trainStorage.size();
        trainStorage.saveEntity(train_a);
        assertEquals("new object don't saved", oldCount + 1, trainStorage.size());
    }

    @Test
    public void test_getSize() {
        assertEquals("wrong size", 0, trainStorage.size());
    }

    @Test
    public void test_clearBase() {
        trainStorage.saveEntity(train_a);
        trainStorage.saveEntity(train_b);
        trainStorage.clear();
        assertEquals("reset error", 0, trainStorage.size());
    }

    @Test
    public void test_readEntity() {
        trainStorage.saveEntity(train_a);
        int index = trainStorage.saveEntity(train_b);
        trainStorage.saveEntity(train_c);
        assertEquals("wrong reading", train_b, trainStorage.readEntity(index));
    }

    @Test
    public void test_deleteEntity() {
        trainStorage.saveEntity(train_a);
        int index = trainStorage.saveEntity(train_b);
        trainStorage.deleteEntity(index);
        assertEquals("wrong size after delete", 1, trainStorage.size());
    }

    @Test
    public void test_getIndexOfEntity() {
        trainStorage.saveEntity(train_a);
        int index = trainStorage.saveEntity(train_b);
        trainStorage.saveEntity(train_c);
        assertEquals("wrong index", index, trainStorage.getIndex(train_b));
    }

    @Test
    public void test_updateEntity() {
        trainStorage.saveEntity(train_a);
        trainStorage.saveEntity(train_b);
        trainStorage.updateEntity(trainStorage.getIndex(train_b), train_new);
        assertEquals("wrong size after update", 2, trainStorage.size());
        assertEquals("wrong reading old object", train_a, trainStorage.readEntity(0));
        assertEquals("wrong reading updated object", train_new, trainStorage.readEntity(1));
    }

    @Test
    public void test_entityUniqueness() {
        trainStorage.saveEntity(train_a);
        assertEquals("we lost repetition", -1, trainStorage.saveEntity(train_a));

    }
}