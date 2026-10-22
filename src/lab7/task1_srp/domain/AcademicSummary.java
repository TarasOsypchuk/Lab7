package lab7.task1_srp.domain;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Результат обробки відомості: GPA та призначена стипендія.
 */
public record AcademicSummary(GradeSheet sheet, double gpa, BigDecimal scholarship) {
    public AcademicSummary {
        Objects.requireNonNull(sheet);
        Objects.requireNonNull(scholarship);
    }
}
