package lab7.task5_dip.infrastructure;

import lab7.task5_dip.core.PayerNotifier;
import lab7.task5_dip.core.PaymentRequest;
import lab7.task5_dip.core.TransactionStatus;

public class TwilioSmsNotifier implements PayerNotifier {
    @Override
    public void notifyPayer(PaymentRequest request, TransactionStatus status) {
        String result = status == TransactionStatus.SUCCESS ? "успішно виконано" : "відхилено";
        System.out.println("[Twilio SMS] Повідомлення на " + request.payerPhone() + ": Платіж "
                + request.transactionId() + " на суму " + request.amount() + " UAH " + result + ".");
    }
}
