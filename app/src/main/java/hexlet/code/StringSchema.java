package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class StringSchema {
    private final Map<String, Predicate<String>> rules = new LinkedHashMap<>();

    public StringSchema() { }

    public StringSchema required() {
        rules.put("required", r -> r != null && !r.trim().isEmpty());
        return this;
    }

    public StringSchema minLength(int length) {
        rules.put("minLength", r -> r != null && r.length() >= length);
        return this;
    }

    public StringSchema contains(String substring) {
        rules.put("contains", r -> r != null && r.contains(substring));
        return this;
    }

    public boolean isValid(Object value) {
        if (value == null) {
            return !rules.containsKey("required");
        }

        if (!(value instanceof String)) {
            return false;
        }

        String str = (String) value;

        for (Predicate<String> predicate : rules.values()) {
            if (!predicate.test(str)) {
                return false;
            }
        }
        return true;
    }





    /*private boolean required = false;
    private Integer minLength = null;
    private String contains = null;

    public StringSchema() {}

    public StringSchema required() {
        this.required = true;
        return this;
    }

    public StringSchema minLength(int length) {
        this.minLength = length;
        return this;
    }

    public StringSchema contains(String subStr) {
        this.contains = subStr;
        return this;
    }

    public boolean isValid(Object value) {
        if (value == null) {
            return !required;
        }

        if (!(value instanceof String)) {
            return false;
        }

        String str = (String) value;
        if (required && str.trim().isEmpty()) {
            return false;
        }

        if (minLength != null && str.length() <= minLength) {
            return false;
        }

        if (contains != null && !str.contains(contains)) {
            return false;
        }
        return true;
    }*/
}
