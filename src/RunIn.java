
public class RunIn {
    //----------First menu
    private void menu(){
        System.out.println("********************************************\n\tWELCOME TO AIRLINE RESERVATION SYSTEM\n********************************************\n\t(1) Sign in\n\t(2) Sign up" );
    }
    private int firstMenu()  {
        int num;
        menu();
        num = Tools.input.nextInt();
        do{
            switch(num){
                case 1 :
                    return 1;
                case 2:
                    return 2;
                default:
                    Tools.cls();
                    menu();
                    System.out.println(ColorMethods.RED_BOLD+"Please use The correct Number..." + ColorMethods.RESET);
                    num = Tools.input.nextInt();
            }
        }while(num !=1 || num != 2);
        return 0;
    }

}
