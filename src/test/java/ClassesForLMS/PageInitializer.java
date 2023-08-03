package ClassesForLMS;

import Pages.DashBoardPage;
import Pages.LoginPage;
import Pages.SignOutPage;

public class PageInitializer {
    public static LoginPage loginPage;
    public static DashBoardPage dashBoardPage;
    public static SignOutPage signOutPage;


    public static void initializepageobjest(){
        loginPage=new LoginPage();
        dashBoardPage=new DashBoardPage();
        signOutPage=new SignOutPage();


    }
}
