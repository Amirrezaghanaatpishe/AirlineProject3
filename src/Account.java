import java.io.FileNotFoundException;
import java.io.RandomAccessFile;


public class Account {
    private final Admin ADMIN = new Admin("admin", "admin");
    private Passenger passenger;
    final String path = "DataBase\\Passengers.dat";


    //----------Methods

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
            if (ADMIN.getId().equals(username) && ADMIN.getPassword().equals(password)) {
                ADMIN.adminTask();
                return;
            }
            for (int i = 0; i < (Tools.getLength(path) / 52); i++) {
                if (Tools.readString(path, 4 + (i * 52)).equals(username) && (Tools.readString(path, 24 + (i * 52)).equals(password))) {
                    passenger = new Passenger(username, password, Tools.readDouble(path, 44 + (i * 52)), Tools.readInteger(path, 52 * i));
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
    private void signUp() {
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
            for (int i = 0; i < (Tools.getLength(path) / 52); i++) {

                if (Tools.readString(path, 4 + (52 * i)).equals(userName)) {
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
        int number = Tools.readInteger(path, (int) (Tools.getLength(path) - 52));
        Tools.writeInteger(path, Tools.getLength(path), number + 1);
        Tools.writeString(path, (Tools.getLength(path)), Tools.fixStringToWrite(userName));
        Tools.writeString(path, (Tools.getLength(path)), Tools.fixStringToWrite(password));
        Tools.writeDouble(path, (Tools.getLength(path)), 0);
        String fileName = "DataBase\\PassengersTickets\\passenger" + String.valueOf(number + 1) + ".dat";
        try {
            new RandomAccessFile(fileName, "rw");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
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