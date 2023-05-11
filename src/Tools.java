import javax.management.StringValueExp;
import java.io.IOException;
import java.util.Scanner;

/**
 * Include useful methods
 */
public class Tools {


    //----------Scanner
    public static Scanner input = new Scanner(System.in);

    //----------Clear
    public static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //----------Pause
    public static void pause() {
        System.out.println("Press Any Key To Continue...");
        input.nextLine();
        cls();
    }

    //----------Checker
    public static boolean stringCheck(String A) {
        boolean B;
        return B = A.equals(String.valueOf(0));
    }

    public static boolean integerCheck(int A) {
        boolean B;
        return B = A == 0;
    }

    public static boolean doubleCheck(double A) {
        boolean B;
        return B = A == 0;
    }
}



