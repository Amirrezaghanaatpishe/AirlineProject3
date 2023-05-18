
public class Admin extends User {
    private int tik ;
    public Admin(String id, String password) {
        super(id, password);
        this.tik = 0;
        if (Tools.getLength(flightPath) >= 108) {
            this.tik = Tools.readInteger(flightPath, Tools.getLength(flightPath) - 108);
        }
    }

    //----------Methods

    //----------Menu

    //----------Admin Menu
    private void menu() {
        System.out.println("*************************\n\tADMIN MENU OPTION\n*************************\n\t(1) Add \n\t(2) Update\n\t(3) Remove\n\t(4) Flight Schedule\n\t(0) Sign out");
    }

    private int adminMenu() {
        Tools.cls();
        int num;
        menu();
        do {
            num = Tools.input.nextInt();
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
                default:
                    Tools.cls();
                    menu();
                    System.out.println(ColorMethods.RED_BOLD + "Please use The correct Number..." + ColorMethods.RESET);
            }
        } while (num < 0 || num > 4);
        return 0;
    }

    //----------Update Menu
    private void updateMenu() {
        System.out.println("*************************\n\tUPDATE MENU OPTION\n*************************\n\t(1) Origin\n\t(2) Destination\n\t(3) Date\n\t(4) Time\n\t(5) Price\n\t(6) Seats\n\t(7) Update all\n\t(0) EXIT");
    }

    //----------Add Airline
    private void addFlight() {
        Tools.cls();
        System.out.print("Origin :");
        String A1 = Tools.input.next();
        if (Tools.stringCheck(A1))
            return;
        System.out.print("Destination :");
        String A2 = Tools.input.next();
        if (Tools.stringCheck(A2))
            return;
        int A3;
        Tools.cls();
        do {
            System.out.print(ColorMethods.CYAN_BOLD_BRIGHT + "---Date---" + ColorMethods.RESET);
            System.out.print("\nYear :");
            A3 = Tools.input.nextInt();
            if (A3 >= 1000)
                break;
            Tools.cls();
            System.out.println(ColorMethods.RED_BOLD + "Please use The correct Number..." + ColorMethods.RESET);
        } while (true);
        if (Tools.integerCheck(A3))
            return;
        System.out.print("Month :");
        int A4 = Tools.input.nextInt();
        if (Tools.integerCheck(A4))
            return;
        System.out.print("Day :");
        int A5 = Tools.input.nextInt();
        if (Tools.integerCheck(A5))
            return;
        Tools.cls();
        System.out.print(ColorMethods.CYAN_BOLD_BRIGHT + "---Time---" + ColorMethods.RESET);
        System.out.print("\nHour :");
        int a1 = Tools.input.nextInt();
        if (Tools.integerCheck(a1))
            return;
        System.out.print("Minute :");
        int a2 = Tools.input.nextInt();
        if (Tools.integerCheck(a2))
            return;
        String A6 = String.valueOf(a1) + ":" + String.valueOf(a2);
        Tools.cls();
        System.out.print("Price :");
        double A7 = Tools.input.nextDouble();
        if (Tools.doubleCheck(A7))
            return;
        System.out.print("Number of seats :");
        int A9 = Tools.input.nextInt();
        if (Tools.integerCheck(A9))
            return;
        int num = tik + 1;
        String A8 = String.valueOf(A1.charAt(0)).toUpperCase() + String.valueOf(A2.charAt(0)).toUpperCase() + String.valueOf(A3).substring(2, 4) + String.valueOf(A4);
        Flight flight = new Flight(A8, A1, A2, A3, A4, A5, A6, A7, A9, flightPath, num);
        flights.add(flight);
        Tools.cls();
        System.out.println(ColorMethods.GREEN_BOLD_BRIGHT + "Done..." + ColorMethods.RESET);
        tik++;
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

    //----------Update
    private void update() {
        int num = 0;
        int N = 0;
        do {
            do {
                schedule();
                System.out.print("\nEnter number of flight which you want to edit :");
                N = Tools.input.nextInt();
                if (Tools.integerCheck(N))
                    return;
                if (N <= Tools.getLength(flightPath) / 108 && N > 0)
                    break;
                Tools.cls();
                System.out.println(ColorMethods.RED_BOLD + "Please use The correct Number..." + ColorMethods.RESET);
            } while (true);
            do {
                updateMenu();
                num = Tools.input.nextInt();
                switch (num) {
                    case 0:
                        break;
                    case 1:
                        updateOrigin(N);
                        continue;
                    case 2:
                        updateDestination(N);
                        continue;
                    case 3:
                        updateDate(N);
                        continue;
                    case 4:
                        updateTime(N);
                        continue;
                    case 5:
                        updatePrice(N);
                        continue;
                    case 6:
                        updateSeat(N);
                        continue;
                    case 7:
                        updateOrigin(N);
                        updateDestination(N);
                        updateDate(N);
                        updateTime(N);
                        updatePrice(N);
                        updateSeat(N);
                        break;
                    default:
                        Tools.cls();
                        System.out.println(ColorMethods.RED_BOLD + "Please use The correct Number..." + ColorMethods.RESET);

                }
            } while (num != 0);
        } while (true);
    }

    private void updateOrigin(int num) {
        Tools.cls();
        System.out.print("Enter new origin:");
        String origin = Tools.input.next();
        if (Tools.stringCheck(origin))
            return;
        Tools.writeString(flightPath, (24 + (108 * (num - 1))), Tools.fixStringToWrite(origin));
        Tools.writeString(flightPath, (4 + (108 * (num - 1))), Tools.fixStringToWrite(String.valueOf(origin.charAt(0)).toUpperCase() + Tools.readString(flightPath, 4 + (108 * (num - 1))).substring(1, Tools.readString(flightPath, 4 + (108 * (num - 1))).length())));
    }

    private void updateDestination(int num) {
        Tools.cls();
        System.out.print("Enter new destination");
        String destination = Tools.input.next();
        if (Tools.stringCheck(destination))
            return;
        Tools.writeString(flightPath, (44 + (108 * (num - 1))), Tools.fixStringToWrite(destination));
        Tools.writeString(flightPath, (4 + (108 * (num - 1))), Tools.fixStringToWrite(String.valueOf(Tools.readString(flightPath, 4 + (108 * (num - 1))).charAt(0)) + String.valueOf(destination.charAt(0)).toUpperCase() + Tools.readString(flightPath, 4 + (108 * (num - 1))).substring(2, Tools.readString(flightPath, 4 + (108 * (num - 1))).length())));
    }

    private void updateDate(int num) {
        Tools.cls();
        int year;
        do {
            System.out.print("Enter new year :");
            year = Tools.input.nextInt();
            if (year >= 1000)
                break;
            Tools.cls();
            System.out.println(ColorMethods.RED_BOLD + "Please use The correct Number..." + ColorMethods.RESET);
        } while (true);
        if (Tools.integerCheck(year))
            return;
        System.out.print("\nEnter new month :");
        int month = Tools.input.nextInt();
        if (Tools.integerCheck(month))
            return;
        System.out.print("\nEnter new day :");
        int day = Tools.input.nextInt();
        if (Tools.integerCheck(day))
            return;
        Tools.writeInteger(flightPath, (64 + ((num - 1) * 108)), year);
        Tools.writeInteger(flightPath, (68 + ((num - 1) * 108)), month);
        Tools.writeInteger(flightPath, (72 + ((num - 1) * 108)), day);
        Tools.writeString(flightPath, (4 + ((num - 1) * 108)), Tools.fixStringToWrite(Tools.readString(flightPath, (4 + ((num - 1) * 108))).substring(0, 2) + String.valueOf(year).substring(2, 4) + String.valueOf(month)));
    }

    private void updateTime(int num) {
        Tools.cls();
        System.out.print("Enter new hour :");
        int hour = Tools.input.nextInt();
        if (Tools.integerCheck(hour))
            return;
        System.out.print("\nEnter new minute :");
        int minute = Tools.input.nextInt();
        if (Tools.integerCheck(minute))
            return;
        String time = String.valueOf(hour) + ":" + String.valueOf(minute);
        Tools.writeString(flightPath, (76 + ((num - 1) * 108)), Tools.fixStringToWrite(time));
    }

    private void updatePrice(int num) {
        Tools.cls();
        System.out.print("Enter new price :");
        int price = Tools.input.nextInt();
        if (Tools.integerCheck(price))
            return;
        Tools.writeDouble(flightPath, (96 + (108 * (num - 1))), price);
    }

    private void updateSeat(int num) {
        Tools.cls();
        System.out.print("Enter new seats :");
        int seat = Tools.input.nextInt();
        if (Tools.integerCheck(seat))
            return;
        Tools.writeInteger(flightPath, (104 + ((num - 1) * 108)), seat);
    }

    //----------REMOVE
    private void remove() {
        int N;
        do {
            do {
                schedule();
                System.out.print("\nEnter number of flight which you want to remove :");
                N = Tools.input.nextInt();
                if (Tools.integerCheck(N))
                    return;
                if (N <= Tools.getLength(flightPath) && N > 0)
                    break;
                Tools.cls();
                System.out.println(ColorMethods.RED_BOLD + "Please use The correct Number..." + ColorMethods.RESET);
            } while (true);
//            Tools.cls();
//            if (Account.checker(flights.get(N).getFlightId(), flights.get(N).getDay(), flights.get(N).getTime())) {
//                System.out.println("You can't remove this flight");
//                return;
//            }
            System.out.println("Are you sure???\n\t(1) Yes \n\t(2) No");
            int num;
            do {
                num = Tools.input.nextInt();
                if (num == 1 || num == 2)
                    break;
                System.out.println(ColorMethods.RED_BOLD + "Please use The correct Number..." + ColorMethods.RESET);
            } while (true);
            if (num == 1) {
                if ((Tools.getLength(flightPath) / 108 )== num) {
                    Tools.setLength(flightPath, Tools.getLength(flightPath) - 108);
                    tik--;
                    return;
                }
                for (int i = N; i < Tools.getLength(flightPath) / 108; i++) {
                    Tools.writeString(flightPath, 4 + (i - 1) * 108, Tools.fixStringToWrite(Tools.readString(flightPath, 4 + i * 108)));
                    Tools.writeString(flightPath, 24 + (i - 1) * 108, Tools.fixStringToWrite(Tools.readString(flightPath, 24 + i * 108)));
                    Tools.writeString(flightPath, 44 + (i - 1) * 108, Tools.fixStringToWrite(Tools.readString(flightPath, 44 + i * 108)));
                    Tools.writeInteger(flightPath, 64 + (i - 1) * 108, Tools.readInteger(flightPath, 64 + i * 108));
                    Tools.writeInteger(flightPath, 68 + (i - 1) * 108, Tools.readInteger(flightPath, 68 + i * 108));
                    Tools.writeInteger(flightPath, 72 + (i - 1) * 108, Tools.readInteger(flightPath, 72 + i * 108));
                    Tools.writeString(flightPath, 76 + (i - 1) * 108, Tools.fixStringToWrite(Tools.readString(flightPath, 76 + i * 108)));
                    Tools.writeDouble(flightPath, 96 + (i - 1) * 108, Tools.readDouble(flightPath, 96 + i * 108));
                    Tools.writeInteger(flightPath, 104 + (i - 1) * 108, Tools.readInteger(flightPath, 104 + i * 108));
                }
            }
            Tools.setLength(flightPath , Tools.getLength(flightPath) - 108);
            tik--;
        } while (true);

    }

    //----------Admin main
    public void adminTask() {
        int num = 0;
        do {
            num = adminMenu();
            switch (num) {
                case 1:
                    addFlight();
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    remove();
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
                    schedule();
                    System.out.println("\nEnter any char to return");
                    Tools.input.next();
                    break;
                default:
                    break;
            }
        } while (num != 0);
    }


}