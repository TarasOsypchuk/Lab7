package lab7.task5_dip.core;

import java.math.BigDecimal;

/**
 * Незмінний запит на платіж з guard clauses. Сума — BigDecimal (не double) для грошей.
 */
public record PaymentRequest(String transactionId, String cardNumber, BigDecimal amount, String payerPhone) {
    public PaymentRequest {
        requireText(transactionId, "Ідентифікатор транзакції");
        requireText(cardNumber, "Номер картки");
        requireText(payerPhone, "Телефон платника");
        if (amount == null || amount.signum() <= 0) {
            throw new IllegalArgumentException("Сума транзакції повинна бути більшою за нуль.");
        }
    }

    private static void requireText(String value, String name) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(name + " не може бути порожнім.");
        }
    }

    /** Маскований номер для логів: **** **** **** 1234 */
    public String maskedCard() {
        String digits = cardNumber.replaceAll("\\D", "");
        return "**** " + digits.substring(Math.max(0, digits.length() - 4));
    }
}
