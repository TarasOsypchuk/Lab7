package lab7.task2_ocp.channels;

import lab7.task2_ocp.NotificationChannel;
import lab7.task2_ocp.NotificationMessage;

public class TelegramChannel implements NotificationChannel {
    @Override
    public boolean send(NotificationMessage message) {
        System.out.println("[TELEGRAM] ChatId: " + message.recipient());
        System.out.println("[TELEGRAM] Message: *" + message.subject() + "*\n" + message.body());
        System.out.println("[TELEGRAM] Статус: Надіслано через Bot API.");
        return true;
    }
}
