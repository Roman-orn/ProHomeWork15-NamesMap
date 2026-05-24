package app;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DataRepository {

    private Map<UUID, String> usersByIdMap = new HashMap<>();
    private int count;

    public DataRepository(){
        usersByIdMap.put(UUID.fromString("4b0f6211-0935-4359-974b-b4c6bf62c11d"), "Lucy");
        usersByIdMap.put(UUID.fromString("a84152c0-e1a4-464f-921d-4114b6dec5a9"), "Bob");
        usersByIdMap.put(UUID.fromString("c8bdd952-151c-4484-8e0e-a29df2013333"), "Tom");
        usersByIdMap.put(UUID.fromString("7446a500-af98-4573-9f3e-e7a1505f14ea"), "Anna");
    }

    public String getData() {
        if (usersByIdMap == null || usersByIdMap.isEmpty()) {
            throw new IllegalArgumentException("No data!");
        }

        StringBuilder sb = new StringBuilder();
        count = 1;
        usersByIdMap.forEach((id, name) ->
                sb.append(String.format("%d) %s - %s%n",
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
