package lab7.task4_isp.clients;

import lab7.task4_isp.roles.Printer;

/** Клієнт залежить лише від ролі Printer. */
public class PrintQueue {
    private final Printer printer;

    public PrintQueue(Printer printer) {
        this.printer = printer;
    }

    public void printAll(Iterable<String> docs) {
        for (String doc : docs) printer.printDocument(doc);
    }
}
