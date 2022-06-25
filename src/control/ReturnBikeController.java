package control;

import java.text.SimpleDateFormat;
import java.util.Date;

import entity.BankCard;
import entity.Bicycle;
import entity.RentalCard;


public class ReturnBikeController {
    private RentalCard rentalCard = new RentalCard();
    

    public ReturnBikeController(RentalCard rentalCard) {
        this.rentalCard = rentalCard;
    }

    public void ReturnBike(Date payTime) throws InterruptedException {
        if (rentalCard.getNumberPlate().equals("0000")) {
            System.out.println("[RETURN FAILED] You need to rent a bicycle before you return");
            return;
        } else {
            SimpleDateFormat sdf =  new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
            long timeRental = this.calculateRentalPeriod(payTime);
            long moneyRental = timeRental * 33;
            System.out.println("You rented the bike at "+ sdf.format(new Date(rentalCard.getRentalTime())));
            if(rentalCard.checkTypeCard() == 1){
                System.out.println("Your balance: "+ rentalCard.getBalance());
            }else{
                System.out.println("Your balance: "+ rentalCard.getBankCard().getBalance());
            }
            System.out.println("Money you have to pay: "+ moneyRental);
            System.out.println("Return bike...");
            Thread.sleep(1500);
            if (rentalCard.checkTypeCard() == 1 && rentalCard.getBalance() < moneyRental
                    || rentalCard.checkTypeCard() == 2 && rentalCard.getBankCard().getBalance() < moneyRental) {
                System.out.println("[RETURN FAILED] The balance in the card is not enough to return the bike");
                return;
            } else {
                int index = RentalCard.getRentalCards().search("username", rentalCard.getUsername());
                int index1 = Bicycle.getBicycles().search("numberPlate", rentalCard.getNumberPlate());
                rentalCard.getBicycle().setStatus("Ready");
                Bicycle bicycle;
                bicycle = rentalCard.getBicycle();
                Bicycle.getBicycles().set(index1, Bicycle.convertToJsonObject(bicycle));
                Bicycle.getBicycles().write();
                rentalCard.setNumberPlate("0000");
                rentalCard.setRentalTime(null);
                bicycle = new Bicycle();
                rentalCard.setBicycle(bicycle);
                if(rentalCard.checkTypeCard() == 1){
                    rentalCard.setBalance(rentalCard.getBalance() -(int)moneyRental);
                }else{
                    int index2 = BankCard.getBankCards().search("iD", rentalCard.getBankCard().getiD());
                    rentalCard.getBankCard().setBalance(rentalCard.getBankCard().getBalance() - (int)moneyRental);
                    BankCard.getBankCards().set(index2, BankCard.convertToJsonObject(rentalCard.getBankCard()));
                    BankCard.getBankCards().write();         
                }
                RentalCard.getRentalCards().set(index, RentalCard.convertToJsonObject(rentalCard));
                RentalCard.getRentalCards().write();
            }
            System.out.println("[RETURN SUCCESS] You have successfully returned the bike");
        }
    }

    public long calculateRentalPeriod(Date payTime) {
        long startValue = rentalCard.getRentalTime();
        long endValue = payTime.getTime();
        long tmp = Math.abs(endValue - startValue);

        return tmp / (60 * 1000);
    }
}
