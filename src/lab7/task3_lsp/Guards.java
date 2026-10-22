package lab7.task3_lsp;

/**
 * Єдине місце (SSOT) для перевірки розмірів фігур — guard clauses, fail-fast.
 */
final class Guards {
    private Guards() {}

    static double requirePositive(double value, String name) {
        if (!Double.isFinite(value) || value <= 0) {
            throw new IllegalArgumentException(name + " має бути додатним скінченним числом, отримано: " + value);
        }
        return value;
    }
}
