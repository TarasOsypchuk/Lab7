package lab7.task2_ocp;

import java.util.Objects;

/**
 * Закритий для модифікації клас: не знає жодного конкретного каналу, немає switch по Enum.
 */
public class NotificationSender {
    public boolean send(NotificationMessage message, NotificationChannel channel) {
        Objects.requireNonNull(message, "Повідомлення не може бути null.");
        Objects.requireNonNull(channel, "Канал сповіщення не може бути null.");
        return channel.send(message); // поліморфна диспетчеризація замість switch
    }
}
