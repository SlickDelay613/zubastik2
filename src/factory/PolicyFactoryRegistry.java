package factory;

import java.util.HashMap;
import java.util.Map;

public class PolicyFactoryRegistry {
    private final Map<String, PolicyFactory> factories = new HashMap<>();

    public void register(PolicyFactory factory) {
        factories.put(factory.getSupportedType(), factory);
    }

    public PolicyFactory getFactory(String type) {
        PolicyFactory factory = factories.get(type);
        if (factory == null) {
            throw new IllegalArgumentException("Неизвестный тип полиса: " + type);
        }
        return factory;
    }
}