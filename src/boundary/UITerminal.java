package boundary;

import java.util.Scanner;

import control.DepositController;
import control.LoginController;
import control.RefundCardController;
import control.RentBikeController;
import control.ReturnBikeController;

public class UITerminal {

    Scanner sc = new Scanner(System.in);
    LoginRentalCardUI loginRentalCardUI;
    LogoutUI logoutUI;
    RegisterUI registerUI;
    DepositUI depositUI;
    RentBikeUI rentBikeUI;
    ReturnBikeUI returnBikeUI;
    RefundUI refundUI;

    public void systemRentalBike() throws InterruptedException {
        System.out.println("Welcome to the System Rental Bicycle!!");
        int choice;
        int choice1;
        do {
            Thread.sleep(1500);
            this.displayOptions(1);
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case (1):
                    loginRentalCardUI = new LoginRentalCardUI();
                    loginRentalCardUI.handleLogin();
                    while (loginRentalCardUI.getLoginController().getRentalCard().checkLoggedIn()) {
                        Thread.sleep(1500);
                        this.displayOptions(2);
                        System.out.print("Your choice: ");
                        choice1 = sc.nextInt();
                        switch (choice1) {
                            case (1):
                                depositUI = new DepositUI(
                                        new DepositController(loginRentalCardUI.getLoginController().getRentalCard()));
                                depositUI.handleDeposit();
                                break;
                            case (2):
                                rentBikeUI = new RentBikeUI(
                                        new RentBikeController(loginRentalCardUI.getLoginController().getRentalCard()));
                                rentBikeUI.handleRentBike();
                                break;
                            case (3):
                                returnBikeUI = new ReturnBikeUI(new ReturnBikeController(
                                        loginRentalCardUI.getLoginController().getRentalCard()));
                                returnBikeUI.handleReturn();
                                break;
                            case (4):
                                refundUI = new RefundUI(new RefundCardController(
                                        loginRentalCardUI.getLoginController().getRentalCard()));
                                if (refundUI.handleRefund() == 0) {
                                    break;
                                }
                            case (0):
                                logoutUI = new LogoutUI(
                                        new LoginController(loginRentalCardUI.getLoginController().getRentalCard()));
                                logoutUI.handleLogout();
                                sc.nextLine();
                                break;
                            default:
                                System.out.println("Unknow command.");
                                break;
                        }

                    }
                    break;
                case (2):
                    registerUI = new RegisterUI();
                    registerUI.handleRegister();
                    break;
                case (0):
                    System.out.println("Exit the program successfully!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Unknow command.");
            }

        } while (choice != 0);
        System.out.println("hghgghg");
    }

    private void displayOptions(int i) {
        if (i == 1) {
            System.out.println("============Main Screen=============");
            System.out.println("== 1. Login                       ==");
            System.out.println("== 2. Register Card               ==");
            System.out.println("== 0. Exit                        ==");
        } else {
            System.out.println("================Menu================");
            System.out.println("== 1. Deposit                     ==");
            System.out.println("== 2. Rental Bicycle              ==");
            System.out.println("== 3. Return Bicycle              ==");
            System.out.println("== 4. Refund Card                 ==");
            System.out.println("== 0. Logout                      ==");

        }
        System.out.println("====================================");
    }
}
