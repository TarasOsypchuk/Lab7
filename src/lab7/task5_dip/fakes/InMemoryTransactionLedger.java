package lab7.task5_dip.fakes;

import lab7.task5_dip.core.PaymentRequest;
import lab7.task5_dip.core.TransactionLedger;
import lab7.task5_dip.core.TransactionStatus;

import java.util.LinkedHashMap;
import java.util.Map;

/** Mock-реєстр: зберігає записи в пам'яті, щоб їх можна було перевірити. */
public class InMemoryTransactionLedger implements TransactionLedger {
    private final Map<String, TransactionStatus> entries = new LinkedHashMap<>();

    @Override
    public void record(PaymentRequest request, TransactionStatus status) {
        entries.put(request.transactionId(), status);
    }

    public Map<String, TransactionStatus> entries() {
        return Map.copyOf(entries);
    }
}
