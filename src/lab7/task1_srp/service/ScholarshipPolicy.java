package lab7.task1_srp.service;

import java.math.BigDecimal;

/**
 * Відповідальність: правила призначення стипендії (змінюються наказом університету).
 */
public class ScholarshipPolicy {
    static final double INCREASED_THRESHOLD = 90.0;
    static final double REGULAR_THRESHOLD = 75.0;
    static final BigDecimal INCREASED_AMOUNT = new BigDecimal("2910.00");
    static final BigDecimal REGULAR_AMOUNT = new BigDecimal("2000.00");
    static final BigDecimal NONE = new BigDecimal("0.00");

    public BigDecimal determine(double gpa, boolean hasFailedCourses) {
        if (hasFailedCourses) return NONE;               // guard clause замість вкладеного if
        if (gpa >= INCREASED_THRESHOLD) return INCREASED_AMOUNT;
        if (gpa >= REGULAR_THRESHOLD) return REGULAR_AMOUNT;
        return NONE;
    }
}
