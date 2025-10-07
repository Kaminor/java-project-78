package hexlet.code;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class StringSchemaTest {
    @Test
    public void nullAndEmptyStringTest() {
        Validator validator = new Validator();
        StringSchema actual = validator.string();

        assertTrue(actual.isValid(null));
        assertTrue(actual.isValid(""));
        assertTrue(actual.isValid("aca"));
    }

    @Test
    public void nonStringTest() {
        Validator validator = new Validator();
        StringSchema actual = validator.string();
        actual.required();

        assertFalse(actual.isValid(null));
        assertFalse(actual.isValid(""));
        assertTrue(actual.isValid("aca"));
    }

    @Test
    public void minLengthTest() {
        Validator validator = new Validator();
        StringSchema actual = validator.string();
        actual.required();
        actual.minLength(4);

        assertTrue(actual.isValid("Hexlet"));
        assertFalse(actual.isValid(""));
        assertFalse(actual.isValid("aca"));
    }

    @Test
    public void containsTest() {
        Validator validator = new Validator();
        StringSchema actual = validator.string();
        actual.required();

        assertTrue(actual.contains("what").isValid("what does"));
        assertFalse(actual.contains("whatthe").isValid("what does"));
        assertFalse(actual.contains(" ").isValid("abc"));
    }
}
