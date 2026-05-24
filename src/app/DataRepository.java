package app;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DataRepository {

    private Map<UUID, String> usersByIdMap = new HashMap<>();
    private int count;

    public DataRepository(){
        User lucy = this.addUser("Lucy");
        usersByIdMap.put(lucy.getId(lucy), lucy.getName(lucy));
        User bob = this.addUser("Bob");
        usersByIdMap.put(lucy.getId(lucy), lucy.getName(lucy));
        User tom = this.addUser("Tom");
        usersByIdMap.put(lucy.getId(lucy), lucy.getName(lucy));
        User anna = this.addUser("Anna");
        usersByIdMap.put(lucy.getId(lucy), lucy.getName(lucy));
    }

    public String getData() {
        if (usersByIdMap == null || usersByIdMap.isEmpty()) {
            throw new IllegalArgumentException("No data!");
        }

        StringBuilder sb = new StringBuilder();
        count = 1;
        usersByIdMap.forEach((id, name) ->
                sb.append(String.format("%d) %s %s%n",
                        count++, id, name)));

        return "ALL NAMES:\n" + sb;
    }

    public User addUser(String name){
        return new User(name);
    }

    public String getUserById(UUID id){
        if(usersByIdMap.containsKey(id)){
            return String.format("User with ID %s: %s", id, usersByIdMap.get(id));
        } else {
            throw new UserNotFoundException(String.format("User with ID %s: Not found!", id));
        }
    }
}
