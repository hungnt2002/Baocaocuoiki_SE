package boundary;

import java.util.Date;

import control.ReturnBikeController;

public class ReturnBikeUI {
    private ReturnBikeController returnBikeController;
    
    public ReturnBikeUI(ReturnBikeController returnBikeController) {
        this.returnBikeController = returnBikeController;
    }

    public void handleReturn() throws InterruptedException {
        returnBikeController.ReturnBike(new Date());
    }
}
