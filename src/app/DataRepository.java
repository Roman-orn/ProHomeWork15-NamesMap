package app;

import java.util.HashMap;
import java.util.Map;

public class DataRepository {

    Map<Integer, String> map = new HashMap<>();

    public Map<Integer, String> getData() {
        map.put(25, "Lucy");
        map.put(59, "Bob");
        map.put(125, "Jack");
        map.put(478, "Anna");

        return map;
    }
}
