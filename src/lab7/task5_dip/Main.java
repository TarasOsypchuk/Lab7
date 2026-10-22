package lab7.task5_dip;

import lab7.task5_dip.core.FinancialTransactionProcessor;
import lab7.task5_dip.core.PaymentRequest;
import lab7.task5_dip.core.TransactionStatus;
import lab7.task5_dip.fakes.FakePaymentGateway;
import lab7.task5_dip.fakes.InMemoryTransactionLedger;
import lab7.task5_dip.fakes.RecordingNotifier;
import lab7.task5_dip.infrastructure.SqlServerTransactionLedger;
import lab7.task5_dip.infrastructure.StripePaymentGateway;
import lab7.task5_dip.infrastructure.TwilioSmsNotifier;

import java.math.BigDecimal;

/**
 * COMPOSITION ROOT — єдине місце, де створюються конкретні реалізації (Manual DI).
 * Service Locator не використовується: процесор ніколи сам не "шукає" залежності.
 */
public class Main {
    static FinancialTransactionProcessor productionProcessor() {
        return new FinancialTransactionProcessor(
                new StripePaymentGateway(), new SqlServerTransactionLedger(), new TwilioSmsNotifier());
    }

    public static void main(String[] args) {
        PaymentRequest request = new PaymentRequest("TX-1001", "4111 1111 1111 1234", new BigDecimal("1499.90"), "+380671112233");

        System.out.println("=== Production-конфігурація ===");
        productionProcessor().processPayment(request);

        System.out.println("\n=== Тестова конфігурація (fakes/mocks), той самий процесор ===");
        InMemoryTransactionLedger ledger = new InMemoryTransactionLedger();
        RecordingNotifier notifier = new RecordingNotifier();
        FinancialTransactionProcessor testProcessor =
                new FinancialTransactionProcessor(new FakePaymentGateway(false), ledger, notifier);

        TransactionStatus status = testProcessor.processPayment(request);
        check(status == TransactionStatus.FAILED, "відхилений шлюзом платіж має статус FAILED");
        check(ledger.entries().get("TX-1001") == TransactionStatus.FAILED, "реєстр зафіксував FAILED");
        check(notifier.sent().equals(java.util.List.of("+380671112233:FAILED")), "платника повідомлено про відмову");
        System.out.println("Реєстр: " + ledger.entries() + ", SMS: " + notifier.sent());
    }

    private static void check(boolean condition, String description) {
        if (!condition) throw new IllegalStateException("ПЕРЕВІРКА НЕ ПРОЙШЛА: " + description);
        System.out.println("OK: " + description);
    }
}
