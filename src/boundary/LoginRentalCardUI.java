package boundary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import control.LoginController;
import entity.RentalCard;

public class LoginRentalCardUI{
    private LoginController loginController;
    private static Scanner sc = new Scanner(System.in);

    //Menu menu ;
    
    public LoginRentalCardUI() {
    }
    public void handleLogin(){
        loginController = new LoginController(new RentalCard());
        System.out.println("Enter a username, a password");
        List<Object> list =  loginInputs();
        loginController.login(list.get(0).toString(), (int)list.get(1));
        System.out.println("Logged in as # "+ loginController.getRentalCard().getUsername());
    }

    private List<Object> loginInputs() {
        List<Object> list = new ArrayList<>();
        System.out.print("USERNAME: ");
        String username = sc.nextLine();
        if(username.equals("")){
            username = sc.nextLine();
        }
        System.out.print("PASSWORD: ");
        Integer password = sc.nextInt();
        list.add(username);
        list.add(password);
        return list;
    }
    public LoginController getLoginController() {
        return loginController;
    }
}
