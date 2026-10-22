package lab7.task5_dip.fakes;

import lab7.task5_dip.core.PaymentGateway;
import lab7.task5_dip.core.PaymentRequest;

/** Тестовий шлюз: без мережі, результат задається в конструкторі. */
public class FakePaymentGateway implements PaymentGateway {
    private final boolean approve;

    public FakePaymentGateway(boolean approve) {
        this.approve = approve;
    }

    @Override
    public boolean charge(PaymentRequest request) {
        return approve;
    }
}
