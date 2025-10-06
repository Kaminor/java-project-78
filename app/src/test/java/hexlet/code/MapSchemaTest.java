package hexlet.code;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class MapSchemaTest {
    @Test
    public void validNullMap() {
        MapSchema actual = new MapSchema();

        assertTrue(actual.isValid(null));
        actual.required();
        assertFalse(actual.isValid(null));
    }

    @Test
    public void validNotNullMap() {
        MapSchema actual = new MapSchema();
        var data = new HashMap<String, String>();
        data.put("key", "value");

        assertTrue(actual.isValid(data));
        actual.required();
        assertTrue(actual.isValid(data));
    }

    @Test
    public void validSizeOf() {
        MapSchema actual = new MapSchema();
        var data = new HashMap<String, String>();
        data.put("key", "value");
        data.put("key2", "value2");

        assertTrue(actual.sizeof(2).isValid(data));
        assertFalse(actual.sizeof(4).isValid(data));
    }
}
