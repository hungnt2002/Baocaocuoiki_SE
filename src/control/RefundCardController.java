package control;

import entity.RentalCard;

public class RefundCardController {
    private RentalCard rentalCard = new RentalCard();

    public RefundCardController(RentalCard rentalCard) {
        this.rentalCard = rentalCard;
    }

    public int refundCard() {
        if(!rentalCard.getNumberPlate().equals("0000")){
            System.out.println("[REFUND FAILED] You need to return the bike before refund card!!!");
            return 0;
        }else{
            if(rentalCard.checkTypeCard() == 1){
                System.out.println("You will get the remaining  " + rentalCard.getBalance() +" d in the card");
            }
            System.out.println("[REFUND SUCCESS] Thank you for using our service");
            RentalCard.getRentalCards().remove(RentalCard.getRentalCards().search("username", rentalCard.getUsername()));
            RentalCard.getRentalCards().write();
            return 1;
        }
    }
}
