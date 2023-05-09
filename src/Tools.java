import java.io.IOException;
import java.util.Scanner;

public class Tools {
    //--------Tools

    //Scanner
    public static Scanner input = new Scanner(System.in);

    //--------Clear
    public static void cls()  {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



