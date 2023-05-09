
public class Passenger {

    //----------Passenger Menu
    private void menu(){
        System.out.println("*****************************\n\tPassenger MENU OPTION\n*****************************\n\t(1) Change password \n\t(2) Search flight ticket\n\t(3) Booking ticket\n\t(4) Ticket cancellation\n\t(5) Booked tickets\n\t(6) Add charge\n\t(0) Sign out" );
    }
    private int passenger() {
        int num ;
        menu();
        num = Tools.input.nextInt();
        do {
            switch (num){
                case 0 :
                    return 0;
                case 1 :
                    return 1;
                case 2 :
                    return 2;
                case 3 :
                    return 3;
                case 4 :
                    return 4;
                case 5 :
                    return 5;
                case 6 :
                    return 6;
                default:
                    Tools.cls();
                    menu();
                    System.out.println(ColorMethods.RED_BOLD+"Please use The correct Number..." + ColorMethods.RESET);
                    num = Tools.input.nextInt();
            }
        }while(num < 0 || num >6);
        return 0;
    }
}
