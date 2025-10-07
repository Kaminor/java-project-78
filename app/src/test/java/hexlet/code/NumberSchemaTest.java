package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class NumberSchemaTest {

    @Test
    public void notRequiredTest() {
        Validator validator = new Validator();
        NumberSchema actual = validator.number();

        assertTrue(actual.isValid(null));
        assertTrue(actual.isValid(0));
        assertTrue(actual.isValid(-13));
    }

    @Test
    public void requiredTest() {
        Validator validator = new Validator();
        NumberSchema actual = validator.number();
        actual.required();

        assertFalse(actual.isValid(null));
        assertTrue(actual.isValid(0));
        assertTrue(actual.isValid(-13));
    }

    @Test
    public void positiveTest() {
        Validator validator = new Validator();
        NumberSchema actual = validator.number();
        actual.positive();

        assertTrue(actual.isValid(null));
        assertFalse(actual.isValid(0));
        assertFalse(actual.isValid(-12));
        assertTrue(actual.isValid(11));
    }

    @Test
    public void rangeTest() {
        Validator validator = new Validator();
        NumberSchema actual = validator.number();
        actual.range(20, 55);

        assertTrue(actual.isValid(null));
        assertFalse(actual.isValid(15));
        assertFalse(actual.isValid(-12));
        assertTrue(actual.isValid(41));
    }
}
