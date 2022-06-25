package boundary;

import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import control.RentBikeController;
import entity.Bicycle;

public class RentBikeUI {
    private RentBikeController rentBikeController;
    private static Scanner sc = new Scanner(System.in);
    
    public RentBikeUI(RentBikeController rentBikeController) {
        this.rentBikeController = rentBikeController;
    }

    public void handleRentBike() {
        this.showListRentBicycle();
        int index = rentBikeInputs();
        rentBikeController.RentBicycle(index);
    }

    public int rentBikeInputs(){
        System.out.print("Enter the ID of the bike you want to rent: ");
        return sc.nextInt();
    }

    public void showListRentBicycle() {
        JsonObject jsonObject = new JsonObject();
        JsonArray memory = Bicycle.getBicycles().getAll();
        System.out.println(
                "*****************************************************************************************");
        System.out.println(
                "**                                Bicycle Rental List                                  **");                
        System.out.println(
                "**-------------------------------------------------------------------------------------**");
        System.out.printf("%-4s %-5s %-15s %-12s %-12s %-14s %-18s %-3s\n","**","ID","NumberPlate","Type","Color","Manufacturer","Status","**");
        System.out.println(
                "**-------------------------------------------------------------------------------------**");
        for (int i = 0; i < Bicycle.getBicycles().getAll().size(); i++) {
            System.out.printf("%-4s %-6d", "**", i);
            rentBikeController.showBicycle(i, jsonObject, memory);
            System.out.printf("%-4s\n", "**");
        }
        System.out.println(
                "*****************************************************************************************");
    }
}
