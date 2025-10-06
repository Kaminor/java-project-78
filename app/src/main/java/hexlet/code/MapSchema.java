package hexlet.code;

import java.util.Map;

public class MapSchema extends BaseSchema<Map> {
    public MapSchema() {
        super();
    }

    public MapSchema required() {
        rules.put("required", r -> r != null);
        return this;
    }

    public MapSchema sizeof(int size) {
        rules.put("sizeof", r -> r.size() == size);
        return this;
    }
}
