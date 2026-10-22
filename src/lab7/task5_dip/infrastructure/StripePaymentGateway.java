package lab7.task5_dip.infrastructure;

import lab7.task5_dip.core.PaymentGateway;
import lab7.task5_dip.core.PaymentRequest;

public class StripePaymentGateway implements PaymentGateway {
    @Override
    public boolean charge(PaymentRequest request) {
        System.out.println("[Stripe API] Виконано списання " + request.amount() + " UAH з картки " + request.maskedCard() + ".");
        return true;
    }
}
