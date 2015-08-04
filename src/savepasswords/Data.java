package savepasswords;

/**
 *
 * @author MeTaXaS4
 */
public class Data {

    int id;
    String name;
    String username;
    String password;
    String email;
    String description;

    Data(int id, String name, String username, String password, String email, String description) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }
}
