package hexlet.code;

public class StringSchema {
    private boolean required = false;
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
    }
}
