package app;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DataRepository {

    private Map<Integer, User> usersByIdMap = new HashMap<>();
    private int key;

    public String getData() {
        if (usersByIdMap == null || usersByIdMap.isEmpty()) {
            throw new IllegalStateException("No data!");
        }

        StringBuilder sb = new StringBuilder();
        AtomicInteger count = new AtomicInteger(1);
        usersByIdMap.forEach((key, user) ->
                sb.append(String.format("%d) %s - %s%n",
                        count.getAndIncrement(), key, user.getName())));

        return "ALL NAMES:\n" + sb;
    }

    public void addUser(String name, Long id){
        User user = new User(name, id);
        usersByIdMap.put(++key, user);
    }

    public String getUserByKey(int key){
        if(usersByIdMap.containsKey(key)){
            return String.format("User with key %s: %s %d",
                    key,
                    usersByIdMap.get(key).getName(),
                    usersByIdMap.get(key).getId());
        } else {
            throw new UserNotFoundException(String.format("User with key %s: Not found!", key));
        }
    }
}
