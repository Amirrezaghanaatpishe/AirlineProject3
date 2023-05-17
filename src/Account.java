import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class Account {
    private final Admin ADMIN = new Admin("admin", "admin");
    private Passenger passenger ;
    private static RandomAccessFile passengerFile;
    final int FIX_SIZE = 10;

    public Account() {
        try {
            passengerFile = new RandomAccessFile("DataBase\\Passengers.dat", "rw");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    //----------Methods

    //----------File
    //----------Close
    private void closeFile() {
        try {
            passengerFile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //----------Fix String
    private String fixStringToWrite(String str) {
        while (str.length() < FIX_SIZE)
            str += " "; //read StringBuilder class for better performance
        return str.substring(0, FIX_SIZE);
    }

    //----------Read String
    private String readString(int bt) {
        String tmp = "";
        try {
            passengerFile.seek(bt);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < FIX_SIZE; i++) {
            try {
                tmp += passengerFile.readChar();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tmp.trim();
    }

    //----------Menu
    private void menu() {
        System.out.println("********************************************\n\tWELCOME TO AIRLINE RESERVATION SYSTEM\n********************************************\n\t(1) Sign in\n\t(2) Sign up\n\t(0) Exit");
    }

    private int signMenu() {
        int num;
        menu();
        num = Tools.input.nextInt();
        do {
            switch (num) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                default:
                    Tools.cls();
                    menu();
                    System.out.println(ColorMethods.RED_BOLD + "Please use The correct Number..." + ColorMethods.RESET);
                    num = Tools.input.nextInt();
            }
        } while (num < 0 && num > 2);
        return 0;
    }

    //----------Sign In
    private void signIn() throws IOException {
        Tools.cls();
        do {
            System.out.print("\nEnter username :");
            String username = Tools.input.next();
            if (Tools.stringCheck(username))
                return;
            System.out.print("\nEnter password :");
            String password = Tools.input.next();
            if (Tools.stringCheck(password))
                return;
            if (ADMIN.getId().equals(username) && ADMIN.getPassword().equals(password)) {
                ADMIN.adminTask();
                return;
            }
            for (int i = 0; i < (passengerFile.length() / 52); i++) {
                if (readString(4 + (i * 52)).equals(username) && (readString(24 + (i * 52)).equals(password))) {
                    passenger = new Passenger(username , password);
                    passenger.passengerTask();
                    passenger = null;
                    return;
                }
            }
            Tools.cls();
            System.out.println(ColorMethods.RED_BOLD + "User name or password is incorrect" + ColorMethods.RESET);
        } while (true);

    }

    //----------Sign Up
    private void signUp() throws IOException {
        Tools.cls();
        System.out.print("Enter username (your username must be less than ten char) :");
        int flag;
        String userName;
        do {
            flag = 1;
            userName = Tools.input.next();
            if (userName.length() > 10) {
                Tools.cls();
                System.out.print(ColorMethods.RED_BOLD + "Use another name :" + ColorMethods.RESET);
                flag = 0;
            }
            if (Tools.stringCheck(userName))
                return;
            for (int i = 0; i < (passengerFile.length() / 52); i++) {

                if (readString(4 + (52 * i)).equals(userName)) {
                    Tools.cls();
                    System.out.print(ColorMethods.RED_BOLD + "Use another name :" + ColorMethods.RESET);
                    flag = 0;
                    break;
                }
            }
        } while (flag != 1);
        System.out.print("\nEnter password :");
        String password = Tools.input.next();
        if (Tools.stringCheck(password))
            return;
        passengerFile.seek(passengerFile.length() - 52);
        int number = passengerFile.readInt();
        passengerFile.seek(passengerFile.length());
        passengerFile.writeInt(number + 1);
        passengerFile.writeChars(fixStringToWrite(userName));
        passengerFile.writeChars(fixStringToWrite(password));
        passengerFile.writeDouble(0);
        String fileName = "DataBase\\PassengersTickets\\passenger" + String.valueOf(number + 1) + ".dat";
        RandomAccessFile ticket = new RandomAccessFile(fileName, "rw");
    }

    //----------Sign
    public void firstMenu() {
        int num;
        do {
            Tools.cls();
            num = signMenu();
            switch (num) {
                case 0:
                    return;
                case 1:
                    try {
                        signIn();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    try {
                        signUp();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    break;
            }
        } while (true);
    }

    //----------Check
    public static boolean checker(String flightId, int day, String time) {
//        for (int i = 0; i < passengers.size(); i++) {
//            for (int j = 0; j < passengers.get(i).getTickets().size(); j++) {
//
//                return passengers.get(i).getTickets().get(i).getFlightId().equals(flightId) && passengers.get(i).getTickets().get(i).getDay() == day && passengers.get(i).getTickets().get(i).getTime().equals(time);
//
//            }
//        }
        return 0 == 1;
    }
}