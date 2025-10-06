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

    public MapSchema shape(Map<String, ? extends BaseSchema<?>> map) {
        rules.put("shape", v -> {
            for (Map.Entry<String, ? extends BaseSchema<?>> entry : map.entrySet()) {

                String key = entry.getKey();
                BaseSchema<?> schema = entry.getValue();
                var value = v.get(key);

                if (!schema.isValid(value)) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }
}
