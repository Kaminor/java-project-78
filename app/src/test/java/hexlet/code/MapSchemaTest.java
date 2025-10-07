package hexlet.code;
import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class MapSchemaTest {
    @Test
    public void nullTest() {
        MapSchema actual = new MapSchema();

        assertTrue(actual.isValid(null));
        actual.required();
        assertFalse(actual.isValid(null));
    }

    @Test
    public void notNullTest() {
        MapSchema actual = new MapSchema();
        var data = new HashMap<String, String>();
        data.put("key", "value");

        assertTrue(actual.isValid(data));
        actual.required();
        assertTrue(actual.isValid(data));
    }

    @Test
    public void sizeOfTest() {
        MapSchema actual = new MapSchema();
        var data = new HashMap<String, String>();
        data.put("key", "value");
        data.put("key2", "value2");

        assertTrue(actual.sizeof(2).isValid(data));
        assertFalse(actual.sizeof(4).isValid(data));
    }

    @Test
    public void shapeTest() {
        var v = new Validator();
        var actual = v.map();

        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().required().minLength(2));

        actual.shape(schemas);
        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");

        assertTrue(actual.isValid(human1));
        assertFalse(actual.isValid(human2));
        assertFalse(actual.isValid(human3));
    }
}
