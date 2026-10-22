package lab7.task5_dip.core;

public interface PayerNotifier {
    void notifyPayer(PaymentRequest request, TransactionStatus status);
}
