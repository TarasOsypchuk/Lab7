package lab7.task5_dip.core;

public interface TransactionLedger {
    void record(PaymentRequest request, TransactionStatus status);
}
