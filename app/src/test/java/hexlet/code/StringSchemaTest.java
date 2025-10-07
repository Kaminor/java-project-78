package hexlet.code;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class StringSchemaTest {
    @Test
    public void nullAndEmptyStringTest() {
        StringSchema actual = new StringSchema();
        assertTrue(actual.isValid(null));
        assertTrue(actual.isValid(""));
        assertTrue(actual.isValid("aca"));
    }

    @Test
    public void nonStringTest() {
        StringSchema actual = new StringSchema();
        actual.required();

        assertFalse(actual.isValid(null));
        assertFalse(actual.isValid(""));
        assertTrue(actual.isValid("aca"));
    }

    @Test
    public void minLengthTest() {
        StringSchema actual = new StringSchema();
        actual.required();
        actual.minLength(4);

        assertTrue(actual.isValid("Hexlet"));
        assertFalse(actual.isValid(""));
        assertFalse(actual.isValid("aca"));
    }

    @Test
    public void containsTest() {
        StringSchema actual = new StringSchema();
        actual.required();

        assertTrue(actual.contains("what").isValid("what does"));
        assertFalse(actual.contains("whatthe").isValid("what does"));
        assertFalse(actual.contains(" ").isValid("abc"));
    }
}
