package hexlet.code;

public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema() {
        super();
    }

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
}
