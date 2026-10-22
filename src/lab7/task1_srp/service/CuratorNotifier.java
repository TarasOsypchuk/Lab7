package lab7.task1_srp.service;

import lab7.task1_srp.domain.Student;

/**
 * Відповідальність: доставка відомості куратору (поштовий транспорт).
 */
public class CuratorNotifier {
    private static final String MAIL_SERVER = "mail.univ.local";

    public void notify(String curatorEmail, Student student, String transcript) {
        System.out.println("Надсилання пошти куратору " + curatorEmail + " через " + MAIL_SERVER);
        System.out.println("Тема: Успішність студента " + student.name());
        System.out.println("Тіло: " + transcript);
    }
}
