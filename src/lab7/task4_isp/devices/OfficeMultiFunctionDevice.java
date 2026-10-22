package lab7.task4_isp.devices;

import lab7.task4_isp.roles.DuplexPrinter;
import lab7.task4_isp.roles.FaxMachine;
import lab7.task4_isp.roles.Scanner;
import lab7.task4_isp.roles.Stapler;

/**
 * Справжній БФП (є в предметній області) — комбінує всі ролі.
 * Саме він обґрунтовує існування FaxMachine та Stapler (не "інтерфейси на майбутнє").
 */
public class OfficeMultiFunctionDevice implements DuplexPrinter, Scanner, FaxMachine, Stapler {
    @Override
    public void printDocument(String doc) {
        System.out.println("[MFD] Printing: " + doc);
    }

    @Override
    public void duplexPrint(String doc) {
        System.out.println("[MFD] Duplex printing: " + doc);
    }

    @Override
    public void scanDocument() {
        System.out.println("[MFD] Scanning physical document...");
    }

    @Override
    public void sendFax(String number, String doc) {
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException("Номер факсу не може бути порожнім.");
        }
        System.out.println("[MFD] Faxing '" + doc + "' to " + number);
    }

    @Override
    public void staplePages(int count) {
        if (count < 2) {
            throw new IllegalArgumentException("Степлювати можна щонайменше 2 сторінки, отримано: " + count);
        }
        System.out.println("[MFD] Stapling " + count + " pages");
    }
}
