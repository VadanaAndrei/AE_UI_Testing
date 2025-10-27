package utils;

import java.util.HashMap;

public class ScenarioContext {

    private static ScenarioContext instance;

    private static HashMap<String, Object> data;

    static {
        data = new HashMap<>();
    }

    private ScenarioContext() {}

    public static ScenarioContext getInstance() {
        if (instance == null) {
            instance = new ScenarioContext();
        }
        return instance;
    }

    public void put(String key, Object value) {
        data.put(key, value);
    }

    public <T> T get(String key, Class<T> clazz) {
        return clazz.cast(data.get(key));
    }

    public void remove(String key) {
        data.remove(key);
    }

    public void removeAll() {
        data.clear();
    }
}