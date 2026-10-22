package lab7.task2_ocp;

import lab7.task2_ocp.channels.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        NotificationSender sender = new NotificationSender();
        NotificationMessage msg = new NotificationMessage(
                "+380501234567", "Розклад", "Пара з КПЗ перенесена на 10:10.", NotificationMessage.Priority.HIGH);

        List<NotificationChannel> channels = List.of(
                new EmailChannel(), new SmsChannel(), new PushChannel(), new TelegramChannel(),
                new ViberChannel()); // новий канал — без змін у NotificationSender

        for (NotificationChannel channel : channels) {
            System.out.println("-> " + channel.getClass().getSimpleName() + ": " + sender.send(msg, channel));
        }

        // Довге SMS обрізається до 160 символів
        new SmsChannel().send(new NotificationMessage("+380", "t", "Х".repeat(200), NotificationMessage.Priority.LOW));
    }
}
