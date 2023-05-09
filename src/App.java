import java.util.ArrayList;

public class App {
    /**
     * This program is an airline reservation simulator
     * @author Amirreza Gghanaatpishe
     * @since   2023-5-9
     * @version 2.0.0
     */
    public static void main(String[] args) {
        Admin admin = new Admin("sss");
        ArrayList<Admin> a = new ArrayList<Admin>();
        a.add(admin);
        System.out.println(a.get(0));
    }
}
