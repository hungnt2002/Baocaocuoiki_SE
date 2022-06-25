package boundary;

import java.util.Scanner;

import control.DepositController;

public class DepositUI {
    private DepositController depositController;
    private static Scanner sc = new Scanner(System.in);

    public DepositUI(DepositController depositController) {
        this.depositController = depositController;
    }

    public void handleDeposit(){
        System.out.println("Enter the amount you want to deposit: ");
        depositController.addMoneyCard(depositInputs());
    }
    
    private int depositInputs() {
        System.out.print("MONEY: ");
        return sc.nextInt();
    }

}
