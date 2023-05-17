import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * Include useful methods
 */
public class Tools {

    static final int FIX_SIZE = 10;

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

    //----------File

    //----------Fix String
    public static String fixStringToWrite(String str) {
        while (str.length() < FIX_SIZE)
            str += " "; //read StringBuilder class for better performance
        return str.substring(0, FIX_SIZE);
    }

    //----------Write

    //----------String
    public static void writeString(String path, long bt, String str) {
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");
            file.seek(bt);
            file.writeChars(str);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //----------Integer
    public static void writeInteger(String path, long bt, int A) {
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");
            file.seek(bt);
            file.writeInt(A);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //----------Double
    public static void writeDouble(String path, long bt, double A) {
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");
            file.seek(bt);
            file.writeDouble(A);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //----------Read

    //----------String
    public static String readString(String path, long bt) {
        String tmp = "";
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");
            file.seek(bt);
            for (int i = 0; i < FIX_SIZE; i++) {
                tmp += file.readChar();
            }
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return tmp.trim();
    }

    //----------Double
    public static double readDouble(String path, long bt) {
        double tmp;
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");
            file.seek(bt);
            tmp = file.readDouble();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return tmp;
    }

    //----------Integer
    public static int readInteger(String path, long bt) {
        int tmp;
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");
            file.seek(bt);
            tmp = file.readInt();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return tmp;
    }

    //----------Length

    public static long getLength(String path) {
        long length = 0;
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");
            length = file.length();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return length;
    }

    public static void setLength(String path , long length) {

        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");
            file.setLength(length);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}