package lab7.task4_isp.clients;

import lab7.task4_isp.roles.Scanner;

/** Оцифрування архіву — потрібен лише сканер. */
public class ArchiveDigitizer {
    private final Scanner scanner;

    public ArchiveDigitizer(Scanner scanner) {
        this.scanner = scanner;
    }

    public void digitize(int pages) {
        for (int i = 0; i < pages; i++) scanner.scanDocument();
    }
}
