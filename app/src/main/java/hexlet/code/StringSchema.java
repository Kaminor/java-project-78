package hexlet.code;

public class StringSchema extends BaseSchema<String> {

    public StringSchema() {
        super();
    }

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




    /*public boolean isValid(Object value) {
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
    }*/
}
