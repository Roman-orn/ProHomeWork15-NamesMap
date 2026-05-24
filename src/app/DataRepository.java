package app;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DataRepository {

    private Map<UUID, String> usersByIdMap = new HashMap<>();

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

    public Map<UUID, String> getData() {
        return usersByIdMap;
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
