package app;

import java.util.Map;
import java.util.UUID;

public class DataHandler {

    private Map<UUID, String> data;
    private int count;

    public DataHandler(DataRepository dataRepository) {
        this.data = dataRepository.getData();
    }

    public String getAll() {
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("No data!");
        }

        StringBuilder sb = new StringBuilder();
        count = 1;
        data.forEach((id, name) ->
                sb.append(String.format("%d) %s %s%n",
                        count++, id, name)));

        return "ALL NAMES:\n" + sb;
    }

    public String getById(UUID id) {
        if (data.containsKey(id)) {
            return String.format("NAME: id %s is %s", id, data.get(id));
        } else {
            return String.format("User with ID %s is not registered!", id);
        }
    }
}