public class Admin extends AirLine{
    //----------Admin Menu
    private void menu() {
        System.out.println("*************************\n\tADMIN MENU OPTION\n*************************\n\t(1) Add \n\t(2) Update\n\t(3) Remove\n\t(4) Flight Schedules\n\t(0) Sign out");
    }

    private int adminMenu() {
        Tools.cls();
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
                default:
                    Tools.cls();
                    menu();
                    System.out.println(ColorMethods.RED_BOLD + "Please use The correct Number..." + ColorMethods.RESET);
                    num = Tools.input.nextInt();
            }
        } while (num < 0 || num > 4);
        return 0;
    }

    //----------add flight
    public void addFlight(){
        Tools.cls();
        System.out.print("Origin :");
        String A1 = Tools.input.next();
        System.out.print("Destination :");
        String A2 = Tools.input.next();
        Tools.cls();
        System.out.print(ColorMethods.CYAN_BOLD_BRIGHT +"---Date---"+ ColorMethods.RESET);
        System.out.print("\nYear :");
        int A3 = Tools.input.nextInt();
        System.out.print("Month :");
        int A4 = Tools.input.nextInt();
        System.out.print("Day :");
        int A5 = Tools.input.nextInt();
        Tools.cls();
        System.out.print(ColorMethods.CYAN_BOLD_BRIGHT +"---Time---"+ ColorMethods.RESET);
        System.out.print("\nHour :");
        int a1 = Tools.input.nextInt();
        System.out.print("Minute :");
        int a2 = Tools.input.nextInt();
        String A6 = String.valueOf(a1) + ":" +String.valueOf(a2);
        Tools.cls();
        System.out.print("Price :");
        double A7 = Tools.input.nextDouble();
        System.out.print("Number of seats :");
        int A9 = Tools.input.nextInt();
        String A8 = String.valueOf(A1.charAt(0)) + String.valueOf(A2.charAt(0)) + String.valueOf(A3).substring(2 , 4) + String.valueOf(A4);
        Flight flight = new Flight(A8 , A1 , A2 , A3 , A4 , A5, A6 , A7 , A9);
        Tools.cls();
        System.out.println(ColorMethods.GREEN_BOLD_BRIGHT+"Done..."+ColorMethods.RESET);
    }
    public void adminTask() {
        int num = 0;
        do {
            num = adminMenu();
            switch (num) {
                case 1:
                    addFlight();
                    break;
                case 2:
                    Tools.input.nextInt();
                    break ;
                case 3:
                    Tools.input.nextInt();
                    break ;
                case 4:
                    Tools.input.nextInt();
                    break ;
                default:
                    break;
            }
        } while (num != 0);
    }
}
