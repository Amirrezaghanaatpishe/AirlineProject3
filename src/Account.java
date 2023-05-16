import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Account {
    private static ArrayList<Admin> admins = new ArrayList<>();
    private static ArrayList<Passenger> passengers = new ArrayList<>();
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
    private void signIn() {
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
            if (admins.get(0).getId().equals(username) && admins.get(0).getPassword().equals(password)) {
                Admin admin = admins.get(0);
                admin.adminTask();
                admins.set(0, admin);
                return;
            }
            for (int i = 0; i < passengers.size(); i++) {
                if (passengers.get(i).getId().equals(username) && (passengers.get(i).getPassword().equals(password))) {
                    Passenger passenger = passengers.get(i);
                    passenger.passengerTask();
                    passengers.set(i, passenger);
                    return;
                }
            }
            Tools.cls();
            System.out.println(ColorMethods.RED_BOLD + "User name or password is incorrect" + ColorMethods.RESET);
        } while (true);

    }

    //----------Sign Up
    private void signUp() {
        Tools.cls();
        System.out.print("Enter username :");
        int flag;
        String userName;
        do {
            flag = 1;
            userName = Tools.input.next();
            if (Tools.stringCheck(userName))
                return;
            for (int i = 0; i < passengers.size(); i++) {
                if (passengers.get(i).getId().equals(userName)) {
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
        Passenger passenger = new Passenger(userName, password);
        passengers.add(passenger);
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
                    signIn();
                    break;
                case 2:
                    signUp();
                    break;
                default:
                    break;
            }
        } while (true);
    }

    //----------Check
    public static boolean checker(String flightId, int day, String time) {
        for (int i = 0; i < passengers.size(); i++) {
            for (int j = 0; j < passengers.get(i).getTickets().size(); j++) {

                return passengers.get(i).getTickets().get(i).getFlightId().equals(flightId) && passengers.get(i).getTickets().get(i).getDay() == day && passengers.get(i).getTickets().get(i).getTime().equals(time);

            }
        }
        return 0 == 1;
    }
}
