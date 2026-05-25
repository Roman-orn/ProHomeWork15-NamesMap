package app;

public class User {

    private final Long id;
    private final String name;

    public User(String name, Long id) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
