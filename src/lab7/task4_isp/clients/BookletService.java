package lab7.task4_isp.clients;

import lab7.task4_isp.roles.DuplexPrinter;
import lab7.task4_isp.roles.Stapler;

/** Друк брошури: потрібні рівно дві ролі — двосторонній друк і степлер. */
public class BookletService {
    private final DuplexPrinter printer;
    private final Stapler stapler;

    public BookletService(DuplexPrinter printer, Stapler stapler) {
        this.printer = printer;
        this.stapler = stapler;
    }

    public void makeBooklet(String doc, int pages) {
        printer.duplexPrint(doc);
        stapler.staplePages(pages);
    }
}
