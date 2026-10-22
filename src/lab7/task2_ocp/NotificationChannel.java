package lab7.task2_ocp;

/**
 * ТОЧКА РОЗШИРЕННЯ (Extension Point) — стратегія доставки.
 * Новий канал = новий клас, що реалізує цей інтерфейс. NotificationSender не змінюється.
 */
public interface NotificationChannel {
    boolean send(NotificationMessage message);
}
