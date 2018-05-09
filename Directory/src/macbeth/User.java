package macbeth;

public class User {
    private String name;
    private String phone;
    private String email2;

    public User(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email2 = email;
    }

    public String toString() {
        return name+" "+phone+" "+email2;
    }
}
