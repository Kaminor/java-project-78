package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T> {
    protected final Map<String, Predicate<T>> rules = new LinkedHashMap<>();

    public BaseSchema() { }

    public boolean isValid(T value) {
        if (value == null) {
            return !rules.containsKey("required");
        }

        for (Predicate<T> predicate : rules.values()) {
            if (!predicate.test(value)) {
                return false;
            }
        }
        return true;
    }
}
