package macbeth;

public class User {
    private String name;
    private String phone;
    private String email;

    public User(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String toString() {
        return name+" "+phone+" "+email;
    }
}
