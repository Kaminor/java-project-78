package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class NumberSchema {
    private final Map<String, Predicate<Integer>> rules = new LinkedHashMap<>();

    public NumberSchema() { }

    public NumberSchema required() {
        rules.put("required", r -> r != null);
        return this;
    }

    public NumberSchema positive() {
        rules.put("positive", r -> r > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        rules.put("range", r -> r >= min && r <= max);
        return this;
    }

    public boolean isValid(Object value) {
        if (value == null) {
            return !rules.containsKey("required");
        }

        if (!(value instanceof Integer)) {
            return false;
        }

        var num = (Integer) value;

        for (Predicate<Integer> predicate : rules.values()) {
            if (!predicate.test(num)) {
                return false;
            }
        }
        return true;
    }
}
