package stream.support;

/**
 * Simple class
 */
public class User implements Comparable<User> {
    private String name;
    private long id;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    @Override
    public int compareTo(User anotherUser) {
        return Long.compare(this.id, anotherUser.id);
    }
}