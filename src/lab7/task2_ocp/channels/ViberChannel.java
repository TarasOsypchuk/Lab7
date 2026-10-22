package lab7.task2_ocp.channels;

import lab7.task2_ocp.NotificationChannel;
import lab7.task2_ocp.NotificationMessage;

/**
 * НОВИЙ канал, доданий для демонстрації OCP.
 * Додано лише цей файл — NotificationSender і решта каналів не змінено жодним рядком.
 */
public class ViberChannel implements NotificationChannel {
    @Override
    public boolean send(NotificationMessage message) {
        System.out.println("[VIBER] Receiver: " + message.recipient());
        System.out.println("[VIBER] Message: " + message.subject() + " — " + message.body());
        System.out.println("[VIBER] Статус: Надіслано через Viber Business Messages API.");
        return true;
    }
}
