package lab7.task2_ocp.channels;

import lab7.task2_ocp.NotificationChannel;
import lab7.task2_ocp.NotificationMessage;

public class PushChannel implements NotificationChannel {
    @Override
    public boolean send(NotificationMessage message) {
        System.out.println("[PUSH] DeviceToken: " + message.recipient());
        System.out.println("[PUSH] Payload: { \"title\": \"" + message.subject()
                + "\", \"body\": \"" + message.body() + "\" }");
        System.out.println("[PUSH] Статус: Доставлено через Firebase Cloud Messaging.");
        return true;
    }
}
