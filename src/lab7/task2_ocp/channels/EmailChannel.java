package lab7.task2_ocp.channels;

import lab7.task2_ocp.NotificationChannel;
import lab7.task2_ocp.NotificationMessage;

public class EmailChannel implements NotificationChannel {
    @Override
    public boolean send(NotificationMessage message) {
        System.out.println("[EMAIL] To: " + message.recipient());
        System.out.println("[EMAIL] Subject: " + message.subject());
        System.out.println("[EMAIL] Body: " + message.body());
        System.out.println("[EMAIL] Статус: Відправлено через SMTP сервер.");
        return true;
    }
}
