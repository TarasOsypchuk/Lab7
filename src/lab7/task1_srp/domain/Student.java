package lab7.task1_srp.domain;

/**
 * Value Object: студент. Інваріант — ID та ім'я не порожні (fail-fast у конструкторі).
 */
public record Student(String id, String name) {
    public Student {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Ідентифікатор студента не може бути порожнім.");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Ім'я студента не може бути порожнім.");
        }
    }
}
