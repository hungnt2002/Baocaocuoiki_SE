package boundary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import control.NewRentalCardController;
import entity.RentalCard;

public class RegisterUI {
    private NewRentalCardController newRentalCardController;
    private static Scanner sc = new Scanner(System.in);

    public RegisterUI() {

    }

    public void handleRegister() {
        newRentalCardController = new NewRentalCardController(new RentalCard());
        System.out.println("Choice type card you want to register: ");
        System.out.println("1.  Prepaid card");
        System.out.println("2.  Postpaid card");
        System.out.print("Your choice: ");
        int index = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your information:");
        List<Object> list = registerInputs(index);
        if (index == 1) {
            newRentalCardController.createPrepaidCards(list.get(0).toString(), (int) list.get(1),
                    list.get(2).toString(), list.get(3).toString(), list.get(4).toString(), (int) list.get(5));
        }else{
            newRentalCardController.createPostpaidCard(list.get(0).toString(), (int) list.get(1),
            list.get(2).toString(), list.get(3).toString(), (int) list.get(4));
        }

    }

    private List<Object> registerInputs(int index) {
        List<Object> list = new ArrayList<>();
        if (index == 1) {
            System.out.print("USERNAME: ");
            list.add(sc.nextLine());
            System.out.print("PASSWORD: ");
            list.add(sc.nextInt());
            sc.nextLine();
            System.out.print("EMAIL: ");
            list.add(sc.nextLine());
            System.out.print("NAME: ");
            list.add(sc.nextLine());
            System.out.print("PHONENUMBER: ");
            list.add(sc.nextLine());
            System.out.print("BALANCE: ");
            list.add(sc.nextInt());
        } else {
            System.out.print("USERNAME: ");
            list.add(sc.nextLine());
            System.out.print("PASSWORD: ");
            list.add(sc.nextInt());
            sc.nextLine();
            System.out.print("EMAIL: ");
            list.add(sc.nextLine());
            System.out.println("Link your Bank Card to Rental Card");
            System.out.print("ID: ");
            list.add(sc.nextLine());
            System.out.print("PIN: ");
            list.add(sc.nextInt());
        }
        return list;
    }

}
