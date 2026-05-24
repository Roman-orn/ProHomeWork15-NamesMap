package app;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DataHandler {

    Map<Integer, String> map = new DataRepository().getData();

    public String getAll() {
        if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException("No data!");
        }

        StringBuilder sb = new StringBuilder();
        AtomicInteger count = new AtomicInteger(1);
        map.forEach((id, name) ->
                sb.append(String.format("%d) %d %s%n",
                        count.getAndIncrement(), id, name)));

        return "ALL NAMES:\n" + sb;
    }

    public String getById(int id) {
        if (map.containsKey(id)) {
            return String.format("NAME: id %d is %s", id, map.get(id));
        } else {
            return String.format("User with ID %d is not registered!", id);
        }
    }
}