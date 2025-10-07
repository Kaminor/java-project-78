package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T> {
    protected final Map<String, Predicate<T>> rules = new LinkedHashMap<>();

    public BaseSchema() {
        super();
    }

    public final boolean isValid(Object value) {
        if (value == null) {
            return !rules.containsKey("required");
        }

        for (Predicate<T> predicate : rules.values()) {
            if (!predicate.test((T) value)) {
                return false;
            }
        }
        return true;
    }
}
