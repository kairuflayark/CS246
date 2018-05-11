package macbeth;

public class User implements Comparable<User>{
    private String name;
    private String phone;
    private String email2;
    private int age;

    public User(String name, String phone, String email, int age) {
        this.name = name;
        this.phone = phone;
        this.email2 = email;
        this.age = age;
    }

    public String getEmail() {
        return email2;
    }

    @Override
    public int compareTo(User o) {
        return age - o.age;

    }

    public String toString() {
        return name+" "+phone+" "+email2+ " "+age;
    }
}
