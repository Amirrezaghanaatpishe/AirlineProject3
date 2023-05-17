import java.util.ArrayList;

public class Passenger extends User {
    private double charge;
    private ArrayList<Flight> tickets = new ArrayList<Flight>();
    private String path;

    public Passenger(String id, String password, double charge, int number) {
        super(id, password);
        this.charge = charge;
        this.path = "DataBase\\PassengersTickets\\passenger" + String.valueOf(number) + ".dat";
    }

    public ArrayList<Flight> getTickets() {
        return tickets;
    }

    //----------Method

    //----------Passenger Menu
    private void menu() {
        System.out.println("*****************************\n\tPassenger MENU OPTION\n*****************************\n\t(1) Change password \n\t(2) Search flight ticket\n\t(3) Booking ticket\n\t(4) Ticket cancellation\n\t(5) Booked tickets\n\t(6) Add charge\n\t(0) Sign out");
    }

    private int passengerMenu() {
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
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                default:
                    Tools.cls();
                    menu();
                    System.out.println(ColorMethods.RED_BOLD + "Please use The correct Number..." + ColorMethods.RESET);
                    num = Tools.input.nextInt();
            }
        } while (num < 0 || num > 6);
        return 0;
    }

    private void searchMenu() {
        System.out.print("\n" + ColorMethods.GREEN_BOLD + "\t-----Search Menu-----" + ColorMethods.RESET + "\n\t(1) By origin and destination\n\t(2) By origin and destination and date \n\t(0) Exit search\n");
    }

    //----------Change Password
    private void changePassword() {
        Tools.cls();
        do {
            System.out.print("Enter your old password :");
            String password = Tools.input.next();
            if (Tools.stringCheck(password))
                return;
            if (password.equals(super.password))
                break;
        } while (true);
        Tools.cls();
        do {
            System.out.print("Enter 0 to return menu...\nEnter your new password :");
            String password = Tools.input.next();
            if (Tools.stringCheck(password))
                return;
            System.out.println("Enter 0 to return menu...\nEnter your new password again:");
            String password1 = Tools.input.next();
            if (Tools.stringCheck(password))
                return;
            if (password.equals(password1)) {
                super.password = password;
                System.out.println("Done");
                break;
            }
            Tools.cls();
            System.out.println(ColorMethods.RED_BOLD + "password didn't match try again" + ColorMethods.RESET);
        } while (true);

    }

    //----------Schedule
    private void schedule() {
        System.out.print("\nN\tID\t\tOrigin\t\tDestination\t\tDate\t\t\tTime\t\tPrice\t\tSeats");
        System.out.print("\n--------------------------------------------------------------------------------------");
        for (int i = 0; i < (Tools.getLength(flightPath) / 108); i++) {
            System.out.print("\n" + Tools.readInteger(flightPath, (108 * i)) + "\t" + Tools.readString(flightPath, (4 + (108 * i))) + "\t" + Tools.readString(flightPath, (24 + (108 * i)))
                    + "\t\t" + Tools.readString(flightPath, (44 + (108 * i))) + "\t\t\t" + String.valueOf(Tools.readInteger(flightPath, (64 + (108 * i))))
                    + "\\" + String.valueOf(Tools.readInteger(flightPath, (68 + (108 * i)))) + "\\" + String.valueOf(Tools.readInteger(flightPath, (72 + (108 * i))) +
                    "\t\t" + Tools.readString(flightPath, (76 + (108 * i))) + "\t\t" + String.valueOf(Tools.readDouble(flightPath, (96 + (108 * i)))) + "\t\t" + String.valueOf(Tools.readInteger(flightPath, (104 + (108 * i))))));
            System.out.print("\n--------------------------------------------------------------------------------------");
        }
    }

    //----------Search
    private void searchFlight() {
        Tools.cls();
        schedule();
        searchMenu();
        int num;
        do {
            num = Tools.input.nextInt();
            switch (num) {
                case 0:
                    return;
                case 1:
                    searchFirst();
                    System.out.println("\nEnter any thing to continue");
                    Tools.input.next();
                    Tools.cls();
                    schedule();
                    searchMenu();
                    break;
                case 2:
                    searchSecond();
                    System.out.println("\nEnter any thing to continue");
                    Tools.input.next();
                    Tools.cls();
                    schedule();
                    searchMenu();
                    break;
                default:
                    Tools.cls();
                    schedule();
                    searchMenu();
                    System.out.println(ColorMethods.RED_BOLD + "Please use The correct Number..." + ColorMethods.RESET);
                    num = Tools.input.nextInt();
            }
        } while (true);
    }

    private void searchFirst() {
        Tools.cls();
        System.out.print("Origin :");
        String origin = Tools.input.next();
        if (Tools.stringCheck(origin))
            return;
        System.out.print("\nDestination :");
        String destination = Tools.input.next();
        if (Tools.stringCheck(destination))
            return;
        int j = flights.size();
        System.out.print("\nN\tID\t\tOrigin\t\tDestination\t\tDate\t\t\tTime\t\tPrice\t\tSeats");
        System.out.print("\n--------------------------------------------------------------------------------------");
        for (int i = 0; i < j; i++) {
            if (flights.get(i).getOrigin().equals(origin) && flights.get(i).getDestination().equals(destination)) {
                System.out.print("\n" + (i + 1) + "\t" + flights.get(i).toString());
                System.out.print("\n--------------------------------------------------------------------------------------");
            }
        }
    }

    private void searchSecond() {
        Tools.cls();
        System.out.print("Origin :");
        String origin = Tools.input.next();
        if (Tools.stringCheck(origin))
            return;
        System.out.print("\nDestination :");
        String destination = Tools.input.next();
        if (Tools.stringCheck(destination))
            return;
        System.out.print("\nYear :");
        int year = Tools.input.nextInt();
        if (Tools.integerCheck(year))
            return;
        System.out.print("\nMonth :");
        int month = Tools.input.nextInt();
        if (Tools.integerCheck(month))
            return;
        System.out.print("\nDay :");
        int day = Tools.input.nextInt();
        if (Tools.integerCheck(day))
            return;
        int j = flights.size();
        System.out.print("\nN\tID\t\tOrigin\t\tDestination\t\tDate\t\t\tTime\t\tPrice\t\tSeats");
        System.out.print("\n--------------------------------------------------------------------------------------");
        for (int i = 0; i < j; i++) {
            if (flights.get(i).getOrigin().equals(origin) && flights.get(i).getDestination().equals(destination) && flights.get(i).getYear() == year && flights.get(i).getMonth() == month && flights.get(i).getDay() == day) {
                System.out.print("\n" + (i + 1) + "\t" + flights.get(i).toString());
                System.out.print("\n--------------------------------------------------------------------------------------");
            }
        }
    }

    //----------Booking
    private void booking() {
        schedule();
        System.out.print("\nEnter num for booking or Enter 999 to search :");
        int num = Tools.input.nextInt();
        if (Tools.integerCheck(num))
            return;
        if (num == 999) {
            searchSecond();
            System.out.println("Enter num for booking");
            num = Tools.input.nextInt();
            if (Tools.integerCheck(num))
                return;
        }
        if (Tools.integerCheck(flights.get(num - 1).getSeat())) {
            System.out.println("Booking failed");
            return;
        }
        if (this.charge < flights.get(num - 1).getPrice()) {
            System.out.println("Booking failed");
            return;
        }
        tickets.add(flights.get(num - 1));
        this.charge -= tickets.get(num - 1).getPrice();
        Flight flight = flights.get(num - 1);
        flight.setSeat((flight.getSeat() - 1));
        flights.set(num - 1, flight);
    }

    //----------Booked
    private void bookedSchedule() {
        int j = tickets.size();
        System.out.print("\nN\tID\t\tOrigin\t\tDestination\t\tDate\t\t\tTime\t\tPrice\t\tSeats");
        System.out.print("\n--------------------------------------------------------------------------------------");
        for (int i = 0; i < j; i++) {
            System.out.print("\n" + (i + 1) + "\t" + tickets.get(i).toString());
            System.out.print("\n--------------------------------------------------------------------------------------");
        }
    }

    //----------Cancel
    private void cancel() {
        bookedSchedule();
        System.out.print("\nEnter num ticket");
        int num = Tools.input.nextInt();
        if (Tools.integerCheck(num))
            return;
        this.charge += tickets.get(num - 1).getPrice();
        for (int i = 0; i < flights.size(); i++) {
            Flight flight = tickets.get(num - 1);
            if (flights.get(i).getFlightId().equals(flight.getFlightId()) && flights.get(i).getDay() == flight.getDay() && flights.get(i).getTime().equals(flight.getTime())) {
                flight = flights.get(i);
                flight.setSeat(flight.getSeat() + 1);
                flights.set(i, flight);
                break;
            }
        }
        tickets.remove(num - 1);
    }

    //----------charge
    private void chargeUser() {
        Tools.cls();
        System.out.print("your charge is :" + this.charge + "\nEnter charge dp you want : ");
        double charge = Tools.input.nextDouble();
        if (Tools.doubleCheck(charge))
            return;
        this.charge += charge;

    }

    public void passengerTask() {
        int num;
        do {
            Tools.cls();
            num = passengerMenu();
            switch (num) {
                case 1:
                    changePassword();
                    System.out.println(ColorMethods.GREEN_BOLD_BRIGHT + "Done..." + ColorMethods.RESET);
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    searchFlight();
                    break;
                case 3:
                    booking();
                    System.out.println(ColorMethods.GREEN_BOLD_BRIGHT + "Done..." + ColorMethods.RESET);
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
                    cancel();
                    System.out.println(ColorMethods.GREEN_BOLD_BRIGHT + "Done..." + ColorMethods.RESET);
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 5:
                    bookedSchedule();
                    System.out.println("\nEnter any char to return");
                    Tools.input.next();
                    break;
                case 6:
                    chargeUser();
                    System.out.println(ColorMethods.GREEN_BOLD_BRIGHT + "Done..." + ColorMethods.RESET);
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    break;
            }
        } while (num != 0);
    }
}