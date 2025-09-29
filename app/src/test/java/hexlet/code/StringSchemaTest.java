package hexlet.code;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public final class StringSchemaTest {
    @Test
    public void validNullEmptyString() {
        StringSchema actual = new StringSchema();
        assertTrue(actual.isValid(null));
        assertTrue(actual.isValid(""));
        assertTrue(actual.isValid("aca"));
    }

    @Test
    public void nonString() {
        StringSchema actual = new StringSchema();
        actual.required();

        assertFalse(actual.isValid(null));
        assertFalse(actual.isValid(""));
        assertTrue(actual.isValid("aca"));
    }

    @Test
    public void minLength() {
        StringSchema actual = new StringSchema();
        actual.required();
        actual.minLength(4);

        assertTrue(actual.isValid("Hexlet"));
        assertFalse(actual.isValid(""));
        assertFalse(actual.isValid("aca"));
    }

    @Test
    public void contains() {
        StringSchema actual = new StringSchema();
        actual.required();

        assertTrue(actual.contains("what").isValid("what does"));
        assertFalse(actual.contains("whatthe").isValid("what does"));
        assertFalse(actual.contains(" ").isValid("abc"));
    }
}
