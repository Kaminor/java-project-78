package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class NumberSchemaTest {

    @Test
    public void notRequiredTest() {
        NumberSchema actual = new NumberSchema();

        assertTrue(actual.isValid(null));
        assertTrue(actual.isValid(0));
        assertTrue(actual.isValid(-13));
    }

    @Test
    public void requiredTest() {
        NumberSchema actual = new NumberSchema();
        actual.required();

        assertFalse(actual.isValid(null));
        assertTrue(actual.isValid(0));
        assertTrue(actual.isValid(-13));
    }

    @Test
    public void positiveTest() {
        NumberSchema actual = new NumberSchema();
        actual.positive();

        assertTrue(actual.isValid(null));
        assertFalse(actual.isValid(0));
        assertFalse(actual.isValid(-12));
        assertTrue(actual.isValid(11));
    }

    @Test
    public void rangeTest() {
        NumberSchema actual = new NumberSchema();
        actual.range(20, 55);

        assertTrue(actual.isValid(null));
        assertFalse(actual.isValid(15));
        assertFalse(actual.isValid(-12));
        assertTrue(actual.isValid(41));
    }
}
