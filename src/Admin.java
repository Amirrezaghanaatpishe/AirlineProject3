public class Admin {
    //Admin Menu
    private void menu() {
        System.out.println("*************************\n\tADMIN MENU OPTION\n*************************\n\t(1) Add \n\t(2) Update\n\t(3) Remove\n\t(4) Flight Schedules\n\t(0) Sign out");
    }

    private int adminMenu()  {
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
                    System.out.println(ColorMethods.RED_BOLD+"Please use The correct Number..." + ColorMethods.RESET);
                    num = Tools.input.nextInt();
            }
        } while (num < 0 || num > 4);
        return 0;
    }
}
