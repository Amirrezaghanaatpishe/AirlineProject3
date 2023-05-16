import java.util.ArrayList;

public class User {
    protected String id;
    protected String password;
    protected static ArrayList<Flight> flights = new ArrayList<Flight>();

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}