package lab7.task2_ocp.channels;

import lab7.task2_ocp.NotificationChannel;
import lab7.task2_ocp.NotificationMessage;

public class SmsChannel implements NotificationChannel {
    static final int MAX_LENGTH = 160;
    private static final String ELLIPSIS = "...";

    @Override
    public boolean send(NotificationMessage message) {
        System.out.println("[SMS] Phone: " + message.recipient());
        System.out.println("[SMS] Text: " + truncate(message.body()));
        System.out.println("[SMS] Статус: Надіслано через GSM шлюз.");
        return true;
    }

    static String truncate(String text) {
        if (text.length() <= MAX_LENGTH) return text;
        return text.substring(0, MAX_LENGTH - ELLIPSIS.length()) + ELLIPSIS;
    }
}
