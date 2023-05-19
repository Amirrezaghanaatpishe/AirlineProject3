public class Passenger extends User {
    private double charge;
    private String path;

    private int number;

    private int tik;

    public Passenger(String id, String password, double charge, int number) {
        super(id, password);
        this.charge = charge;
        this.number = number;
        this.path = "DataBase\\PassengersTickets\\passenger" + String.valueOf(number) + ".dat";
        this.tik = 0;
        if (Tools.getLength(path) >= 108) {
            this.tik = Tools.readInteger(path, Tools.getLength(path) - 108);
        }
    }


    //----------Method

    //----------Passenger Menu
    private void menu() {
        System.out.println("*************************************\n\tPassenger MENU OPTION\n*************************************\n\t(1) Change password \n\t(2) Search flight ticket\n\t(3) Booking ticket\n\t(4) Ticket cancellation\n\t(5) Booked tickets\n\t(6) Add charge\n\t(0) Sign out");
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
            System.out.print("\nEnter 0 to return menu...\nEnter your new password again:");
            String password1 = Tools.input.next();
            if (Tools.stringCheck(password))
                return;
            if (password.equals(password1)) {
                super.password = password;
                Tools.writeString(passengerPath, 24 + (this.number * 52) , password);
                break;
            }
            Tools.cls();
            System.out.println(ColorMethods.RED_BOLD + "password didn't match try again" + ColorMethods.RESET);
        } while (true);

    }

    //----------Schedule
    private void schedule() {
        System.out.print("\nN\tID\t\tOrigin\t\tDestination\t\tDate\t\t\tTime\t\tPrice\t\tSeats");
        System.out.print("\n------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < (Tools.getLength(flightPath) / 108); i++) {
            System.out.print("\n" + Tools.readInteger(flightPath, (108 * i)) + "\t" + Tools.readString(flightPath, (4 + (108 * i))) + "\t\t" + Tools.readString(flightPath, (24 + (108 * i)))
                    + "\t\t" + Tools.readString(flightPath, (44 + (108 * i))) + "\t\t" + String.valueOf(Tools.readInteger(flightPath, (64 + (108 * i))))
                    + "\\" + String.valueOf(Tools.readInteger(flightPath, (68 + (108 * i)))) + "\\" + String.valueOf(Tools.readInteger(flightPath, (72 + (108 * i))) +
                    "\t\t\t" + Tools.readString(flightPath, (76 + (108 * i))) + "\t\t" + String.valueOf(Tools.readDouble(flightPath, (96 + (108 * i)))) + "\t\t" + String.valueOf(Tools.readInteger(flightPath, (104 + (108 * i))))));
            System.out.print("\n------------------------------------------------------------------------------------------------------------------------------");
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
        System.out.print("\nN\tID\t\tOrigin\t\tDestination\t\tDate\t\t\tTime\t\tPrice\t\tSeats");
        System.out.print("\n------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < Tools.getLength(flightPath) / 108; i++) {
            if (Tools.readString(flightPath, 24 + (108 * i)).equals(origin) && Tools.readString(flightPath, 44 + (108 * i)).equals(destination)) {
                System.out.print("\n" + Tools.readInteger(flightPath, (108 * i)) + "\t" + Tools.readString(flightPath, (4 + (108 * i))) + "\t\t" + Tools.readString(flightPath, (24 + (108 * i)))
                        + "\t\t" + Tools.readString(flightPath, (44 + (108 * i))) + "\t\t" + String.valueOf(Tools.readInteger(flightPath, (64 + (108 * i))))
                        + "\\" + String.valueOf(Tools.readInteger(flightPath, (68 + (108 * i)))) + "\\" + String.valueOf(Tools.readInteger(flightPath, (72 + (108 * i))) +
                        "\t\t\t" + Tools.readString(flightPath, (76 + (108 * i))) + "\t\t" + String.valueOf(Tools.readDouble(flightPath, (96 + (108 * i)))) + "\t\t" + String.valueOf(Tools.readInteger(flightPath, (104 + (108 * i))))));
                System.out.print("\n------------------------------------------------------------------------------------------------------------------------------");
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
        System.out.print("\nN\tID\t\tOrigin\t\tDestination\t\tDate\t\t\tTime\t\tPrice\t\tSeats");
        System.out.print("\n------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < Tools.getLength(flightPath) / 108; i++) {
            if (Tools.readString(flightPath, 24 + (108 * i)).equals(origin) && Tools.readString(flightPath, 44 + (108 * i)).equals(destination) && Tools.readInteger(flightPath, (64 + (108 * i))) == year && Tools.readInteger(flightPath, 68 + (108 * i)) == month && Tools.readInteger(flightPath, (72 + (108 * i))) == day) {
                System.out.print("\n" + Tools.readInteger(flightPath, (108 * i)) + "\t" + Tools.readString(flightPath, (4 + (108 * i))) + "\t\t" + Tools.readString(flightPath, (24 + (108 * i)))
                        + "\t\t" + Tools.readString(flightPath, (44 + (108 * i))) + "\t\t" + String.valueOf(Tools.readInteger(flightPath, (64 + (108 * i))))
                        + "\\" + String.valueOf(Tools.readInteger(flightPath, (68 + (108 * i)))) + "\\" + String.valueOf(Tools.readInteger(flightPath, (72 + (108 * i))) +
                        "\t\t\t" + Tools.readString(flightPath, (76 + (108 * i))) + "\t\t" + String.valueOf(Tools.readDouble(flightPath, (96 + (108 * i)))) + "\t\t" + String.valueOf(Tools.readInteger(flightPath, (104 + (108 * i))))));
                System.out.print("\n------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }

    //----------Booking
    private void booking() {
        schedule();
        System.out.print("\nEnter num for booking or Enter 999 to search :");
        int num = 0;
        while (true) {
            num = Tools.input.nextInt();
            if (num >= 0 && num <= Tools.getLength(flightPath) / 108 || num == 999)
                break;
            System.out.println(ColorMethods.RED_BOLD + "use correct number :" + ColorMethods.RESET);
        }
        if (Tools.integerCheck(num))
            return;
        if (num == 999) {
            searchSecond();
            System.out.print("\nEnter num for booking :");
            while (true) {
                num = Tools.input.nextInt();
                if (num >= 0 && num <= Tools.getLength(flightPath) / 108)
                    break;
                System.out.println(ColorMethods.RED_BOLD + "use correct number :" + ColorMethods.RESET);
            }
            if (Tools.integerCheck(num))
                return;
        }
        if (Tools.integerCheck(Tools.readInteger(flightPath, 104 + (108 * (num - 1))))) {
            System.out.println("Booking failed");
            return;
        }
        if (this.charge < Tools.readDouble(flightPath, 96 + (108 * (num - 1)))) {
            System.out.println("Booking failed");
            return;
        }
        Tools.writeInteger(path, Tools.getLength(path), tik + 1);
        Tools.writeString(path, Tools.getLength(path), Tools.fixStringToWrite(Tools.readString(flightPath, 4 + 108 * (num - 1))));
        Tools.writeString(path, Tools.getLength(path), Tools.fixStringToWrite(Tools.readString(flightPath, 24 + 108 * (num - 1))));
        Tools.writeString(path, Tools.getLength(path), Tools.fixStringToWrite(Tools.readString(flightPath, 44 + 108 * (num - 1))));
        Tools.writeInteger(path, Tools.getLength(path), Tools.readInteger(flightPath, 64 + 108 * (num - 1)));
        Tools.writeInteger(path, Tools.getLength(path), Tools.readInteger(flightPath, 68 + 108 * (num - 1)));
        Tools.writeInteger(path, Tools.getLength(path), Tools.readInteger(flightPath, 72 + 108 * (num - 1)));
        Tools.writeString(path, Tools.getLength(path), Tools.fixStringToWrite(Tools.readString(flightPath, 76 + 108 * (num - 1))));
        Tools.writeDouble(path, Tools.getLength(path), Tools.readDouble(flightPath, 96 + 108 * (num - 1)));
        Tools.writeInteger(flightPath, 104 + (108 * (num - 1)), Tools.readInteger(flightPath, 104 + 108 * (num - 1)) - 1);
        Tools.writeInteger(path, Tools.getLength(path), Tools.readInteger(flightPath, 104 + 108 * (num - 1)));
        this.charge = this.charge - Tools.readDouble(flightPath, 96 + 108 * (num - 1));
        Tools.writeDouble(passengerPath, 44 + (this.number * 52), (this.charge));
        System.out.println(ColorMethods.GREEN_BOLD_BRIGHT + "Done..." + ColorMethods.RESET);
        tik++;
    }

    //----------Booked
    private void bookedSchedule() {
        System.out.print("\nN\tID\t\tOrigin\t\tDestination\t\tDate\t\t\tTime\t\tPrice\t\tSeats");
        System.out.print("\n------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < (Tools.getLength(path) / 108); i++) {
            System.out.print("\n" + Tools.readInteger(path, (108 * i)) + "\t" + Tools.readString(path, (4 + (108 * i))) + "\t\t" + Tools.readString(path, (24 + (108 * i)))
                    + "\t\t" + Tools.readString(path, (44 + (108 * i))) + "\t\t" + String.valueOf(Tools.readInteger(path, (64 + (108 * i))))
                    + "\\" + String.valueOf(Tools.readInteger(path, (68 + (108 * i)))) + "\\" + String.valueOf(Tools.readInteger(path, (72 + (108 * i))) +
                    "\t\t\t" + Tools.readString(path, (76 + (108 * i))) + "\t\t" + String.valueOf(Tools.readDouble(path, (96 + (108 * i)))) + "\t\t" + String.valueOf(Tools.readInteger(path, (104 + (108 * i))))));
            System.out.print("\n------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    //----------Cancel
    private void cancel() {
        bookedSchedule();
        System.out.print("\nEnter num ticket :");
        int num;
        while (true) {
            num = Tools.input.nextInt();
            if (num >= 0 && num <= Tools.getLength(path) / 108)
                break;
            System.out.println(ColorMethods.RED_BOLD + "use correct number :" + ColorMethods.RESET);
        }
        if (Tools.integerCheck(num))
            return;

        for (int i = 0; i < Tools.getLength(flightPath) / 108; i++) {
            if (Tools.readString(path, 4 + ((num - 1) * 108)).equals(Tools.readString(flightPath, 4 + i * 108)) && Tools.readInteger(path, 72 + ((num - 1) * 108)) == Tools.readInteger(flightPath, 72 + i * 108) && Tools.readString(path, 76 + 108 * (num  - 1)).equals(Tools.readString(flightPath, 76 + 108 * i))) {
                Tools.writeInteger(flightPath, 104 + 108 * i, Tools.readInteger(flightPath, 104 + 108 * i) + 1);
                break;
            }
        }
        this.charge += Tools.readDouble(path , 96 + (num-1) * 108);
        Tools.writeDouble(passengerPath, 44 + this.number * 52, this.charge);

        if ((Tools.getLength(path) / 108 )== num){
            Tools.setLength(path , Tools.getLength(path) - 108);
            tik--;
            return;
        }
        for (int i = num; i < Tools.getLength(path) / 108; i++) {
            Tools.writeString(path, 4 + (i - 1) * 108, Tools.fixStringToWrite(Tools.readString(path, 4 + i * 108)));
            Tools.writeString(path, 24 + (i - 1) * 108, Tools.fixStringToWrite(Tools.readString(path, 24 + i * 108)));
            Tools.writeString(path, 44 + (i - 1) * 108, Tools.fixStringToWrite(Tools.readString(path, 44 + i * 108)));
            Tools.writeInteger(path, 64 + (i - 1) * 108, Tools.readInteger(path, 64 + i * 108));
            Tools.writeInteger(path, 68 + (i - 1) * 108, Tools.readInteger(path, 68 + i * 108));
            Tools.writeInteger(path, 72 + (i - 1) * 108, Tools.readInteger(path, 72 + i * 108));
            Tools.writeString(path, 76 + (i - 1) * 108, Tools.fixStringToWrite(Tools.readString(path, 76 + i * 108)));
            Tools.writeDouble(path, 96 + (i - 1) * 108, Tools.readDouble(path, 96 + i * 108));
            Tools.writeInteger(path, 104 + (i - 1) * 108, Tools.readInteger(path, 104 + i * 108));
            Tools.writeDouble(passengerPath, 44 + this.number * 52, this.charge);
        }
        Tools.setLength(path , Tools.getLength(path) - 108);
        tik--;
    }

    //----------charge
    private void chargeUser() {
        Tools.cls();
        System.out.print("your charge is :" + this.charge + "\nEnter charge do you want : ");
        double charge = Tools.input.nextDouble();
        if (Tools.doubleCheck(charge))
            return;
        this.charge += charge;
        Tools.writeDouble(passengerPath, 44 + this.number * 52, this.charge);
        System.out.println(ColorMethods.GREEN_BOLD_BRIGHT + "Done..." + ColorMethods.RESET);
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
                    Tools.cls();
                    searchFlight();
                    break;
                case 3:
                    Tools.cls();
                    booking();
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
                    Tools.cls();
                    cancel();
                    System.out.println(ColorMethods.GREEN_BOLD_BRIGHT + "Done..." + ColorMethods.RESET);
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 5:
                    Tools.cls();
                    bookedSchedule();
                    System.out.print("\nEnter any char to return :");
                    Tools.input.next();
                    break;
                case 6:
                    chargeUser();
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