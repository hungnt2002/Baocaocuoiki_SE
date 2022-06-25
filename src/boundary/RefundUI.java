package boundary;

import control.RefundCardController;

public class RefundUI {
    private RefundCardController refundCard;

    public RefundUI(RefundCardController refundCard) {
        this.refundCard = refundCard;
    }

    public int handleRefund() throws InterruptedException{
        System.out.println("Refund...");
        Thread.sleep(1500);
        return refundCard.refundCard();
    }
}
