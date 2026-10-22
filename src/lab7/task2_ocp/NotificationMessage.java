package lab7.task2_ocp;

import java.util.Objects;

/**
 * Незмінне повідомлення, що не залежить від каналу доставки.
 */
public record NotificationMessage(String recipient, String subject, String body, Priority priority) {
    public enum Priority { LOW, NORMAL, HIGH }

    public NotificationMessage {
        if (recipient == null || recipient.isBlank()) {
            throw new IllegalArgumentException("Отримувач не може бути порожнім.");
        }
        Objects.requireNonNull(subject, "Тема не може бути null.");
        Objects.requireNonNull(body, "Текст не може бути null.");
        Objects.requireNonNull(priority, "Пріоритет не може бути null.");
    }
}
