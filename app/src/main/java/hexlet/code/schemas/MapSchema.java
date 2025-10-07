package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map> {
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

    public <T> MapSchema shape(Map<String, BaseSchema<T>> map) {
        rules.put("shape", v -> {
            for (Map.Entry<String, BaseSchema<T>> entry : map.entrySet()) {

                String key = entry.getKey();
                BaseSchema<T> schema = entry.getValue();
                var value = v.get(key);

                if (!schema.isValid((T) value)) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }
}
