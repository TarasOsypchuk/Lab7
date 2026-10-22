package lab7.task5_dip.fakes;

import lab7.task5_dip.core.PayerNotifier;
import lab7.task5_dip.core.PaymentRequest;
import lab7.task5_dip.core.TransactionStatus;

import java.util.ArrayList;
import java.util.List;

/** Замість реального SMS — запам'ятовує, кому що було б надіслано. */
public class RecordingNotifier implements PayerNotifier {
    private final List<String> sent = new ArrayList<>();

    @Override
    public void notifyPayer(PaymentRequest request, TransactionStatus status) {
        sent.add(request.payerPhone() + ":" + status);
    }

    public List<String> sent() {
        return List.copyOf(sent);
    }
}
