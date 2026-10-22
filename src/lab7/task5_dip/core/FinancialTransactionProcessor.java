package lab7.task5_dip.core;

import java.util.Objects;

/**
 * Високорівнева бізнес-логіка. Жодного `new` для інфраструктури —
 * всі залежності приходять через конструктор (Constructor Injection).
 */
public class FinancialTransactionProcessor {
    private final PaymentGateway gateway;
    private final TransactionLedger ledger;
    private final PayerNotifier notifier;

    public FinancialTransactionProcessor(PaymentGateway gateway, TransactionLedger ledger, PayerNotifier notifier) {
        this.gateway = Objects.requireNonNull(gateway, "gateway");
        this.ledger = Objects.requireNonNull(ledger, "ledger");
        this.notifier = Objects.requireNonNull(notifier, "notifier");
    }

    public TransactionStatus processPayment(PaymentRequest request) {
        Objects.requireNonNull(request, "Запит на платіж не може бути null.");

        TransactionStatus status = gateway.charge(request) ? TransactionStatus.SUCCESS : TransactionStatus.FAILED;
        ledger.record(request, status);
        notifier.notifyPayer(request, status);
        return status;
    }
}
