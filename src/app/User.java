package app;

import java.util.UUID;

public class User {

    private final UUID id;
    private final String name;

    public User(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public UUID getId(User user) {
        return user.id;
    }

    public String getName(User user) {
        return user.name;
    }
}
